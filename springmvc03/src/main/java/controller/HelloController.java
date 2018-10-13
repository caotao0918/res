package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController{
	
	@ExceptionHandler
	//����һ���쳣������
	//ex:�����������׳����쳣
	public String exHandle(Exception ex,HttpServletRequest request){
		System.out.println("exHandle()");
		//�����쳣���ͷֱ�������Ӧ����
		if(ex instanceof NumberFormatException){
			request.setAttribute("errorMsg", "�ף���������ȷ�����֣�");
			return "error";
		}else if(ex instanceof StringIndexOutOfBoundsException){
			request.setAttribute("errorMsg", "�±�Խ��");
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
