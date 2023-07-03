//package account;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.ui.Model;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//@Component
//@Slf4j
//public class RegistrationInterceptor implements HandlerInterceptor {
////    @Override
////    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
////            throws Exception {
////        // Получение объекта Account из модели
////        Model model = (Model) request.getAttribute("org.springframework.ui.Model");
////        Account account = (Account) model.getAttribute("account");
////
////        if (account == null || account.getEmail() == null || account.getEmail().isEmpty()
////                || account.getPassword() == null || account.getPassword().isEmpty()) {
////            // Если не переданы обязательные параметры, вернуть ошибку
////            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing email or password");
////            return false;
////        }
////        return true;
////    }
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//    {
////
//    }
//}