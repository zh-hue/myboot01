package com.cdut.zhong.tm.config;

import com.cdut.zhong.tm.filter.Jurisdiction;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Arrays;

@Component
public class MyWebConfig implements WebMvcConfigurer {
    /**
     * 配置静态资源访问权限
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Bean //将组件注册到容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            //注册视图解析器
            @Override
            public void addViewControllers(ViewControllerRegistry registry){
                registry.addViewController("goToRegister").setViewName("register");//在模板引擎中找
                registry.addViewController("/").setViewName("login");//在模板引擎中找
            }

            //注册拦截器

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                super.addInterceptors(registry);
                //addPathPatterns添加要拦截的路径  excludePathPatterns：移除不要拦截的页面
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/index.html","/","/main","/asserts/**","/webjars/**");
            }
        };
        return adapter;
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean regis = new FilterRegistrationBean();
        regis.setFilter(new Jurisdiction());
        regis.setUrlPatterns(Arrays.asList("/goToPerson","/goToIndex",
                "/goods","/gooddetailHtml","/goToOrderHtml",
                "/goToPlayHtml","/playSuccessHtml","/OrderDetailHtml",
                "/goToComment","/addComment","/goToShoppingCar","/goodsByKeyword"));
        return regis;
    }
}
