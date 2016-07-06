package basic.b1;

import java.io.UnsupportedEncodingException;

/**
 * @author 孟洛
 * 
 * 基础 
 * 
 * 一.面向对象的三大特征并分别阐述
 * 
 * 1.封装：把属性和函数封装到一个类中，提供外部使用。面向过程是用函数来解决问题，而面向对象是让类“自治”解决问题
 * 更进一步的讲，车和人两个类，人可以开车门，车也可以开，那开门的行为应该封装给人还是车？我个人的经验 是，谁
 * 拥有的属性多，就封装给谁，这里，门是属于车的，车也比人更清楚开门的过程要怎么转动哪个螺丝之类的，所以开门
 * 的方法应该封装给车。而且在实际设计程序中，用到什么方法就封装什么方法，不必要一个类中什么都封装进去
 * 
 * 2.继承：新产生的类继承已有的类(父类)的属性和方法[不继承构造函数]，在某种程度上简化了程序，比如有人类，人
 * 有年龄和身高的属性，吃饭的方法；在新创建一个男人类，男人也有年龄和身高的属性以及吃饭的方法，如果让男人类
 * 继承人类，就不必要再在男人类中声明年龄、身高这类共有的属性和吃饭之类共有的方法
 *
 * 3.多态：官方的解释是父类的指针指向子类的对象，简单地说就是让不同的对象对同一个方法做出不同的回应。比如说有个
 * 宠物类中有叫的方法，猫类和狗类分别继承这个宠物类，猫类和狗类分别调用宠物类的叫的方法，可以有各自不同的结果。
 * 多态又分为编译时多态和运行时多态，方法重载体现编译时多态，方法重写体现运行时多态。好比，如果把汽车系统和动力
 * 系统看成两个系统，动力系统的方法可以有电力产生动力，石油产生动力，氨产生动力等，汽车系统继承动力系统，通过
 * 重写动力系统产生动力的方法实现汽车动力的获取，这就体现了动态绑定，也就是运行时多态。而静态绑定，也就是编译
 * 时多态就好比把汽车系统和动力系统看成一回事儿，写在一个类中，通过方法重载来实现不同的动力获取方式。在实际开发
 * 中，动态绑定可以使程序更加灵活
 * 
 * 二.switch后面能否有byte、long和String?
 * 
 * JDK1.7以及之后支持String之类，long类型不支持，byte类型支持。除此之外，还支持short、char、int类型
 * 在JDK1.5之后，支持枚举类型
 * 
 * 三.String、StringBuffer、StringBuilder的区别?
 * 
 * String是用final修饰的，因此String引用的字符串是不能被修改的，而StringBuffer、StringBuilder
 * [表示的字符串]是可以修改的，而且在做字符串拼接时，StringBuffer、StringBuilder的效率比String高
 * 至于StringBuffer、StringBuilder的区别，一个线程安全，一个线程不安全，至于哪个安全哪个不安全，可以
 * 查看源代码中谁有synchronized关键字修饰，有的话就安全，没有就不安全
 * 
 * 四.如何把ISO-8859-1编码的字符串转换为GBK编码？  见代码
 * 
 * 五.列举一些常见的RuntimeException
 * 
 * Exception分为checked exception 和 RuntimeException ，其中checked exception编辑器就会
 * 报错。常见的RuntimeException有：
 * 
 * ClassCastException、IndexOutOfBoundsException、NullPointerException、
 * NumberFormatException、UnsupportedEncodingException、IOException
 * 
 * 六.List、Set、Map是否继承自Collection接口？ 
 * 
 * List、Set是，Map不是。List允许重复，Set不允许重复
 * 
 * ArrayList 底层是数组、LinkedList是双链表，LinkedList特别适合头尾操作
 * 
 * 七.理解TreeMap和TreeSet
 * 
 * 他们更适合做对元素的比较，实现Comparable接口，然后重写compareTo方法
 * 
 * 八.多线程有几种实现方式？
 * 
 * 两种：1.继承Thread类 2.实现Runnable接口
 * 
 * 九.Java中有几种流？
 * 
 * 字节流继承自InputStream、OutputStream 、 字符流继承自Reader 和 Writer
 * 
 * 十.反射获取一个类的对象的三种方式
 * 
 *  a.如果知道类，就 "类.class" 
 *  b.如果知道对象，就:"对象.getClass()" 
 *  c.Class.forName()
 *  
 * 十一.通过反射创建对象
 * 
 * 方法1:对象.newInstance() eg:String.class.newInstance
 * 方法2:先通过对象获取构造器，再创建对象 eg:String.class.getConstructor(String.class)
 *  
 * 十二.简述设计模式
 * 
 * 工厂模式：管理对象的创建，根据不同的条件创建不同的子类实例
 * 适配器模式：解决接口臃肿的
 * 
 */

public class Test1{
	public static void main(String[] args) {
		try {
			//第四问
			String str = "你好";
			String changeStr = new String(str.getBytes("ISO-8859-1"),"GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}

