package aps.pokeshop.apspokeshop.Oferta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastroOfertas {

  @Autowired
  private ICadastroOfertas iCadastroOfertas;
  @Autowired
  private ICadastroCartas iCadastroCartas;
  @Autowired
  private ISubsistemaComunicacaoPokemonTCGAPI iSubsistemaComunicacaoPokemonTCGAPI;

  public CadastroOfertas() {
  }

  public List<Oferta> recuperarOfertas() {
    return this.iCadastroOfertas.findAll();
  }

  public void adicionarOferta(Oferta oferta) {
    this.iCadastroOfertas.save(oferta);
  }

  public void adicionarCarta(Carta carta){
    this.iCadastroCartas.save(carta);
  }

  public Carta fetchCarta(String codigo){
    return this.iSubsistemaComunicacaoPokemonTCGAPI.fetchCarta(codigo);
  }

  // TODO: getInstance() CadastroOfertas singleton
}
