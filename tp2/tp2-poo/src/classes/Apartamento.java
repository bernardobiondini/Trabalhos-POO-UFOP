package classes;

public class Apartamento extends Imovel{
	private int andar;
	private float taxa_condo;
	private int elev;
	private int sacada;
	
	public Apartamento (int id, float valor, String prop, String rua, String bairro, 
                            String cidade, int num, int quartos, int banhei, int andar,
                            float taxa_condo, int elev, int sacada) {
		
    	super(id, valor, prop, rua, bairro, cidade, num, quartos, banhei);
		set_andar(andar);
		set_taxa_condo(taxa_condo);
		set_elev(elev);
		set_sacada(sacada);
	}

	public Apartamento(){}

	
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
