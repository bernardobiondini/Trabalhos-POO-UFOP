#include "classes.h"
using namespace std;

//using std::endl;
//using std::string;
//using std::stoi;

//Esse arquivo basicamente contem setters, getters, construtores e destrutores das classes criadas
///////////////////////////  METODOS IMOVEL //////////////////////////////////
Imovel::Imovel(const int id, const float valor, const string prop, const string rua, const string bairro, 
	const string cidade, const int num, const int quartos, const int banhei):
	id(id), valor(valor), prop(prop), rua(rua), bairro(bairro), cidade(cidade), 
	num(num), quartos(quartos), banhei(banhei){}

int Imovel::get_id(){
	return id;
}

void Imovel::set_id(int id){
	this->id = id;
}

float Imovel::get_valor(){
	return valor;
}

void Imovel::set_valor(float valor){
	this->valor = valor;
}

string Imovel::get_prop(){
	return prop;
}

void Imovel::set_prop(string prop){
	this->prop = prop;
}

string Imovel::get_rua(){
	return rua;
}

void Imovel::set_rua(string rua){
	this->rua = rua;
}

string Imovel::get_bairro(){
	return bairro;
}

void Imovel::set_bairro(string bairro){
	this->bairro = bairro;
}

string Imovel::get_cidade(){
	return cidade;
}

void Imovel::set_cidade(string cidade){
	this->cidade = cidade;
}

int Imovel::get_num(){
	return num;
}

void Imovel::set_num(int num){
	this->num = num;
}

int Imovel::get_quartos(){
	return quartos;
}

void Imovel::set_quartos(int quartos){
	this->quartos = quartos;
}

int Imovel::get_banhei(){
	return banhei;
}

void Imovel::set_banhei(int banhei){
	this->banhei = banhei;
}

void Imovel::print(ostream& out){
	out << "\n-----------------------------------------------------------------"
	<< "\nProprietario: "<< this->prop
	<< "\n\t Preco: " << this->valor
 	<< "\n\t Quartos: " << this->quartos
 	<< "\n\t Rua: " << this->rua
 	<< "\n\t Bairro: " << this->bairro
 	<< "\n\t Cidade: " << this->cidade;
}

std::ostream& operator<<(std::ostream& out, Imovel& i){
	i.print(out);

	return out;
}

vector<Imovel*> Imovel::ler_dados(){
	char letra;
    string linha_inteira;
    
    FILE *arquivo_r = fopen("database_imoveis.txt", "r");;
    FILE *arquivo_w = fopen("dados.txt", "w");;
     
    while(true){
        letra = (char) fgetc(arquivo_r);
        if(feof(arquivo_r))
            break;
        if(letra == ';')
            fputc('\n', arquivo_w);
        else
            fputc(letra, arquivo_w);
    }
    
    fclose(arquivo_r);
    fclose(arquivo_w);
	
	vector<Imovel*> imoveis;
    return cria_vetor(imoveis);
}

vector<Imovel*> Imovel::cria_vetor(vector<Imovel*> imoveis){
	ifstream gera_dados;
	gera_dados.open("dados.txt", ifstream::in);
    
    int cont = 0;
	string palavra;
	stringstream ss;
    
    // float fl;
    // int in;
    
    while(getline(gera_dados, palavra)){
        if(palavra == "apartamento") {
			getline(gera_dados, palavra);			
			float valor = atof(palavra.c_str());
				
		    getline(gera_dados, palavra);
		    string prop = palavra;
		
		    getline(gera_dados, palavra);
		    string rua = palavra;
		
		    getline(gera_dados, palavra);
		    string bairro = palavra;
		
		    getline(gera_dados, palavra);
		    string cidade = palavra;

		    getline(gera_dados, palavra);
		    int num = atoi(palavra.c_str());		    
		
		    getline(gera_dados, palavra);
		    int quartos = atoi(palavra.c_str());		    
		
		    getline(gera_dados, palavra);
		    int banhei = atoi(palavra.c_str());		    
            
            getline(gera_dados, palavra);
            int andar = atoi(palavra.c_str());		    
        
            getline(gera_dados, palavra);
            float taxa_condominio = atof(palavra.c_str());		    
            
            getline(gera_dados, palavra);
            int elevador = atoi(palavra.c_str());		    
            
            getline(gera_dados, palavra);
            int sacada = atoi(palavra.c_str());		    
			
			imoveis.push_back(new Apartamento(
				cont++, valor, prop, rua, bairro, cidade, num, quartos, banhei, andar, taxa_condominio, elevador, sacada
			));
        }
        else if(palavra == "casa") {
            
			getline(gera_dados, palavra);			
			float valor = atof(palavra.c_str());
				
		    getline(gera_dados, palavra);
		    string prop = palavra;
		
		    getline(gera_dados, palavra);
		    string rua = palavra;
		
		    getline(gera_dados, palavra);
		    string bairro = palavra;
		
		    getline(gera_dados, palavra);
		    string cidade = palavra;

		    getline(gera_dados, palavra);
		    int num = atoi(palavra.c_str());		    
		
		    getline(gera_dados, palavra);
		    int quartos = atoi(palavra.c_str());		    
		
		    getline(gera_dados, palavra);
		    int banhei = atoi(palavra.c_str());		    
            
            getline(gera_dados, palavra);
            int andares = atoi(palavra.c_str());		

            getline(gera_dados, palavra);
			int sala_jantar = atoi(palavra.c_str());

			imoveis.push_back(new Casa(
				cont++, valor, prop, rua, bairro, cidade, num, quartos, banhei, andares, sala_jantar
			));
			
        }
        else if(palavra == "chacara") {
		    getline(gera_dados, palavra);			
			float valor = atof(palavra.c_str());
				
		    getline(gera_dados, palavra);
		    string prop = palavra;
		
		    getline(gera_dados, palavra);
		    string rua = palavra;
		
		    getline(gera_dados, palavra);
		    string bairro = palavra;
		
		    getline(gera_dados, palavra);
		    string cidade = palavra;

		    getline(gera_dados, palavra);
		    int num = atoi(palavra.c_str());		    
		
		    getline(gera_dados, palavra);
		    int quartos = atoi(palavra.c_str());		    
		
		    getline(gera_dados, palavra);
		    int banhei = atoi(palavra.c_str());	
            
            getline(gera_dados, palavra);
            int salao_festa = atoi(palavra.c_str());
            
            getline(gera_dados, palavra);
            int salao_jogos = atoi(palavra.c_str());
            
            getline(gera_dados, palavra);
            int campo_fut = atoi(palavra.c_str());
            
            getline(gera_dados, palavra);
            int churras = atoi(palavra.c_str());
            
            getline(gera_dados, palavra);
            int piscina = atoi(palavra.c_str());

			imoveis.push_back(new Chacara(
				cont++, valor, prop, rua, bairro, cidade, num, quartos, banhei, salao_festa, salao_jogos, 
				campo_fut, churras, piscina
			));
        }
    }

    return imoveis;
}

void Imovel::imprime(FILE *arquivo, Imovel &imovel){
	fprintf(arquivo, "%s\n", imovel.get_prop().c_str());
	fprintf(arquivo, "\t%.2f\n", imovel.get_valor());
	fprintf(arquivo, "\t%d\n", imovel.get_quartos());
	fprintf(arquivo, "\t%s\n", imovel.get_rua().c_str());
	fprintf(arquivo, "\t%s\n", imovel.get_bairro().c_str());
	fprintf(arquivo, "\t%s\n", imovel.get_cidade().c_str());
}

/////////////////////////////  METODOS CASA ///////////////////////////////////////

Casa::Casa(const int id, const float valor, const string prop, const string rua, const string bairro, 
	const string cidade, const int num, const int quartos, const int banhei, const int andares, const bool sala_jantar): 
    Imovel(id, valor, prop, rua, bairro, cidade, num, quartos, banhei),
    andares(andares), sala_jantar(sala_jantar){}

int Casa::get_andares(){
	return andares;
}

void Casa::set_andares(int andares){
	this->andares = andares;
}

bool Casa::get_sala_jantar(){
	return sala_jantar;
}

void Casa::set_sala_jantar(bool sala_jantar){
	this->sala_jantar = sala_jantar;
}

void Casa::print(ostream& out){
	Imovel::print(out);
	out << "\n\t Andares: " << this->get_andares()
	<< endl;
}

std::ostream& operator<<(std::ostream& out, Casa& c){
	c.print(out);

	return out;
}

void Casa::printAll(){
	cout << "\n\t Andares: " << this->get_andares()
	<< "\n\t " << (this->get_sala_jantar() ? "Possui sala de jantar" : "Sem sala de jantar")
	<< endl;
}

void Casa::imprime(FILE *arquivo, Casa &imovel){
	Imovel ptr = imovel;
	Imovel::imprime(arquivo, ptr);
	fprintf(arquivo, "lalalalalala");
	fprintf(arquivo, "\t%d\n", imovel.get_andares());
}

///////////////////////////  METODOS APARTAMENTO //////////////////////////////////
Apartamento::Apartamento(const int id, const float valor, const string prop, const string rua, const string bairro, 
	const string cidade, const int num, const int quartos, const int banhei, const int andar,
	const float taxa_condo, const bool elev, const bool sacada):
	Imovel(id, valor, prop, rua, bairro, cidade, num, quartos, banhei),
	andar(andar), taxa_condo(taxa_condo),elev(elev), sacada(sacada){}

int Apartamento::get_andar(){
	return andar;
}

void Apartamento::set_andar(int andar){
	this->andar = andar;
}

float Apartamento::get_taxa_condo(){
	return taxa_condo;
}

void Apartamento::set_taxa_condo(float taxa){
	this->taxa_condo = taxa;
}

bool Apartamento::get_elev(){
	return elev;
}

void Apartamento::set_elev(bool elev){
	this->elev = elev;
}

bool Apartamento::get_sacada(){
	return sacada;
}

void Apartamento::set_sacada(bool sacada){
	this->sacada = sacada;
}

void Apartamento::print(ostream& out){
	Imovel::print(out);
	out	<< "\n\t " << (this->get_elev() ? "Possui elevador" : "Sem elevador")
	<< endl;

}

std::ostream& operator<<(std::ostream& out, Apartamento& a){
	a.print(out);

	return out;
}

void Apartamento::printAll(){
	cout << "\n\t Andar: " << this->get_andar()
	<< "\n\t Taxa de condominio: " << this->get_taxa_condo()
	<< "\n\t " << (this->get_elev() ? "Possui elevador" : "Sem elevador")
	<< "\n\t " << (this->get_sacada() ? "Possui sacada" : "Sem sacada")
	<< endl;
}

void Apartamento::imprime(FILE *arquivo, Apartamento &imovel){
	Imovel ptr = imovel;
	Imovel::imprime(arquivo, ptr);
	fprintf(arquivo, "lalalalalala");
	fprintf(arquivo, "\t%d\n", imovel.get_elev());
}


/////////////////////////////  METODOS CHACARA ////////////////////////////////////
Chacara::Chacara(const int id, const float valor, const string prop, const string rua, const string bairro, 
	const string cidade, const int num, const int quartos, const int banhei,
	const bool salao_festa, const bool salao_jogos, const bool campo_fut, const bool churras,
	const bool piscina): 
	Imovel(id, valor, prop, rua, bairro, cidade, num, quartos, banhei),
	salao_festa(salao_festa), salao_jogos(salao_jogos), campo_fut(campo_fut), churras(churras), 
	piscina(piscina){}
bool Chacara::get_salao_festa(){
	return salao_festa;
}

void Chacara::set_salao_festa(bool salao_festa){
	this->salao_festa = salao_festa;
}

bool Chacara::get_salao_jogos(){
	return salao_jogos;
}

void Chacara::set_salao_jogos(bool salao_jogos){
	this->salao_jogos = salao_jogos;
}

bool Chacara::get_campo_fut(){
	return campo_fut;
}

void Chacara::set_campo_fut(bool campo_fut){
	this->campo_fut = campo_fut;
}

bool Chacara::get_churras(){
	return churras;
}

void Chacara::set_churras(bool churras){
	this->churras = churras;
}

bool Chacara::get_piscina(){
	return piscina;
}

void Chacara::set_piscina(bool piscina){
	this->piscina = piscina;
}

void Chacara::print(ostream& out){
	Imovel::print(out);
	out << "\n\t " << (this->get_piscina() ? "Possui piscina" : "Sem piscina")
	<< endl;
}

std::ostream& operator<<(std::ostream& out, Chacara& c){
	c.print(out);

	return out;
}

void Chacara::printAll(){
	cout << "\n\t " << (this->get_salao_festa() ? "Possui salão de festa" : "Sem salão de festa")
	<< "\n\t " << (this->get_salao_jogos() ? "Possui salão de jogos" : "Sem salão de jogos")
	<< "\n\t " << (this->get_campo_fut() ? "Possui campo de futebol" : "Sem campo de futebol")
	<< "\n\t " << (this->get_churras() ? "Possui churrasqueira" : "Sem churrasqueira")
	<< "\n\t " << (this->get_piscina() ? "Possui piscina" : "Sem piscina")
	<< endl;
}

void Chacara::imprime(FILE *arquivo, Chacara &imovel){
	Imovel ptr = imovel;
	Imovel::imprime(arquivo, ptr);
	fprintf(arquivo, "lalalalalala");
	fprintf(arquivo, "\t%d\n", imovel.get_piscina());
}
