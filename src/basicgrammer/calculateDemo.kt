package basicgrammer

fun main(args: Array<String>) {
    println("请输入计算式，例如:1 + 2")//然后使用字符串分割函数将两个参数和运算符提取出来
    val input = readLine()
    if (input != null) {
        val nums = input.split(" ")
        val arg1 = nums[0].toDouble()
        val op = nums[1]
        val arg2 = nums[2].toDouble()
    }
}


//定义运算符
class Operator constructor(op: String) {
    val opFun: (left: Double, right: Double) -> Double

    init {
        opFun = when (op) {
            "+" -> { left, right -> left + right }
            "-" -> { left, right -> left - right }
            "*" -> { left, right -> left * right }
            "%" -> { left, right -> left % right }
            else ->
        }
    }

}