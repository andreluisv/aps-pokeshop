package aps.pokeshop.usuarioservice.Factories;

import aps.pokeshop.usuarioservice.Usuario.IRepositorioUsuarios;

import org.springframework.beans.factory.annotation.Autowired;

public class FabricaRepositorioBDR implements IFabricaAbstrataRepositorio {

  @Autowired
  private IRepositorioUsuarios iRepositorioUsuarios;

  public IRepositorioUsuarios CriarRepositorioUsuarios() {
    return this.iRepositorioUsuarios;
  }

}
