package account.config;


import account.RegistrationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * interceptor configuration class
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {
    /**
     *
     * @param registry
     * listening "save" path to intercept registry request
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RegistrationInterceptor()).addPathPatterns("/save");
    }
}
