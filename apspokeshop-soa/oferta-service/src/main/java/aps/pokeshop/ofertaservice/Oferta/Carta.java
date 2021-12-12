package aps.pokeshop.ofertaservice.Oferta;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carta implements Serializable{

  private String pokemon;
  private String tipo;
  private String raridade;
  private String artista;

}
