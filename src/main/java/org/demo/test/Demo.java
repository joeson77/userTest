package org.demo.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;

public class Demo {
	//设置APPID/AK/SK
    public static final String APP_ID = "10854852";
    public static final String API_KEY = "Ytj9j3ZZmlLOa8mOwAjkrELj";
    public static final String SECRET_KEY = "xsKgw1RHKvZ9gpbIONKGhxWObPatRP2V";
    
    
    public static void sample(AipFace client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("ext_fields", "qualities");
        options.put("image_liveness", ",faceliveness");
        options.put("types", "7,13");
         
        //参数为本地图片路径列表
        String path1 = "/Users/liyunjian/Downloads/demo1.jpg";
        String path2 = "/Users/liyunjian/Downloads/demo2.jpg";
        ArrayList<String> path = new ArrayList<String>();
        path.add(path1);
        path.add(path2);
        //byte[][] images = {/Users/liyunjian/Downloads/demo.jpg};
        JSONObject res = client.match(path, options);
        System.out.println(res.toString(2)); 
    }



    public static void main(String[] args) {
        // 初始化一个AipFace
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        
        // 可选：设置网络连接参数
        //client.setConnectionTimeoutInMillis(2000);
        //client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        //System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "/Users/liyunjian/Downloads/demo1.jpg";
        JSONObject res = client.detect(path, new HashMap<String, String>());
        System.out.println(res.toString(2));
        System.out.println();
        System.out.println();
        System.out.println("===========================");
        System.out.println();
        System.out.println();
        
        sample(client);
    }
}
