package br.com.caelum.tarefas.controller;

import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.modelo.Usuario;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
   private JdbcUsuarioDao dao;

   @Autowired
   public LoginController(JdbcUsuarioDao dao) {
      this.dao = dao;
   }

   @RequestMapping({"loginForm"})
   public String loginForm() {
      return "formulario-login";
   }

   @RequestMapping({"efetuaLogin"})
   public String efetuaLogin(Usuario usuario, HttpSession session) {
      if (this.dao.existeUsuario(usuario)) {
         session.setAttribute("usuarioLogado", usuario);
         return "menu";
      } else {
         return "redirect:loginForm";
      }
   }

   @RequestMapping({"logout"})
   public String logout(HttpSession session) {
      session.invalidate();
      return "redirect:loginForm";
   }
}
