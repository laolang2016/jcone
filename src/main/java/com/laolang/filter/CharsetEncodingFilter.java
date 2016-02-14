package com.laolang.filter;
 
import java.io.IOException;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
 
/**
 * Servlet Filter implementation class CharsetEncodingFilter
 * 将所有页面的字符集过滤为utf-8
 * @version 1.2.1
 * @author 小代码
 */
public class CharsetEncodingFilter implements Filter {
 
    /**
     * Default constructor.
     */
    public CharsetEncodingFilter() {
    }
 
    /**
     * @see Filter#destroy()
     */
    public void destroy() {
    }
 
    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        // place your code here
 
        // pass the request along the filter chain
        request.setCharacterEncoding(CODE);
        response.setCharacterEncoding(CODE);
        chain.doFilter(request, response);
    }
 
    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        CODE = fConfig.getInitParameter("code");
    }
 
    private static String CODE = "UTF-8";
 
}