#include "classes.h"
#include "funcoes.h"

using namespace std;

int main(){
	vector<Imovel*> imoveis;
	vector<Imovel*> imoveis_retorno;
	
	imoveis = Imovel::ler_dados();

	int funcao, quartos, opcao;
	float valor;
	string prop, cidade, tipo;
	cout << "Digite o numero da funcao desejada: ";
	cin >> funcao;
	
	switch(funcao){
		case 1:
			for(unsigned int i = 0; i < imoveis.size(); i++)
				cout << *imoveis.at(i);
		break;
		case 2:
			cout << "Digite o nome desejado: ";
			cin.ignore();
			getline(cin, prop);
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
		{
			vector<vector<Imovel*>::iterator> vetor7;
			cout << "Digite o nome do proprietario: ";
			cin.ignore();
			getline(cin, prop);
			
			vetor7 = func7(&imoveis, prop);			
			if(!vetor7.empty()){
		 		cout << "Os imoveis de " << prop << " sao:" << endl;
                for(unsigned int i = 0; i < vetor7.size(); i++){
                    cout << **vetor7.at(i) << endl;
            	}
				vetor7.clear();
				break;
        	}
        	else{
				cout << prop << " nao possui imoveis" << endl;
				vetor7.clear();
				break;
			}
		}
		break;

		case 8:
			cout << "Digite 1 para imprimir as prorpiedades no terminal e 2 para criar um arquivo: ";
			cin >> opcao;

			func8(&imoveis, opcao);
		break;
	}
	return 0;
}
