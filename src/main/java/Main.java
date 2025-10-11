import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Book;
import model.SmsMessage;
import model.Visitor;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Gson gson = new Gson();
        Type arrayType = new TypeToken<List<Visitor>>() {}.getType();

        List<Visitor> visitors = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Admin\\Desktop\\Lab_java2\\books.json"))) {
            visitors = gson.fromJson(reader, arrayType);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (visitors != null) {

            System.out.println("//////////////// 1 //////////////////////");
            System.out.println(visitors);
            System.out.println("Visitor count: " + visitors.size());

            System.out.println("//////////////// 2 //////////////////////");
            Set<Book> books = visitors.stream()
                    .flatMap(visitor -> visitor.getFavoriteBooks().stream())
                    .collect(Collectors.toSet());
            System.out.println(books);
            System.out.println("Books count: " + books.size());

            System.out.println("//////////////// 3 //////////////////////");
            List<Book> sortedBooks = books.stream()
                    .sorted((thisBook,otherBook) -> Integer.compare(thisBook.getPublishingYear(),otherBook.getPublishingYear()))
                    .toList();
            System.out.println(sortedBooks);

            System.out.println("//////////////// 4 //////////////////////");
            List<Visitor> visitorWithBook = visitors.stream()
                    .filter(visitor -> visitor.getFavoriteBooks().stream()
                            .anyMatch( book -> "Jane Austen".equals(book.getAuthor())))
                    .toList();
            System.out.println(visitorWithBook);

            System.out.println("//////////////// 5 //////////////////////");
            List<Integer> favoriteBooksSize = visitors.stream()
                    .map(visitor -> visitor.getFavoriteBooks().size())
                    .toList();
            Optional<Integer> booksCount = favoriteBooksSize.stream()
                    .max(Comparator.naturalOrder());
            booksCount.ifPresent(integer -> System.out.println("Max books count in favorite: " + integer));

            System.out.println("//////////////// 6 //////////////////////");
            List<SmsMessage> smsMessages = new LinkedList<>();
            List<Visitor> subscribedVisitors = visitors.stream()
                    .filter(visitor -> visitor.isSubscribed() == true)
                    .toList();
            List<Integer> subscribedVisitorsBooksCount = visitors.stream()
                    .map(visitor -> visitor.getFavoriteBooks().size())
                    .toList();
            OptionalDouble averageBooks = subscribedVisitorsBooksCount.stream()
                    .mapToInt(Integer::intValue)
                    .average();

            for (int i = 0; i < subscribedVisitors.size();i++){

                if (averageBooks.isPresent()) {
                    String message = "";
                    if (subscribedVisitorsBooksCount.get(i) < averageBooks.getAsDouble()) {
                        message = "read more";
                    } else if (subscribedVisitorsBooksCount.get(i) > averageBooks.getAsDouble()) {
                        message = "you are a bookworm";
                    } else {
                        message = "fine";
                    }
                    smsMessages.add(new SmsMessage(subscribedVisitors.get(i).getPhone(), message));
                }
            }
            System.out.println(smsMessages);

        } else {
            System.out.println("Visitors list is null");
        }
    }
}