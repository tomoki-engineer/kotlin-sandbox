import model.DepartmentStats
import model.Employee
import model.User

val users = listOf(
    User("Vader", 31),
    User("Luke", 19),
    User("Leia", 19),
    User("Han", 35)
)

val employees = listOf(
    Employee("A", "Dev", 500, 31),
    Employee("B", "Dev", 600, 48),
    Employee("C", "HR", 400, 19),
    Employee("D", "HR", 450,28),
    Employee("E", "Dev", 700, 56)
)

fun main() {
    val tripleListSort = employees.groupBy{it.department}
        .mapValues { entry ->
            val average = entry.value.map{it.age}.average()
            val maxSalary = entry.value.map{it.salary}.max()
            val peopleCount = entry.value.size
            Triple(average , maxSalary , peopleCount)
        }.toList().sortedByDescending { it.second.second }
    println(tripleListSort)

    val avgAgeSortModel = employees.groupBy{it.department}
        .mapValues { (_, list) ->
            DepartmentStats(
                avgAge = list.map{it.age}.average(),
                maxSalary = list.map{it.salary}.max(),
                count = list.size
            )
        }.toList().sortedByDescending { it.second.avgAge }
    println(tripleListSort)
}