package classandobject

import org.omg.CORBA.StringHolder


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

    val Barack = PersonB("BarackBao", 20)
    Barack.ReadBook("The OpenGL Cook Book")
    Barack.Coding("Kotlin")
}


/**
 * 类中定义成员属性
 * 还有他们的GetterSetter方法
 */

class A {
    var b = 0 //kotlin默认在定义变量之后就自动生成了get，set方法
}


//但是，如果想要在get，set方法中添加其他内容时，就需要对get，set方法进行重写

class A1 {
    var b = 0
        get() {
            println("override get")
            return field //这里的field就代表b，需要注意的是，field只能在get，set方法中调用到
        }
        set(value) {
            field = value //使用field指代b
            println("override set")
        }
}



/**
 * lateinit关键字和by lazy
 */

//我们在定义成员属性时有时不会知道它的初始值是什么，但是也不能所有的东西都初始化为空
//所以kotlin加入了延时初始化的机制，告诉编译器，我们会在之后妥善处理这些变量

class B

class A2 {
    val a = 0
    lateinit var str: String
    lateinit var b: B //对于var定义的变量可以使用lateinit关键字
    val e: B by lazy {
        //对于val定义的量可以使用by lazy的方式告知编译器
        println("init B")
        B()
    }
}

/**
 * 总结一下属性
 * 如果在构造方法参数中val或var修饰的就是类属性，如果参数前面没有var或val，就代表是普通的构造函数的参数
 * 类内部也可以定义属性，而且有延时初始化机制
 * 下面看一个例子
 */

class Test constructor(var aField: String, nField: String) { //这里aField是类属性
    lateinit var bField: String //这里属于在类内部定义属性
}




