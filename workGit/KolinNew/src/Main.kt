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
    val names = listOf("Vador", "Luke", "Leia")
    val salaries = listOf(900, 500, 600)

    //名前と給与をペアに
    val paired = names.zip(salaries)
    println(paired)

    val (unzippedNames, unzippedSalaries) = paired.unzip()
    println(unzippedNames)
    println(unzippedSalaries)

    val (highSalary, lowSalary) = employees.partition { it.salary >= 600 }
    highSalary.forEach { println("${it.name}:${it.salary}" ) }
    lowSalary.forEach { println("${it.name}:${it.salary}" ) }
}