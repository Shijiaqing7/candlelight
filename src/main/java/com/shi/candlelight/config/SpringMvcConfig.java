package com.shi.candlelight.config;
import com.shi.candlelight.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {

    //增加一个过滤器把这个过滤器注入进来
    @Resource
    LogInterceptor logInterceptor;
    //注册过滤器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor)
                .addPathPatterns("/**").excludePathPatterns("/login");//针对所以请求打印日志 排除login

    }
}
