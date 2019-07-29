package lab.servlet.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class ValidateCookieFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("***************Filter Invoked**********************");
		HttpServletRequest servletReq = (HttpServletRequest) request;
		Cookie ck[] = servletReq.getCookies();
		System.out.println("Cookies length : " + ck.length);
		for (int i = 0; i < ck.length; i++) {
			System.out.println("<br>" + ck[i].getName() + " " + ck[i].getValue());// printing name and value of cookie
		}

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
