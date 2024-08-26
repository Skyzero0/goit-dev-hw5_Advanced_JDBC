package jdbc;

import model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseQueryServiceTest {
    private DatabaseQueryService databaseQueryService;

    @BeforeEach
    public void beforeEach () {
        databaseQueryService = new DatabaseQueryService();
    }


    @Test
    public void thatPrintProjectPrices() throws IOException {
        List<ProjectPrices> projectPrices = databaseQueryService.printProjectPrices();

        StringBuilder actual = new StringBuilder();
        for (ProjectPrices g:projectPrices) {
            actual.append(g.toString()).append("\n");
        }

        String expected = """
                PricesOfProject: name='Project 2', price=4090500}
                PricesOfProject: name='Project 3', price=2539350}
                PricesOfProject: name='Project 4', price=2029104}
                PricesOfProject: name='Project 8', price=1174625}
                PricesOfProject: name='Project 9', price=947700}
                PricesOfProject: name='Project 1', price=853702}
                PricesOfProject: name='Project 6', price=350100}
                PricesOfProject: name='Project 10', price=188600}
                PricesOfProject: name='Project 7', price=181452}
                PricesOfProject: name='Project 5', price=113610}
                """;

        assertEquals(actual.toString(),expected);
    }

    @Test
    public void thatFindMaxSalaryWorker() throws IOException {
        List<MaxSalaryWorker> maxSalaryWorker = databaseQueryService.findMaxSalaryWorker();

        StringBuilder actual = new StringBuilder();
        for (MaxSalaryWorker msw:maxSalaryWorker) {
            actual.append(msw.toString()).append("\n");
        }
        String expected = "Worker with max Salary: name='VALERIIA', salary=90000\n";

        assertEquals(actual.toString(), expected);
    }

    @Test
    public void  testFindYoungestEldestWorkers() throws IOException {
        List<YoungestEldestWorker> youngestEldestWorkers = databaseQueryService.findYoungestEldestWorkers();

        StringBuilder actual = new StringBuilder();
        for (YoungestEldestWorker yew:youngestEldestWorkers) {
            actual.append(yew.toString()).append("\n");
        }
        String expected = """
                YOUNGEST worker: 'name='JAMIR', birthday='2002-08-14
                OLDEST worker: 'name='ANDER', birthday='1965-12-27
                OLDEST worker: 'name='KLARA', birthday='1965-12-27
                """;

        assertEquals(actual.toString(), expected);
    }

    @Test
    public void  testFindLongestProject() throws IOException {
        List<LongestProject> longestProject = databaseQueryService.findLongestProject();

        StringBuilder actual = new StringBuilder();
        for (LongestProject lp:longestProject) {
            actual.append(lp.toString()).append("\n");
        }
        String expected = """
                Longest project: name='Project 1', monthCount=82
                """;

        assertEquals(actual.toString(), expected);
    }

    @Test
    public void  testFindMaxProjectsClient() throws IOException {
        List<MaxProjectsClient> maxProjectsClient = databaseQueryService.findMaxProjectsClient();

        StringBuilder actual = new StringBuilder();
        for (MaxProjectsClient mpc:maxProjectsClient) {
            actual.append(mpc.toString()).append("\n");
        }
        String expected = """
                Client with max projects: name='MARK', projectCount=2
                Client with max projects: name='ZLATA', projectCount=2
                Client with max projects: name='JAWELINA', projectCount=2
                """;

        assertEquals(actual.toString(), expected);
    }
}
