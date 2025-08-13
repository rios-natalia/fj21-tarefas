package br.com.caelum.tarefas.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {
      String uri = request.getRequestURI();
      if (!uri.endsWith("loginForm") && !uri.endsWith("efetuaLogin") && !uri.contains("resources")) {
         if (request.getSession().getAttribute("usuarioLogado") != null) {
            return true;
         } else {
            response.sendRedirect("loginForm");
            return false;
         }
      } else {
         return true;
      }
   }
}
