package java_intro.week11.practical_11;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
// Create an immutable list of employees
        List<Employee> employees = List.of(
                new Employee(1, "Alice", 75000),
                new Employee(2, "Bob", 50000),
                new Employee(3, "Charlie", 120000),
                new Employee(4, "Diana", 45000),
                new Employee(5, "Eve", 90000)
        );
// 1. Filter Employees
        System.out.println("Employees earning above 60,000:");
        List<Employee> filteredEmployees = filterEmployees(employees, e -> e.getSalary() > 60000);
        filteredEmployees.forEach(System.out::println);
// 2. Sort Employees by Salary
        System.out.println("\nEmployees sorted by salary (ascending):");
        List<Employee> sortedBySalary =
                sortEmployees(employees,
                        Comparator.comparing(Employee::getSalary));
        sortedBySalary.forEach(System.out::println);
// 3. Transform Employee Names to Uppercase
        System.out.println("\nEmployee names in uppercase:");
        List<String> upperCaseNames =
                transformEmployeeNames(employees);
        upperCaseNames.forEach(System.out::println);
// 4. Aggregate Data: Total and Average Salary
        double totalSalary =
                employees.stream().mapToDouble(Employee::getSalary).sum();
        double averageSalary =
                employees.stream().mapToDouble(Employee::getSalary).average().
                        orElse(0);
        System.out.println("\nTotal Salary: " + totalSalary);
        System.out.println("Average Salary: " + averageSalary);
// Extra: Find employee with highest salary
        System.out.println("\nEmployee with the highest salary:");
        Employee highestSalaryEmployee =
                employees.stream().max(Comparator.comparing(Employee::getSalary)).orElse(null);
        System.out.println(highestSalaryEmployee);
// Extra: Group employees by salary range
        System.out.println("\nEmployees grouped by salary range:");
        Map<String, List<Employee>> groupedBySalaryRange =
                groupEmployeesBySalaryRange(employees);
        groupedBySalaryRange.forEach((range, empList) -> {
            System.out.println(range + ":");
            empList.forEach(System.out::println);
        });
    }

    // Method to filter employees based on a condition
    public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> condition) {
        return
                employees.stream().filter(condition).collect(Collectors.toList
                        ());
    }

    // Method to sort employees based on a comparator
    public static List<Employee> sortEmployees(List<Employee> employees, Comparator<Employee> comparator) {
        return
                employees.stream().sorted(comparator).collect(Collectors.toList());
    }

    // Method to transform employee names to uppercase
    public static List<String>
    transformEmployeeNames(List<Employee> employees) {
        return employees.stream().map(e ->
                e.getName().toUpperCase()).collect(Collectors.toList());
    }

    // Method to group employees by salary range
    public static Map<String, List<Employee>>
    groupEmployeesBySalaryRange(List<Employee> employees) {
        return
                employees.stream().collect(Collectors.groupingBy(e -> {
                    if (e.getSalary() < 50000) return "< 50K";
                    else if (e.getSalary() <= 100000) return
                            "50K-100K";
                    else return "> 100K";
                }));
    }
}
