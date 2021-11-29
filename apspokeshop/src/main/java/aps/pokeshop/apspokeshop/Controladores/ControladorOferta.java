package aps.pokeshop.apspokeshop.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aps.pokeshop.apspokeshop.Oferta.CadastroOfertas;
import aps.pokeshop.apspokeshop.Usuario.CadastroUsuarios;
import aps.pokeshop.apspokeshop.Usuario.Usuario;
import aps.pokeshop.apspokeshop.Oferta.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class ControladorOferta {
  
  @Autowired private CadastroOfertas cadastroOfertas;
  @Autowired private CadastroUsuarios cadastroUsuarios;
  @Autowired private CadastroCartas cadastroCartas;

  public ControladorOferta(){
    this.cadastroOfertas = CadastroOfertas.getInstance();
    this.cadastroUsuarios = CadastroUsuarios.getInstance();
    this.cadastroCartas = CadastroCartas.getInstance();
  }

  public CadastroCartas getCadastroCartas() {
    return this.cadastroCartas;
  }

  public CadastroUsuarios getCadastroUsuarios() {
    return this.cadastroUsuarios;
  }

  public CadastroOfertas getCadastroOfertas() {
    return this.cadastroOfertas;
  }

  public List<Oferta> recuperarOfertas() {
    return this.cadastroOfertas.recuperarOfertas();
  }

  public boolean cadastrarOferta(CadastroOfertaDTO dto) {
    Optional<Usuario> proprietario = this.getCadastroUsuarios().getUserById(dto.getUserId());
    Carta carta = this.getCadastroCartas().fetchCarta(dto.getCodigoCarta());
    if (!proprietario.isPresent() || Objects.isNull(carta)){
      return false;
    }
    this.getCadastroCartas().adicionarCarta(carta);
    
    Oferta oferta = new Oferta(carta, proprietario.get());
    oferta.setDescricao(dto.getDescricao());
    oferta.setPreco(dto.getPreco());
    oferta.setTitulo(dto.getTitulo());
    oferta.setCodigoCarta(dto.getCodigoCarta());
    this.cadastroOfertas.adicionarOferta(oferta);

    return true;
  }
}

