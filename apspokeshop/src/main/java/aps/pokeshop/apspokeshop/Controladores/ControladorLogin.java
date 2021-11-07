package aps.pokeshop.apspokeshop.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aps.pokeshop.apspokeshop.Usuario.CadastroUsuarios;

@Component
public class ControladorLogin {

  @Autowired private CadastroUsuarios cadastroUsuarios;

  public ControladorLogin(CadastroUsuarios cadastroUsuarios){
    this.cadastroUsuarios = cadastroUsuarios;
  }
  
  private CadastroUsuarios getCadastroUsuarios(){
    return this.cadastroUsuarios;
  }

  public boolean efetuarLogin(String email, String senha){
    return this.getCadastroUsuarios().validarCredenciais(email, senha);
  }
}
