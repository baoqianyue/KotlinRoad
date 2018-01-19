package basicgrammer

/**
 * Created by BarackBao on 2017/12/1.
 */


/**
 * 可以使用下划线使数字常量更加直观
 */
val oneMillion = 1_000_000

/**
 * 数据类型的显示转换
 * 较小的数据类型不能隐式转换为较大的数据类型(与java不同，java中int可以隐式转换为long类型)，但是可以显示拓宽
 */

//测试一下较小数据类型到较大数据类型的转换
fun DatatypeCastTest() {
    val a: Byte = 1
//    val b : Int = a//这里编译不通过
    //我们使用显示拓宽数据类型
    val b: Int = a.toInt()
    //每种数据类型都有各自的拓宽方法
    val c: Long = a.toLong()
    val d: Double = a.toDouble()
}


/**
 * 位运算，Kotlin中没有对应于位运算的特殊字符，只能采用中缀方式调用对应的位运算函数
 * 下面列举一下(只用于Int和Long类型)
 */

fun BitOperationDemo() {
    val a = 5 shl 2 //有符号左移(<<)
    val b = 5 shr 2 //有符号右移(>>)
    val c = 5 ushr 2 //无符号右移(>>>)
    val d = 5 and 3 //位与
    val e = 5 or 3 //位或
    val f = 5 xor 3 //位异或
}

/**
 * 字符
 */

//字符用Char类型表示，但是不能直接当作数字
//可以显式的将字符转换成数字
fun charCastToSum(ch: Char): Int {
    if (ch !in '0'..'9') {
        throw IllegalArgumentException("Out of range")
    }
    return ch.toInt() - '0'.toInt()
}


/**
 * 数组类型
 * Kotlin中的数组也可以使用[]运算符来获取某个索引指向的元素
 * 但是需要注意的是，在kotlin中数组被封装成了Array类，这和java是不同的
 * 所以如果我们使用[]来操作时实质上时调用了Array类的成员函数get()和set()
 * 还有一点，在kotlin中数组类型是不可变的，这也是与java不同的一点
 */


//使用库函数arrayOf()创建一个数组
fun arrayTypeTest(): Array<String?> {
//    return arrayOf("bao","qian","yue")
    //库函数arrayOfNulls可以创建一个指定类型和大小的数组
    return arrayOfNulls<String?>(2)
}

//传入数组的长度和工厂函数来创建数组，工厂函数可以对对应索引的数组元素赋值
fun createArray() {
    //新建一个数组["0","1","4","9"."16"]
    Array(5, { i -> (i * i).toString() })
}

//kotlin也支持无装箱开销的原生数组类型数组
//虽然这些原生数组类型与Array类没有直接的继承关系，但是却有类似的成员方法，比如get,set
fun baseArrayType() {
    val byteArr: ByteArray = byteArrayOf(1, 3, 4, 5)
    val intArr: IntArray = intArrayOf(1, 2, 2, 3)
    intArr[1] = intArr[2] + intArr[0]
    intArr[3] = 3
}


/**
 * 字符串
 * kotlin中字符串也是不可变类型，这与java一致
 */
//字符串可以使用[]来获取对应索引的字符，也可以使用for遍历
fun traverseString(str: String) {
    for (s in str) {
        println(s)
    }
}

//转义字符串，可以包括转义字符
//val test = "BarackBao\n"

//原生字符串，字符串中可以包含各种字符且不承认转义字符，需要三引号括起来""""""
fun nativityStringTest() {
    val nativityString = """
        hello
        world
        barack
        bao
    """.trimMargin() //去除前导空格
    println(nativityString)
}


//字符串模板，在模板表达式中使用美元符$引用到字符串
fun templateStringTest(): Unit {
    val str: String = "BarackBao"
    println("I am $str")
}


fun main(args: Array<String>) {
//    println(charCastToSum('5')
    val s: String = "BarackBao"
//    traverseString(s)
//    nativityStringTest()
    templateStringTest()
}
