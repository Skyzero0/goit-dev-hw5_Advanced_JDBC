package jdbc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DatabasePopulateService {
        private final Connection connection = Database.getInstance().getConnection();
        private PreparedStatement insert;

        String clientsFileName = "dataSQL\\clients.txt";
        String project_workerFileName = "dataSQL\\project_worker.txt";
        String workerFileName = "dataSQL\\workers.txt";
        String projectFileName = "dataSQL\\projects.txt";

        Scanner sc = new Scanner(System.in);

    public int [] addWorker (int count) throws SQLException {
        insert = connection.prepareStatement("INSERT INTO worker (name, birthday, level, salary) VALUES (?, ?, ?, ?)");

        for (int i = 0; i < count; i++) {
            try {
                System.out.println("Ім'я: ");
                insert.setString(1, sc.nextLine());
                System.out.println("Дата народження: ");
                insert.setDate(2, Date.valueOf(sc.nextLine()));
                System.out.println("Рівень: ");
                insert.setString(3, sc.nextLine());
                System.out.println("Зарплата: ");
                insert.setLong(4, sc.nextLong());
                insert.addBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
//        System.out.println(Arrays.toString(insert.executeBatch()));
        return insert.executeBatch();
    }
    public int[] addWorkerFromFile () throws SQLException, IOException {
        List<String> list = Files.readAllLines(Path.of(workerFileName));

        insert = connection.prepareStatement("INSERT INTO worker (name, birthday, level, salary) VALUES (?, ?, ?, ?)");
        for (String line:list) {
            String[] split = line.split(", ");
            try {
                insert.setString(1, split[0]);
                insert.setDate(2, java.sql.Date.valueOf(split[1]));
                insert.setString(3, split[2]);
                insert.setLong(4, Long.parseLong(split[3]));
                insert.addBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return insert.executeBatch();
    }

    public int[] addClient (int count) throws SQLException {
        insert = connection.prepareStatement("INSERT INTO client (name) VALUES (?)");

        for (int i = 0; i < count; i++) {
            try {
                System.out.println("Ім'я клієнта: ");
                insert.setString(1, sc.nextLine());
                insert.addBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return insert.executeBatch();
    }
    public int[] addClientFromFile () throws SQLException, IOException {
        List<String> list = Files.readAllLines(Path.of(clientsFileName));

        insert = connection.prepareStatement("INSERT INTO client (name) VALUES (?)");
        for (String s:list) {
            try {
                insert.setString(1, s);
                insert.addBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return insert.executeBatch();
    }

    public void addProject (int count) throws SQLException {
        insert = connection.prepareStatement("INSERT INTO project (client_id, start_date, finish_date) VALUES (?, ?, ?)");

        for (int i = 0; i < count; i++) {
            try {

                System.out.println("ID клієнта: ");
                insert.setInt(1, sc.nextInt());
                System.out.println("Дата початку проекту: ");
                insert.setDate(2, Date.valueOf(sc.next()));
                System.out.println("Дата закінчення проекту: ");
                insert.setDate(3, Date.valueOf(sc.next()));

                insert.addBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        insert.executeBatch();
    }
    public int[] addProjectFromFile () throws SQLException, IOException {
        List<String> list = Files.readAllLines(Path.of(projectFileName));

        insert = connection.prepareStatement("INSERT INTO project (client_Id, start_Date, finish_Date) VALUES (?, ?, ?)");
        for (String line:list) {
            String[] split = line.split(", ");
            try {
                insert.setString(1, split[0]);
                insert.setDate(2, java.sql.Date.valueOf(split[1]));
                insert.setDate(3, java.sql.Date.valueOf(split[2]));
                insert.addBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return insert.executeBatch();
    }

    public void addProjectsWorker (int count) throws SQLException {
        Scanner sc = new Scanner(System.in);

        insert = connection.prepareStatement("INSERT INTO project_worker (project_id, worker_id) VALUES (?, ?)");
        for (int i = 0; i < count; i++) {
            try {
                System.out.println("Введіть id проекту: ");
                insert.setInt(1, sc.nextInt());
                System.out.println("Введіть id працівника: ");
                insert.setInt(2, sc.nextInt());
                insert.addBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        insert.executeBatch();
    }
    public int[] addProjectsWorkerFromFile () throws SQLException, IOException {
        List<String> list = Files.readAllLines(Path.of(project_workerFileName));

        insert = connection.prepareStatement("INSERT INTO project_worker (project_id, worker_id) VALUES (?, ?)");

        for (String s:list) {
            List<String> split = List.of(s.split(";"));
            for (String st:split) {
                String [] arr = st.split(",");
                try {
                    insert.setInt(1, Integer.parseInt(arr[0].trim()));
                    insert.setInt(2, Integer.parseInt(arr[1].trim()));
                    insert.addBatch();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return insert.executeBatch();
    }
}
