package cn.bolianlai.handler;

import cn.bolianlai.entity.User;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloHandler {

//    参数绑定
    @RequestMapping("index")
    public String index(@RequestParam("name") String name, @RequestParam("id") int id) {
        System.out.println("执行业务方法index:"+ name + id);
        return "index";
    }

//    RESTful 风格参数
    @RequestMapping("rest/{name}/{id}")
    public String rest(@PathVariable("name") String name, @PathVariable("id") String id) {
        System.out.println("执行业务方法rest:"+ name + id);
        return "index";
    }

//    映射 Cookie
    @RequestMapping("cookie")
    public String cookie(@CookieValue("JSESSIONID") String sessionId) {
        System.out.println("执行业务方法cookie:" + sessionId);
        return "index";
    }
//    使用 POJO 绑定参数
    @RequestMapping("addUser")
    public String getPOJO(User user){
        System.out.println("执行业务方法getPOJO:" + user);
        return "index";
    }

//    JSP页面的转发和重定向
    @RequestMapping("redirect")
    public String redirect() {
        return "redirect:cookie";
    }
}
