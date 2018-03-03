package higherorderfunction

/**
 * 内联函数
 */

//我们先来看一下with方法
inline fun <T> with(t: T, body: T.() -> Unit) {
    t.body()
}

/**
 * 这个函数接收一个T类型的对象和一个被作为扩展函数的函数。它的实现仅仅是让
 * 这个对象去执行这个函数，因为第二个函数是一个函数，所以我们可以把它放在
 * 圆括号外面，所以我们可以创建一个代码块，在这个代码快中我们可以使用this直接访问
 * 所有的public方法和属性
 */
class Me {
    val age: Int = 19
    val name: String = "BarackBao"
    fun sout(mes: String) {
        println(mes)
    }

}


fun main(args: Array<String>) {
    with(Me()) {
        sout(name)
        sout(age.toString())
    }
}

/**
 * 内联函数与普通的函数有点不同，一个内联函数会在编译的时候被替换掉，而不是真正的方法调用。
 * 这在一些情况下可以减少内存分配和运行时开销，举个例子
 * 如果我们有一个函数，只接受一个函数作为他的参数，如果只是一个普通的函数，内部会创建一个
 * 含有那个函数的对象，但如果是内联函数会，它就会把我们调用这个函数的地方替换掉，所以它不需要为此
 * 生成一个内部的对象
 */