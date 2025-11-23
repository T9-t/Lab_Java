import java.sql.*;

public class BooksTable implements CommanderSQL{

    private final Connection connect;
    private final Statement stmt;

    public BooksTable(String url) throws SQLException {

        connect = Connector.startConnection(url);
        stmt = connect.createStatement();
    }
    @Override
    public void createTable() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS books (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255) NOT NULL, " +
                "author VARCHAR(255) NOT NULL, " +
                "publishingYear INT NOT NULL, " +
                "isbn VARCHAR(255) NOT NULL, " +
                "publisher VARCHAR(255) NOT NULL" +
                ")";
        stmt.execute(sql);

        insert("Harry Potter and the Philosopher's Stone","J.K.Rowling", 1997,"0747532735","Bloomsbury");
        insert("Brave New World","Aldous Huxley",1932,"0060860495","Harper Perennial");
        insert("The Hunger Games","Suzanne Collins",2008,"439023483","Scholastic");
        insert("Gone Girl","Gillian Flynn",2012,"0316205775","Crown");
        insert("To Kill a Mockingbird","Harper Lee",1960,"0446310759","Harper Perennial");
        insert("The Nightingale","Kristin Hannah",2015,"0385387035","St.Martin's Press");
        insert("The Great Gatsby","F.Scott Fitzgerald",1925,"0743273567","Scribner");
        insert("The Alchemist","Paulo Coelho",1988,"0060920508","Harper One");
        insert("The Fault in Our Stars","John Green",2012,"0316038746","Dutton");
        insert("1984","George Orwell",1949,"0451534852","Signet Classics");
        insert("The Martian","Andy Weir",2011,"0553418438","Crown");
        insert("The Da Vinci Code","Dan Brown",2003,"0385504209","Doubleday");
        insert("The Shack","William P.Young",2007,"0316067860","Windblown Media");
        insert("Pride and Prejudice","Jane Austen",1813,"0525472125","Penguin Classics");
        insert("The Hitchhiker's Guide to the Galaxy","Douglas Adams",1979,"034539082","X.Del Rey");
        insert("The Catcher in the Rye","J.D.Salinger",1951,"0316769487","Little, Brown");
        insert("The Book Thief","Markus Zusak",2005,"0375831004","Knopf");
        insert("The Kite Runner","Khaled Hosseini",2003,"0385506982","Riverhead Books");
        insert("The Girl on the Train","Paula Hawkins",2015,"0007555445","Riverhead Books");
        insert("The Lord of the Rings","J.R.Tolkien",1954,"0395026468","Allen & Unwin");
    }
    public void insert(String name, String author, int publishingYear, String isbn, String publisher) throws SQLException {

        String sql = "INSERT INTO books (name,author,publishingYear,isbn,publisher) VALUES (?,?,?,?,?)";
        PreparedStatement ps = connect.prepareStatement(sql);

        ps.setString(1, name);
        ps.setString(2, author);
        ps.setInt(3, publishingYear);
        ps.setString(4, isbn);
        ps.setString(5, publisher);
        ps.executeUpdate();
    }
    @Override
    public void select(String sql) throws SQLException {

        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " '" +
                    rs.getString("name") + "', author: " +
                    rs.getString("author") + ", publishingYear: " +
                    rs.getInt("publishingYear") + ", isbn: " +
                    rs.getInt("isbn") + ", publisher: " +
                    rs.getString("publisher"));
        }
    }
    @Override
    public void deleteTable(){

        String dropTable = "DROP TABLE IF EXISTS books;";
        try {
            stmt.executeUpdate(dropTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Connector.closeConnection(connect);
    }
}
