package aps.pokeshop.apspokeshop.TelaControles;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aps.pokeshop.apspokeshop.Fachadas.Fachada;

@Controller
public class TelaCadastrarOfertaControle {

  @Autowired
  Fachada fachada;

  @GetMapping(path = "/oferta/nova/{userId}")
  public String telaCadastrarOferta(Model model, @PathVariable Long userId) {
    model.addAttribute("userId", userId);
    return "create_oferta";
  }

  @PostMapping(path = "/oferta/nova/{userId}")
  public String telaCadastrarOferta(Model model, @PathVariable Long userId,
      @RequestParam(required = true) Map<String, String> qparams) {

    boolean res = fachada.cadastrarOferta(userId, qparams.get("descricao"), Double.parseDouble(qparams.get("preco")),
        qparams.get("titulo"), qparams.get("codigoCarta"));
    if (res){
      model.addAttribute("titulo", qparams.get("titulo"));
      return "success_oferta";
    }

    model.addAttribute("fail", "Error while creating new Oferta");
    return "create_oferta";
  }
}
