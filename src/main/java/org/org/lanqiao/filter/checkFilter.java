package org.lanqiao.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "checkFilter",urlPatterns = "/*")
public class checkFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       //前驱操作
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        chain.doFilter(req,resp);
        //后驱操作
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
