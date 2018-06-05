package com.xxz.interceptors;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @Auther: xxz
 * @Date: 2018/5/26 0026 11:48
 * @Description:自定义拦截器
 */
@Configuration
public class CustomInterceptor implements WebMvcConfigurer {
    /**
     * 添加拦截器
     **/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new IndexInterceptor()).addPathPatterns("/index.html").excludePathPatterns("/fileupload.html");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {

    }

    /**
     * 配置内容裁决的一些选项
     **/
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {

    }

    /**
     * 默认静态资源处理器
     **/
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

    }

    @Override
    public void addFormatters(FormatterRegistry registry) {

    }

    /**
     * 静态资源处理
     **/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    /**
     * 解决跨域问题
     **/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET","POST","DELETE","PUT","PATCH","OPTION")
                .maxAge(3600);
    }

    /**
     * 视图跳转控制器
     **/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }

    /**
     * 这里配置视图解析器
     **/
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }


}
