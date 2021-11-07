package aps.pokeshop.apspokeshop.TelaControles;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aps.pokeshop.apspokeshop.Fachadas.Fachada;

@Controller
public class TelaLoginControle {

  @Autowired
  Fachada fachada;

  @GetMapping(path = "/login")
  public String telaLogin() {
    return "login";
  }

  @GetMapping(path = "/login/logar")
  public String efetuarLogin(Model model, @RequestParam(required = true) Map<String, String> qparams) {
    String email = qparams.get("email"), senha = qparams.get("senha");
    if (this.fachada.efetuarLogin(email, senha)) {
      model.addAttribute("email", email);
      return "home";
    }
    model.addAttribute("fail", "Usuario ou senha incorretos");
    return "login";
  }

}