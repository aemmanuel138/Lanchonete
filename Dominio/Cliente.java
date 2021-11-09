package Dominio;

import java.util.Calendar;

public class Cliente extends Pessoa {
	private Calendar dataDoCadastro;
	private String telefone;

  /*@Aragon - Dúvida
  * Esse atributo consumo é só pra guardar o total consumido pelo cliente *durante todo o relacionamento dele com a lanchonete?
  *E se a reposta for SIM, em que momento essa informação seria exposta?? Relatório?
  */
	private double consumo = 0;
  
/**
*Construtor
*/
	public Cliente(String nome, int cod, String telefone, double consumo) {
		super(nome, cod);
		this.dataDoCadastro = Calendar.getInstance();
		this.telefone = telefone;
		this.consumo += consumo;

		/*
		 * > Variável para o consumo geral do cliente (1);
     (done!) > Data de cadastro (2); (done!)
		 */
	}


  

	//----------------Métodos de acesso: --------------------
	
	/**
	* @return Uma String da data de cadastro
	*/
	public String getDataDoCadastro() {
			return this.dataDoCadastro.getTime().toString();
	}

	/**
	* @return O telefone do cliente
	*/
	public String getTelefone() {
			return this.telefone;
	}

	/**
	* @param telefone Ajusta o telefone do cliente
	*/
	public void setTelefone(String telefone) {
			this.telefone = telefone;
	}
	/**
	
	*/
	public void addConsumo(double valor){
		this.consumo += valor; // ** valor da compra;
	}

  /**
  * @return O consumo do cliente
  */
	public double getConsumo(){
		return this.consumo;
	}

	public void setcod(int cod) {
		super.setCod(cod);
	}

	public int getcod() {
		return this.getCod();
	}
  
	/**
  * Exibe as informações pertinente do objeto
  */
	public String toString(){
		String r = String.format("Cliente: %s, código %s, idade %d, sexo %s", getNome(), this.getcod(), this.getIdade(), this.getSexo());
	return r;
	}
}