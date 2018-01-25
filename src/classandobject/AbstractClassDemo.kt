package classandobject

/**
 * 抽象类与接口的区别
 * 抽象类其实也是一种规定，但是它内部的实现程序位于接口和具体的类之间
 * 也可以将抽象类看成是一些类的模板
 * 而接口就是完全意义上的协议设定
 * 二者各有各的不同和特点
 * 下面举例介绍
 */


/**
 * 1.抽象类可以定义成员变量，而接口不能
 */
abstract class TestAbClass {
    val i = 0
    fun test() {

    }
}


interface TestInter {
    //    val i = 0 //这个地方会报错
    //原因是在kotlin中直接给变量赋值相当于实现了该变量的getter和setter方法，这不符合接口的定义
    //所以可以这里不进行赋值操作
    var i: Int //只写出变量名和类型

}


/**
 * 2.接口和抽象类中定义的方法不同
 * 抽象类中可以定义一些普通方法(有函数体，而且可以直接调用类中定义的变量),抽象方法(定义函数时需要加上abstract关键字，没有函数体)
 * 接口中也可以有方法的定义和实现，这和java8之后对接口的扩展类似
 */

abstract class AbstractClassDemo1 {
    val i = 0
    //普通方法的定义
    fun test() {
        println(i)
    }

    //抽象方法的定义
    abstract fun test1()//此时不能有函数体
}

interface TestInter1 {
    var i: Int //这里虽然没有报错，但是这里的仍然没有具体的含义，虽然这里给它设置了默认类型Int型
    //但是当一个新的具体类实现该接口时，仍需要对这个变量进行重新实现，这也是接口与抽象类不同的地方
    //在kotlin的接口中可以写一个默认方法
    fun hello() {
        println(i)
    }

}


//下面我们来使用一个新的类来实现一下接口
class TestInter2(override var i: Int) : TestInter1 {//这里需要对接口中的变量重写，给他设置具体的意义

}

fun main(args: Array<String>) {

}