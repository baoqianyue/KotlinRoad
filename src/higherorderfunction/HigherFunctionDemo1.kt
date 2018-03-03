package higherorderfunction

fun main(args: Array<String>) {
    val list: List<Int> = listOf(3, 4, 5, 12, 1)

    /**
     * forEach
     */

    //现在我们要将这个list映射到一个新的list中
    val newList = ArrayList<Int>()

    //可以使用forEach
    list.forEach {
        val newElement = it * 2 + 1
        newList.add(newElement)
    }

    //输出一下:
//    newList.forEach(::println)

    /**
     * map
     */

    //下面使用一个全新的函数map
    val newList1 = list.map {
        //这里的it就代表每一个lambda，it*2+1就是每个lambda的返回值
        it * 2 + 1
    }

    val newList2 = list.map {
        it.toDouble()
    }//这里的list就是map参数中的transform:(T)，所以可以引用成员函数

    val newList3 = list.map(Int::toDouble)

//    newList1.forEach(::println)

    /**
     * flatMap
     * 可以将多个list压成一个大的list
     */
    val mutiplyList = listOf(
            1..20,
            2..7,
            100..333
    )

    val flatList = mutiplyList.flatMap {
        //这个it代表mutiplyList中的每个IntRange
        it.map {
            "No.$it"//这个it是上一层IntRange经过map后的每个Int
        }
    }
    //如果有很多层高阶函数嵌套，只使用it来指代元素，就不太清楚
    //我们可以将每一层的lambda的参数写出来，这样就简单明了，下面的代码和上面代码效果一样
    val flatList1 = mutiplyList.flatMap { intRange ->
        intRange.map { i ->
            "No.$i"
        }
    }

    val flatList3 = mutiplyList.flatMap { it }

//    flatList.forEach(::println)

//    flatList1.forEach(::println)

    /**
     * reduce
     * 可以将集合累积做求和求阶乘等运算
     */
    println(flatList3.reduce { acc, s -> acc + s }) //将上面的flatmap进行求和运算
    //查看了reduce的定义，发现参数是两个泛型参数，第一个参数是accumulator是积累的意思，所以在遍历的时候每次保存结果
    //然后进行叠加或者其他积累操作


}