#include "classes.h"
#include "funcoes.h"

using namespace std;

int main(){
	vector<Imovel*> imoveis;
	vector<Imovel*> imoveis_retorno;
	
	imoveis = Imovel::ler_dados();

	int funcao, quartos;
	float valor;
	string prop, cidade, tipo;
	cout << "Digite o numero da funcao desejada: ";
	cin >> funcao;
	
	for(unsigned int i = 0; i < imoveis.size(); i++){
		cout << *imoveis.at(i) << endl;
	}
	
	switch(funcao){
		case 2:
			cout << "Digite o nome desejado: ";
			cin.ignore();
			getline( cin, prop);
			if(func2(imoveis, prop)) cout << prop << " Eh proprietario\n";
			else cout << prop << " Nao eh proprietario\n";
		break;

		case 3:
			cout << "Digite o valor desejado: ";
			cin >> valor;
			imoveis_retorno = func3(&imoveis, valor);
			//for(auto & i : imoveis_retorno){
			//	cout << *i;
			//}
			for(unsigned int i = 0; i < imoveis_retorno.size(); i++)
				cout << *imoveis_retorno.at(i);
			imoveis_retorno.clear();
		break;

		case 4:
			cout << "Digite a quantidade de quartos desejada: ";
			cin >> quartos;
			imoveis_retorno = func4(&imoveis, quartos);
			//for(auto &i : imoveis_retorno){
			//	cout << *i;
			//}
			for(unsigned int i = 0; i < imoveis_retorno.size(); i++)
				cout << *imoveis_retorno.at(i);
			imoveis_retorno.clear();
		break;

		case 5:
			cout << "Digite o tipo desejado: ";
			cin.ignore();
			cin >> tipo;
			cout << tipo << endl;
			imoveis_retorno = func5(&imoveis, tipo);
			//for(auto &i : imoveis_retorno){
			//	cout << *i;
			//}
			for(unsigned int i = 0; i < imoveis_retorno.size(); i++)
				cout << *imoveis_retorno.at(i);
			imoveis_retorno.clear();
		break;

		case 6:
			cout << "Digite a cidade desejada: ";
			cin.ignore();
			cin >> cidade;
			imoveis_retorno = func6(&imoveis, cidade);
			//for(auto i = imoveis_retorno.rbegin(); i != imoveis_retorno.rend(); ++i){
			//	cout << **i;
			//}
			for(unsigned int i = imoveis_retorno.size() - 1; i >= 0; i--)
				cout << *imoveis_retorno.at(i);
			imoveis_retorno.clear();
		break;

		case 7:
			cout << "Digite o nome do proprietario: ";
			cin.ignore();
			cin >> prop;
			imoveis_retorno = func7(&imoveis, prop);
		 	for(unsigned int i = imoveis_retorno.size() - 1; i >= 0; i--)
				cout << *imoveis_retorno.at(i);
			imoveis_retorno.clear();
		break;

		case 8:

		break;
	}
	return 0;
}
