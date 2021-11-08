package aps.pokeshop.apspokeshop.TelaControles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import aps.pokeshop.apspokeshop.Fachadas.Fachada;
import aps.pokeshop.apspokeshop.Oferta.Oferta;

@Controller
public class TelaListarOfertaControle {
  
  @Autowired
  Fachada fachada;

  @GetMapping(path = "/oferta/listar")
  public String recuperarOfertas(Model model) {
    // model.addAttribute("userId", userId);
    List<Oferta> ofertas = fachada.recuperarOfertas();
    model.addAttribute("ofertas", ofertas);
    // if (ofertas.size() > 0) System.out.println(ofertas.get(0).getProprietario());
    return "list_oferta";
  }
}
