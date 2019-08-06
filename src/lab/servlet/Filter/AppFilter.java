package lab.servlet.Filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AppFilter implements Filter {

	private ServletContext context;
	private List<String> excludedUrls;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getServletPath();
		// HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession(false);
		if (session == null && !excludedUrls.contains(path)) {
			req.getRequestDispatcher("index.html").include(request, response);
		} else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");

		String excludePattern = filterConfig.getInitParameter("excludedUrls");
		excludedUrls = Arrays.asList(excludePattern.split(","));
	}

}
