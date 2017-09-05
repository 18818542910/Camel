package demoTwo.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by 李建红
 * Date:2017/9/5.
 * 版权:数帝网络
 */
public class FileConvertProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        try {
            InputStream body = exchange.getIn().getBody(InputStream.class);
            BufferedReader in = new BufferedReader(new InputStreamReader(body));
            StringBuffer strbf = new StringBuffer("");
            String str = null;
            str = in.readLine();
            while (str != null) {
                System.out.println(str);
                strbf.append(str + " ");
                str = in.readLine();
            }
            exchange.getOut().setHeader(Exchange.FILE_NAME, "converted.txt");
            exchange.getOut().setBody(strbf.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
