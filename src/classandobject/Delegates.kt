package classandobject

import basicgrammer.sout
import kotlin.reflect.KProperty

/**
 * 属性代理
 */

class Delegates {
    //将Barack的初始化委托给了lazy，lazy向上查找其实是一个接口
    val Barack: String by lazy {
        "Bao"
    }

    //我们来自定义一个被委托类

    //这里是用val定义的，所以被委托类中需要提供getter方法
    val Barack1 by CustomDelegateAssign()
    //这里使用var定义的，所以还需要提供setter方法
    var Barack2 by CustomDelegateAssign()

}

class CustomDelegateAssign {
    private var value: String? = null
    operator fun getValue(delegates: Delegates, property: KProperty<*>): String {
        println("getValue: $delegates -> ${property.name}")//我们输出一下相关信息
        return value ?: ""
    }

    operator fun setValue(delegates: Delegates, property: KProperty<*>, s: String) {
        println("setValue: $delegates -> ${property.name} = $s")
        value = s
    }
}

fun main(args: Array<String>) {
    val delegate: Delegates = Delegates()
    println(delegate.Barack)
    println(delegate.Barack1)
    println(delegate.Barack2)
    delegate.Barack2 = "value of Barack2"
    println(delegate.Barack2)
}

/**
 * 总结
 * 1.定义方法：
 * val/var <property name> : <Type> by <Expression>
 * 2.代理者需要实现相应的setValue/getValue方法
 */
