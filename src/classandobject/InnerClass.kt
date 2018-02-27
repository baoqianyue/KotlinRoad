package classandobject

/**
 * 静态内部类和匿名内部类
 * kotlin中内部类默认是静态的，这与Java相反，在java中需要使用static关键字修饰内部类成为静态内部类
 * 如果想要把内部类变为非静态的，需要使用inner关键字
 */


/**
 * 静态内部类
 */
open class Outter {
    class Inner {

    }
}

/**
 * 非静态内部类
 */
class Outter1 {
    val a: Int = 5

    inner class Inner1 {
        val a: Int = 4
        fun sout() {
            //分别访问外部类的属性和非静态内部类的属性
            println(this@Outter1.a)
            println(this.a)
        }

    }
}

/**
 * 匿名内部类
 */
interface OnClickListener {
    fun onClick()
}

class View {
    var onClickListener: OnClickListener? = null
}

fun main(args: Array<String>) {
    val inner = Outter.Inner()//新建静态内部类实例，使用类名
    val inner1 = Outter1().Inner1()//新建非静态内部类实例，使用外部类对象新建

    val view = View()
    //kotlin创建匿名内部类时，使用一个object对象来实现或继承接口或类
    view.onClickListener = object : Outter(), OnClickListener {
        override fun onClick() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}