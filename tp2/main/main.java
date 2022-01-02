/*
	TRABALHO PRÁTICO DE PROGRAMAÇÃO ORIENTADA A OBJETOS
	---------------------------------------------------
	ARTHUR SILVA LIMA - 20.1.4019
	BERNARDO BIONDINI CAVANELLAS - 20.1.4112
	LEANDRO LIBÉRIO MACHADO DA SILVA - 19.2.4074
*/


package main;

import java.util.ArrayList;
import java.util.Scanner;
import classes.*;

public class main {

	public static void main(String[] args) {
		//inicializando vetores
		ArrayList<Imovel> imoveis = new ArrayList<Imovel>();
		ArrayList<Imovel> imoveis_retorno = new ArrayList<Imovel>();
		
		//recebendo os dados do arquivo no vetor imoveis
		imoveis = imoveis.ler_dados();

		//inicializando variaveis para receber valores do vetor ou do usuario
		Scanner entrada = new Scanner(System.in);
		int funcao, quartos, opcao;
		float valor;
		String prop, cidade, tipo;

		do{
			//recebendo do usuario qual a funcao a ser utilizada
			System.out.print("Digite o numero da função desejada(valor 0 interrompe a execução): ");
			funcao = entrada.nextInt();
			
			//switch para a funcao escolhida pelo usuario
			switch(funcao){
				case 1://printa os imoveis e seus dados de acordo com o enunciado 1
					for(int i = 0; i < imoveis.size(); i++)
						System.out.print(imoveis.at(i));
				break;
				case 2://printa os imoveis do proprietario e seus dados de acordo com o enunciado 2
					System.out.print("Digite o nome desejado: ");
					cin.ignore();
					getline(cin, prop);
					if(func2(imoveis, prop)) System.out.println(prop + " É proprietário\n");//printar dependendo do retorno da funcao 
					else System.out.println(prop + " Não é proprietário\n");
				break;

				case 3://funcao para filtrar imoveis de acordo com o valor como solicitado no enunciado 3
					System.out.print("Digite o valor desejado: ");
					valor = entrada.nextFloat();
					imoveis_retorno = func3(imoveis, valor);
					//for(auto & i : imoveis_retorno){
					//	cout << *i;
					//}
					for(int i = 0; i < imoveis_retorno.size(); i++)//printando os imoveis com valor igual ou acima do inserido
						System.out.print(imoveis_retorno.at(i));
					imoveis_retorno.clear();
				break;

				case 4://filtrar imoveis de acordo com o numero de quartos no imovel
					System.out.print("Digite a quantidade de quartos desejada: ");
					quartos = entrada.nextInt();
					imoveis_retorno = func4(imoveis, quartos);
					//for(auto &i : imoveis_retorno){
					//	cout << *i;
					//}
					for(int i = 0; i < imoveis_retorno.size(); i++)//printar os imoveis com quantidade igual ou maior que a solicitada
						System.out.print(imoveis_retorno.at(i));
					imoveis_retorno.clear();
				break;

				case 5://funcao que filtra de acordo com o tipo de imovel (casa, chacara, apartamento)
					System.out.print("Digite o tipo desejado: ");
					cin.ignore();
					tipo = entrada.next();
					System.out.println(tipo);
					imoveis_retorno = func5(imoveis, tipo);
					//for(auto &i : imoveis_retorno){
					//	cout << *i;
					//}
					for(int i = 0; i < imoveis_retorno.size(); i++)//printar os imoveis do tipo solicitado
						System.out.print(imoveis_retorno.at(i));
					imoveis_retorno.clear();
				break;

				case 6://filtrar imoveis de acordo com a cidade inserida
					System.out.print("Digite a cidade desejada: ");
					cin.ignore();
					getline(cin, cidade);
					imoveis_retorno = func6(imoveis, cidade);
					//for(auto i = imoveis_retorno.rbegin(); i != imoveis_retorno.rend(); ++i){
					//	cout << **i;
					//}
					for(int i = 0; i <  imoveis_retorno.size(); i++)//printar os imoveis da cidade inserida
						imoveis_retorno.at(i);
					imoveis_retorno.clear();
				break;

				case 7://filtrar os imoveis de acordo com o nome do proprietario
				{
					vector<vector<Imovel*>::iterator> vetor7;
					System.out.print("Digite o nome do proprietário: ");
					cin.ignore();
					getline(cin, prop);
					
					vetor7 = func7(imoveis, prop);
					if(!vetor7.empty()){//listar os imoveis do proprietario caso ele possua algum
						System.out.println("Os imóveis de " + prop + " são:");
							for(int i = 0; i < vetor7.size(); i++){
								System.out.println(vetor7.at(i));
							}
						vetor7.clear();
						break;
					}
					else{//caso o proprietario n tenha imoveis
						System.out.println(prop + " não possui imoveis");
						vetor7.clear();
						break;
					}
				}
				break;

				case 8://listagem dos imoveis conforme solicitado no enunciado 8
					System.out.print("Digite 1 para imprimir as propriedades no terminal e 2 para criar um arquivo: ");
					opcao = entrada.nextInt();

					func8(imoveis, opcao);
				break;
			}
		}while(funcao != 0);
	}

}
