import java.sql.*;

public class VisitorsTable  implements CommanderSQL{

    private final Connection connect;
    private final Statement stmt;

    public VisitorsTable(String url) throws SQLException {

        connect = Connector.startConnection(url);
        stmt = connect.createStatement();
    }
    @Override
    public void createTable() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS visitors (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255) NOT NULL, " +
                "surname VARCHAR(255) NOT NULL, " +
                "phone VARCHAR(255) NOT NULL, " +
                "subscribed BIT NOT NULL" +
                ")";
        stmt.execute(sql);

        insert("John","Doe","123-456-7890",true);
        insert("Jane","Smith","987-654-3210",false);
        insert("Michael","Johnson","555-123-4567",true);
        insert("Emily","Brown","555-987-6543",true);
        insert("David","Wilson","555-111-2222",false);
        insert("Olivia","Miller","555-333-4444",true);
        insert("William","Davis","555-555-5555",true);
        insert("Sophia","Garcia","555-666-7777",false);
        insert("James","Martinez","555-888-9999",true);
        insert("Isabella","Anderson","555-000-1111",false);
        insert("Ethan","Taylor","555-222-3333",true);
        insert("Ava","Thomas","555-444-5555",true);
        insert("Jack","Hill","555-666-7777",true);
        insert("Lily","Jones","555-777-8888",true);
        insert("Oliver","Baker","555-888-9999",true);
    }
    public void insert(String name, String surname, String phone, Boolean subscribed) {

        String sql = "INSERT INTO visitors (name,surname,phone,subscribed) VALUES (?,?,?,?)";
        try (PreparedStatement ps = connect.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setString(3, phone);
            ps.setBoolean(4, subscribed);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void select(String sql) throws SQLException {

        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "  " +
                    rs.getString("name") + " " +
                    rs.getString("surname") + ", phone: " +
                    rs.getString("phone") + ", subscribed: " +
                    rs.getBoolean("subscribed"));
        }
    }
    @Override
    public void deleteTable(){

        String dropTable = "DROP TABLE IF EXISTS visitors;";
        try {
            stmt.executeUpdate(dropTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Connector.closeConnection(connect);
    }
}
