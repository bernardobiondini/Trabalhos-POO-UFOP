package classes;

public class Apartamento extends Imovel{
	private int andar;
	private float taxa_condo;
	private int elev;
	private int sacada;
	
	public Apartamento() {
		set_id(0);
		set_valor(0);
		set_prop("-");
		set_rua("-");
		set_bairro("-");
		set_cidade("-");
		set_num(0);
		set_quartos(0);
		set_banhei(0);
		set_andar(0);
		set_taxa_condo(0);
		set_elev(0);
		set_sacada(0);
	}

    Apartamento(int i, float valor, String prop, String rua, String bairro, String cidade, int num, int quartos, int banhei, int andar, float taxa_condominio, int elevador, int sacada) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
	
	public int get_andar()
	{
		return andar;
	}

	public void set_andar(int andar)
	{
		this.andar = andar;
	}

	public float get_taxa_condo()
	{
		return taxa_condo;
	}

	public void set_taxa_condo(float taxa)
	{
		this.taxa_condo = taxa;
	}

	public int get_elev()
	{
		return elev;
	}

	public void set_elev(int elev)
	{
		this.elev = elev;
	}

	public int get_sacada()
	{
		return sacada;
	}

	public void set_sacada(int sacada)
	{
		this.sacada = sacada;
	}
	
	public void print_ap() {
		print_imovel();
		System.out.printf("\n\t Andar: " + this.get_andar());
		System.out.printf("\n\t Taxa de condominio: " + this.get_taxa_condo());
		System.out.printf("\n\t " + (this.get_elev() == 1 ? "Possui elevador" : "Sem elevador"));
		System.out.printf("\n\t " + (this.get_sacada() == 1 ? "Possui sacada" : "Sem sacada"));
	}
}
