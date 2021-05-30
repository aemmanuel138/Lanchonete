package Dominio;

public class Pessoa {
    private String nome;
    private int cod;
    private String sexo = "Não informado";
    private int idade = 2021 - (2021 - 18);

    public Pessoa(String name, int cod) {
        this.nome = name;
        this.cod = cod;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public String getNome() {
        return this.nome;
    }

    public void setcod(int cod) {
        this.cod = cod;
    }

    public int getcod() {
        return this.cod;
    }

    public void setIdade(int age) {
        this.idade = age;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo.substring(0, 1);
    }

    public String getSexo() {
        return this.sexo;
    }
}