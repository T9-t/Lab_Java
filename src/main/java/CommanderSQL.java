import java.sql.SQLException;

public interface CommanderSQL {
    void createTable() throws SQLException;
    void select(String sql) throws SQLException;
    void deleteTable() throws SQLException;
}