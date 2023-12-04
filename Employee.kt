data class Employee(
    val id: Int,
    val name: String,
    val department: String?,
    val salary: Double?
)

fun filterEmployeesByDepartment(employees: List<Employee>, targetDepartment: String?): List<Employee> {
    return employees.filter { it.department == targetDepartment }
}

fun calculateAverageSalary(employees: List<Employee>): Double {
    val validSalaries = employees.mapNotNull { it.salary }
    return if (validSalaries.isNotEmpty()) {
        validSalaries.average()
    } else {
        0.0
    }
}

fun main() {
    // Sample list of employees
    val employees = listOf(
        Employee(1, "John Doe", "HR", 50000.0),
        Employee(2, "Jane Smith", "IT", 60000.0),
        Employee(3, "Bob Johnson", "HR", null),
        Employee(4, "Alice Williams", "Finance", 70000.0),
        Employee(5, "Charlie Brown", null, null)
    )

    // Filter employees in a specific department (e.g., "HR")
    val hrEmployees = filterEmployeesByDepartment(employees, "HR")

    println("HR Employees:")
    hrEmployees.forEach {
        println("${it.name} (ID: ${it.id}, Salary: ${it.salary ?: "Not available"})")
    }

    // Calculate the average salary in the IT department
    val itEmployees = filterEmployeesByDepartment(employees, "IT")
    val averageSalaryIT = calculateAverageSalary(itEmployees)

    println("\nAverage Salary in IT Department: $averageSalaryIT")
}
