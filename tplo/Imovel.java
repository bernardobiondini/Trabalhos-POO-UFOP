//package com.mycompany.poo_tp2;

public class Imovel {
    private int id;
    private float valor;
    private String proprietario;
    private String rua;
    private String bairro;
    private String cidade;
    private int numero;
    private int quartos;
    private int banheiros;

    public Imovel(int id, float valor, String proprietario, String rua, String bairro, String cidade, int numero, 
    int quartos, int banheiros) {
        this.id = id;
        this.valor = valor;
        this.proprietario = proprietario;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
        this.quartos = quartos;
        this.banheiros = banheiros;
    }

    public int getBanheiros() {
        return banheiros;
    }

    public void setBanheiros(int banheiros) {
        this.banheiros = banheiros;
    }

    public int getQuartos() {
        return quartos;
    }

    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	@Override
	public String toString() {
        return "-----\n" + "Proprietario: " + this.getProprietario() + "\n\tPreco: " + this.getValor() +
                 "\n\tQuartos: " + this.getQuartos() + "\n\tRua: " + this.getRua() +
                 "\n\tBairro: " + this.getBairro() +  "\n\tCidade: " + this.getCidade();
    }
    
}
