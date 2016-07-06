package basic.b1;
/**
 * 中级：Web编程
 * @author 孟洛
 * 
 * 一.Servlet生命周期
 * 
 * 1.init()初始化 ---> service() ---> (根据请求方式调用)doGet()或doPost()方法 ---> destroy()
 * 
 * 二.转发(forward)和重定向(redirect)的区别
 * 
 * forward:地址不变。服务器直接请求资源然后发给浏览器,浏览器不知道内容从哪来，更加高效,信息保留
 *
 * redirect:地址栏改变。服务器根据逻辑给浏览器一个状态码，让浏览器去请求地址。
 * 信息不保留，请求另一个服务器资源必须使用重定向
 * 
 * 三.JSP九大内置对象
 * 
 * request:封装浏览器请求，可以是GET或POST
 * response:封装服务器对浏览器的响应
 * session:封装用户会话,从打开浏览器开始到关闭结束
 * application:封装服务器运行环境,从服务器开启到服务器关闭
 * out:输出
 * config:配置对象
 * page:jsp页面本身(相当于java中的this)
 * exception:封装页面抛出的异常
 * 
 * 四.JSP和Servlet的关系
 * 
 * JSP本质就是Servlet,JSP最终还是会被翻译成Servlet
 * JSP更适合做前端页面，Servlet更适合做控制
 * 如果用servlet生成网页中的动态内容非常繁琐，就没有jsp方便
 * 能跑JSP环境的容器，也能跑Servlet,比如tomcat就是一个jsp/servlet容器
 * 
 * 
 * 五.get请求和post请求的区别
 * 
 * 1.get请求暴露参数,不适合处理敏感数据
 * 2.get传输数据有长度限制，因此上传文件一般用post请求
 * 3.get把数据用key-value的形式添加到action指向的url后面，两者用"?"号链接,变量之间用"&"链接
 *   post请求把数据传递到http协议的请求头或消息体中，传递到action所指向的url
 * 
 * 
 * 
 * 
 */
public class Test2 {

}
