package aps.pokeshop.apspokeshop.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aps.pokeshop.apspokeshop.Usuario.CadastroUsuarios;
import aps.pokeshop.apspokeshop.Usuario.Usuario;

@Component
public class ControladorLogin {

  @Autowired private CadastroUsuarios cadastroUsuarios;
  
  private CadastroUsuarios getCadastroUsuarios(){
    return this.cadastroUsuarios;
  }

  public Usuario efetuarLogin(String email, String senha){
    return this.getCadastroUsuarios().validarCredenciais(email, senha);
  }
}
