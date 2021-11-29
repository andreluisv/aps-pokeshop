package aps.pokeshop.apspokeshop.Oferta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastroCartas {

  @Autowired
  private IRepositorioCartas iCadastroCartas;
  @Autowired
  private ISubsistemaComunicacaoPokemonTCGAPI iSubsistemaComunicacaoPokemonTCGAPI;

  public void adicionarCarta(Carta carta){
    this.iCadastroCartas.save(carta);
  }

  public Carta fetchCarta(String codigo){
    return this.iSubsistemaComunicacaoPokemonTCGAPI.fetchCarta(codigo);
  }
}
