package aps.pokeshop.ofertaservice.TelaControles;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import aps.pokeshop.ofertaservice.Fachadas.Fachada;
import aps.pokeshop.ofertaservice.Oferta.CadastroOfertaDTO;

@Controller
@RequestMapping("/oferta")
public class TelaCadastrarOfertaControle {

  @Autowired
  Fachada fachada;

  @GetMapping(path = "/")
  @ResponseBody
  public String fetchUser() {
    return "teste";
  }

  @GetMapping(path = "/nova/{userId}")
  public String telaCadastrarOferta(Model model, @PathVariable Long userId) {
    model.addAttribute("userId", userId);
    return "create_oferta";
  }

  @PostMapping(path = "/nova/{userId}")
  public String telaCadastrarOferta(Model model, @PathVariable Long userId,
      @RequestParam(required = true) Map<String, String> qparams) {

    String preco = "0";
    if (qparams.containsKey("preco"))
      preco = qparams.get("preco");
    CadastroOfertaDTO dto = new CadastroOfertaDTO(userId, qparams.get("descricao"), Double.parseDouble(preco),
        qparams.get("titulo"), qparams.get("codigoCarta"));
    boolean res = fachada.cadastrarOferta(dto);
    if (res) {
      model.addAttribute("titulo", qparams.get("titulo"));
      return "success_oferta";
    }

    model.addAttribute("fail", "Error while creating new Oferta");
    return "create_oferta";
  }
}
