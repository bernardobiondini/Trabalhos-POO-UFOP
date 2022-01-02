package classes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

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
	
	public Imovel() {
		set_id(0);
		set_valor(0);
		set_prop("-");
		set_rua("-");
		set_bairro("-");
		set_cidade("-");
		set_num(0);
		set_quartos(0);
		set_banhei(0);
	}
	
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
	
	public void print_imovel(){
		System.out.printf("\n-----------------------------------------------------------------");
		System.out.printf("\nPropriet�rio: " + this.prop);
		System.out.printf("\n\t Pre�o: " + this.valor);
		System.out.printf("\n\t Quartos: " + this.quartos);
		System.out.printf("\n\t Rua: " + this.rua);
		System.out.printf("\n\t Bairro: " + this.bairro);
		System.out.printf("\n\t Cidade: " + this.cidade);
	}
	
	public ArrayList<Imovel> ler_dados() {
		try {
			String linha;
			
			FileInputStream arquivo = new FileInputStream("database_imoveis.txt");
			InputStreamReader input = new InputStreamReader(arquivo); 
			BufferedReader br = new BufferedReader(input); 
			
			FileOutputStream novo_arquivo = new FileOutputStream("dados.txt");
			PrintWriter pr = new PrintWriter(novo_arquivo);
	
			do
			{
				linha = br.readLine();
				String[] palavras = linha.split(";");
				
				for(int i = 0; i < palavras.length; i++) {
					pr.println(palavras[i]);
				}
				
			} while(linha != null);
	
			pr.close();
			br.close();
			input.close();
			arquivo.close();
			novo_arquivo.close();
			
		}
		
		catch(Exception e){
			System.out.println("Erro ao ler o arquivo!");
		}
		
		ArrayList<Imovel> imoveis = new ArrayList<Imovel>();
		return cria_vetor(imoveis);
	}
	
	public ArrayList<Imovel> cria_vetor(ArrayList<Imovel> imoveis) throws IOException{
		FileInputStream arquivo = new FileInputStream("dados.txt");
		InputStreamReader input = new InputStreamReader(arquivo); 
		BufferedReader br = new BufferedReader(input); 
		
		int cont = 0;
		String palavra;
		
		do
		{
			palavra = br.readLine();
					
			if (palavra == "apartamento")
			{
				palavra = br.readLine();
				float valor = Float.parseFloat(palavra); 

				palavra = br.readLine();				
				String prop = palavra;

				palavra = br.readLine();
				String rua = palavra;

				palavra = br.readLine();
				String bairro = palavra;

				palavra = br.readLine();
				String cidade = palavra;

				palavra = br.readLine();
				int num = Integer.parseInt(palavra);

				palavra = br.readLine();
				int quartos = Integer.parseInt(palavra);

				palavra = br.readLine();
				int banhei = Integer.parseInt(palavra);

				palavra = br.readLine();
				int andar = Integer.parseInt(palavra);

				palavra = br.readLine();;
				float taxa_condominio = Float.parseFloat(palavra);

				palavra = br.readLine();
				int elevador = Integer.parseInt(palavra);

				palavra = br.readLine();
				int sacada = Integer.parseInt(palavra);

				imoveis.add(new Apartamento(
						cont++, valor, prop, rua, bairro, cidade, num, quartos, banhei, andar, taxa_condominio, elevador, sacada));
			}
			else if (palavra == "casa")
			{

				palavra = br.readLine();
				float valor = Float.parseFloat(palavra); 

				palavra = br.readLine();				
				String prop = palavra;

				palavra = br.readLine();
				String rua = palavra;

				palavra = br.readLine();
				String bairro = palavra;

				palavra = br.readLine();
				String cidade = palavra;

				palavra = br.readLine();
				int num = Integer.parseInt(palavra);

				palavra = br.readLine();
				int quartos = Integer.parseInt(palavra);

				palavra = br.readLine();
				int banhei = Integer.parseInt(palavra);

				palavra = br.readLine();
				int andares = Integer.parseInt(palavra);

				

				palavra = br.readLine();
				int sala_jantar = Integer.parseInt(palavra);

				imoveis.add(new Casa(
						cont++, valor, prop, rua, bairro, cidade, num, quartos, banhei, andares, sala_jantar));
			}
			else if (palavra == "chacara")
			{
				palavra = br.readLine();
				float valor = Float.parseFloat(palavra); 

				palavra = br.readLine();				
				String prop = palavra;

				palavra = br.readLine();
				String rua = palavra;

				palavra = br.readLine();
				String bairro = palavra;

				palavra = br.readLine();
				String cidade = palavra;

				palavra = br.readLine();
				int num = Integer.parseInt(palavra);

				palavra = br.readLine();
				int quartos = Integer.parseInt(palavra);

				palavra = br.readLine();
				int banhei = Integer.parseInt(palavra);

				palavra = br.readLine();
				int salao_festa = Integer.parseInt(palavra);

				palavra = br.readLine();
				int salao_jogos = Integer.parseInt(palavra);

				palavra = br.readLine();
				int campo_fut = Integer.parseInt(palavra);

				palavra = br.readLine();
				int churras = Integer.parseInt(palavra);

				palavra = br.readLine();
				int piscina = Integer.parseInt(palavra);

				imoveis.add(new Chacara(
						cont++, valor, prop, rua, bairro, cidade, num, quartos, banhei, salao_festa, salao_jogos,
						campo_fut, churras, piscina));
			}
		}while(palavra != null);
		
		br.close();
		input.close();
		arquivo.close();
		
		return imoveis;
	}
}
