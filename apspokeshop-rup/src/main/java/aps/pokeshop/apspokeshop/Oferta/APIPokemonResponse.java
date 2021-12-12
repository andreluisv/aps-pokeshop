package aps.pokeshop.apspokeshop.Oferta;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIPokemonResponse implements Serializable{
  public Data data;

  public class Data implements Serializable{
    public String name;
    public List<String> types;
    public String artist;
    public String rarity;
  }

}
