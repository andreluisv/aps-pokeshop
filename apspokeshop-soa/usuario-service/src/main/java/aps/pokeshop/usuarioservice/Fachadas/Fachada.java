package aps.pokeshop.usuarioservice.Fachadas;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aps.pokeshop.usuarioservice.Controladores.ControladorLogin;
import aps.pokeshop.usuarioservice.Usuario.Usuario;

@Component
public class Fachada {
  @Autowired
  private ControladorLogin controladorLogin;

  public Usuario efetuarLogin(String email, String senha) {
    return this.controladorLogin.efetuarLogin(email, senha);
  }

  public Optional<Usuario> getUsuario(Long id){
    return this.controladorLogin.getUserById(id);
  }

}