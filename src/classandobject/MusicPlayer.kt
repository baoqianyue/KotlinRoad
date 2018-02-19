package classandobject


/**
 * Kotlin中的单例实现
 * 用object关键字标识的其实本质上还是一个类，只是这个类只能有一个实例
 */

abstract class Player(val isUSB: Boolean) {
    val isStop: Boolean = false
}

interface InstallDetials {
    fun install()
    fun unInstall()
}


object MusicPlayer : Player(true), InstallDetials {//object中也可以继承和实现抽象类和接口

    override fun install() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun unInstall() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val state: Int = 1 //object中可以定义属性
    fun play() {
        println("正在播放")
    } //也可以定义方法

}

/**
 * 总结
 * 1.object是只有一个实例的类
 * 2.不能自定义构造方法，object的构造方法已经被内部私有
 * 3.可以实现接口，继承父类
 * 4.本质上就是最简单的单例模式的实现
 */