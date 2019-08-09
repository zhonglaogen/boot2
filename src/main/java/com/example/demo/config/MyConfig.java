package com.example.demo.config;


import com.example.demo.component.LoginHandlerIntercepter;
import com.example.demo.component.MyLocalResolver;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 使用WebMvcConfigurerAdapter扩展mvc功能，如拦截器，视图解析器,内部功能
 * 无效,又有效了,
 * 和默认的组合使用，调用的时候for循环调用所有
 */
@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        //浏览器发送请求/zlx到myhtml页面
        registry.addViewController("/zlx").setViewName("myhtml");

    }

    /**视图映射
     * 设置首页
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
            WebMvcConfigurer webMvcConfigurer=new WebMvcConfigurer() {
                @Override
                public void addViewControllers(ViewControllerRegistry registry) {
                    registry.addViewController("/").setViewName("index");
                    registry.addViewController("/index.html").setViewName("index");
                    //防止刷新，表单重复提交，重定向页面
                    registry.addViewController("/main.html").setViewName("dashboard");
                }

                /**
                 * 拦截器
                 * @param registry
                 */
                @Override
                public void addInterceptors(InterceptorRegistry registry) {

                    //spring boot做好了静态资源配置
//                    registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/**")
//                            .excludePathPatterns("/static/asserts/css/**","static/asserts/img/**","static/asserts/js/**")
//                            .excludePathPatterns("/index.html","/","/user/login");

                }

            };
        return webMvcConfigurer;
    }

    /**
     * 源码配置就是oncodition如果没有人做配置就用默认，如果自定义了，就不用默认了
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }


}
