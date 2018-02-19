package classandobject;

/**
 * 这里我们想在java类中也调用kotlin类中的静态方法
 */

public class StaticDemoJava {
    public static void main(String args[]) {
//        Latitude.ofDouble(); //这里光靠类名还是无法调用到类中定义的静态方法
        //使用关键字Companion得到伴生对象来调用方法
        Latitude.Companion.ofDouble(3.0);
        Latitude.Companion.ofLatitude(3.0);
        //如果还是想用类名直接调用kotlin类中定义的静态方法，可以给kotlin类中对应方法加上注解@JvmStatic
        Latitude.ofDouble(3.0);
        //在kotlin中定义了静态变量，并使用注解@JvmField修饰，就可以直接在java中引用到
        System.out.println(Latitude.latitudeValue);
    }
}
