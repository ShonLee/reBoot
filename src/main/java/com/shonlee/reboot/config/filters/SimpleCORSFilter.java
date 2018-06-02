package com.shonlee.reboot.config.filters;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 允许跨域
 *
 * @Auther shonlee
 * @Date 2018-5-11
 */
@Component
public class SimpleCORSFilter implements Filter {
    private final RedisTemplate<String, String> redisTemplate;
    private final String key = "core:reBoot";

    @Autowired
    public SimpleCORSFilter(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
        redisTemplate.opsForSet().add(key, "token");
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = ((HttpServletRequest) req);
        HttpServletResponse response = (HttpServletResponse) res;

        if (request.getMethod().equals("OPTIONS")) {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            response.setHeader("Access-Control-Max-Age", "0");
            response.setHeader("Access-Control-Allow-Headers", StringUtils.join(redisTemplate.opsForSet().members(key), ','));
            response.setStatus(200);
            return;
        } else {
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                redisTemplate.opsForSet().add(key, headerNames.nextElement());
            }
        }
        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) {
    }

    public void destroy() {
    }

}