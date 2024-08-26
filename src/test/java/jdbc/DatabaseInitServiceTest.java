package jdbc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseInitServiceTest {
    private DatabaseInitService databaseInitService = new DatabaseInitService();

    @BeforeEach
    public void beforeEach () {
        databaseInitService = new DatabaseInitService();
    }

    @AfterEach
    public void afterEach () {
        Database.getInstance().close();
    }

    @Test
    public void testThatATableDroped() throws IOException, SQLException {

        int actual = databaseInitService.dropTable();
        int expected = 0;

        assertEquals(expected, actual);
    }
    @Test
    public void testThatATableCreateCorrect() throws IOException, SQLException {

        int actual = databaseInitService.createTableFromFile();
        int expected = 0;

        assertEquals(actual, expected);
    }
}
