import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private static Connection connection;
    //Lazy Initialization
    // Constructor to initialize the connection
    public EmployeeDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    // Method to add an employee
    public void addEmployee(Employee employee) {
    String name = employee.getName();
    int age = employee.getAge();
    double salary = employee.getSalary();
        // Ensure the connection is not null before proceeding
      
        if (connection != null) {
            String sql = "INSERT INTO employees (name, age, salary) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, age);
                preparedStatement.setDouble(3, salary);

                // Execute the update
                preparedStatement.executeUpdate();

                System.out.println("Employee added successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Connection is null. Cannot perform database operations.");
        }
    }

    public List<Employee> getAllEmployees() {
    List<Employee> employees = new ArrayList<>();

    // Ensure the connection is not null before proceeding
    if (connection != null) {
        String sql = "SELECT * FROM employees";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Iterate over the result set and create Employee objects
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double salary = resultSet.getDouble("salary");

                Employee employee = new Employee(id, name, age, salary);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } else {
        System.err.println("Connection is null. Cannot perform database operations.");
    }

    return employees;
}

}

