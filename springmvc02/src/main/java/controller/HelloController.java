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
 * ���дһ����������
 * 1.����ʵ��Controller�ӿڡ�
 * 2.�����ڴ�����������Ӷ��������ÿһ����������һ�����͵�����
 * 3.����������Ҫ�󣬷������Ϳ������κ����͡�������ModelAndView��
 * 4.ʹ��@Controller,���ô����������������й���Ҳ����˵��spring�����ļ��������ô������ˡ�
 * 5.ʹ��RequestMapping������ǰ�˿�����������·���봦�����ķ����Ķ�Ӧ��ϵ��Ҳ����˵��spring�����ļ���������HandlerMapping�ˡ�
 */
@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello()");
		return "hello";//����Ŀ����hello.jsp�ļ�(������ͼ�������Ľ�������)��ִ��hello.jsp�������Ŀ��û��hello.jsp��������޷�ִ��
	}
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "login";
	}
	@RequestMapping("/login.do")
	//��ȡ�������ֵ�ĵ�һ�ַ�����ͨ��request����
	public String login1(HttpServletRequest request){
		System.out.println("login1()");
		String adminCode = request.getParameter("adminCode");
		String pwd = request.getParameter("pwd");
		System.out.println("adminCode:"+adminCode+"<br/>"+"password:"+pwd);
		return "index";
	}
	@RequestMapping("/login2.do")
	//��ȡ�������ֵ�ĵڶ��ַ�����ͨ��@RequestParamע�⣨�����ã�
	public String login2(@RequestParam("adminCode") String name,@RequestParam("pwd") String password){
		System.out.println("login2()");
		System.out.println("adminCode:"+name+"<br/>"+"password:"+password);
		return "index";
	}
	@RequestMapping("/login3.do")
	//��ȡ�������ֵ�ĵ����ַ�����ͨ��javabean��װ�������ֵ(���)
	public String login3(AdminParam ap){
		System.out.println("login3()");
		System.out.println("adminCode:"+ap.getAdminCode()+"   "+"password:"+ap.getPwd());
		return "index";
	}
	@RequestMapping("/login4.do")
	//��ҳ�洫ֵ�ĵ�һ�ַ�����ͨ��request��ʽ
	public String login4(AdminParam ap,HttpServletRequest request){
		System.out.println("login4()");
		String adminCode = ap.getAdminCode();
		System.out.println(adminCode);
		//�����ݰ󶨵�request��
		request.setAttribute("adminCode", adminCode);
		//springmvcĬ��ʹ��ת��
		return "index";
	}
	@RequestMapping("/login5.do")
	//��ҳ�洫ֵ�ĵڶ��ַ�����ͨ��ModelAndView����ʽ
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
	//��ҳ�洫ֵ�ĵ����ַ�����ͨ��ModelMap��ʽ
	public String login6(AdminParam ap,ModelMap mm){
		System.out.println("login6()");
		String adminCode = ap.getAdminCode();
		System.out.println(adminCode);
		mm.addAttribute("adminCode",adminCode);
		return "index";
	}
	@RequestMapping("/login7.do")
	//�ض��� "redirect:***"��ʽ
	public String login7(){
		System.out.println("login7()");
		return "redirect:toIndex.do";
	}
	@RequestMapping("/toIndex.do")
	//�ض��� "redirect:***"��ʽ
	public String toIndex(){
		System.out.println("toIndex()");
		return "index";
	}
	@RequestMapping("/login9.do")
	//�ض���ModelAndView
	public ModelAndView login9(AdminParam ap,HttpSession session){
		System.out.println("login9()");
		RedirectView rv = new RedirectView("toIndex.do");
		ModelAndView mav = new ModelAndView(rv);
		String adminCode = ap.getAdminCode();
		session.setAttribute("adminCode", adminCode);
		return mav;
	}
}





