package cn.itcast.test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class Test {

    public static void main(String[] args) throws IOException, TemplateException {
        //创建配置类
        Configuration configuration=new Configuration(Configuration.getVersion());
        //设置模板所在目录
        configuration.setDirectoryForTemplateLoading(new File("E:\\com.pingyougou\\freemarker\\src\\test\\java\\test"));
        //设置字符集
        configuration.setDefaultEncoding("utf-8");
        //加载模板
        Template template = configuration.getTemplate("test.ftl");
        //创建数据模型


        Map map=new HashMap();

        List goodsList=new ArrayList();
        Map goods1=new HashMap();
        goods1.put("name", "苹果");
        goods1.put("price", 5.8);
        Map goods2=new HashMap();
        goods2.put("name", "香蕉");
        goods2.put("price", 2.5);
        Map goods3=new HashMap();
        goods3.put("name", "橘子");
        goods3.put("price", 3.2);
        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        map.put("goodsList", goodsList);


        map.put("name", "张三 ");
        map.put("message", "欢迎来到神奇的品优购世界！");
        map.put("success", true);
        map.put("today", new Date());
        map.put("point", 102920122);
        //创建输出流
        Writer writer=new FileWriter("d:\\test.html");
        //输出
        template.process(map,writer);
        //关闭
        writer.close();

    }
}
