package com.shonlee.reboot.config.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * 会话管理
 *
 * @Auther shonlee
 * @Date 2018-5-11
 */
@Component
public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
//    private final RedisTemplate<String, Object> redisTemplate;
//
//    @Autowired
//    public SessionFilter(RedisTemplate<String, Object> redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest request1 = (HttpServletRequest) request;
//        String token = request1.getHeader("token");
//        LoginSession loginSession = (LoginSession) redisTemplate.opsForValue().get(LoginService.SESSION_NAMESPACE + token);
//        if (loginSession != null) {
//            int timeOut = loginProperties.getLoginTimeout();
//            redisTemplate.expire(LoginService.SESSION_NAMESPACE + token, timeOut, TimeUnit.MINUTES);
//            if (loginSession.token != null) {
//                HttpServletResponse response1 = (HttpServletResponse) response;
//                response1.addHeader("local-token", loginSession.token);
//            }
//        }
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
}
