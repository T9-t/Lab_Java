import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Book;
import model.Visitor;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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

            System.out.println(visitors.toString());
            System.out.println("Visitor count: " + visitors.stream().count());

            Set<Book> books = visitors.stream()
                    .flatMap(visitor -> visitor.getFavoriteBooks().stream())
                    .collect(Collectors.toSet());
            System.out.println(books.toString());
            System.out.println("Books count: " + books.size());

            List<Book> sortedBooks = books.stream()
                    .sorted((thisBook,otherBook) -> Integer.compare(thisBook.getPublishingYear(),otherBook.getPublishingYear()))
                    .toList();
            System.out.println(sortedBooks.toString());

            List<Visitor> visitorWithBook = visitors.stream()
                    .filter(visitor -> visitor.getFavoriteBooks().stream()
                            .anyMatch( book -> "Jane Austen".equals(book.getAuthor())))
                    .toList();
            System.out.println(visitorWithBook.toString());

            List<Integer> favoriteBooksSize = visitors.stream()
                    .map(visitor -> visitor.getFavoriteBooks().size())
                    .toList();
            Optional<Integer> booksCount = favoriteBooksSize.stream()
                    .max(Comparator.naturalOrder());
            System.out.println("Max books count in favorite: " + booksCount.get());





        } else {
            System.out.println("Список посетителей не был загружен или пуст.");
        }
    }
}