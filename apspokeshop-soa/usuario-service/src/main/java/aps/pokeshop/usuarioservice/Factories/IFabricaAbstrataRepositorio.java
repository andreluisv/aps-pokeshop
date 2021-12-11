package aps.pokeshop.usuarioservice.Factories;

import aps.pokeshop.usuarioservice.Usuario.IRepositorioUsuarios;

public interface IFabricaAbstrataRepositorio {

  public IRepositorioUsuarios CriarRepositorioUsuarios();

}
