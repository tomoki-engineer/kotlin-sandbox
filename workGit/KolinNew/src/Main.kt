import model.DepartmentStats
import model.Employee
import model.PublicEmployee
import model.User
import service.EmployeeService
import kotlin.collections.sortedBy

val users = listOf(
    User("Vader", 31),
    User("Luke", 19),
    User("Leia", 19),
    User("Han", 35)
)

val employees = listOf(
    Employee("Vader", "IT", 900, 31),
    Employee("Luke", "IT", 500, 19),
    Employee("Kenobi", "IT", 800, 45),

    Employee("Leia", "HR", 600, 19),
    Employee("Han", "HR", 750, 35),
    Employee("Rey", "HR", 720, 22),

    Employee("Yoda", "Finance", 1200, 900),
    Employee("Finn", "Finance", 650, 23)
)

val publicEmployees = listOf(
    PublicEmployee("Vader", 31, 900),
    PublicEmployee("Luke", null, 500),
    PublicEmployee("Leia", 19, 600),
    PublicEmployee("Han", null, 700),
    PublicEmployee("Kenobi", 45, 800)
)

fun List<Employee>.highEarnersByDepartment(minAge: Int): Map<String, List<String>> {
    val highNameAry = this.groupBy{it.department}.mapValues { (_,list) ->
        val ageOverEmployee = list.filter { it.age >= minAge }

        if(ageOverEmployee.isEmpty()) return@mapValues emptyList()
        val avgSalary = ageOverEmployee.map { it.salary }.average()
        val nameList = ageOverEmployee.filter { it.salary > avgSalary }.map{it.name}
        nameList
    }
    return highNameAry
}

fun main() {
    val result = employees.highEarnersByDepartment(30)

    println(result)
}