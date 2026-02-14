package model

data class Employee(
    var name: String,
    var department: String,
    var salary: Int,
    var age: Int
)

data class DepartmentStats(
    val avgAge: Double,
    val maxSalary: Int,
    val count: Int
)