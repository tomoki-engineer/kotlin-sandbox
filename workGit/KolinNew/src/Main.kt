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
    val numbers = (1..10).toList()

    /* 3個ずつに分割 */
    val chunks = numbers.chunked(3)
    println(chunks)

    val numbers2 = (1..5).toList()

    /* 3つの連続要素でウインドウ作成 */
    val windows = numbers2.windowed(size = 3, step = 1)
    println(windows)

    val average = numbers2.average()
    println(average)
}