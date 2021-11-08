#include "classes.h"
#include "funcoes.h"

using namespace std;

int main(){
	vector<Apartamento*> aps;
	vector<Casa*> casas;
	vector<Chacara*> chacs;
	
	le_cria_arquivos();
	cria_imoveis(casas, aps, chacs);
	
	cout << casas[0]->get_id() << endl;
	cout << casas[0]->get_prop() << endl;
	cout << casas[5]->get_id() << endl;
	
	cout << aps[0]->get_id() << endl;
	cout << aps[0]->get_prop() << endl;
	cout << aps[5]->get_id() << endl;
	
	cout << chacs[0]->get_id() << endl;
	cout << chacs[0]->get_prop() << endl;
	cout << chacs[5]->get_id() << endl;
	return 0;
}
