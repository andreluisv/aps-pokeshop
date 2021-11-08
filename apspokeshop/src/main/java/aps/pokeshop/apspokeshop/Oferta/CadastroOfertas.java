package aps.pokeshop.apspokeshop.Oferta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastroOfertas {

  @Autowired
  private ICadastroOfertas iCadastroOfertas;

  public CadastroOfertas() {
  }

  public List<Oferta> recuperarOfertas() {
    return this.iCadastroOfertas.findAll();
  }

  public void adicionarOferta(Oferta oferta) {
    this.iCadastroOfertas.save(oferta);
  }

  // TODO: getInstance() CadastroOfertas singleton
}
