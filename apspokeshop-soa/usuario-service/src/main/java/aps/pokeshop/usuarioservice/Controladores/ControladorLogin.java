package aps.pokeshop.usuarioservice.Controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aps.pokeshop.usuarioservice.Usuario.CadastroUsuarios;
import aps.pokeshop.usuarioservice.Usuario.Usuario;

@Component
public class ControladorLogin {

  @Autowired private CadastroUsuarios cadastroUsuarios;
  
  private CadastroUsuarios getCadastroUsuarios(){
    return this.cadastroUsuarios;
  }

  public Usuario efetuarLogin(String email, String senha){
    return this.getCadastroUsuarios().validarCredenciais(email, senha);
  }

  public Optional<Usuario> getUserById(Long id){
    return this.getCadastroUsuarios().getUserById(id);
  }
}
