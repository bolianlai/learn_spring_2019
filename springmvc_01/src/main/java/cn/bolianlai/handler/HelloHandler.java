package cn.bolianlai.handler;

import cn.bolianlai.entity.Student;
import cn.bolianlai.entity.User;
import cn.bolianlai.entity.UserMap;
import com.alibaba.fastjson.JSON;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//把业务数据绑定到session域对象中
//    1
//    @Controller
//    @SessionAttributes(value={"user"})
//    public class HelloHandler {
//    //省略代码
//    }
//    2
//    @Controller
//    @SessionAttributes(types={User.class})
//    public class HelloHandler {
//    //省略代码
//    }

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

//    函数的形参id和没有用RequestParam注释的区别是这里的请求的参数必须和这个函数的形参一致，
//    而使用了注解的形参可以使用不一致的参数,并且可以对参数进行相关设置，基本类型的参数不能为null，包装类可以
    @RequestMapping("base")
    @ResponseBody
    public String base(int id) {
        System.out.println("执行业务方法base:" + id);
        return "id:" + id;
    }

//    使用包装类
    @RequestMapping("baseInteger")
    @ResponseBody
    public String baseInteger(Integer id) {
        System.out.println("baseInteger:" + id);
        return "id:" + id;
    }

//    使用RequestParam注解
    @RequestMapping(value="/packageType")
    @ResponseBody
    public String packageType(@RequestParam(value="id",required=false,defaultValue="1") Integer id){
        return "id:"+id;
    }

//    数组,多个相同的参数名的参数
    @RequestMapping("arrayType")
    @ResponseBody
    public String arrayType(String[] name) {
        StringBuffer stringBuffer = new StringBuffer();
        for(String item:name) {
            stringBuffer.append(item).append(" ");
        }
        return "name:" + stringBuffer.toString();
    }

//    POJO 级联关系
    @RequestMapping("pojoType")
    @ResponseBody
    public String pojoType(User user) {
        System.out.println("执行业务方法pojoType:" + user);
        return "pojoType:" + user;
    }

//    Map
    @RequestMapping("mapType")
    @ResponseBody
    public String mapType(UserMap userMap) {
        StringBuffer stringBuffer = new StringBuffer();
        for(String key:userMap.getUserMap().keySet()) {
            User user = userMap.getUserMap().get(key);
            stringBuffer.append(user).append(" ");
        }
        return stringBuffer.toString();
    }

//    JSON
    @RequestMapping("jsonType")
    @ResponseBody
    public User jsonType(@RequestBody User user) {
        user.setId(user.getId()+10);
        return user;
    }

//    Map
    @RequestMapping("mapTest")
    public String mapTest(Map<String,Object> map){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        map.put("user", user);
        return "map";
    }
//    Model
    @RequestMapping("modelTest")
    public String modelTest(Model model){
        User user = new User();
        user.setId(1);
        user.setName("李四");
        model.addAttribute("user", user);
        return "map";
    }

//    ModelAndView
    @RequestMapping("/modelAndViewTest1")
    public ModelAndView modelAndViewTest1(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setId(1);
        user.setName("张三");
        modelAndView.addObject("user", user);
        modelAndView.setViewName("map");
        return modelAndView;
    }

    @RequestMapping("/modelAndViewTest2")
    public ModelAndView modelAndViewTest2(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setId(1);
        user.setName("张三");
        modelAndView.addObject("user", user);
        View view = new InternalResourceView("/map.jsp");
        modelAndView.setView(view);
        return modelAndView;
    }

    @RequestMapping("/modelAndViewTest3")
    public ModelAndView modelAndViewTest3(){
        ModelAndView modelAndView = new ModelAndView("map");
        User user = new User();
        user.setId(1);
        user.setName("张三");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("/modelAndViewTest4")
    public ModelAndView modelAndViewTest4(){
        View view = new InternalResourceView("/map.jsp");
        ModelAndView modelAndView = new ModelAndView(view);
        User user = new User();
        user.setId(1);
        user.setName("张三");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("/modelAndViewTest5")
    public ModelAndView modelAndViewTest5(){
        Map<String,Object> map = new HashMap<String,Object>();
        User user = new User();
        user.setId(1);
        user.setName("张三");
        map.put("user", user);
        ModelAndView modelAndView = new ModelAndView("map", map);
        return modelAndView;
    }

    @RequestMapping("/modelAndViewTest6")
    public ModelAndView modelAndViewTest6(){
        Map<String,Object> map = new HashMap<String,Object>();
        User user = new User();
        user.setId(1);
        user.setName("张三");
        map.put("user", user);
        View view = new InternalResourceView("/map.jsp");
        ModelAndView modelAndView = new ModelAndView(view, map);
        return modelAndView;
    }

    @RequestMapping("/modelAndViewTest7")
    public ModelAndView modelAndViewTest7(){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        ModelAndView modelAndView = new ModelAndView("map", "user", user);
        return modelAndView;
    }

    @RequestMapping("/modelAndViewTest8")
    public ModelAndView modelAndViewTest8(){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        View view = new InternalResourceView("/map.jsp");
        ModelAndView modelAndView = new ModelAndView(view, "user", user);
        return modelAndView;
    }

//    HttpServletRequest
    @RequestMapping("requestTest")
    public String requestTest(HttpServletRequest request){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        request.setAttribute("user", user);
        return "map";
    }

//    ModelAttribute
    @RequestMapping("modelAttributeTest")
    public String modelAttributeTest(){
        return "map";
    }

    @ModelAttribute
    public User getUser(){
        User user = new User();
        user.setId(1);
        user.setName("张三1");
        return user;
    }

//    优先级 1
    @ModelAttribute
    public void getUser2(Map<String,Object> map){
        User user = new User();
        user.setId(1);
        user.setName("张三2");
        map.put("user", user);
    }

//    优先级 2
    @ModelAttribute
    public void getUser3(Model model){
        User user = new User();
        user.setId(1);
        user.setName("张三3");
        model.addAttribute("user", user);
    }

    @RequestMapping(value="dateConverterTest")
    @ResponseBody
    public String dateConverterTest(Date date){
        return date.toString();
    }

    @RequestMapping(value="studentConverterTest")
    @ResponseBody
    public String studentConverterTest(Student student){
        return student.toString();
    }



}
