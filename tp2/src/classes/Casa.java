package classes;

public class Casa extends Imovel{
	private int andares;
	private int sala_jantar;
		
	public Casa(int id, float valor, String prop, String rua, String bairro, 
                    String cidade, int num, int quartos, int banhei, int andares, 
                    int sala_jantar) {
                
        super(id, valor, prop, rua, bairro, cidade, num, quartos, banhei);
        set_andares(andares);
		set_sala_jantar(sala_jantar);
	}

    public Casa(){}
	
	public int get_andares() {
		return andares;
	}
	
	public void set_andares(int andares) {
		this.andares = andares;
	}
	
	public int get_sala_jantar() {
		return sala_jantar;
	}
	
	public void set_sala_jantar(int sala_jantar) {
		this.sala_jantar = sala_jantar;
	}
	
	public String toString() {
		return String.format("%s\n\t%d\n\t%d\n-----",
		super.toString(), this.get_andares(), this.get_sala_jantar());
	}
	
	//void printAll();
	
	//void imprime(FILE *, Casa&);
}
