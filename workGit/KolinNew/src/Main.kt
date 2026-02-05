import model.User

val users = listOf(
    User("Vader", 31),
    User("Luke", 19),
    User("Leia", 19),
    User("Han", 35)
)

fun main() {
    /* 名前→年齢のMap作成*/
    val nameToAgeMap = users.associate { user ->
        user.name to user.age
    }

    println(nameToAgeMap)

    /* 最年長だけMapする*/
    val oldestMap = users
        .maxByOrNull { it.age }
        ?.let { user ->
            mapOf(user.name to user.age)
        }
    println(oldestMap)

    /*年齢 →人数の Map*/
    val ageToPeopleCountMap = users
        .groupBy { it.age }.toSortedMap().mapValues { it.value.size }
    println(ageToPeopleCountMap)

    //年齢 → 名前一覧（カンマ区切り）の Map
    val ageToNameListMap = users
        .groupBy { it.age }.toSortedMap().mapValues { it.value.joinToString(", ") {it.name} }
    println(ageToNameListMap)
}