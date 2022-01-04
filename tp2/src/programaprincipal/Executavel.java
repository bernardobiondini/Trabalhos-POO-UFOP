/*
	TRABALHO PRï¿½TICO DE PROGRAMAï¿½ï¿½O ORIENTADA A OBJETOS
	---------------------------------------------------
	ARTHUR SILVA LIMA - 20.1.4019
	BERNARDO BIONDINI CAVANELLAS - 20.1.4112
	LEANDRO LIBÉRIO MACHADO DA SILVA - 19.2.4074
*/

package programaprincipal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import classes.*;
import funcoes.*;
import java.io.IOException;

public class Executavel {
	public static void main(String[] args) throws IOException {
		//inicializando vetores
		Metodos funcoes = new Metodos();
		
		int total_imoveis = funcoes.ler_dados();
		Imovel[] imoveis = new Imovel[total_imoveis];
		Imovel[] imoveis_retorno = new Imovel[total_imoveis];
		
		//Criamos um objeto da classe Contador para podermos calcular qual será o tamanho
		//do vetor que iremos retornar para a main, faremos isso para todas as funções, com 
		//excessão da 2, 7 e 8.
		Contador contador = new Contador();
		contador.set_tamanho(0);
        
		//recebendo os dados do arquivo no vetor imoveis        
		imoveis = funcoes.cria_vetor(imoveis);

		//inicializando variaveis para receber valores do vetor ou do usuario
		Scanner entrada = new Scanner(System.in);
		int funcao, quartos, opcao, i = 0;
		float valor;
		String prop, cidade, tipo;

		do{
			//recebendo do usuario qual a funcao a ser utilizada
			System.out.println("\n\nDigite o numero da função desejada(valor 0 interrompe a execução): ");
			funcao = entrada.nextInt();

			//switch para a funcao escolhida pelo usuario
			switch(funcao){
				case 1://printa os imoveis e seus dados de acordo com o enunciado 1
				for(i = 0; i < imoveis.length; i++) 
					System.out.print(imoveis[i].toString());
				
				System.out.println("-----");
				
				break;
				case 2://printa os imoveis do proprietario e seus dados de acordo com o enunciado 2
					System.out.print("Digite o nome desejado: \n");
					entrada.nextLine();
					prop = entrada.nextLine();
					if(funcoes. func2(imoveis, prop) == 1) System.out.println(prop + " é proprietário\n");//printar dependendo do retorno da funcao 
					else System.out.println(prop + " não é proprietário\n");
				break;

				case 3://funcao para filtrar imoveis de acordo com o valor como solicitado no enunciado 3
					System.out.print("Digite o valor desejado: \n");					
					valor = entrada.nextFloat();
                    imoveis_retorno = funcoes.func3(imoveis, valor, contador);

                    for(i = 0; i < contador.get_tamanho(); i++) 
                    	System.out.print(imoveis_retorno[i].toString());              

                     i = 0;
                     contador.set_tamanho(0);
				break;

				case 4://filtrar imoveis de acordo com o numero de quartos no imovel
					System.out.print("Digite a quantidade de quartos desejada: \n");
					quartos = entrada.nextInt();
					imoveis_retorno = funcoes.func4(imoveis, quartos, contador);

                    if(contador.get_tamanho() == 0)
                    	System.out.print("Não há imóveis sem quartos");
                                        
					for(i = 0; i < contador.get_tamanho(); i++)
						System.out.print(imoveis_retorno[i]);
					
					i = 0;
					contador.set_tamanho(0);
				break;

				case 5://funcao que filtra de acordo com o tipo de imovel (casa, chacara, apartamento)
					System.out.print("Digite o tipo desejado: \n");
					tipo = entrada.next();
					imoveis_retorno = funcoes.func5(imoveis, tipo, contador);

                    if(contador.get_tamanho() == 0)
                    	System.out.print("Não há esse tipo de imóvel\n");
                                        
					for(i = 0; i < contador.get_tamanho(); i++)//printar os imoveis do tipo solicitado
						System.out.print(imoveis_retorno[i].toString());
					
					i = 0;
					contador.set_tamanho(0);
				break;

				case 6://filtrar imoveis de acordo com a cidade inserida
					System.out.print("Digite a cidade desejada: \n");
                                        entrada.nextLine();
					cidade = entrada.nextLine();
					imoveis_retorno = funcoes.func6(imoveis, cidade, contador);

                    if(contador.get_tamanho() == 0)
                    	System.out.print("Não há imóveis nessa cidade\n");
                                        
					for(i = 0; i < contador.get_tamanho(); i++)//printar os imoveis da cidade inserida
						System.out.print(imoveis_retorno[i].toString());
					
					i = 0;
					contador.set_tamanho(0);
				break;

				case 7://filtrar os imoveis de acordo com o nome do proprietario
					//vector<vector<Imovel*>::iterator> vetor7;
					List <Imovel> imoveis_func7 = new ArrayList<Imovel>();
					for(i = 0; i < imoveis.length; i++) 
						imoveis_func7.add(imoveis[i]);
					
					System.out.println("Insira o nome do proprietário que deseja pesquisar");
					entrada.nextLine();
					prop = entrada.nextLine();
					Iterator<Imovel> it = funcoes.func7(imoveis_func7, prop);
					
					Imovel aux = new Imovel();
					if(!it.hasNext()) {
						System.out.println(prop + " não possui imóveis");
						break;
					}
					
					System.out.println("Os imóveis de " + prop + " são:");
					while(it.hasNext()){
						aux = it.next();
						System.out.println(aux);
					}																																					
				
				break;

				case 8://listagem dos imoveis conforme solicitado no enunciado 8
					System.out.print("Digite 1 para imprimir as propriedades no terminal e 2 para criar um arquivo: \n");
					opcao = entrada.nextInt();

					funcoes.func8(imoveis, opcao);
				break;
			}
		}while(funcao != 0);
		
		entrada.close();
	}

}
