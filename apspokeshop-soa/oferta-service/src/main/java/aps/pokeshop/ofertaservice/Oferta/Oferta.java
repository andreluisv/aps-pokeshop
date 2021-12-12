package aps.pokeshop.ofertaservice.Oferta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Oferta {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String titulo;
  private String descricao;
  private double preco;
  private Carta carta;
  private Long proprietario_id;
  private String proprietario_email;
  private String codigoCarta;

  public Oferta(Carta carta, Long proprietario_id, String proprietario_email) {
    this.carta = carta;
    this.proprietario_id = proprietario_id;
    this.proprietario_email = proprietario_email;
  }
}
