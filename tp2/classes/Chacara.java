package classes;

public class Chacara extends Imovel{
	private int salao_festa;
	private int salao_jogos;
	private int campo_fut;
	private int churras;
	private int piscina;
	
	public Chacara() {
		set_id(0);
		set_valor(0);
		set_prop("-");
		set_rua("-");
		set_bairro("-");
		set_cidade("-");
		set_num(0);
		set_quartos(0);
		set_banhei(0);
		set_salao_festa(0);
		set_salao_jogos(0);
		set_campo_fut(0);
		set_churras(0);
		set_piscina(0);
	}
	
	public int get_salao_festa()
	{
		return salao_festa;
	}

	public void set_salao_festa(int salao_festa)
	{
		this.salao_festa = salao_festa;
	}

	public int get_salao_jogos()
	{
		return salao_jogos;
	}

	public void set_salao_jogos(int salao_jogos)
	{
		this.salao_jogos = salao_jogos;
	}

	public int get_campo_fut()
	{
		return campo_fut;
	}

	public void set_campo_fut(int campo_fut)
	{
		this.campo_fut = campo_fut;
	}

	public int get_churras()
	{
		return churras;
	}

	public void set_churras(int churras)
	{
		this.churras = churras;
	}

	public int get_piscina()
	{
		return piscina;
	}

	public void set_piscina(int piscina)
	{
		this.piscina = piscina;
	}
	
	public void print_chacara() {
		print_imovel();
		System.out.printf("\n\t " + (this.get_salao_festa() == 1 ? "Possui sal�o de festa" : "Sem sal�o de festa"));
		System.out.printf("\n\t " + (this.get_salao_jogos() == 1 ? "Possui sal�o de jogos" : "Sem sal�o de jogos"));
		System.out.printf("\n\t " + (this.get_campo_fut() == 1 ? "Possui campo de futebol" : "Sem campo de futebol"));
		System.out.printf("\n\t " + (this.get_churras() == 1 ? "Possui churrasqueira" : "Sem churrasqueira"));
		System.out.printf("\n\t " + (this.get_piscina() == 1 ? "Possui piscina" : "Sem piscina"));
	}
}
