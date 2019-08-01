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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab.servlet.Constants.Constants;

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
		HttpServletResponse servletRes = (HttpServletResponse) response;

		if (!servletReq.getRequestURI().equals(Constants.LOGIN_URI)) {

			Cookie ck[] = servletReq.getCookies();
			for (int i = 0; i < ck.length; i++) {
				if (ck[i].getName().equals("Authorization")) {

				}

			}
			/*
			 * if (session == null) { servletRes.sendRedirect("index.html"); }
			 */
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
