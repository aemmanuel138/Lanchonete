package Dominio;

import java.util.Calendar;

public class Cliente extends Pessoa {
    private Calendar dataDoCadastro;
    private String telefone;
    private double consumo = 0;

    public Cliente(String nome, int cod, String telefone, double consumo) {
        super(nome, cod);
        this.telefone = telefone;
        this.dataDoCadastro = Calendar.getInstance();
        this.consumo += consumo;
    }

    // --------------Métodos de acesso --------------------
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
     * @return O consumo do cliente
     */
    public double getConsumo() {
        return this.consumo;
    }

    /**
     * @param consumo Ajusta o consumo do cliente
     */
    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    /**
     * Exibe as informações pertinente do objeto
     */
    public String toString() {
        String r = String.format("Cliente: %s, código %s, idade %d, sexo %s", getNome(), this.getcod(), this.getIdade(),
                this.getSexo());
        return r;
    }
}
