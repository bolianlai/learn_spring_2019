package cn.bolianlai.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloHandler {

    @RequestMapping("/index")
    public String index() {
        System.out.println("执行业务方法index");
        return "index";
    }
}
