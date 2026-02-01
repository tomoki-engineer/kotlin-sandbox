data class User(val name:String, val age: Int)

val users = listOf(
    User("Vader", 31),
    User("Luke", 19),
    User("Leia", 19),
    User("Han", 35)
)

fun main() {
    /* 20歳以上 */
    val user20More = users.filter{it.age >= 20}.groupBy{it.name.first()}
        .mapValues{entry -> entry.value.joinToString(", "){it.name + "(" + it.age + ")"} }

    println(user20More)

    /* 20歳未満 */
    val user20Under = users.filter{it.age < 20}.groupBy{it.name.first()}

    println(user20Under)

    /* 未成年 */
    val userMinor = users.groupingBy { it.age < 20 }.eachCount()
    println(userMinor)
}