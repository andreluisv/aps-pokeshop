package aps.pokeshop.ofertaservice.Fachadas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aps.pokeshop.ofertaservice.Controladores.ControladorOferta;
import aps.pokeshop.ofertaservice.Oferta.CadastroOfertaDTO;
import aps.pokeshop.ofertaservice.Oferta.Oferta;

@Component
public class Fachada {
  @Autowired
  private ControladorOferta controladorOferta;

  public boolean cadastrarOferta(CadastroOfertaDTO dto) {
    return this.controladorOferta.cadastrarOferta(dto);
  }

  public List<Oferta> recuperarOfertas() {
    return this.controladorOferta.recuperarOfertas();
  }
}