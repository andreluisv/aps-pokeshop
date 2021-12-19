package aps.pokeshop.ofertaservice.Factories;

import aps.pokeshop.ofertaservice.Oferta.IRepositorioOfertas;

import org.springframework.beans.factory.annotation.Autowired;

public class FabricaRepositorioBDR implements IFabricaAbstrataRepositorio {

  @Autowired
  private IRepositorioOfertas iRepositorioOfertas;

  public IRepositorioOfertas CriarRepositorioOfertas() {
    return this.iRepositorioOfertas;
  }
}
