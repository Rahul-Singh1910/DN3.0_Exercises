
public class EmployeeManagement {
    private Employee[] employees;
    private int size;

    public EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Method to add an employee
    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Employee array is full. Cannot add more employees.");
        }
    }

    // Method to search an employee by ID
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Method to traverse and display all employees
    public void displayEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Method to delete an employee by ID
    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                employees[i] = employees[--size];
                employees[size] = null;
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        EmployeeManagement ems = new EmployeeManagement(10);
        
        Employee emp1 = new Employee(101, "John Doe", "Manager", 75000);
        Employee emp2 = new Employee(102, "Jane Smith", "Developer", 65000);
        Employee emp3 = new Employee(103, "Emily Davis", "Designer", 60000);
        
        ems.addEmployee(emp1);
        ems.addEmployee(emp2);
        ems.addEmployee(emp3);
        
        System.out.println("All Employees:");
        ems.displayEmployees();
        
        System.out.println("\nSearch for Employee with ID 102:");
        Employee emp = ems.searchEmployee(102);
        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println("Employee not found.");
        }
        
        System.out.println("\nDeleting Employee with ID 102:");
        ems.deleteEmployee(102);
        
        System.out.println("\nAll Employees after deletion:");
        ems.displayEmployees();
    }
}

