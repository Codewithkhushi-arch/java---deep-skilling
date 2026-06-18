class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    public void add(Employee emp) {
        if (count < employees.length) {
            employees[count++] = emp;
        } else {
            System.out.println("Capacity reached!");
        }
    }

    public Employee search(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) return employees[i];
        }
        return null;
    }

    public void traverse() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i].name + " - " + employees[i].position);
        }
    }

    public void delete(int employeeId) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[count - 1] = null;
            count--;
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);
        ems.add(new Employee(1, "Alice", "Manager", 5000));
        ems.add(new Employee(2, "Bob", "Developer", 4000));
        
        System.out.println("All Employees:");
        ems.traverse();
        
        System.out.println("Search for ID 2:");
        Employee emp = ems.search(2);
        if (emp != null) {
            System.out.println("Found: " + emp.name);
        }
        
        System.out.println("Deleting ID 1:");
        ems.delete(1);
        ems.traverse();
    }
}
/*
Output:
All Employees:
Alice - Manager
Bob - Developer
Search for ID 2:
Found: Bob
Deleting ID 1:
Bob - Developer
*/
