package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        HttpServletResponse resp=(HttpServletResponse) servletResponse;
        String uri=req.getRequestURI();
       if(uri.endsWith(".css")||uri.endsWith(".js")||uri.endsWith(".jpg")||uri.endsWith(".img")){
           filterChain.doFilter(req,resp);
           return;
       }

        if(uri.endsWith("login.html")||uri.endsWith("login")){
            filterChain.doFilter(req,resp);
            return;
        }

        String userName=(String) req.getSession().getAttribute("userName");
        if(null==userName){
            resp.sendRedirect("login.html");
            return;
        }
    }
}
