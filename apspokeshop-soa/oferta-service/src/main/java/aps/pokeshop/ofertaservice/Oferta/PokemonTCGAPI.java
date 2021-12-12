package aps.pokeshop.ofertaservice.Oferta;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PokemonTCGAPI implements ISubsistemaComunicacaoPokemonTCGAPI{

  private final RestTemplate restTemplate;

  public PokemonTCGAPI(RestTemplateBuilder restTemplateBuilder) {
      this.restTemplate = restTemplateBuilder.build();
  }

  @Override
  public Carta fetchCarta(String codigo) {
    String url = "https://api.pokemontcg.io/v2/cards/"+codigo;
    try{
      ResponseEntity<APIPokemonResponse> req = this.restTemplate.exchange(url, HttpMethod.GET, null, APIPokemonResponse.class);
      APIPokemonResponse body = req.getBody();
      String pokemon = body.data.name;
      String tipo = body.data.types.size()>0 ? body.data.types.get(0) : "";
      String raridade = body.data.rarity;
      String artista = body.data.artist;
      
      Carta carta = new Carta();
      carta.setArtista(artista);
      carta.setPokemon(pokemon);
      carta.setRaridade(raridade);
      carta.setTipo(tipo);
      return carta;
    }catch(Exception e){
      System.out.println(e.getMessage());
      return null;
    }
  }
  
}
