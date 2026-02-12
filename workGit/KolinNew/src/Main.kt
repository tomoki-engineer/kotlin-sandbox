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
    val result = listOf(1,2,3,4,5)
        .filter{it % 2 == 1}
        .map{it * it}
        .take(2)
    println(result)


    val adultsNameList = users.filter { it.age >= 20 }.map{it.name}.joinToString(", ")

    println(adultsNameList)

    val employeeOrderByDescAverage = employees.groupBy{it.department}
        .mapValues {entry ->  entry.value.map{it.age}.average()}.toList().sortedByDescending { it.second }

    println(employeeOrderByDescAverage)

    for (i in 0..255) {
        // "%08d"で8桁にして、toString(2)で2進数に変換
        val binary = i.toString(2).padStart(8, '0')
        println("$i: $binary")
    }
}