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

fun List<Employee>.highEarnersByDepartment(condition: (Employee) -> Boolean, topN:Int): Map<String, DepartmentStats> {
    return this.groupBy(Employee::department).mapValues { (_,list) ->
        val filtered = list.filter (condition)
            .sortedByDescending { it.salary }
            .take(topN)

        filtered.agregateStats()
    }
}

data class DepartmentStats(
    val avgAge: Double,
    val maxSalary: Int,
    val employeeNames: List<String>,
    val count: Int
)

private fun List<Employee>.agregateStats(): DepartmentStats{
    if(this.isEmpty()) {
        return DepartmentStats(
            avgAge = 0.0,
            maxSalary = 0,
            employeeNames = emptyList(),
            count = 0
        )
    }

    val avgAge = this.map{it.age}.average()
    val maxSalary = this.maxOf{it.salary}
    val employeeNames = this.map{"${it.name}(${it.salary})"}
    val count = this.size

    return DepartmentStats(
        avgAge,
        maxSalary,
        employeeNames,
        count
    )
}


fun calculateAverageSalary(
    emp: List<Employee>,
    filterAge: Int
):Map<String, Double>{
    val calcAverage = emp.groupBy{it.department}.mapValues { (_, list) ->
        list
            .asSequence()
            .filter { it.age >= filterAge }
            .map { it.salary }
            .average()
    }

    return calcAverage
}

fun <K,R> List<Employee>.aggregateByDepartment(
    keySelector: (Employee) -> K,
    operation: (List<Employee>) -> R
): Map<K, R> {
    return this
        .groupBy { keySelector(it) }
        .mapValues{(_, list) ->
            operation(list)
        }
}

fun plusCalc(param1 :Int, param2 :Int) : Int{
    return (param1 + param2)
}

fun minusCalc(param1 :Int, param2 :Int): Int{
    return (param1 - param2)
}





fun main() {
    val avgSalary = employees.aggregateByDepartment(
        keySelector = { it.department},
        operation =  {list -> list.map{it.salary}.average()}
    )

    val countByAge = employees.aggregateByDepartment(
        keySelector = {it.age},
        operation = {list -> list.size}
    )
}