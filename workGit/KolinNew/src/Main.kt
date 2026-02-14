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

    val employee = Employee("Vador", "Dev", 900, 31)

    // apply　→　自分自身に設定
    val updateEmployee = employee.apply {
        age += 1 /* 年齢アップ */
        salary += 100 /* 給料アップ */
    }

    println("After apply: $updateEmployee")

    /* also → 副作用 */
    updateEmployee.also {
        println("Logging employee info $it") /*　副作用ログ */
    }

    /* let → 値を受け取って別の型に変換 */
    val description = updateEmployee.let {
        "Employee: ${it.name}, Age: ${it.age}, Salary: ${it.salary}"
    }

    /* run → オブジェクトスコープで処理して結果を返す */
    val summary = updateEmployee.run{
        "Summary →　Name: $name, Age + Salary: ${age + salary} " }



}