package funcoes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import classes.*;

public class Metodos {

        public static Imovel[] propriedades;
        
	public int func2(Imovel[] imoveis, String proprietario){

		for(int i = 0; i < imoveis.length; i++){
			if(imoveis[i].get_prop().equals(proprietario)) 
				return 1;
		}
		return 0;	
	}
	
	public Imovel[] func3(Imovel[] imoveis, float valor, Contador cont){
		Imovel propriedades[] = new Imovel[imoveis.length];
		
		int j = 0;
		for(int i = 0; i < imoveis.length; i++){
			if(imoveis[i].get_valor() <= valor) {
				propriedades[j++] = imoveis[i];
			}
		}
		cont.set_tamanho(j);
		return propriedades;
	}
	
	//funcao para filtrar os imoveis com numero de quartos igual ou superior ao inserido
	public Imovel[] func4(Imovel[] imoveis, int quartos, Contador cont){
		Imovel [] propriedades = new Imovel[imoveis.length];

		int j = 0;
		for(int i = 0; i < imoveis.length; i++)
			if(imoveis[i].get_quartos() >= quartos) 
				propriedades[j++] = imoveis[i];
		
		cont.set_tamanho(j);
		return propriedades;
	}
	
	//funcao que filtra os imoveis de acordo com o tipo inserido
	public Imovel[] func5(Imovel[] imoveis, String tipo, Contador cont){
		Imovel[] imoveis_tipo = new Imovel[imoveis.length];
		Apartamento aux_ap = new Apartamento();
		Casa aux_casa = new Casa();
		Chacara aux_chac = new Chacara();
		
		int j = 0;
		for(int i = 0; i < imoveis.length; i++){
			if ((imoveis[i].getClass()) == aux_casa.getClass() && (tipo == "casa")) imoveis_tipo[j++] = imoveis[i];
			else if ((imoveis[i].getClass()) == aux_ap.getClass() && (tipo == "apartamento")) imoveis_tipo[j++] = imoveis[i];
			else if ((imoveis[i].getClass()) == aux_chac.getClass() && (tipo == "chacara")) imoveis_tipo[j++] = imoveis[i];
		}
		
		cont.set_tamanho(j);
		return imoveis_tipo;
	}
	
	public Imovel[] func6(Imovel[] imoveis, String cidade, Contador cont){
		Imovel[] propriedades = new Imovel[imoveis.length];

		int j = 0;
		for(int i = 0; i < imoveis.length; i++){
			if(imoveis[i].get_cidade() == cidade) propriedades[j++] = imoveis[i];
		}
		
		cont.set_tamanho(j);
		return propriedades;
	}
	
	/*
	//funcao que filtra os imoveis do proprietario inserido
	vector<vector<Imovel*>::iterator> func7(vector<Imovel*> *imoveis, string proprietario){
		vector<vector<Imovel*>::iterator> colecao_iterador;
	  Imovel *imovel;

		vector<Imovel*>::iterator it;
	    for(it = imoveis->begin(); it != imoveis->end(); ++it) {
	        imovel = *it;

	        if(imovel->get_prop() == proprietario){
	            colecao_iterador.push_back(it);
	        }
	    }

	    return colecao_iterador;
	}
	*/
	
	//funcao que cria um arquivo(opcao 2) ou lista os imoveis(opcao 1)
	public void func8(Imovel[] imoveis, int opcao) throws IOException{
		FileOutputStream arquivo = new FileOutputStream("saida.txt");
		PrintWriter pr = new PrintWriter(arquivo);
		

		for(int i = 0; i < imoveis.length; i++){
			if(opcao == 1){
				System.out.println(imoveis[i]);
			}
			else{
				//imoveis[i].imprime(arquivo, imoveis[i]);
				pr.printf("%s\n", imoveis[i].get_prop());
				pr.printf("\t%.2f\n", imoveis[i].get_valor());
				pr.printf("\t%d\n", imoveis[i].get_quartos());
				pr.printf("\t%s\n", imoveis[i].get_rua());
				pr.printf("\t%s\n", imoveis[i].get_bairro());
				pr.printf("\t%s\n", imoveis[i].get_cidade());
			}
		}
		pr.close();
		arquivo.close();
	}
	
	public int ler_dados() throws IOException {
		int cont = 0;
		try {
			String linha;
			
			
			FileInputStream arquivo = new FileInputStream("C:\\Users\\Leandro\\eclipse-workspace\\tp2-poo\\src\\funcoes\\database_imoveis.txt");
			InputStreamReader input = new InputStreamReader(arquivo); 
			BufferedReader br = new BufferedReader(input); 
			
			FileOutputStream novo_arquivo = new FileOutputStream("C:\\Users\\Leandro\\eclipse-workspace\\tp2-poo\\src\\funcoes\\dados.txt");
			PrintWriter pr = new PrintWriter(novo_arquivo);
			do
			{
				linha = br.readLine();
				if(linha == null)
					break;
				
				String[] palavras = linha.split(";");
				
				
				for(int i = 0; i < palavras.length; i++) {
					pr.println(palavras[i]);					
				}
				
				cont++;
			} while(linha != null);
			
			pr.close();
			br.close();
			input.close();
			arquivo.close();
			novo_arquivo.close();
			
		}
		
		catch(Exception e){
			System.out.println("Erro ao ler o arquivo!" + e);
		}
		
		return cont;
	}
	
	public Imovel[] cria_vetor(Imovel[] imoveis) throws IOException{
		FileInputStream arquivo = new FileInputStream("C:\\Users\\Leandro\\eclipse-workspace\\tp2-poo\\src\\funcoes\\dados.txt");
		InputStreamReader input = new InputStreamReader(arquivo); 
		BufferedReader br = new BufferedReader(input); 
		
		int cont = 0;
		String palavra;
		
		do
		{
			palavra = br.readLine();
			
			if(palavra == null)
				break;
			
			if (palavra.equals("apartamento"))
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

				palavra = br.readLine();				
				float taxa_condominio = Float.parseFloat(palavra);

				palavra = br.readLine();				
				int elevador = Integer.parseInt(palavra);

				palavra = br.readLine();				
				int sacada = Integer.parseInt(palavra);
								
				imoveis[cont] = (new Apartamento(
						cont++, valor, prop, rua, bairro, cidade, num, quartos, banhei, andar, taxa_condominio, elevador, sacada));
			}
			else if (palavra.equals("casa"))
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

				imoveis[cont] = (new Casa(
						cont++, valor, prop, rua, bairro, cidade, num, quartos, banhei, andares, sala_jantar));
			}
			else if (palavra.equals("chacara"))
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

				imoveis[cont] = (new Chacara(
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
