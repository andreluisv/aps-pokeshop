package aps.pokeshop.apspokeshop.Fachadas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aps.pokeshop.apspokeshop.Controladores.ControladorLogin;
import aps.pokeshop.apspokeshop.Controladores.ControladorOferta;
import aps.pokeshop.apspokeshop.Oferta.CadastroOfertaDTO;
import aps.pokeshop.apspokeshop.Oferta.Oferta;
import aps.pokeshop.apspokeshop.Usuario.Usuario;

@Component
public class Fachada {
 @Autowired private ControladorLogin controladorLogin;
 @Autowired private ControladorOferta controladorOferta;

  public Usuario efetuarLogin(String email, String senha){
    return this.controladorLogin.efetuarLogin(email, senha);
  }
  
  public boolean cadastrarOferta(CadastroOfertaDTO dto){
    return this.controladorOferta.cadastrarOferta(dto);
  }

  public List<Oferta> recuperarOfertas(){
    return this.controladorOferta.recuperarOfertas();
  }
}