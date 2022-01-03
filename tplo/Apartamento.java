//package com.mycompany.poo_tp2;

public class Apartamento extends Imovel{
    private int andar;
    private float taxa_condominio;
    private boolean elevador;
    private boolean sacada;

    public Apartamento(int id, float valor, String proprietario, String rua, String bairro, String cidade,
					int numero, int quartos, int banheiros, int andar, float taxa_condominio, int elevador, int sacada) {
        super(id, valor, proprietario, rua, bairro, cidade, numero, quartos, banheiros);
        this.andar = andar;
        this.taxa_condominio = taxa_condominio;
        this.elevador = elevador != 0;
        this.sacada = sacada != 0;
    }

    public boolean isSacada() {
        return sacada;
    }

    public void setSacada(boolean sacada) {
        this.sacada = sacada;
    }

    public boolean isElevador() {
        return elevador;
    }

    public void setElevador(boolean elevador) {
        this.elevador = elevador;
    }

    public float getTaxa_condominio() {
        return taxa_condominio;
    }

    public void setTaxa_condominio(float taxa_condominio) {
        this.taxa_condominio = taxa_condominio;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }
    
	@Override
    public String toString() {
		String saida = super.toString();
		
		if (this.isElevador()) {
			saida += "\n\tTem elevador.\n";
		} else {
			saida += "\n\tNao tem elevador.\n";
		}

        return saida;
    }
}
