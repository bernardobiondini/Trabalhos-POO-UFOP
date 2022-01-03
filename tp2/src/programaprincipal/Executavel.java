/*
	TRABALHO PR�TICO DE PROGRAMA��O ORIENTADA A OBJETOS
	---------------------------------------------------
	ARTHUR SILVA LIMA - 20.1.4019
	BERNARDO BIONDINI CAVANELLAS - 20.1.4112
	LEANDRO LIB�RIO MACHADO DA SILVA - 19.2.4074
*/

package programaprincipal;

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

                                        System.out.println("antes do loop");
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
                                            System.out.print("Tem não patrão, dificil não ter quarto numa moradia ne kk");
                                        
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
                                            System.out.print("Deu erro patrão");
                                        
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
                                            System.out.print("Deu erro patrão");
                                        
					for(i = 0; i < contador.get_tamanho(); i++)//printar os imoveis da cidade inserida
						System.out.print(imoveis_retorno[i].toString());
					
					i = 0;
					contador.set_tamanho(0);
				break;

//				case 7://filtrar os imoveis de acordo com o nome do proprietario
//				{
//					vector<vector<Imovel*>::iterator> vetor7;
//					System.out.print("Digite o nome do propriet�rio: ");
//					cin.ignore();
//					prop = entrada.nextLine();
//
//					vetor7 = funcoes.func7(imoveis, prop);
//					if(!vetor7.empty()){//listar os imoveis do proprietario caso ele possua algum
//						System.out.println("Os im�veis de " + prop + " s�o:");
//							for(int i = 0; i < vetor7.size(); i++){
//								System.out.println(vetor7.at(i));
//							}
//						vetor7.clear();
//						break;
//					}
//					else{//caso o proprietario n tenha imoveis
//						System.out.println(prop + " n�o possui imoveis");
//						vetor7.clear();
//						break;
//					}
//				}
//				break;

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
