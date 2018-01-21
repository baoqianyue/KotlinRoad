package basicgrammer

/**
 * Created by BarackBao on 2017/11/27.
 */


/**
 * 定义函数
 * 带有两个Int参数，返回值为Int
 */

private fun sum(a: Int, b: Int): Int {
    return a + b
}

/**
 * 将表达式作为函数主体，返回值类型自动推断
 */
fun sum1(a: Int, b: Int) = a + b

/**
 * 函数返回无意义值(Unit返回类型可以省略)
 */
fun sum2(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

/**
 * 定义局部变量
 */

//一次赋值的变量
val a: Int = 1 //立即赋值
val b = 2 //自动推断类型

//可变变量
var x = 5 //自动推断类型

/**
 * 使用字符串模板
 */
var a1 = 1
//模板中的简单名称
val s1: String = "a1 is $a1"

//a1 = 3
val s2 = "${s1.replace("is", "was")},but now is $a1"


/**
 * 使用条件表达式
 */

fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

//使用if作为表达式
fun maxOf1(a: Int, b: Int): Int = if (a > b) a else b

/**
 * 使用可空值及null检测
 */

//当某个变量的值可以为null的时候，必须在声明处的类型后添加？来标识该引用可以为空
//如果str的内容不是数字返回null
fun parseInt(str: String): Int? {
    return 2//这个地方返回值不重要，只是为了表示返回值可以为null
}

//使用返回可空值的函数
fun print(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)
//    println(x * y)
// 直接使用x*y可能会报错，因为他们有可能为null
    if (x != null && y != null) {
        //在空安全检测后，x和y会自动转换为非空值(non_nullable)
        println(x * y)
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}

//或者

fun print1(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)
//    println(x * y)
    //直接使用x*y会报错
    if (x == null) {
        println("wrong number format：'$arg1'")
        return
    }
    if (y == null) {
        println("wrong number format: '$arg2'")
        return
    }
    //在空安全检测后，x和y会自动转换非空值
    println(x * y)
}

/**
 * 使用类型检测和自动类型转换
 */

//is运算符可以检测一个变量是否为某类型的一个实例,类似于java中的instanceof()
// 如果一个不可变的局部变量或属性已经判断出为某属性，那么检测后的分支中可以直接当做该类型使用，无需再显示转换

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        //obj在这个条件分支中已自动转换为String类型,可以直接当作String使用
        return obj.length//这时将鼠标放在obj上面，ide会提示'Smart cast to Kotlin.String'
    }
    //在离开类型检测分支后，obj仍然为Any类型
    return null
}

//或者
fun getStringLength1(obj: Any): Int? {
    if (obj !is String) return null
    //obj在这一分支自动转换成String
    return obj.length
}

//甚至
fun getStringLength2(obj: Any): Int? {
    //obj在&&右侧已经自动转换成String类型
    if (obj is String && obj.length > 0) {
        return obj.length
    }
    return null
}


/**
 * 使用for循环
 */
fun forTest() {
    //listOf只能返回只读的集合，而且需要直接传入参数初始化
    val items = listOf("China", "America", "Japan")
    for (item in items) {
        println(item)
    }
    //或者
    for (index in items.indices) {
        println("the $index is ${items[index]}")
    }
}

/**
 * 使用while循环
 */
fun whileTest() {
    val items = listOf("China", "America", "Japan")
    var index: Int = 0
    while (index < items.size) {
        println("the $index is ${items[index]}")
        index++
    }
}


/**
 * 使用when表达式
 * 比switch好用多了woc
 */
fun whenTest(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Barack" -> "Bao"
            is Long -> "Long"
            !is String -> "Not is a String"
            else -> "Unknown"
        }

fun whenTest1(obj: Any): String? {
    when (obj) {
        1 -> "barack";
        2 -> "bao";
        else -> "Unknown"
    }
    return null
}


/**
 * 使用区间(Range)
 */
//使用in判断一个数字是否在一个区间内
fun rangeTest() {
    val a = 9
    val b = 10
    if (b in 1..a + 1) {
        println("fits in the range")
    }
}

//判断一个数字是否在区间外
fun rangeTest1() {
    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    //输出一下list.indices
    println("list.indices:" + list.indices)
    println(list.indices)
    //list.indices就是一个IntRange，指集合有效索引构成的一个range
    if (list.size !in list.indices) {
        println("list size is out of list valid indices range too")
    }
}

//区间迭代
fun rangeTest2() {
    for (x in 1..5) {
        print(x)
    }
    println()
}

//数列迭代
fun rangeTest3() {
    //间隔2进行数列遍历
    for (x in 1..10 step 2) {
        print(x)
    }
    println()
    //从后往前间隔3遍历数列
    for (x in 9 downTo 0 step 3) {
        print(x)
    }
}

/**
 * 使用集合
 */
//遍历集合
fun listTest() {
    val items = listOf("China", "America", "Japan")
    for (item in items) {
        println(item)
    }

    //使用in运算符来判断集合中是否包含某实例
    when {
        "America" in items -> println("contain too")
    //或者
        "China" in items -> println("contain")
    }
}


//使用lambda表达式来过滤(filter)和映射(map)集合
fun lambdaListTest() {
    val items = listOf("China", "America", "Japan","iambarackBao")
    items.filter { it.startsWith("i") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}


fun main(args: Array<String>) {
//    println(sum(2, 3))
//    println(sum1(2, 3))
//    sum2(2, 3)
//    println(s2)
//    println(maxOf(2,4))
//    forTest()
//    whileTest()
//    println(whenTest("Barack"))
//    println(whenTest(2))
//    rangeTest()
//    rangeTest1()
//    rangeTest2()
//    rangeTest3()
//    listTest()
    lambdaListTest()
}