//package com.mycompany.poo_tp2;

public class Chacara extends Imovel {
    private boolean salao_festa, salao_jogos, campo_futebol, churrasqueira, piscina;

    public Chacara(int id, float valor, String proprietario, String rua, String bairro, String cidade, int numero, int quartos,
	int banheiros, int salao_festa, int salao_jogos, int campo_futebol, int churrasqueira, int piscina) {
        super(id, valor, proprietario, rua, bairro, cidade, numero, quartos, banheiros);
		this.salao_festa = salao_festa != 0;
		this.salao_jogos = salao_jogos != 0;
		this.campo_futebol = campo_futebol != 0;
		this.churrasqueira = churrasqueira != 0;
		this.piscina = piscina != 0;
    }

    public boolean isSalao_festa() {
        return salao_festa;
    }

    public void setSalao_festa(boolean salao_festa) {
        this.salao_festa = salao_festa;
    }

    public boolean isSalao_jogos() {
        return salao_jogos;
    }

    public void setSalao_jogos(boolean salao_jogos) {
        this.salao_jogos = salao_jogos;
    }

    public boolean isCampo_futebol() {
        return campo_futebol;
    }

    public void setCampo_futebol(boolean campo_futebol) {
        this.campo_futebol = campo_futebol;
    }

    public boolean isChurrasqueira() {
        return churrasqueira;
    }

    public void setChurrasqueira(boolean churrasqueira) {
        this.churrasqueira = churrasqueira;
    }

    public boolean isPiscina() {
        return piscina;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    @Override
    public String toString() {
		String saida = super.toString();
		
		if (this.isPiscina()) {
			saida += "\n\tTem piscina.\n";
		} else {
			saida += "\n\tNao tem piscina.\n";
		}

        return saida;
    }
}






