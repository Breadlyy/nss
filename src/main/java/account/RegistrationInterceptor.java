package account;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * The type Registration interceptor.
 */
@Slf4j
public class RegistrationInterceptor implements HandlerInterceptor {

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @return getting registration request. take the email and password form model and check if it's not blank
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // Ваш код для проверки почты и пароля
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // Проверьте почту и пароль здесь и выполните необходимые действия

        if (email.isBlank() || password.isBlank()) {
            log.info("email or password is null");
            // Почта или пароль не заполнены, выполните соответствующие действия
            return false; // Остановить обработку запроса
        }
        log.info("everything is ok");
        return true; // Продолжить обработку запроса
    }




}
