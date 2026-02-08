import model.User

val users = listOf(
    User("Vader", 31),
    User("Luke", 19),
    User("Leia", 19),
    User("Han", 35)
)

fun main() {


    // 年齢 → (総人数, 未成年人数)
    val ageStats: Map<Int, Pair<Int,Int>> = users
        .groupBy { it.age }
        .mapValues{entry ->
            val total = entry.value.size
            val minors = entry.value.count{it.age < 20}
            total to minors
        }

    println(ageStats)
}