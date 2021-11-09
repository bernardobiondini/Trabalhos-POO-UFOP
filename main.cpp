#include "classes.h"
#include "funcoes.h"

using namespace std;

int main(){
	vector<Apartamento*> aps;
	vector<Casa*> casas;
	vector<Chacara*> chacs;
	
	le_cria_arquivos();
	cria_imoveis(casas, aps, chacs);

	
	cout << *casas[0] << endl;
	cout << *casas[5] << endl;
	
	cout << *aps[0] << endl;
	cout << *aps[5] << endl;
	
	cout << *chacs[0] << endl;
	cout << *chacs[5] << endl;
	return 0;
}
