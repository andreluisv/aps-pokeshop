package aps.pokeshop.ofertaservice.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import aps.pokeshop.ofertaservice.Oferta.CadastroOfertas;
import aps.pokeshop.ofertaservice.Oferta.*;

import java.util.List;
import java.util.Objects;

@Component
public class ControladorOferta {

  @Autowired
  private CadastroOfertas cadastroOfertas;
  @Autowired
  private ISubsistemaComunicacaoPokemonTCGAPI iSubsistemaComunicacaoPokemonTCGAPI;
  @Autowired
  WebClient.Builder wBuilder;

  private WebClient client() {
    return wBuilder.baseUrl("lb://usuario").build();
  }

  public ISubsistemaComunicacaoPokemonTCGAPI getISubsistemaComunicacaoPokemonTCGAPI() {
    return this.iSubsistemaComunicacaoPokemonTCGAPI;
  }

  public CadastroOfertas getCadastroOfertas() {
    return this.cadastroOfertas;
  }

  public List<Oferta> recuperarOfertas() {
    return this.cadastroOfertas.recuperarOfertas();
  }

  public boolean cadastrarOferta(CadastroOfertaDTO dto) {
    String email = client().get().uri("/usuario?id=" + dto.getUserId().toString()).retrieve().bodyToMono(String.class)
        .block();
    Carta carta = this.getISubsistemaComunicacaoPokemonTCGAPI().fetchCarta(dto.getCodigoCarta());
    if (email == null || email.length() == 0 || Objects.isNull(carta))
      return false;

    Oferta oferta = new Oferta(carta, dto.getUserId(), email);
    oferta.setDescricao(dto.getDescricao());
    oferta.setPreco(dto.getPreco());
    oferta.setTitulo(dto.getTitulo());
    oferta.setCodigoCarta(dto.getCodigoCarta());
    this.cadastroOfertas.adicionarOferta(oferta);

    return true;
  }
}
