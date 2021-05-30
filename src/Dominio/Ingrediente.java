package Dominio;

public class Ingrediente {
	private static int count = 0; // :: ? Não seria a mesma definição do qTotalDisponivel?
	private String nome_ing;
	private String codEan;
	private boolean disponivel;
	private String categoria;

	// Controle de insumos com abastecimento e redução dos ingredientes;
	public Ingrediente() { // addUngrediente
		count++;
	}

	/**
	 * @return the count
	 */
	public static int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public static void setCount(int count) {
		Ingrediente.count = count;
	}

	/**
	 * @return the nome_ing
	 */
	public String getNome_ing() {
		return nome_ing;
	}

	/**
	 * @param nome_ing the nome_ing to set
	 */
	public void setNome_ing(String nome_ing) {
		this.nome_ing = nome_ing;
	}

	/**
	 * @return the codEan
	 */
	public String getCodEan() {
		return codEan;
	}

	/**
	 * @param codEan the codEan to set
	 */
	public void setCodEan(String codEan) {
		this.codEan = codEan;
	}

	/**
	 * @return the disponivel
	 */
	public boolean isDisponivel() {
		return disponivel;
	}

	/**
	 * @param disponivel the disponivel to set
	 */
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}