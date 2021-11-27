package aps.pokeshop.apspokeshop.Oferta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastroOfertas {

  @Autowired
  private IRepositorioOfertas iCadastroOfertas;

  public static CadastroOfertas instance;
  public static CadastroOfertas getInstance() {
    if (instance == null){
      instance = new CadastroOfertas();
    }

    return instance;
  }

  public CadastroOfertas() {
  }

  public List<Oferta> recuperarOfertas() {
    return this.iCadastroOfertas.findAll();
  }

  public void adicionarOferta(Oferta oferta) {
    this.iCadastroOfertas.save(oferta);
  }

}
