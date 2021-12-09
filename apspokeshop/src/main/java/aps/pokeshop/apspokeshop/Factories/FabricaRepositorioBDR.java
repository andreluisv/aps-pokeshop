package aps.pokeshop.apspokeshop.Factories;

import aps.pokeshop.apspokeshop.Usuario.IRepositorioUsuarios;
import aps.pokeshop.apspokeshop.Oferta.IRepositorioOfertas;

import org.springframework.beans.factory.annotation.Autowired;

public class FabricaRepositorioBDR implements IFabricaAbstrataRepositorio {

  @Autowired
  private IRepositorioUsuarios iRepositorioUsuarios;
  @Autowired
  private IRepositorioOfertas iRepositorioOfertas;

  public IRepositorioUsuarios CriarRepositorioUsuarios() {
    return this.iRepositorioUsuarios;
  }

  public IRepositorioOfertas CriarRepositorioOfertas() {
    return this.iRepositorioOfertas;
  }
}
