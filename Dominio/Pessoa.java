
public class Pessoa {
	private String nome;
	private int cod;
	private String sexo = "Não informado";
	private int idade = 2021 - (2021 - 18);

	public Pessoa(String name, int cod) {
		this.nome = name;
		this.cod = cod;
	}

	protected void setNome(String name) {
		this.nome = name;
	}
	protected int getCod(){
		return this.cod;
	}

	public String getNome() {
		return this.nome;
	}
	
	protected void setIdade(int age) {
		this.idade = age;
	}

	public int getIdade() {
		return this.idade;
	}

	protected void setSexo(String sexo) {
		this.sexo = sexo.substring(0, 1);
	}

	public String getSexo() {
		return this.sexo;
	}
}