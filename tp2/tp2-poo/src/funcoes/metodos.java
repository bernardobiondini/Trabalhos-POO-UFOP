package funcoes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import classes.*;

public class metodos {

	int func2(ArrayList<Imovel> imoveis, String proprietario){

		for(int i = 0; i < imoveis.size(); i++){
			if(imoveis.get(i).get_prop() == proprietario) 
				return 1;
		}
		return 0;	
	}
	
	ArrayList<Imovel> func3(ArrayList<Imovel> imoveis, float valor){
		ArrayList<Imovel>propriedades = new ArrayList<Imovel>();
		
		for(int i = 0; i < imoveis.size(); i++){
			if(imoveis.get(i).get_valor() <= valor) 
				propriedades.add(imoveis.get(i));
		}

		return propriedades;
	}
	
	//funcao para filtrar os imoveis com numero de quartos igual ou superior ao inserido
	ArrayList<Imovel> func4(ArrayList<Imovel> imoveis, int quartos){
		ArrayList<Imovel> propriedades = new ArrayList<Imovel>();

		for(int i = 0; i < imoveis.size(); i++){
			if(imoveis.get(i).get_quartos() >= quartos) 
				propriedades.add(imoveis.get(i));
		}

		return propriedades;
	}
	
	//funcao que filtra os imoveis de acordo com o tipo inserido
	ArrayList<Imovel> func5(ArrayList<Imovel> imoveis, String tipo){
		ArrayList<Imovel> imoveis_tipo = new ArrayList<Imovel>();
		Apartamento aux_ap = new Apartamento();
		Casa aux_casa = new Casa();
		Chacara aux_chac = new Chacara();

		for(int i = 0; i < imoveis.size(); i++){
			if ((imoveis.get(i).getClass()) == aux_casa.getClass() && (tipo == "casa")) imoveis_tipo.add(imoveis.get(i));
			else if ((imoveis.get(i).getClass()) == aux_ap.getClass() && (tipo == "apartamento")) imoveis_tipo.add(imoveis.get(i));
			else if ((imoveis.get(i).getClass()) == aux_chac.getClass() && (tipo == "chacara")) imoveis_tipo.add(imoveis.get(i));
		}
		
		return imoveis_tipo;
	}
	
	ArrayList<Imovel> func6(ArrayList<Imovel> imoveis, String cidade){
		ArrayList<Imovel> propriedades = new ArrayList<Imovel>();

		for(int i = 0; i < imoveis.size(); i++){
			if(imoveis.get(i).get_cidade() == cidade) propriedades.add(imoveis.get(i));
		}

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
	public void func8(ArrayList<Imovel> imoveis, int opcao) throws IOException{
		FileOutputStream arquivo = new FileOutputStream("saida.txt");
		PrintWriter pr = new PrintWriter(arquivo);
		

		for(int i = 0; i < imoveis.size(); i++){
			if(opcao == 1){
				System.out.println(imoveis.get(i));
			}
			else{
				//imoveis.get(i).imprime(arquivo, imoveis.get(i));
				pr.printf("%s\n", imoveis.get(i).get_prop());
				pr.printf("\t%.2f\n", imoveis.get(i).get_valor());
				pr.printf("\t%d\n", imoveis.get(i).get_quartos());
				pr.printf("\t%s\n", imoveis.get(i).get_rua());
				pr.printf("\t%s\n", imoveis.get(i).get_bairro());
				pr.printf("\t%s\n", imoveis.get(i).get_cidade());
			}
		}
		pr.close();
		arquivo.close();
	}
}
