package classes;

public class Casa extends Imovel{
	private int andares;
	private int sala_jantar;
		
	public Casa() {
		set_id(0);
		set_valor(0);
		set_prop("-");
		set_rua("-");
		set_bairro("-");
		set_cidade("-");
		set_num(0);
		set_quartos(0);
		set_banhei(0);
		set_andares(0);
		set_sala_jantar(0);
	}
	
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
	
	public void print_casa() {
		print_imovel();
		System.out.printf("\n\t Andares: " + this.get_andares());
		System.out.printf("\n\t " + (this.get_sala_jantar() == 1 ? "Possui sala de jantar" : "Sem sala de jantar"));
	}
	
	//void printAll();
	
	//void imprime(FILE *, Casa&);
}
