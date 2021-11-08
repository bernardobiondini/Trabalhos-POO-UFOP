#include "classes.h"
#include "funcoes.h"

using namespace std;

int main(){
	vector<Apartamento*> aps;
	vector<Casa*> casas;
	vector<Chacara*> chacs;
	
	le_cria_arquivos();
	cria_imoveis(casas, aps, chacs);
	
	printf("%d\n", casas[0]->get_id());
	return 0;
}
