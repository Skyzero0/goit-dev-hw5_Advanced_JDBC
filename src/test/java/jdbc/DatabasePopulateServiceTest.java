package jdbc;

import jdbc.DatabasePopulateService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabasePopulateServiceTest {
    private DatabasePopulateService databasePopulateService = new DatabasePopulateService();

    @BeforeEach
    public void beforeEach () {
        databasePopulateService = new DatabasePopulateService();
    }


    @Test
    public void testThatAddWorkerFromFileCorrect() throws SQLException, IOException {
        int [] actual = databasePopulateService.addWorkerFromFile();
        int expected = 1;

        for (int j : actual) {
            assertEquals(j, expected);
        }
    }
    @Test
    public void testThatAddClientFromFileCorrect() throws SQLException, IOException {
        int [] actual = databasePopulateService.addClientFromFile();
        int expected = 1;

        for (int j : actual) {
            assertEquals(j, expected);
        }
    }

    @Test
    public void testThatAddProjectFromFileCorrect() throws SQLException, IOException {
        int [] actual = databasePopulateService.addProjectFromFile();
        int expected = 1;

        for (int j : actual) {
            assertEquals(j, expected);
        }
    }

    @Test
    public void testThatAddProjectsWorkerFromFileCorrect() throws SQLException, IOException {
        int [] actual = databasePopulateService.addProjectsWorkerFromFile();
        int expected = 1;

        for (int j : actual) {
            assertEquals(j, expected);
        }
    }
}
