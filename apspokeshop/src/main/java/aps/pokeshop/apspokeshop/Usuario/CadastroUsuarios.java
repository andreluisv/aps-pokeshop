package aps.pokeshop.apspokeshop.Usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastroUsuarios {

  @Autowired
  private ICadastroUsuarios iCadastroUsuarios;

  public CadastroUsuarios() {
  }

  private List<Usuario> getUsuarios() {
    return this.iCadastroUsuarios.findAll();
  }

  public boolean validarCredenciais(String email, String senha) {
    this.addMockedData();// Mocked data
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

  private void addMockedData() {
    Long sz = this.iCadastroUsuarios.count();
    if (sz > 0) return;
    Usuario usrr = new Usuario();
    usrr.setEmail("alpvj@cin.ufpe.br");
    usrr.setSenha("senha123");
    this.iCadastroUsuarios.save(usrr);
  }
}
