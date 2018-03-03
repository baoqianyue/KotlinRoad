package higherorderfunction

fun main(args: Array<String>) {
    val list: List<Int> = listOf(3, 4, 5, 12, 1)

    //现在我们要将这个list映射到一个新的list中
    val newList = ArrayList<Int>()

    //可以使用forEach
    list.forEach {
        val newElement = it * 2 + 1
        newList.add(newElement)
    }

    //输出一下:
    newList.forEach(::println)

    //下面使用一个全新的函数map
    val newList1 = list.map {
        //这里的it就代表每一个lambda，it*2+1就是每个lambda的返回值
        it * 2 + 1
    }

    val newList2 = list.map {
        it.toDouble()
    }//这里的list就是map参数中的transform:(T)，所以可以引用成员函数

    val newList3 = list.map(Int::toDouble)


    newList1.forEach(::println)

}