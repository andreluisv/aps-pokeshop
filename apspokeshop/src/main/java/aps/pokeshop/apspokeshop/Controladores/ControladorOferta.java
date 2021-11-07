package aps.pokeshop.apspokeshop.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aps.pokeshop.apspokeshop.Oferta.CadastroOfertas;
import aps.pokeshop.apspokeshop.Usuario.CadastroUsuarios;
import aps.pokeshop.apspokeshop.Usuario.Usuario;
import aps.pokeshop.apspokeshop.Oferta.*;

import java.util.List;
import java.util.Optional;

@Component
public class ControladorOferta {
  
  @Autowired private CadastroOfertas cadastroOfertas;
  @Autowired private CadastroUsuarios cadastroUsuarios;

  public ControladorOferta(CadastroOfertas cadastroOfertas, CadastroUsuarios cadastroUsuarios){
    this.cadastroOfertas = cadastroOfertas;
    this.cadastroUsuarios = cadastroUsuarios;
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

  public boolean cadastrarOferta(Long userId, String descricao, Double preco, String titulo, String codigoCarta) {
    Optional<Usuario> proprietario = this.getCadastroUsuarios().getUserById(userId);
    if (!proprietario.isPresent()){
      return false;
    }
    Carta carta = new Carta();
    // TODO API com o codigoCarta
    String[] fraquezas = new String[1];
    fraquezas[0] = "fraquesa 1 da carta";
    carta.setFraquezas(fraquezas);
    carta.setPokemon("pokemonDaCarta");
    carta.setRaridade("raridadeDaCarta");
    carta.setTipo("tipoDaCarta");
    carta.setTitulo("tituloDaCarta");
    carta.setArtista("artistaDaCarta");
    // API com o codigoCarta
    this.cadastroOfertas.adicionarCarta(carta);
    
    Oferta oferta = new Oferta(carta, proprietario.get());
    oferta.setDescricao(descricao);
    oferta.setPreco(preco);
    oferta.setTitulo(titulo);
    oferta.setcodigoCarta(codigoCarta);
    this.cadastroOfertas.adicionarOferta(oferta);

    return true;
  }
}

