package aps.pokeshop.apspokeshop.Oferta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import aps.pokeshop.apspokeshop.Usuario.Usuario;

@Entity
public class Oferta {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String titulo;
  private String descricao;
  private double preco;
  @Autowired
  @OneToOne
  private Carta carta;
  @Autowired
  @ManyToOne
  private Usuario proprietario;
  private String codigoCarta;

  public Oferta(){}

  public Oferta(Carta carta, Usuario proprietario) {
    this.carta = carta;
    this.proprietario = proprietario;
  }

  public Usuario getProprietario() {
    return this.proprietario;
  }

  public Carta getCarta() {
    return this.carta;
  }

  public String getTitulo() {
    return this.titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Double getPreco() {
    return this.preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public String getcodigoCarta() {
    return this.codigoCarta;
  }

  public void setcodigoCarta(String codigoCarta) {
    this.codigoCarta = codigoCarta;
  }
}
