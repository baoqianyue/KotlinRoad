package classandobject

/**
 * kotlin中的继承
 * kotlin中的接口代理模式
 */

/**
 * 先定义两种特长，使用接口表示
 */

//表示会开车
//接口已被定义就表示要被实体类去实现，所以其中的属性和方法默认都是open的
interface Driver {
    fun drive()
}

//表示会写作
interface Writer {
    fun write()
}

/**
 * 我们定义一个实体类去实现上面两个接口,将接口中的方法都进行重写
 * 这里的重写与java中接口实现中有所不同，java中只用弱类型的注解@Override来指定重写
 * kotlin中必须使用override关键字表示方法或属性被重写
 */
class Manager : Driver, Writer {
    override fun write() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun drive() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}


/**
 * 下面我们再定义一个资深经理类来描述一下接口代理
 */
class SeniorManager(val driver: Driver, val writer: Writer) : Driver, Writer {

    override fun write() {
        driver.drive()
    }

    override fun drive() {
        writer.write()
    }

}

//这里这种写法表示该SeniorManager类具有接口的属性并且重写了接口的方法，直接让属性变量调用对应的方法
//在kotlin中可以使用接口代理来简化这种写法
class SeniorManager1 constructor(val driver: Driver, val writer: Writer) :
        Driver by driver, Writer by writer
//这里无须再重写接口中的方法，直接使用by关键字将重写方法的任务代理给了类的两个属性变量完成
//具体实现效果与上面一致(会直接使用writer.write(),即xxer.xx())


//再看一个例子
class CarDriver : Driver {
    override fun drive() {
        println("I am a car driver")
    }
}

class PPTWriter : Writer {
    override fun write() {
        println("I am a PPT writer")
    }

}


fun main(args: Array<String>) {
    //下面使用接口代理
    //先创建Driver,Writer接口的实例，他们的类中已有相应的drive(),write()方法
    val driver = CarDriver()
    val writer = PPTWriter()
    //将这两个实例作为属性设置到SeniorManager对象中
    val seniorManager = SeniorManager1(driver, writer)
    seniorManager.drive() //这里使用接口代理直接由driver对象调用drive方法
    seniorManager.write() //同上
}