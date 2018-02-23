package higherorderfunction

/**
 * 高阶函数
 *
 */


/**
 * 几种函数引用的方式
 */
fun main(args: Array<String>) {
    /** 1.引用包级函数
     * 可以使用函数引用的方式调用包级函数
     * 这里forEach里面需要一个lambda，但是println是一个包级函数，其参数与forEach所需lambda的参数一致，可以使用函数引用的方式
     */
    args.forEach(::println)

    /** 2.引用成员方法或扩展方法
     * 可以直接使用类名引用成员方法
     *
     */
    var str:String = "test"
    val test = Test::test
    args.filter(String::isNotEmpty)


}

class Test {
    fun test() {
        println("test")
    }
    fun test1(str:String){
        println(str)
    }
}

