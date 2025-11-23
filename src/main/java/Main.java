import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException{

        String username = "root";
        String password = "123";

        String sqlBooks = "SELECT * FROM books";
        String sqlMusic = "SELECT * FROM music";
        String sqlVisitors = "SELECT * FROM visitors";

        String urlBooks = "jdbc:h2:file:C:\\Users\\Admin\\Desktop\\Lab_java2\\books";
        String urlMusic = "jdbc:h2:file:C:\\Users\\Admin\\Desktop\\Lab_java2\\music";
        String urlVisitors = "jdbc:h2:file:C:\\Users\\Admin\\Desktop\\Lab_java2\\visitors";

        BooksTable books = new BooksTable(urlBooks,username,password);
        MusicTable music = new MusicTable(urlMusic,username,password);
        VisitorsTable visitors = new VisitorsTable(urlVisitors,username,password);

        /// remove this entry if the tables have already been created.
        books.createTable();
        music.createTable();
        visitors.createTable();
        ///

        System.out.println("//////////////// 1 //////////////////");

        music.select(sqlMusic);

        System.out.println("//////////////// 2 //////////////////");

        String sqlMusic2 = "SELECT * FROM music WHERE LOWER(name) NOT LIKE '%t%' AND LOWER(name) NOT LIKE '%m%'";
        music.select(sqlMusic2);

        System.out.println("//////////////// 3 //////////////////");

        music.insert("Sister Splinter");
        music.select(sqlMusic);

        System.out.println("//////////////// 5 //////////////////");

        String sqlBooks5 = "SELECT * FROM books ORDER BY publishingYear";
        books.select(sqlBooks5);

        System.out.println("//////////////// 6 //////////////////");

        String sqlBooks6 = "SELECT * FROM books WHERE publishingYear < 2000";
        books.select(sqlBooks6);

        System.out.println("//////////////// 7 //////////////////");

        visitors.insert("Veronika","Procvetova","900-990-9999",false);
        visitors.select(sqlVisitors);

        books.insert("Three Men in a Boat (To Say Nothing of the Dog)","Jerome K.Jerome",1889,"0060730508","J.W.Arrowsmith");
        books.insert("The Colossus Rises","Peter Lerangis",2013,"0150730538","HarperCollins");
        books.select(sqlBooks);

        books.deleteTable();
        music.deleteTable();
        visitors.deleteTable();
    }
}