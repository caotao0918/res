package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
//������
public class SomeInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion()");
	}
	/*
	 * Controller(������)�����귽��֮��
	 * ��׼����������(ModelAndView)���ظ�DispatcherServlet(ǰ�˿�����)֮ǰ
	 * ִ�и÷����������ڸ÷��������޸Ĵ�������
	 */
	public void postHandle(HttpServletRequest arg0,
			               HttpServletResponse arg1,
			               Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("postHandle()");
	}
	//DispatcherServlet(ǰ�˿�����)�յ�����󣬻��ȵ����������еĸ÷�����
	//����÷�������ֵΪtrue�����������ִ��
	//�����ж�����
	//����������������һ������
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("preHandle()");
		return true;
	}

}
