package aps.pokeshop.gateway.Tela;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TelaControler {
  @GetMapping()
  public String telaLogin() {
    return "home";
  }
}