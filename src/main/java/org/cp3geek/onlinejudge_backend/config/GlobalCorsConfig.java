package org.cp3geek.onlinejudge_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalCorsConfig {
    @Bean
    public WebMvcConfigurer corsConfiguere(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/**")
                        .allowCredentials(true)//是否发送Cookie信息
                        .allowedHeaders("*")//放行哪些原始域（头部信息）
                        .allowedMethods("GET","POST","PUT","DELETE")//放行哪些原始域（请求方式）
                        .allowedOrigins("*")
                        .exposedHeaders("Header1","Header2");//暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
            }
        };
    }
}
