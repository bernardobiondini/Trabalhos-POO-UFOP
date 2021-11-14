#include "classes.h"
using namespace std;

bool func2(vector<Imovel*> imoveis, string propietario){
	//for (auto i : imoveis){
	//	if(i->get_prop() == propietario) return true;
	//}
	for(int i = 0; i < imoveis.size(); i++){
		if(imoveis.at(i)->get_prop() == propietario) 
			return true;
	}
	return false;	
}

vector<Imovel*> func3(vector<Imovel*> *imoveis, float valor){
	vector<Imovel*> propriedades;
	
	//for (auto & i : *imoveis){
	//	if(i->get_valor() <= valor) propriedades.push_back(i);
	//}
	for(int i = 0; i < imoveis->size(); i++){
		if(imoveis->at(i)->get_valor() <= valor) 
			propriedades.push_back(imoveis->at(i));
	}

	return propriedades;
}

vector<Imovel*> func4(vector<Imovel*> *imoveis, int quartos){
	vector<Imovel*> propriedades;
	//for (auto & i : *imoveis){
	//	if(i->get_quartos() >= quartos) propriedades.push_back(i);
	//}
	for(int i = 0; i < imoveis->size(); i++){
		if(imoveis->at(i)->get_quartos() >= quartos) 
			propriedades.push_back(imoveis->at(i));
	}

	return propriedades;
}

vector<Imovel*> func5(vector<Imovel*> *imoveis, string tipo){
	vector<Imovel*> imoveis_tipo;

	//for (auto & i : *imoveis){
	//	if ((typeid(*i) == typeid(Casa)) && (tipo == "casa")) imoveis_tipo.push_back(i);
	//	else if ((typeid(*i) == typeid(Apartamento)) && (tipo == "apartamento")) imoveis_tipo.push_back(i);
	//	else if ((typeid(*i) == typeid(Chacara)) && (tipo == "chacara")) imoveis_tipo.push_back(i);
	//}
	for(int i = 0; i < imoveis->size(); i++){
		if ((typeid(imoveis->at(i)) == typeid(Casa)) && (tipo == "casa")) imoveis_tipo.push_back(imoveis->at(i));
		else if ((typeid(imoveis->at(i)) == typeid(Apartamento)) && (tipo == "apartamento")) imoveis_tipo.push_back(imoveis->at(i));
		else if ((typeid(imoveis->at(i)) == typeid(Chacara)) && (tipo == "chacara")) imoveis_tipo.push_back(imoveis->at(i));
	}

	return imoveis_tipo;
}

vector<Imovel*> func6(vector<Imovel*> *imoveis, string cidade){
	vector<Imovel*> propriedades;

	//for (auto & i : *imoveis){
	//	if(i->get_cidade() == cidade) propriedades.push_back(i);
	//}
	for(int i = 0; i < imoveis->size(); i++){
		if(imoveis->at(i)->get_cidade() == cidade) propriedades.push_back(imoveis->at(i));
	}

	return propriedades;
}
