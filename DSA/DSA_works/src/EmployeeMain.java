
class Employee {
    protected String employeeId;
    protected String name;
    protected String department;
    protected double basicSalary;

    public Employee(String employeeId, String name,
                    String department, double basicSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.basicSalary = basicSalary;
    }

    public double calculateSalary() {
        return basicSalary;
    }

    public String getCategory() {
        return "Employee";
    }

    public void displayInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Category: " + getCategory());
        System.out.printf("Monthly Salary: $%.2f%n",
                calculateSalary());
        System.out.println();
    }
}

class FullTimeEmployee extends Employee {
    private double allowance;

    public FullTimeEmployee(String id, String name,
                            String department, double salary, double allowance) {
        super(id, name, department, salary);
        this.allowance = allowance;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + allowance;
    }

    @Override
    public String getCategory() {
        return "Full-Time Employee";
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String id, String name,
                            String department, int hoursWorked, double hourlyRate) {
        super(id, name, department, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public String getCategory() {
        return "Part-Time Employee";
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String id, String name,
                   String department, double salary, double bonus) {
        super(id, name, department, salary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + bonus;
    }

    @Override
    public String getCategory() {
        return "Manager";
    }
}

public class EmployeeMain {
    public static void main(String[] args) {

        Employee[] employees = {
                new FullTimeEmployee(
                        "EMP001", "Ahmed Ali", "IT", 500, 150),

                new PartTimeEmployee(
                        "EMP002", "Fatima Hassan", "HR", 20, 12),

                new Manager(
                        "EMP003", "Mohamed Omar", "Finance", 1000, 200)
        };

        System.out.println("===== EMPLOYEE SALARY REPORT =====");
        System.out.println();

        for (Employee emp : employees) {
            emp.displayInfo();
        }
    }
}
