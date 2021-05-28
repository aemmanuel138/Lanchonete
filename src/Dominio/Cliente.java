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

        /**
         * > Variável para o consumo geral do cliente (1); (done!) > Data de cadastro
         * (2); (done!)
         */
    }

    public String getDataDoCadastro() {
        return this.dataDoCadastro.getTime().toString();
    }
}