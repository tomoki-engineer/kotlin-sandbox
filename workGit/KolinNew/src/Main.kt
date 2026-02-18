import model.DepartmentStats
import model.Employee
import model.PublicEmployee
import model.User
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

fun main() {
    val avgAgeByDepart = employees
        .groupBy { it.department }
        .mapValues { emp ->
            val departName = emp.key
            val avgAge = emp.value.map{it.age}.average()
            val count = emp.value.size
            Triple(departName, avgAge, count)
        }.toList().sortedByDescending { it.second.second }


    println(avgAgeByDepart)

    val emp30Over = employees
        .groupBy { it.department }
        .mapValues{(_, list) ->
            list.filter{it.age >= 30}
                .sumOf { it.salary }
        }

    println(emp30Over)
}