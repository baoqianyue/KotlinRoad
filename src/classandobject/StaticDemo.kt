package classandobject

/**
 * 伴生对象和静态成员
 * kotlin中的伴生对象其实就是一个类中的单例
 */

class Latitude private constructor(val value: Double) { //这里将构造函数私有化，表明不能新建该类的对象
    companion object {
        @JvmStatic //加上此注解，就可以在java中也调用到该方法
        fun ofDouble(double: Double): Latitude {
            return Latitude(double)
        }

        fun ofLatitude(double: Double): Latitude {
            return Latitude(double)
        }

        //变量也可以定义为静态的
        //如果也想在java中引用该变量，需要加上注解
        @JvmField
        var latitudeValue: Double = 4.0

    }
}


fun main(args: Array<String>) {
    val latitude = Latitude.ofDouble(2.0) //这样就可以用类名调用类中的静态方法
    println(Latitude.latitudeValue)//可以直接使用类名引用到静态成员变量
}

/**
 * 总结
 * 1.每个类都可以对应一个伴生对象
 * 2.伴生对象的成员全局独一份
 * 3.伴生对象的成员类似Java的静态成员
 * 4.定义静态成员时考虑使用包级函数和变量，脱离一个具体的类存在
 * 5.在Java中调用kotlin中定义的静态成员时，方法使用@JvmStatic修饰，变量使用@JvmField修饰
 */