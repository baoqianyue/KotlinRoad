package basicgrammer

fun main(args: Array<String>) {
    while (true) {
        try {
            println("请输入计算式，例如:1 + 2")//然后使用字符串分割函数将两个参数和运算符提取出来
            val input = readLine() ?: break //直接判空
            val nums = input.trim().split(" ")
            val arg1 = nums[0].toDouble()
            val op = nums[1]
            val arg2 = nums[2].toDouble()
            println("$arg1 $op $arg2 = ${Operator(op).apply(arg1, arg2)}")

        } catch (e: NumberFormatException) {
            println("你输入的数字非法，请重新输入")
        }
        println("是否继续计算?[y]")
        val cmd = readLine()
        if (cmd == null || cmd.toLowerCase() != "y") {
            break
        }

    }
}


//定义运算符
class Operator(op: String) {
    val opFun: (left: Double, right: Double) -> Double

    init {
        opFun = when (op) {
            "+" -> { left, right -> left + right }
            "-" -> { left, right -> left - right }
            "*" -> { left, right -> left * right }
            "%" -> { left, right -> left % right }
            else -> {
                throw UnsupportedOperationException(op)
            }
        }
    }

    fun apply(arg1: Double, arg2: Double): Double {
        return opFun(arg1, arg2)
    }
}


