import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException{

        String sqlBooks = "SELECT * FROM books";
        String sqlMusic = "SELECT * FROM music";
        String sqlVisitors = "SELECT * FROM visitors";

        String urlBooks = "jdbc:h2:file:C:\\Users\\Admin\\Desktop\\Lab_java2\\books";
        String urlMusic = "jdbc:h2:file:C:\\Users\\Admin\\Desktop\\Lab_java2\\music";
        String urlVisitors = "jdbc:h2:file:C:\\Users\\Admin\\Desktop\\Lab_java2\\visitors";

        BooksTable books = new BooksTable(urlBooks);
        MusicTable music = new MusicTable(urlMusic);
        VisitorsTable visitors = new VisitorsTable(urlVisitors);

        //books.createTable();
        //music.createTable();
        //visitors.createTable();

        books.select(sqlBooks);
        music.select(sqlMusic);
        visitors.select(sqlVisitors);

        //books.deleteTable();
        //music.deleteTable();
        //visitors.deleteTable();
    }
}