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

    /*総人数 */
    val totalPeopleCount = users.size
    println("総人数：$totalPeopleCount")

    /*平均年齢 */
    val averageAge = users.map{it.age}.average()
    println("平均年齢：$averageAge")

    /*最年長 */
    val oldestPerson = users.maxByOrNull{it.age}
    println("最年長：${oldestPerson?.name} (${oldestPerson?.age})")
    /*未成年カウント */
    val minorCount = users.count{ it.age < 20 }
    println("未成年人数：$minorCount")
}