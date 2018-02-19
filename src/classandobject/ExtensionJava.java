package classandobject;

/**
 * 在java中调用kotlin中定义的扩展成员也是可以的，调用时类似于调用静态成员
 * 使用kt类名或者文件名，传入被扩展对象作为参数
 */
class ExtensionJava {
    public static void main(String[] args) {
        String str = new String("Bao");
        System.out.println(ExtensionKt.mutiply(str, 5));
        System.out.println(ExtensionKt.times("Bao", 5));
    }
}

