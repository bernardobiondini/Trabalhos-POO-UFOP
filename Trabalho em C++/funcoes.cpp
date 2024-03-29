#include "classes.h"
using namespace std;

//funcao para verificar se o proprietario possui imoveis
bool func2(vector<Imovel*> imoveis, string proprietario){
	//for (auto i : imoveis){
	//	if(i->get_prop() == propietario) return true;
	//}
	for(unsigned int i = 0; i < imoveis.size(); i++){
		if(imoveis.at(i)->get_prop() == proprietario) 
			return true;
	}
	return false;	
}

//funcao para filtrar os imoveis de valor igual ou abaixo do inserido
vector<Imovel*> func3(vector<Imovel*> *imoveis, float valor){
	vector<Imovel*> propriedades;
	
	//for (auto & i : *imoveis){
	//	if(i->get_valor() <= valor) propriedades.push_back(i);
	//}
	for(unsigned int i = 0; i < imoveis->size(); i++){
		if(imoveis->at(i)->get_valor() <= valor) 
			propriedades.push_back(imoveis->at(i));
	}

	return propriedades;
}

//funcao para filtrar os imoveis com numero de quartos igual ou superior ao inserido
vector<Imovel*> func4(vector<Imovel*> *imoveis, int quartos){
	vector<Imovel*> propriedades;
	//for (auto & i : *imoveis){
	//	if(i->get_quartos() >= quartos) propriedades.push_back(i);
	//}
	for(unsigned int i = 0; i < imoveis->size(); i++){
		if(imoveis->at(i)->get_quartos() >= quartos) 
			propriedades.push_back(imoveis->at(i));
	}

	return propriedades;
}

//funcao que filtra os imoveis de acordo com o tipo inserido
vector<Imovel*> func5(vector<Imovel*> *imoveis, string tipo){
	vector<Imovel*> imoveis_tipo;

	//for (auto & i : *imoveis){
	//	if ((typeid(*i) == typeid(Casa)) && (tipo == "casa")) imoveis_tipo.push_back(i);
	//	else if ((typeid(*i) == typeid(Apartamento)) && (tipo == "apartamento")) imoveis_tipo.push_back(i);
	//	else if ((typeid(*i) == typeid(Chacara)) && (tipo == "chacara")) imoveis_tipo.push_back(i);
	//}
	for(unsigned int i = 0; i < imoveis->size(); i++){
		if ((typeid(*imoveis->at(i)) == typeid(Casa)) && (tipo == "casa")) imoveis_tipo.push_back(imoveis->at(i));
		else if ((typeid(*imoveis->at(i)) == typeid(Apartamento)) && (tipo == "apartamento")) imoveis_tipo.push_back(imoveis->at(i));
		else if ((typeid(*imoveis->at(i)) == typeid(Chacara)) && (tipo == "chacara")) imoveis_tipo.push_back(imoveis->at(i));
	}
	
	return imoveis_tipo;
}

//funcao para filtrar os imoveis da cidade inserida
vector<Imovel*> func6(vector<Imovel*> *imoveis, string cidade){
	vector<Imovel*> propriedades;

	//for (auto & i : *imoveis){
	//	if(i->get_cidade() == cidade) propriedades.push_back(i);
	//}
	for(unsigned int i = 0; i < imoveis->size(); i++){
		if(imoveis->at(i)->get_cidade() == cidade) propriedades.push_back(imoveis->at(i));
	}

	return propriedades;
}

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

    /*
    vector<Imovel*> 
		Imovel *imovel;
		vector<Imovel*>::iterator it;
    for(it = imoveis->begin(); it != imoveis->end(); it++) {
      imovel = *it;
      if(imovel->get_prop() == proprietario)    	
		}
	*/
}

//funcao que cria um arquivo(opcao 2) ou lista os imoveis(opcao 1)
void func8(vector<Imovel*> *imoveis, int opcao){
	
	FILE *arquivo = fopen("saida.txt", "w");

	for(unsigned int i = 0; i < imoveis->size(); i++){
		if(opcao == 1){
			cout << *imoveis->at(i);
		}
		else{
			imoveis->at(i)->imprime(arquivo, *imoveis->at(i));
		}
	}
	fclose(arquivo);
}