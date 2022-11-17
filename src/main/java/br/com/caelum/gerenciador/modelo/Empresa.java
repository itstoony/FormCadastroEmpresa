package br.com.caelum.gerenciador.modelo;

import java.util.Date;

public class Empresa {

    private Integer id;
    private String nome;
    private Date dataDeAbertura;
    private int contador = 3;

    public Empresa(){
        dataDeAbertura = new Date();
        this.defineId();
    }

    private void defineId() {
        this.id = contador++;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDeAbertura() {
        return dataDeAbertura;
    }

    public void setDataDeAbertura(Date dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }

}

