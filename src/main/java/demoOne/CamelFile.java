package demoOne;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by 李建红
 * Date:2017/9/5.
 * 版权:数帝网络
 *文件传输组件的使用
 */
public class CamelFile {
    public static void main(String[] args) throws Exception {
        //初始化CamelContext 容器
        CamelContext camelContext = new DefaultCamelContext();

        //往容器中添加一个路由
        camelContext.addRoutes(new RouteBuilder() {
            //实现转换
            public void configure() {
                //每间隔30秒轮训一次 D:/myTest 将下面的文件全部移到 E:/Tool下
                //delay=30000 表示休眠多少时间
                from("file:D:/myTest/?delay=30000").to("file:E:/Tool");
            }
        });
        //启动容器
        camelContext.start();
        //停止
        camelContext.stop();

    }
}
