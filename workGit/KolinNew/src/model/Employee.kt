package model

data class Employee(
    val name: String,
    val department: String,
    val salary: Int,
    val age: Int
)

data class DepartmentStats(
    val avgAge: Double,
    val maxSalary: Int,
    val count: Int
)