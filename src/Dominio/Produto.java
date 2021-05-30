package Dominio;

import java.util.List;
import java.util.ArrayList;

public class Produto {
  private String nome;
  private double preco;
  List<Ingrediente> ingredientes;

  public Produto() {
    this.nome = "";
    this.preco = 0.0;
    this.ingredientes = new ArrayList<Ingrediente>();
  }

  /**
   * @param name Ajusta o nome do produto
   */

  protected void setNome(String name) {
    this.nome = name;
  }

  /**
   * 
   * @return O nome do Produto
   */
  protected String getNome() {
    return this.nome;
  }

  /**
   * @param name 
   * Ajusta o preço do produto
   */
  protected void setPreco(double preco) {
    this.preco = preco;
  }

  /**
   * @param name 
   * Ajusta o preço do produto
   */
  protected void setPreco(int preco) {
    this.preco = preco;
  }

  /**
   * 
   * @return O preço do Produto
   */
  protected double getPreco() {
    return this.preco;
  }

  /**
   * @param name 
   * Ajusta a lista de ingredientes do produto
   */
  protected void setListaIngredientes(ArrayList<Ingrediente> list) {
    this.ingredientes = list;
  }

  /**
   * 
   * @return A lista de ingredientes
   */
  protected List<Ingrediente> getListaIngredient() {
    return this.ingredientes;
  }

}
