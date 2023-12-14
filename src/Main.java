import java.util.List;

public class Main {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        // Add employee
        Employee newEmployee = new Employee(0,"Alice", 25, 60000.0);
        employeeDAO.addEmployee(newEmployee);

        // Retrieve all employees
        List<Employee> employees = employeeDAO.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Close the database connection
        DatabaseConnection.closeConnection();
    }
}
