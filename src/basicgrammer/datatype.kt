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
 * 较小的数据类型不能隐式转换为较大的数据类型，但是可以显示拓宽
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

fun BitOperationDemo(){
    val a = 5 shl 2 //有符号左移(<<)
    val b = 5 shr 2 //有符号右移(>>)
    val c = 5 ushr 2 //无符号右移(>>>)
    val d = 5 and 3 //位与
    val e = 5 or 3 //位或
    val f = 5 xor 3 //位异或
}


fun main(args: Array<String>) {

}
