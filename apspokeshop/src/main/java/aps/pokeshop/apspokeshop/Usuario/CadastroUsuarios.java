package aps.pokeshop.apspokeshop.Usuario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CadastroUsuarios {

  private List<Usuario> usuarios;

  public CadastroUsuarios() {
    this.usuarios = new ArrayList<>();
    // Mocked data
    Usuario usr = new Usuario();
    usr.setEmail("alpvj@cin.ufpe.br");
    usr.setSenha("senha123");
    this.usuarios.add(usr);
  }

  private List<Usuario> getUsuarios() {
    return this.usuarios;
  }

  public boolean validarCredenciais(String email, String senha) {
    List<Usuario> lista = this.getUsuarios();
    int length = lista.size();
    for (int i = 0; i < length; i++) {
      Usuario usr = lista.get(i);
      if (usr.getEmail().equals(email) && usr.getSenha().equals(senha)) {
        return true;
      }
    }
    return false;
  }
}
