package classandobject


/**
 * kotlin中使用class关键字声明类
 * 类声明可以有类名、构造参数、和类体
 */
class Person {
    val age: Int = 18
}


//如果类体为空，大括号可以省略
class Person1


/**
 * 构造函数，一个类的构造函数分为一个主构造函数和多个次构造函数
 */

//主构造函数是类头的一部分，放在类名的后面
class Person2 constructor(age: Int, isBoy: Boolean) {

}

//如果主构造函数参数中没有注解或者可见性修饰符，则关键字constructor可省略
class Person3(age: Int, isBoy: Boolean) {

}

//主构造函数内不能含有任何的代码，如果想要初始化赋值，要在init代码块中进行
class Person4(age: Int, isBoy: Boolean, name: String) {
    init {
        val thisAge: Int = age;
        val gender: Boolean = isBoy
        val name: String = name
        println("初始化..." + age)
    }

    //主构造函数中的参数除了可以在init代码块中使用，在类体中也可以使用
    val customName = name.toUpperCase()
}

//其实还有更简洁的写法，直接定义参数加上初始化赋值一气呵成
class Person5 constructor(val age: Int, val name: String, var isBoy: Boolean)


//类中也可以有次级构造函数,在类体中使用constructor关键字定义次级构造函数

class Person6 {
    constructor(parent: Person6) {
        println(parent)
    }
}

//如果一个类已经有了一个主构造函数，那其他所有的次级构造函数都需要委托或者间接委托给主构造函数
//委托可以看作是将主构造函数中的参数传递给次构造函数，委托使用关键字this
class Person7 constructor(val name: String) {
    constructor(name: String, parent: Person7) : this(name) {
        println(name)
    }
}

//如果一个类没有任何构造函数时，编译器会自动生成一个不带参数的默认主构造函数，构造函数的可见性符为public，
//也可以给构造函数设置为private
class Person8 private constructor() {

}


/**
 * 新建对象，在kotlin中无new关键字，新建对象可以像调用普通方法一样
 */
fun createObjectDemo(): Person {
    val person: Person = Person()
    return person
}


/**
 * 继承，在kotlin中没有extends关键字，继承用:表示
 * 首先，默认的超类是Any
 * 我们需要创建一个显示的超类，然后使用子类继承它
 */

//这里与java不同的是open与java中的final正好相反，open表示该类可以被其他类继承
//所以可以看出，kotlin中的类默认都是final的(不可以被继承)，如果在类声明前加上open关键字，代表该类可以被继承
//****如果类有一个主构造函数，其子类型的初始化必须使用子类型本身的主构造函数初始化****
open class Base constructor(a: Int) {

}

//继承使用:
class CustomClass(a: Int) : Base(a) {

}


//如果类没有主构造函数，那么每个次级构造函数都需要使用super关键字初始化，或者委托给另一个次级构造函数
open class View {
    constructor(st: String)
    constructor(st: String, num: Int)
}

class MyView : View {
    constructor(st: String) : super(st)

    constructor(st: String, num: Int) : super(st, num)
}


/**
 * 覆盖方法
 * kotlin需要显示标注可覆盖的成员和覆盖后的成员(函数和属性)
 */
//只有在类声明时加上open关键字，类中的成员才有机会被覆盖
//一个final类中，开放成员是禁止的
open class Base1 {
    //只有加上了open关键字修饰的成员才有资格被覆盖
    open fun f() {}

    fun nf() {}
}

class CustomClass1 : Base1() {
    //这里必须显示加上override关键字表示被覆盖，否则编译器会报错
    override fun f() {
        println("this function is overrided")
    }
    //因为基类中nf()并没有加open修饰符，所以不可以被覆盖，这里会报错
    //override fun nf(){}
}

/**
 * 成员方法
 * 首先定义一个类，然后定义成员方法
 * 然后在main函数中调用成员方法
 */
class PersonB(var name: String, var age: Int) {
    fun ReadBook(bookname: String) {
        //这里是该方法的具体实现
        println("The person is reading $bookname")
    }

    fun Coding(type: String) {
        //这里是该方法的具体实现
        println("The person coding with $type")
    }
}


fun main(args: Array<String>) {
    val Barack = PersonB("BarackBao",20)
    Barack.ReadBook("The OpenGL Cook Book")
    Barack.Coding("Kotlin")
}