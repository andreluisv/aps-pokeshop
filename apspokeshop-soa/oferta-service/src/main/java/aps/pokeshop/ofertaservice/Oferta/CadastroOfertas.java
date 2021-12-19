package aps.pokeshop.ofertaservice.Oferta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aps.pokeshop.ofertaservice.Factories.FabricaRepositorioBDR;
import aps.pokeshop.ofertaservice.Factories.IFabricaAbstrataRepositorio;

@Component
public class CadastroOfertas {

  private IFabricaAbstrataRepositorio iFabricaAbstrataRepositorio = new FabricaRepositorioBDR();

  @Autowired
  private IRepositorioOfertas iCadastroOfertas = iFabricaAbstrataRepositorio.CriarRepositorioOfertas();

  public CadastroOfertas() {
  }

  public List<Oferta> recuperarOfertas() {
    return this.iCadastroOfertas.findAll();
  }

  public void adicionarOferta(Oferta oferta) {
    this.iCadastroOfertas.save(oferta);
  }

}
