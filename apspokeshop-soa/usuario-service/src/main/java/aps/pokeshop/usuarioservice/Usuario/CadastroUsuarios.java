package aps.pokeshop.usuarioservice.Usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aps.pokeshop.usuarioservice.Factories.FabricaRepositorioBDR;
import aps.pokeshop.usuarioservice.Factories.IFabricaAbstrataRepositorio;

@Component
public class CadastroUsuarios {

  private IFabricaAbstrataRepositorio iFabricaAbstrataRepositorio = new FabricaRepositorioBDR();

  @Autowired
  private IRepositorioUsuarios iCadastroUsuarios = iFabricaAbstrataRepositorio.CriarRepositorioUsuarios();

  private List<Usuario> getUsuarios() {
    return this.iCadastroUsuarios.findAll();
  }

  public Optional<Usuario> getUserById(Long id) {
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
