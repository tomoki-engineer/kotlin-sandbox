import model.User

val users = listOf(
    User("Vader", 31),
    User("Luke", 19),
    User("Leia", 19),
    User("Han", 35)
)

fun main() {
    val ageToNames = users
        .groupBy {it.age}
        .mapValues { entry ->
            entry.value.map{it.name}
        }

    println(ageToNames)

    val ageStats = users
        .groupBy { it.age }
        .mapValues { entry ->
            val total = entry.value.size
            val minor = entry.value.count{it.age < 20}
            total to minor
        }

    println(ageStats)

    val adultNames = users
        .filter { it.age >= 20 }
        .sortedBy { it.age }
        .map{it.name}

    println(adultNames)
}