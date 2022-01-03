package classes;


public class Imovel {
	private int id;
	private float valor;
	private String prop;
	private String rua;
	private String bairro;
	private String cidade;
	private int num;
	private int quartos;
	private int banhei;
	
	public Imovel(int id, float valor, String prop, String rua, String bairro,
            	  String cidade, int num, int quartos, int banhei) {
		set_id(id);
		set_valor(valor);
		set_prop(prop);
		set_rua(rua);
		set_bairro(bairro);
		set_cidade(cidade);
		set_num(num);
		set_quartos(quartos);
		set_banhei(banhei);
	}

	public Imovel(){}
	
	public int get_id(){
		return id;
	}

	public void set_id(int id){
		this.id = id;
	}

	public float get_valor(){
		return valor;
	}

	public void set_valor(float valor){
		this.valor = valor;
	}

	public String get_prop(){
		return prop;
	}

	public void set_prop(String prop){
		this.prop = prop;
	}

	public String get_rua(){
		return rua;
	}

	public void set_rua(String rua){
		this.rua = rua;
	}

	public String get_bairro(){
		return bairro;
	}

	public void set_bairro(String bairro){
		this.bairro = bairro;
	}

	public String get_cidade(){
		return cidade;
	}

	public void set_cidade(String cidade){
		this.cidade = cidade;
	}

	public int get_num(){
		return num;
	}

	public void set_num(int num){
		this.num = num;
	}

	public int get_quartos(){
		return quartos;
	}

	public void set_quartos(int quartos){
		this.quartos = quartos;
	}

	public int get_banhei(){
		return banhei;
	}

	public void set_banhei(int banhei){
		this.banhei = banhei;
	}
	
	public String toString(){
		return String.format("-----\n%s\n\t%.2f\n\t%d\n\t%s\n\t%s", this.get_prop(), this.get_valor(), this.get_quartos(),this.get_rua(), this.get_bairro(),this.get_cidade());
	}
}
