package aps.pokeshop.apspokeshop.Oferta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import aps.pokeshop.apspokeshop.Usuario.Usuario;
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
  @Autowired
  @ManyToOne
  private Usuario proprietario;
  private String codigoCarta;

  public Oferta(Carta carta, Usuario proprietario) {
    this.carta = carta;
    this.proprietario = proprietario;
  }
}
