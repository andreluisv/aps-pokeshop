package aps.pokeshop.ofertaservice.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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

  private final RestTemplate restTemplate;

  public ControladorOferta(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.build();
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
    // lb://usuario
    ResponseEntity<String> req = this.restTemplate
        .exchange("http://localhost:8083/usuario?id=" + dto.getUserId().toString(), HttpMethod.GET, null, String.class);
    Carta carta = this.getISubsistemaComunicacaoPokemonTCGAPI().fetchCarta(dto.getCodigoCarta());
    if (!req.hasBody() || req.getBody().length() == 0 || Objects.isNull(carta))
      return false;

    Oferta oferta = new Oferta(carta, dto.getUserId(), req.getBody());
    oferta.setDescricao(dto.getDescricao());
    oferta.setPreco(dto.getPreco());
    oferta.setTitulo(dto.getTitulo());
    oferta.setCodigoCarta(dto.getCodigoCarta());
    this.cadastroOfertas.adicionarOferta(oferta);

    return true;
  }
}
