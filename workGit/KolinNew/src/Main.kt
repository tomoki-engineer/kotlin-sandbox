import model.DepartmentStats
import model.Employee
import model.PublicEmployee
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
    Employee("E", "Dev", 700, 56),
)

fun main() {
    val employees = listOf(
        PublicEmployee("Vader", 31, 900),
        PublicEmployee("Luke", null, 500),
        PublicEmployee("Leia", 19, 600),
        PublicEmployee("Han", null, 700)
    )



    /* 年齢がnullじゃない*/
    val ageList = employees.mapNotNull{it.age}
    println(ageList)

    /* 年齢がnullじゃない人の名前だけ*/
    val nameList = employees.mapNotNull{
        emp -> emp.age?.let{emp.name}
    }

    println(nameList)
}