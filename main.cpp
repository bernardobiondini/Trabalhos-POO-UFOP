#include "classes.h"
#include "funcoes.h"

using namespace std;

int main(){
	vector<Imovel*> imoveis;
	
	imoveis = Imovel::ler_dados();

	cout << *imoveis[0] << endl;
	return 0;
}
