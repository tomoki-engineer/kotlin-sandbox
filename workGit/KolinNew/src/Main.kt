import model.User

val users = listOf(
    User("Vader", 31),
    User("Luke", 19),
    User("Leia", 19),
    User("Han", 35)
)

fun main() {

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