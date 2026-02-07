import model.User

val users = listOf(
    User("Vader", 31)：
    User("Luke", 19),
    User("Leia", 19),
    User("Han", 35)
)

fun main() {

    // 大人/未成年別 Map<User>
    val adultsAndMinorsMap: Map<Boolean,List<User>> = users.groupBy { it.age >= 20 }
    println(adultsAndMinorsMap)

    // 大人／未成年別 Map、年齢順に名前リスト
    val adultsAndMinorsNames: Map<Boolean,List<String>> = users
        .groupBy{it.age>=20}
        .mapValues { entry -> entry.value.sortedBy { it.age }.map{it.name} }
}