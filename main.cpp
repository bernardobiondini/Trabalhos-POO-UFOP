#include "classes.h"
#include "funcoes.h"

using namespace std;

int main(){
	//inicializando vetores
	vector<Imovel*> imoveis;
	vector<Imovel*> imoveis_retorno;
	
	//recebendo os dados do arquivo no vetor imoveis
	imoveis = Imovel::ler_dados();

	//inicializando variaveis para receber valores do vetor ou do usuario
	int funcao, quartos, opcao;
	float valor;
	string prop, cidade, tipo;

	//recebendo do usuario qual a funcao a ser utilizada
	cout << "Digite o numero da funcao desejada: ";
	cin >> funcao;
	
	//switch para a funcao escolhida pelo usuario
	switch(funcao){
		case 1://printa os imoveis e seus dados de acordo com o enunciado 1
			for(unsigned int i = 0; i < imoveis.size(); i++)
				cout << *imoveis.at(i);
		break;
		case 2://printa os imoveis do proprietario e seus dados de acordo com o enunciado 2
			cout << "Digite o nome desejado: ";
			cin.ignore();
			getline(cin, prop);
			if(func2(imoveis, prop)) cout << prop << " Eh proprietario\n";//printar dependendo do retorno da funcao 
			else cout << prop << " Nao eh proprietario\n";
		break;

		case 3://funcao para filtrar imoveis de acordo com o valor como solicitado no enunciado 3
			cout << "Digite o valor desejado: ";
			cin >> valor;
			imoveis_retorno = func3(&imoveis, valor);
			//for(auto & i : imoveis_retorno){
			//	cout << *i;
			//}
			for(unsigned int i = 0; i < imoveis_retorno.size(); i++)//printando os imoveis com valor igual ou acima do inserido
				cout << *imoveis_retorno.at(i);
			imoveis_retorno.clear();
		break;

		case 4://filtrar imoveis de acordo com o numero de quartos no imovel
			cout << "Digite a quantidade de quartos desejada: ";
			cin >> quartos;
			imoveis_retorno = func4(&imoveis, quartos);
			//for(auto &i : imoveis_retorno){
			//	cout << *i;
			//}
			for(unsigned int i = 0; i < imoveis_retorno.size(); i++)//printar os imoveis com quantidade igual ou maior que a solicitada
				cout << *imoveis_retorno.at(i);
			imoveis_retorno.clear();
		break;

		case 5://funcao que filtra de acordo com o tipo de imovel (casa, chacara, apartamento)
			cout << "Digite o tipo desejado: ";
			cin.ignore();
			cin >> tipo;
			cout << tipo << endl;
			imoveis_retorno = func5(&imoveis, tipo);
			//for(auto &i : imoveis_retorno){
			//	cout << *i;
			//}
			for(unsigned int i = 0; i < imoveis_retorno.size(); i++)//printar os imoveis do tipo solicitado
				cout << *imoveis_retorno.at(i);
			imoveis_retorno.clear();
		break;

		case 6://filtrar imoveis de acordo com a cidade inserida
			cout << "Digite a cidade desejada: ";
			cin.ignore();
			cin >> cidade;
			imoveis_retorno = func6(&imoveis, cidade);
			//for(auto i = imoveis_retorno.rbegin(); i != imoveis_retorno.rend(); ++i){
			//	cout << **i;
			//}
			for(unsigned int i = imoveis_retorno.size() - 1; i >= 0; i--)//printar os imoveis da cidade inserida
				cout << *imoveis_retorno.at(i);
			imoveis_retorno.clear();
		break;

		case 7://filtrar os imoveis de acordo com o nome do proprietario
		{
			vector<vector<Imovel*>::iterator> vetor7;
			cout << "Digite o nome do proprietario: ";
			cin.ignore();
			getline(cin, prop);
			
			vetor7 = func7(&imoveis, prop);
			if(!vetor7.empty()){//listar os imoveis do proprietario caso ele possua algum
		 		cout << "Os imoveis de " << prop << " sao:" << endl;
          for(unsigned int i = 0; i < vetor7.size(); i++){
            cout << **vetor7.at(i) << endl;
          }
				vetor7.clear();
				break;
      }
    	else{//caso o proprietario n tenha imoveis
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
