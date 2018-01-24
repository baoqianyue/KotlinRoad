package classandobject

import basicgrammer.sout


/**
 * kotlin中的接口可以看成是一种约定
 * 它规定了要具体实现他的类的一些规定和标准
 */

//先定义一个最顶层接口
//这里我们模拟电脑的输入设备
interface InputDevice {
    fun input(event: Any)
}

//接口直接也有继承关系，可以继续向下划分具体的标准
//这里我们模拟一下USB输入和BLE输入
//我们可以使用这两个子类接口直接继承父类接口，将所有接口都遵循的输入方法给继承下来
interface USBInputDevice : InputDevice

interface BLEInputDevice : InputDevice

//下面我们定义一个计算机类
class Computer {

    fun addUSBInputDevice(inputDevice: USBInputDevice) {
        //这里是对这个方法的具体实现
        println("add usb input device: $inputDevice")
    }

    fun addBLEInputDevice(inputDevice: BLEInputDevice) {
        //这里是对这个方法的具体实现
        println("add ble input device: $inputDevice")
    }

    //我们也可以将上面两个方法整合一下
    fun addInputDevice(inputDevice: InputDevice) {
        //我们先判断一下输入设备的类型然后在去调用具体的add方法
        when (inputDevice) {
            is USBInputDevice -> addUSBInputDevice(inputDevice)
            is BLEInputDevice -> addBLEInputDevice(inputDevice)
            else -> throw IllegalArgumentException("输入设备类型不支持")
        }
    }
}


//一个类也可以实现多个类，就是遵循多个规定
interface GameMouse

//我们来模拟一个具体的输入设备
//这里我们模拟一个usb类型的鼠标输入
class USBMouse(val name: String) : USBInputDevice, GameMouse {
    //重写输入方法
    override fun input(event: Any) {

    }

    //这里重写一下toString方法，以便输出鼠标名称
    override fun toString(): String {
        return name
    }

}


fun main(args: Array<String>) {
    val computer = Computer()
    val usbMouse = USBMouse("雷蛇")
    computer.addInputDevice(usbMouse)
}