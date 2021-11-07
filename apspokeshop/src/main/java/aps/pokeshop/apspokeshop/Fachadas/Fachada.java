package aps.pokeshop.apspokeshop.Fachadas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aps.pokeshop.apspokeshop.Controladores.ControladorLogin;

@Component
public class Fachada {
 @Autowired private ControladorLogin controladorLogin;

  public boolean efetuarLogin(String email, String senha){
    return this.controladorLogin.efetuarLogin(email, senha);
  }
}