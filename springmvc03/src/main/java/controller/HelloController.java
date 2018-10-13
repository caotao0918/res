package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController{
	
	@ExceptionHandler
	//这是一个异常处理方法
	//ex:其他方法所抛出的异常
	public String exHandle(Exception ex,HttpServletRequest request){
		System.out.println("exHandle()");
		//依据异常类型分别做出相应处理
		if(ex instanceof NumberFormatException){
			request.setAttribute("errorMsg", "亲，请输入正确的数字！");
			return "error";
		}else if(ex instanceof StringIndexOutOfBoundsException){
			request.setAttribute("errorMsg", "下标越界");
			return "error";
		}else{
			return "system_error";
		}
	}
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello()");
		Integer.parseInt("100a");
		return "hello";
	}
	@RequestMapping("/demo/hello2.do")
	public String hello2(){
		System.out.println("hello2()");
		String str = "abcdefg";
		str.charAt(10);
		return "hello";
	}
}
