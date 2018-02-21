package classandobject

/**
 * kotlin中内部类默认是静态的，这与Java相反，在java中需要使用static关键字修饰内部类成为静态内部类
 * 如果想要把内部类变为非静态的，需要使用inner关键字
 */
class Outter{
    class Inner{

    }
}

class Outter1{
    inner class Inner1{

    }
}

fun main(args: Array<String>) {
    val inner = Outter.Inner()//新建静态内部类实例，使用类名
    val inner1 = Outter1().Inner1()//新建非静态内部类实例，使用外部类对象新建
}