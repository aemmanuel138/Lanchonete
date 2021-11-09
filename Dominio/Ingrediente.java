package Dominio;/*Qual o Objetivo dessa Classe?
  Pode utilizar esse cabeçalho pra contar uma breve estória dessa classe.
  @Aragon

  @Aragon
*/


public class Ingrediente {
	private static int count = 0; // :: ? Não seria a mesma definição do qTotalDisponivel? 
	protected static int qTotalDisponivel; // ** Aqui eu pensei em obter via método a quantidade disponível (geral) e ir decrementando pra saber quantos ainda tem por lá mas acho que essa contagem pode ser mais especializada em cima de cada categoria, vou remover isso aqui depois
	private String nome_ing;
	private String codEan;
	private boolean disponivel;
	private String categoria;

//public static
//this.nome = nome; 
//this.categoria = categoria;

	protected void setTotalDisponivel(int n) {
		qTotalDisponivel = n;
    
	}
  // Controle de insumos com abastecimento e redução dos ingredientes; 
	public Ingrediente() { //addUngrediente
		count++;
	}
  //public removeIngrediente() {
	//	count--;
	//}
}