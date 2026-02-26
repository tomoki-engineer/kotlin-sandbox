package model

data class Employee(
    var name: String,
    var department: String,
    var salary: Int,
    var age: Int
)

data class PublicEmployee(
    var name: String,
    var age: Int?,
    var salary: Int
)