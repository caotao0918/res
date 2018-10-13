package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
//拦截器
public class SomeInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion()");
	}
	/*
	 * Controller(处理器)处理完方法之后，
	 * 正准备将处理结果(ModelAndView)返回给DispatcherServlet(前端控制器)之前
	 * 执行该方法。可以在该方法里面修改处理结果。
	 */
	public void postHandle(HttpServletRequest arg0,
			               HttpServletResponse arg1,
			               Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("postHandle()");
	}
	//DispatcherServlet(前端控制器)收到请求后，会先调用拦截器中的该方法，
	//如果该方法返回值为true，则继续向下执行
	//否则，中断请求
	//描述处理器方法的一个对象
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("preHandle()");
		return true;
	}

}
