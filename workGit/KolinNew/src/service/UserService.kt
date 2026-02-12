package service

import employees
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

    fun userMapFunction(){
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

        //名前 → 未成年かどうか(Boolean)のMap
        val nameToMinors = users.associate{it.name to (it.age<20)}
        println(nameToMinors)

        //大人の名前だけを、年齢順のListで作る
        val adultsNameList = mutableListOf<String>()

        users.filter { it.age >= 20 }
            .sortedBy { it.age }.forEach {
                    user -> adultsNameList.add(user.name)
            }

        println(adultsNameList)
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


        // 大人/未成年別 Map<User>
        val adultsAndMinorsMap: Map<Boolean,List<User>> = users.groupBy { it.age >= 20 }
        println(adultsAndMinorsMap)

        // 大人／未成年別 Map、年齢順に名前リスト
        val adultsAndMinorsNames: Map<Boolean,List<String>> = users
            .groupBy{it.age>=20}
            .mapValues { entry -> entry.value.sortedBy { it.age }.map{it.name} }

        /* 年齢→未成年フラグList  */
        val ageToMinorFlags: Map<Int, List<Boolean>> = users
            .groupBy { it.age }
            .mapValues{entry ->
                entry.value.map{it.age < 20}
            }

        println(ageToMinorFlags)

        /*　平均500以上の年収の従業員 */
        val employeeAvgSalary500More = employees.groupBy { it.department }.mapValues { depart ->
            depart.value.map{it.salary}.average()
        }
            .filter { avg -> avg.value >= 500 }
        println(employeeAvgSalary500More)

        val maxSalaryByDepart = employees.groupBy{it.department}
            .mapValues {it.value.maxOf{it.salary}}

        println(maxSalaryByDepart)
    }

    fun ageStatus(){
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

    fun flatList(){
        /*　ネストリストを平らにする */
        val nestedList = listOf(listOf(1,2), listOf(3,4), listOf(5))
        val flatList = nestedList.flatMap{it}
        println(flatList)
    }


}