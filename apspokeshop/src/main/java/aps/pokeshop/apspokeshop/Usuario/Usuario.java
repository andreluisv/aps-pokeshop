package aps.pokeshop.apspokeshop.Usuario;

import org.springframework.stereotype.Component;

@Component
public class Usuario {

  private String email;
  private String senha;

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return this.senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }
}