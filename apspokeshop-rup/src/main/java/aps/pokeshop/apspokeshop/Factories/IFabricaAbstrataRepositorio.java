package aps.pokeshop.apspokeshop.Factories;

import aps.pokeshop.apspokeshop.Usuario.IRepositorioUsuarios;
import aps.pokeshop.apspokeshop.Oferta.IRepositorioOfertas;

public interface IFabricaAbstrataRepositorio {

  public IRepositorioUsuarios CriarRepositorioUsuarios();

  public IRepositorioOfertas CriarRepositorioOfertas();
}
