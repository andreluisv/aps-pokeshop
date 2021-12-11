package aps.pokeshop.ofertaservice.Factories;

import aps.pokeshop.ofertaservice.Oferta.IRepositorioOfertas;

public interface IFabricaAbstrataRepositorio {
  public IRepositorioOfertas CriarRepositorioOfertas();
}
