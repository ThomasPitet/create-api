package com.formation.apirestdemo.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class DureeInterceptor implements HandlerInterceptor {

    private static final String DEBUT = "debutTraitement";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        request.setAttribute(DEBUT, System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        long duree = System.currentTimeMillis() - (long) request.getAttribute(DEBUT);
        System.out.println(request.getMethod() + " " + request.getRequestURI()
                + " -> " + response.getStatus() + " (" + duree + " ms)");
    }
}
