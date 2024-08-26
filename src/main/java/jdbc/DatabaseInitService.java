package jdbc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    private final Connection connection = Database.getInstance().getConnection();
    public int createTableFromFile () throws IOException {
        String sql = Files.readString(Path.of("sql\\init_db.sql"));

        try (PreparedStatement ps = connection.prepareStatement(sql)){
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Таблиця створена");
        return 0;
    }

    public int dropTable () throws IOException, SQLException {
        String sql = "drop table CLIENT, PROJECT, PROJECT_WORKER, WORKER";

        Statement st = connection.createStatement();

        System.out.println("Таблиця видалена");
        return st.executeUpdate(sql);
    }
}
