//package com.mycompany.poo_tp2;

public class Casa extends Imovel {
    private int andares;
    private boolean sala_jantar;

    public Casa(int id, float valor, String proprietario, String rua, String bairro, String cidade, int numero, 
				int quartos, int banheiros, int andares, int sala_jantar) {
        super(id, valor, proprietario, rua, bairro, cidade, numero, quartos, banheiros);
        this.andares = andares;
		this.sala_jantar = sala_jantar != 0;
    }

    public boolean isSala_jantar() {
        return sala_jantar;
    }

    public void setSala_jantar(boolean sala_jantar) {
        this.sala_jantar = sala_jantar;
    }

    public int getAndares() {
        return andares;
    }

    public void setAndares(int andares) {
        this.andares = andares;
    }

	@Override
    public String toString() {
		return super.toString() +  "\n\tNumero de andares: " + this.getAndares() + "\n";
    }
}
