import model.User

val users = listOf(
    User("Vader", 31),
    User("Luke", 19),
    User("Leia", 19),
    User("Han", 35)
)

fun main() {
    /*　未成年と大人別の名前List */
    val adultsAndMinors: Map<Boolean, List<String>> = users
        .groupBy{ it.age >= 20 }
        .mapValues{ entry -> entry.value.sortedBy { it.age }.map{it.name}}

    println(adultsAndMinors)

    /*　名前の頭文字でMapを作る */
    val mapByFirstLetter = users.associateBy { it.name.first() }
    println(mapByFirstLetter)

    /*　ネストリストを平らにする */
    val nestedList = listOf(listOf(1,2), listOf(3,4), listOf(5))
    val flatList = nestedList.flatMap{it}
    println(flatList)
}