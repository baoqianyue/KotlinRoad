package basicgrammer

import classandobject.OnClickListener

/**
 * lambda表达式的定义
 */
//定义一个名为sum的lambda表达式，有两个参数
//lambda表达式的返回值由表达式最后一行的值决定
//lambda表达式的参数和语句用->分隔
val sum = { arg1: Int, arg2: Int ->
    println("$arg1 + $arg2 = ${arg1 + arg2}")
    arg1 + arg2
}

//这里只有一行输出语句，所以自动检测为返回值为Unit
val sout = {
    println("barack")
}


//fun main(args: Array<String>) {

//调用lambda表达式时就像调用普通方法一样
//    println(sum(2, 4))
//这里其实是kotlin对()操作符的重载，实际上是一个invoke运算，在invoke里面将lambda表达式的参数传进去
//    sum.invoke(2, 4)


//这里再给一个遍历数组的例子说明
val arr: Array<Int> = arrayOf(1, 3, 4, 56, 6)

//先使用for循环遍历一下
//    for (i in arr) {
//        println(i)
//    }

//还可以使用lambda表达式遍历
//    arr.forEach {
//        println(it)
//    }

//等同于
//    arr.forEach({ it -> println(it) })//这里it相当于那个action参数，返回值类型就是Unit，这样就与lambda表达式的形式吻合了
//然后将lambda表达式作为参数传入

//其实可以简写成
//    arr.forEach({ println(it) })

//还可以简写成
//    arr.forEach { println(it) }

//最终可以简写成引用类型,前提是函数的参数类型和lambda表达式的参数类型是一致的
//我们只需将函数名作为参数传进去就行了
//    arr.forEach(::println)


//除了普通的遍历，我们还可以在lambda表达式中进行过滤或者判断
//    arr.forEach {
//        if (it != 4)
//            println(it)
//    }


//如果我们想提前结束遍历，使用return的方式是不行的，因为lambda表达式是表达式
//不是函数，如果在lambda表达式内部使用了return语句，那它会寻找到包含它的函数，并将函数返回
//为了达到中途停止遍历的效果，可以在lambda表达式中特定的条件时加上一个ForEach@标签来截断表达式
/*arr.forEach ForEach@ {
    println(it)
    if (it == 4) ForEach@//当满足这个条件式，遍历就会被终止
    return
}


println("The End")
*/

/*(0..19).forEach { i ->
    (0..19).forEach { j ->

    }
}

(0..100).filter { it % 2 == 0 }.fold(0) { acc, i -> acc + i }.let(::println)*/
//}


/**
 * 一个lambda表达式通过参数的形式被定义在箭头的左边(被括号包围)，然后在箭头的右边返回结果值
 * 我们举个例子
 */

interface OnClickListener {
    fun onClick(view: View)
}

/**
 * 上面那个接口中只有一个函数，在kotlin中只含有一个函数的Interface可以替换成一个函数，像下面一样
 */

class View {
    //正常方式定义
    fun setOnClickListener(listener: OnClickListener) {
        //...
    }

    //lambda表达式定义
    fun setOnClickListener(listener: (View) -> Unit) {
        //...
    }

}

fun main(args: Array<String>) {
    val view = View()
    //普通方式实现点击事件需要使用匿名对象
    view.setOnClickListener(object : OnClickListener {
        override fun onClick() {
            println("click")
        }
    })

    //使用lambda表达式
    view.setOnClickListener({ view -> println("click") })
    /**
     * 上面的写法已经相当的简化了
     * 当我们定义了一个方法，我们必须使用大括号{}包围，然后再箭头的左边指定参数
     * 在箭头右边返回函数执行的结果，如果左边的参数没有使用到,我们甚至可以省略左边的参数
     * 像下面一样
     */
    view.setOnClickListener({ println("click") })

    /**
     * 如果这个函数的最后一个参数是一个函数，我们可以把这个函数移动到圆括号外面
     */
    view.setOnClickListener() { println("click") }
    /**
     * 最后，如果这个函数只有一个参数，我们可以省略这个圆括号
     */
    view.setOnClickListener { println("click") }
    view.setOnClickListener(::println)

}


/**
 * 总结
 * 1，函数的参数只有一个lambda时，调用时小括号可以省略
 * 2. lambda只有一个参数时，可以默认为it，it其实iterator的意思
 * 3. 参数和返回值都和要传入函数的形参一致的lambda表达式，可以使用函数引用::的方式作为实参传入
 */

