package Dominio;
/*Classe de Item do Pedido
  
  @Produto - Produto individual
  @quantidade - Quantidade individual de cada item (produto) adicionado ao Pedido
  @subTotal - Total do Item quando multiplicados o valor do Produto.getPreco() * quantidade

*/

public class ItemPedido{
  private Produto produto;
  private int quantidade;  
  private double subTotal;

  /**
   * @return O produto
   */
  public Produto getProduto() {
    return produto;
  }
  
  /**
   * @param produto
   * Ajusta o produto
   */
  public void setProduto(Produto produto) {
    this.produto = produto;
  }
  /**
   * @return A quantidade
   */
  public int getQuantidade() {
    return quantidade;
  }
  /**
   * @param quantidade Ajusta a quantidade
   */
  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }
  /**
   * @return O subTotal
   */
  public double getSubTotal() {
    return subTotal;
  }
  
  /**
   * @param subTotal
   * Ajusta o subTotal
   */
  public void setSubTotal(double subTotal) {
    this.subTotal = subTotal;
  }  

}
