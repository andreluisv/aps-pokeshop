package aps.pokeshop.usuarioservice.Comunicacao;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import aps.pokeshop.usuarioservice.Fachadas.Fachada;
import aps.pokeshop.usuarioservice.Usuario.Usuario;

@Controller
public class UsuarioComunicacao {

  @Autowired
  Fachada fachada;

  @GetMapping(path = "/usuario")
  @ResponseBody
  public String fetchUser(@RequestParam(required = true) Map<String, String> qparams) {
    if (!qparams.containsKey("id"))
      return "";
    Long id = Long.parseLong(qparams.get("id"));
    Optional<Usuario> usr = this.fachada.getUsuario(id);
    if (usr.isPresent()) {
      return usr.get().getEmail();
    }
    return "";
  }

}