data class User(val name:String, val age: Int)

val users = listOf(
    User("Vader", 31),
    User("Luke", 19),
    User("Leia", 19),
    User("Han", 35)
)

fun User.isAdult(): Boolean = age >= 20
fun main() {
    /* 名前の頭文字をキーにしてUserをマップ化 */
    val mapByFirst = users.associateBy { it.name.first() }
    println(mapByFirst)

    /* ネストされたリストを平らにする*/
    val nestedList = listOf(
        listOf(1, 2),
        listOf(3, 4)
    )

    val flat = nestedList.flatMap {it}
    println(flat)

    /* 条件で二分割*/
    val (adults, minors) = users.partition {it.age >= 20}
    println("大人：$adults")
    println("未成年：$minors")
}