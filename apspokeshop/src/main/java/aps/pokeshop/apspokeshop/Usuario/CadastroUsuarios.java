package aps.pokeshop.apspokeshop.Usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastroUsuarios {

  @Autowired
  private ICadastroUsuarios iCadastroUsuarios;

  public static CadastroUsuarios instance;
  public static CadastroUsuarios getInstance() {
    if (instance == null){
      instance = new CadastroUsuarios();
    }
    
    return instance;
  }

  public CadastroUsuarios() {
  }

  private List<Usuario> getUsuarios() {
    return this.iCadastroUsuarios.findAll();
  }

  public Optional<Usuario> getUserById(Long id){
    return this.iCadastroUsuarios.findById(id);
  }

  public Usuario validarCredenciais(String email, String senha) {
    List<Usuario> lista = this.getUsuarios();
    int length = lista.size();
    for (int i = 0; i < length; i++) {
      Usuario usr = lista.get(i);
      if (usr.getEmail().equals(email) && usr.getSenha().equals(senha)) {
        return usr;
      }
    }
    return null;
  }

}
