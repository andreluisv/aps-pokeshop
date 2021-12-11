package aps.pokeshop.ofertaservice.TelaControles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import aps.pokeshop.ofertaservice.Fachadas.Fachada;
import aps.pokeshop.ofertaservice.Oferta.Oferta;

@Controller
public class TelaListarOfertaControle {
  
  @Autowired
  Fachada fachada;

  @GetMapping(path = "/oferta/listar")
  public String recuperarOfertas(Model model) {
    List<Oferta> ofertas = fachada.recuperarOfertas();
    model.addAttribute("ofertas", ofertas);
    return "list_oferta";
  }
}
