import java.sql.*;

public class MusicTable implements CommanderSQL {

    private final Connection connect;
    private final Statement stmt;

    public MusicTable(String url) throws SQLException {

        connect = Connector.startConnection(url);
        stmt = connect.createStatement();
    }
    @Override
    public void createTable() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS music (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255) NOT NULL" +
                ")";
        stmt.execute(sql);

        insert("Bohemian Rhapsody");
        insert("Stairway to Heaven");
        insert("Imagine");
        insert("Sweet Child O Mine");
        insert("Hey Jude");
        insert("Hotel California");
        insert("Billie Jean");
        insert("Wonderwall");
        insert("Smells Like Teen Spirit");
        insert("Let It Be");
        insert("I Want It All");
        insert("November Rain");
        insert("Losing My Religion");
        insert("One");
        insert("With or Without You");
        insert("Sweet Caroline");
        insert("Yesterday");
        insert("Don't Stop Believin");
        insert("Crazy Train");
        insert("Always");
    }
    public void insert(String name) throws SQLException {

        String sql = "INSERT INTO music (name) VALUES (?)";
        PreparedStatement ps = connect.prepareStatement(sql);

        ps.setString(1, name);
        ps.executeUpdate();
    }
    @Override
    public void select(String sql) throws SQLException {

        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "  " + rs.getString("name"));
        }
    }
    @Override
    public void deleteTable(){

        String dropTable = "DROP TABLE IF EXISTS music;";
        try {
            stmt.executeUpdate(dropTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Connector.closeConnection(connect);
    }
}
