package basicgrammer


/**
 * 具名参数
 * 其实就是在调用函数的参数列表中加上参数名,然后给对应的参数传值
 * 在一般情况下好像并没有什么实际作用，而且看上去还有些语法错误
 * 但是在有些情况下，比如变长参数的识别上，却有奇效
 */
//我们先来定义一个含有几个参数的方法
fun test(int: Int, double: Double, string: String) {
    println("$int,$double,$string")
}

//下面使用具名参数来调用一下

fun main(args: Array<String>) {
    test(int = 1, double = 1.0, string = "Barack")
//    test1(1,2,34,"Barack")//这种情况下就会报错，这是因为编译器并不知道你的变长参数的具体个数
    //因而无法做出正确的识别，这种情况在java中是没有办法解决的，但是在kotlin中就可以使用具名参数来解决
    test1(1, 4, 5, string = "Barack") //使用具名参数给对应的参数传参
}


/**
 * 变长参数
 * 与java中的有所不同，java中只能识别最后一个参数
 * kotlin中可以实现识别任意位置的参数为变长参数
 * 如果出现识别矛盾，还可以使用具名参数来解决这个问题
 */

//我们先来定义一个普遍的变长参数情况，定义变长参数时需要在参数前面加上varage关键字
fun test1(vararg ints: Int, string: String) {
    //遍历一下这个ints参数
    ints.forEach(::println)
    println(string)
}

