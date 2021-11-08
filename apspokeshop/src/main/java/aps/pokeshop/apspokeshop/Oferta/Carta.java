package aps.pokeshop.apspokeshop.Oferta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Carta {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String titulo;
  private String pokemon;
  private String tipo;
  private String[] fraquezas;
  private String raridade;
  private String artista;

  public Carta(){
  }

  public String getTitulo(){
    return this.titulo;
  }

  public void setTitulo(String titulo){
    this.titulo = titulo;
  }

  public String getPokemon(){
    return this.pokemon;
  }

  public void setPokemon(String pokemon){
    this.pokemon = pokemon;
  }

  public String getTipo(){
    return this.tipo;
  }

  public void setTipo(String tipo){
    this.tipo = tipo;
  }

  public String[] getFraquezas(){
    return this.fraquezas;
  }

  public void setFraquezas(String[] fraquezas){
    this.fraquezas = fraquezas;
  }

  public String getRaridade(){
    return this.raridade;
  }

  public void setRaridade(String raridade){
    this.raridade = raridade;
  }

  public String getArtista(){
    return this.artista;
  }

  public void setArtista(String artista){
    this.artista = artista;
  }
}