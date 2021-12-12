
package aps.pokeshop.ofertaservice.Oferta;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CadastroOfertaDTO implements Serializable {
  Long userId;
  String descricao;
  Double preco;
  String titulo;
  String codigoCarta;
}