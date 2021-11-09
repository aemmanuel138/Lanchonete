package Dominio;
/* Classe do Pedido
  @numPedido - identificador externo do Pedido
  @cliente - Cliente associado ao Pedido
  @itens - Lista de Item adicionados ao Pedido;
  @total - valor total do Pedido somados os subtotais da Lista de Item
*/
import java.util.List;
public class Pedido{
  private int numPedido;
  private Cliente cliente;
  private List<ItemPedido> itens;
  private int totalPedido;

  /**
   * @return O número do pedido
   */
  public int getNumPedido() {
    return numPedido;
  }

  /**
   * @param numPedido
   * Ajusta o número do pedido
   */
  public void setNumPedido(int numPedido) {
    this.numPedido = numPedido;
  }

  /**
   * @return O cliente
   */
  public Cliente getCliente() {
    return cliente;
  }

  /**
   * @param cliente
   * Ajusta o cliente
   */
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  /**
   * @return Os itens
   */
  public List<ItemPedido> getItens() {
    return itens;
  }

  /**
   * @param itens
   * Ajustam os itens
   */
  public void setItens(List<ItemPedido> itens) {
    this.itens = itens;
  }

  /**
   * @return O total do pedido
   */
  public int getTotalPedido() {
    return totalPedido;
  }

  /**
   * @param totalPedido
   * Ajusta o total do Pedido
   */
  public void setTotalPedido(int totalPedido) {
    this.totalPedido = totalPedido;
  }

}