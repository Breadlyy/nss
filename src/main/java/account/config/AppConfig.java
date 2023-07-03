//package account.config;
//
//import account.GeneralInterceptor;
//import account.RegistrationInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class AppConfig extends WebMvcConfigurationSupport {
//
//    private GeneralInterceptor generalInterceptor;
//
//    public void addInterceptor(InterceptorRegistry registry)
//    {
//        registry.addInterceptor(generalInterceptor);
//    }
//
////    @Override
////    public void addInterceptors(InterceptorRegistry registry) {
////        registry.addInterceptor(new RegistrationInterceptor());
////    }
//}
