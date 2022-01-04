package funcoes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import classes.*;

public class Metodos {

    public static Imovel[] propriedades;
    
    //Função simples, comparamos o nome do proprietário procurado com
    //todos os proprietários de todos os imóveis e se o nome coincidir
    //retornamos true, se não, retornamos false
	public int func2(Imovel[] imoveis, String prop){
		for(int i = 0; i < imoveis.length; i++){
			if(imoveis[i].get_prop().equals(prop)) 
				return 1;
		}
		return 0;	
	}
	
	//Comparamos todos os imoveis com o valor desejado e se for igual ou menor
	//colocamos aquele imovel no vetor propriedades, no final retornamos esse vetor
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
		
		//cria auxiliares para comparar com o tipo procurado 
		Apartamento aux_ap = new Apartamento();
		Casa aux_casa = new Casa();
		Chacara aux_chac = new Chacara();
        
		//comparamos para ver quais são os imóveis do tipo procurado
		int j = 0;
		for(int i = 0; i < imoveis.length; i++){
			if ((imoveis[i].getClass().equals(aux_casa.getClass())) && (tipo.equals("casa"))) imoveis_tipo[j++] = imoveis[i];
			else if ((imoveis[i].getClass().equals(aux_ap.getClass())) && (tipo.equals("apartamento"))) imoveis_tipo[j++] = imoveis[i];
			else if ((imoveis[i].getClass().equals(aux_chac.getClass())) && (tipo.equals("chacara"))) imoveis_tipo[j++] = imoveis[i];
            else continue;
		}
		
		cont.set_tamanho(j);
		
		//Criamos um vetor auxiliar que armazenaremos o valor de todos os imoveis do tipo
		//ainda desordenados
		float []aux_ordenador = new float[j];
		for(int i = 0; i < j; i++) {
			aux_ordenador[i] = imoveis_tipo[i].get_valor();
		}
		
		//Agora iremos ordenar esse vetor auxiliar e depois usaremos ele pra colocar
		//em um novo vetor os imoveis nas posições de forma que fique ordenado e retornamos
		//esse vetor
		Arrays.sort(aux_ordenador);
		int i = 0;
		j = 0;
		
		Imovel[] imoveis_retorno = new Imovel[cont.get_tamanho()];
		while(j < cont.get_tamanho()) {
			if(imoveis_tipo[i].get_valor() == (aux_ordenador[j])) {
				imoveis_retorno[j] = imoveis_tipo[i];
				j++;
				i = 0;
			}
			i++;
			if (i == cont.get_tamanho())
				i = 0;
		}
				
        return imoveis_retorno;
	}
	
	//Função que filtra imóveis pela cidade inserida
	public Imovel[] func6(Imovel[] imoveis, String cidade, Contador cont){
		Imovel[] propriedades = new Imovel[imoveis.length];

		int j = 0;
		for(int i = 0; i < imoveis.length; i++){
			if(imoveis[i].get_cidade().equals(cidade)) propriedades[j++] = imoveis[i];
                }
                
		cont.set_tamanho(j);
		return propriedades;
	}
	
	
	//funcao que filtra os imoveis do prop inserido
	public Iterator<Imovel> func7(List<Imovel> imoveis, String prop){
		//Primeiro criamos auxiliares para poder fazer a iteração
		List<Imovel> aux = new ArrayList<Imovel>();
		Imovel aux2 = new Imovel();
		
		Iterator<Imovel> it = imoveis.iterator();
		while(it.hasNext()) {
			aux2 = it.next();
			
			if(aux2.get_prop().equals(prop)) {
				aux.add(aux2);
			}
		}
		
		//Fazemos outro iterador para iterar sobre o vetor auxiliar que contem os 
		//imoveis do prop inserido
		Iterator<Imovel> it2 = aux.iterator();
		
		return it2;
	}
	
	
	//funcao que cria um arquivo(opcao 2) ou lista os imoveis(opcao 1)
	public void func8(Imovel[] imoveis, int opcao) throws IOException{
		FileOutputStream arquivo = new FileOutputStream("saida.txt");
		PrintWriter pr = new PrintWriter(arquivo);
		

		for(int i = 0; i < imoveis.length; i++){
			if(opcao == 1){
				System.out.println(imoveis[i]);
			}
			else{
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
	
	//Função que pega a base de dados desorganizada e cria outra com um item em cada linha
	public int ler_dados() throws IOException {
		int cont = 0;
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
	
	//Função que pega o txt dados.txt e monta o vetor de imoveis
	public Imovel[] cria_vetor(Imovel[] imoveis) throws IOException{
		FileInputStream arquivo = new FileInputStream("dados.txt");
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
