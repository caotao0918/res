package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 如何写一个处理器：
 * 1.不用实现Controller接口。
 * 2.可以在处理器当中添加多个方法，每一个方法处理一种类型的请求。
 * 3.方法名不做要求，返回类型可以是任何类型。不必是ModelAndView。
 * 4.使用@Controller,将该处理器纳入容器进行管理。也就是说，spring配置文件不用配置处理器了。
 * 5.使用RequestMapping，告诉前端控制器，请求路径与处理器的方法的对应关系。也就是说，spring配置文件不用配置HandlerMapping了。
 */
@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello()");
		return "hello";//在项目里找hello.jsp文件(根据视图解析器的解析而定)，执行hello.jsp，如果项目里没有hello.jsp，则程序无法执行
	}
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "login";
	}
	@RequestMapping("/login.do")
	//读取请求参数值的第一种方法：通过request对象
	public String login1(HttpServletRequest request){
		System.out.println("login1()");
		String adminCode = request.getParameter("adminCode");
		String pwd = request.getParameter("pwd");
		System.out.println("adminCode:"+adminCode+"<br/>"+"password:"+pwd);
		return "index";
	}
	@RequestMapping("/login2.do")
	//读取请求参数值的第二种方法：通过@RequestParam注解（不常用）
	public String login2(@RequestParam("adminCode") String name,@RequestParam("pwd") String password){
		System.out.println("login2()");
		System.out.println("adminCode:"+name+"<br/>"+"password:"+password);
		return "index";
	}
	@RequestMapping("/login3.do")
	//读取请求参数值的第三种方法：通过javabean封装请求参数值(最常用)
	public String login3(AdminParam ap){
		System.out.println("login3()");
		System.out.println("adminCode:"+ap.getAdminCode()+"   "+"password:"+ap.getPwd());
		return "index";
	}
	@RequestMapping("/login4.do")
	//向页面传值的第一种方法：通过request方式
	public String login4(AdminParam ap,HttpServletRequest request){
		System.out.println("login4()");
		String adminCode = ap.getAdminCode();
		System.out.println(adminCode);
		//将数据绑定到request上
		request.setAttribute("adminCode", adminCode);
		//springmvc默认使用转发
		return "index";
	}
	@RequestMapping("/login5.do")
	//向页面传值的第二种方法：通过ModelAndView对象方式
	public ModelAndView login5(AdminParam ap){
		System.out.println("login5()");
		String adminCode = ap.getAdminCode();
		System.out.println(adminCode);
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("adminCode", adminCode);
		ModelAndView mav = new ModelAndView("index",data);
		return mav;
	}
	@RequestMapping("/login6.do")
	//向页面传值的第三种方法：通过ModelMap方式
	public String login6(AdminParam ap,ModelMap mm){
		System.out.println("login6()");
		String adminCode = ap.getAdminCode();
		System.out.println(adminCode);
		mm.addAttribute("adminCode",adminCode);
		return "index";
	}
	@RequestMapping("/login7.do")
	//重定向 "redirect:***"方式
	public String login7(){
		System.out.println("login7()");
		return "redirect:toIndex.do";
	}
	@RequestMapping("/toIndex.do")
	//重定向 "redirect:***"方式
	public String toIndex(){
		System.out.println("toIndex()");
		return "index";
	}
	@RequestMapping("/login9.do")
	//重定向：ModelAndView
	public ModelAndView login9(AdminParam ap,HttpSession session){
		System.out.println("login9()");
		RedirectView rv = new RedirectView("toIndex.do");
		ModelAndView mav = new ModelAndView(rv);
		String adminCode = ap.getAdminCode();
		session.setAttribute("adminCode", adminCode);
		return mav;
	}
}





