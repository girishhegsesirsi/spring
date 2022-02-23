package spring.girish.ExceptionHandlingWithMapping.Interceptors;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		
		Calendar cal = Calendar.getInstance();
		int dayOfTheWeek = cal.get(cal.DAY_OF_WEEK);
		
		if(dayOfTheWeek==7) {
			response.getWriter().write("The Website is closed for Saturday, please try accessing it on other weekday!!");
		return false;
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model)throws Exception {
		
		System.out.println("HandlerInterceptorAdapter : Spring MVC called postHandle method for " +request.getRequestURI().toString());
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws Exception {
		
		System.out.println("HandlerInterceptorAdaptor : Spring MVC called afterCompletion method for " +request.getRequestURI().toString());
	}
	
}
