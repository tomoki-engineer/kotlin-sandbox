package service

import model.User
import users

object UserService {
    fun printAdultsAndMinors(users: List<User>) {
        val (adults, minors) = users.partition { it.age >= 20 }

        println("【大人】")
        adults.sortedBy { it.age }
            .forEach { println("${it.age}歳: ${it.name}") }

        println("【未成年】")
        minors.sortedBy { it.age }
            .forEach { println("${it.age}歳: ${it.name}") }


    }

    /*未使用ファンクション */
    fun unusedFunction(){
        /* 名前の頭文字をキーにしてUserをマップ化 */
        val mapByFirst = users.associateBy { it.name.first() }
        println(mapByFirst)

        /* ネストされたリストを平らにする*/
        val nestedList = listOf(
            listOf(1, 2),
            listOf(3, 4)
        )

        val flat = nestedList.flatMap { it }
        println(flat)

        /*総人数 */
        val totalPeopleCount = users.size
        println("総人数：$totalPeopleCount")

        /*平均年齢 */
        val averageAge = users.map { it.age }.average()
        println("平均年齢：$averageAge")

        /*最年長 */
        val oldestPerson = users.maxByOrNull { it.age }
        println("最年長：${oldestPerson?.name} (${oldestPerson?.age})")
        /*未成年カウント */
        val minorCount = users.count { it.age < 20 }
        println("未成年人数：$minorCount")

        /* 年齢順に並べて表示 */
        users.sortedBy{it.age}.forEach{println("${it.age}:${it.name}")}

        /*　年齢ごとにグループ化して表示 */
        users.sortedBy { it.age }.groupBy { it.age }
            .forEach { (age, group) ->
                val names = group.joinToString(", ") { it.name }
                println("${age}歳: $names") }

        /*　年齢ごとの人数も表示する */
        users.sortedBy { it.age }.groupBy { it.age }
            .forEach { (age, group) ->
                val names = group.joinToString(", ") { it.name }
                println("${age}歳 (${group.size}人): $names") }
    }
}