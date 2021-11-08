#include "funcoes.h"
using namespace std;

void le_cria_arquivos(){
	FILE *arquivo, *arquivo_escrita;
	char aux;
	
	
	arquivo = fopen("database_imoveis.txt", "r");
	arquivo_escrita = fopen("new_database.txt", "w");
	
	while(true){
		aux = (char)fgetc(arquivo);
		if(feof(arquivo))
			break;
		if(aux == ';')
			fputc('\n', arquivo_escrita);
		else
			fputc(aux, arquivo_escrita);
	}
	
	fclose(arquivo);
	fclose(arquivo_escrita);
}

void cria_imoveis(vector<Casa*> casas, vector<Apartamento*> aps, vector<Chacara*> chacs){
	
	ifstream arquivo_leitura_final;
	arquivo_leitura_final.open("new_database.txt", ifstream::in);
	
	string line;
	int cont_ap = 0, cont_casa = 0, cont_chac = 0, id = 1;
	float valor_float;
	int valor_int;
	while(getline(arquivo_leitura_final, line)){
		if(line == "apartamento"){
			aps.push_back(new(Apartamento));
			aps[cont_ap]->set_id(id);
			id++;
			
			getline(arquivo_leitura_final, line);
			valor_float = atoi(line.c_str());
			aps[cont_ap]->set_valor(valor_float);
			
			getline(arquivo_leitura_final, line);
			aps[cont_ap]->set_prop(line);
			
			getline(arquivo_leitura_final, line);
			aps[cont_ap]->set_rua(line);
			
			getline(arquivo_leitura_final, line);
			aps[cont_ap]->set_bairro(line);
			
			getline(arquivo_leitura_final, line);
			aps[cont_ap]->set_cidade(line);
			
			getline(arquivo_leitura_final, line);
			valor_int = atoi(line.c_str());
			aps[cont_ap]->set_num(valor_int);
			
			getline(arquivo_leitura_final, line);
			valor_int = atoi(line.c_str());
			aps[cont_ap]->set_quartos(valor_int);
			
			getline(arquivo_leitura_final, line);
			valor_int = atoi(line.c_str());
			aps[cont_ap]->set_banhei(valor_int);
			
			getline(arquivo_leitura_final, line);
			valor_int = atoi(line.c_str());
			aps[cont_ap]->set_andar(valor_int);
			
			getline(arquivo_leitura_final, line);
			valor_float = atoi(line.c_str());
			aps[cont_ap]->set_taxa_condo(valor_float);
			
			getline(arquivo_leitura_final, line);
			if(line == "1")
				aps[cont_ap]->set_elev(true);
			else
				aps[cont_ap]->set_elev(false);
				
			getline(arquivo_leitura_final, line);
			if(line == "1")
				aps[cont_ap]->set_sacada(true);
			else
				aps[cont_ap]->set_sacada(false);
			
			cont_ap++;
		}
		
		else if(line == "casa"){
			casas.push_back(new(Casa));
			casas[cont_casa]->set_id(id);
			id++;
			
			getline(arquivo_leitura_final, line);
			valor_float = atoi(line.c_str());
			casas[cont_casa]->set_valor(valor_float);
			
			getline(arquivo_leitura_final, line);
			casas[cont_casa]->set_prop(line);
			
			getline(arquivo_leitura_final, line);
			casas[cont_casa]->set_rua(line);
			
			getline(arquivo_leitura_final, line);
			casas[cont_casa]->set_bairro(line);
			
			getline(arquivo_leitura_final, line);
			casas[cont_casa]->set_cidade(line);
			
			getline(arquivo_leitura_final, line);
			valor_int = atoi(line.c_str());
			casas[cont_casa]->set_num(valor_int);
			
			getline(arquivo_leitura_final, line);
			valor_int = atoi(line.c_str());
			casas[cont_casa]->set_quartos(valor_int);
			
			getline(arquivo_leitura_final, line);
			valor_int = atoi(line.c_str());
			casas[cont_casa]->set_banhei(valor_int);
			
			getline(arquivo_leitura_final, line);
			valor_int = atoi(line.c_str());
			casas[cont_casa]->set_andares(valor_int);
			
			getline(arquivo_leitura_final, line);
			if(line == "1")
				casas[cont_casa]->set_sala_jantar(true);
			else
				casas[cont_casa]->set_sala_jantar(false);
			
			cont_casa++;
		}
		
		else if(line == "chacara"){
			chacs.push_back(new(Chacara));
			chacs[cont_chac]->set_id(id);
			id++;
			
			getline(arquivo_leitura_final, line);
			valor_float = atoi(line.c_str());
			chacs[cont_chac]->set_valor(valor_float);
			
			getline(arquivo_leitura_final, line);
			chacs[cont_chac]->set_prop(line);
			
			getline(arquivo_leitura_final, line);
			chacs[cont_chac]->set_rua(line);
			
			getline(arquivo_leitura_final, line);
			chacs[cont_chac]->set_bairro(line);
			
			getline(arquivo_leitura_final, line);
			chacs[cont_chac]->set_cidade(line);
			
			getline(arquivo_leitura_final, line);
			valor_int = atoi(line.c_str());
			chacs[cont_chac]->set_num(valor_int);
			
			getline(arquivo_leitura_final, line);
			valor_int = atoi(line.c_str());
			chacs[cont_chac]->set_quartos(valor_int);
			
			getline(arquivo_leitura_final, line);
			valor_int = atoi(line.c_str());
			chacs[cont_chac]->set_banhei(valor_int);
			
			getline(arquivo_leitura_final, line);
			if(line == "1")
				chacs[cont_chac]->set_salao_festa(true);
			else
				chacs[cont_chac]->set_salao_festa(false);
				
			getline(arquivo_leitura_final, line);
			if(line == "1")
				chacs[cont_chac]->set_salao_jogos(true);
			else
				chacs[cont_chac]->set_salao_jogos(false);
				
			getline(arquivo_leitura_final, line);
			if(line == "1")
				chacs[cont_chac]->set_campo_fut(true);
			else
				chacs[cont_chac]->set_campo_fut(false);
				
			getline(arquivo_leitura_final, line);
			if(line == "1")
				chacs[cont_chac]->set_churras(true);
			else
				chacs[cont_chac]->set_churras(false);
				
			getline(arquivo_leitura_final, line);
			if(line == "1")
				chacs[cont_chac]->set_piscina(true);
			else
				chacs[cont_chac]->set_piscina(false);
				
			cont_chac++;
		}
	}
	
	cout << casas[0]->get_id() << endl;
	cout << casas[0]->get_prop() << endl;
	cout << casas[5]->get_id() << endl;
	
	cout << aps[0]->get_id() << endl;
	cout << aps[0]->get_prop() << endl;
	cout << aps[5]->get_id() << endl;
	
	cout << chacs[0]->get_id() << endl;
	cout << chacs[0]->get_prop() << endl;
	cout << chacs[5]->get_id() << endl;
}
