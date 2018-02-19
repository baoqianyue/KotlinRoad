package classandobject

import java.lang.StringBuilder

/**
 * 扩展成员
 */


/**
 * 下面写一个String类的扩展方法，用来重复字符串
 */
fun String.mutiply(i: Int): String {
    val stringBuilder: StringBuilder = StringBuilder()
    //使用StringBuilder调用方字符串重复i次
    for (i in 0 until i) {
        stringBuilder.append(this) //这里的this就可以指代调用方
    }
    return stringBuilder.toString()
}

//还可以给运算符重载,这样就可以实现类似Python中使用*来重复元素的功能
operator fun String.times(i: Int): String {
    val stringBuilder: StringBuilder = StringBuilder()
    for (i in 0 until i) {
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}


fun main(args: Array<String>) {
    val str: String = "Bao"
    println(str.mutiply(5))
    println(str * 5)
}