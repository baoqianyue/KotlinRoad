package higherorderfunction

/**
 * 高阶函数
 * 传入或者返回函数的函数
 *
 */


/**
 * 几种函数引用的方式
 */
fun main(args: Array<String>) {
    /** 1.引用包级函数
     * 可以使用函数引用的方式调用包级函数
     * 这里forEach里面需要一个lambda，但是println是一个包级函数，其参数与forEach所需lambda的参数一致，可以使用函数引用的方式
     */
    args.forEach(::println)

    /** 2.引用成员方法或扩展方法
     * 可以直接使用类名引用成员方法
     *
     */
    var str: String = "test"
    val test = Test::test
    //使用类名引用成员方法这种方式其实隐含了一个默认参数
    //查看了filter的参数签名：predicate: (T) -> Boolean.是这样一个lambda，第一个参数是一个T类型的实例
    //再看一下isNotEmpty的参数签名:public inline fun CharSequence.isNotEmpty(): Boolean
    //这是一个扩展方法
    //这里的arg就是默认的第一个实例参数，所以filter内部可以直接引用第二个参数
    args.filter(String::isNotEmpty)

    /**
     * 3.使用实例引用成员方法
     * 这种方法的情况就和上面第二种方式不同了
     * 这里就需要有一个实例来进行成员方法的引用，否则就和forEach的参数不符合
     */
//    args.forEach(PdfPrinter::println)//这样通过类名的方式引用，就缺少了默认的第一个T类型的实例参数
    val pdfPrinter = PdfPrinter()
    args.forEach(pdfPrinter::println)
}

class Test {
    fun test() {
        println("test")
    }

    fun test1(str: String) {
        println(str)
    }
}

class PdfPrinter {
    fun println(any: Any) {
        kotlin.io.println(any)
    }
}


