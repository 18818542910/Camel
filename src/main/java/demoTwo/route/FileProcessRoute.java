package demoTwo.route;

import demoTwo.process.FileConvertProcessor;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by 李建红
 * Date:2017/9/5.
 * 版权:数帝网络
 */
public class FileProcessRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("file:d:/temp/inbox?noop=true").process(new FileConvertProcessor()).to("file:d:/temp/outbox");
    }
}
