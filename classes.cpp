#include "classes.h"
using namespace std;

//Esse arquivo basicamente contem setters, getters, construtores e destrutores das classes criadas
///////////////////////////  METODOS IMOVEL //////////////////////////////////
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
	out << endl
	<< "Proprietário: "<< this->prop
	<< "\n\t Preço: " << this->valor
 	<< "\n\t Quartos: " << this->quartos
 	<< "\n\t Rua: " << this->rua
 	<< "\n\t Bairro: " << this->bairro
 	<< "\n\t Cidade: " << this->cidade;
}

std::ostream& operator<<(std::ostream& out, Imovel& i){
	i.print(out);

	return out;
}

/////////////////////////////  METODOS CASA ///////////////////////////////////////

Casa::Casa(){
	set_id(0);
	set_valor(0.00);
	set_prop("x");
	set_rua("x");
	set_bairro("x");
	set_cidade("x");
	set_num(0);
	set_quartos(0);
	set_banhei(0);
	set_andares(0);
	set_sala_jantar(false);
}

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
	out << "\n\t Andares: " << this->get_andares();
	out << "\n\t " << (this->get_sala_jantar() ? "Possui sala de jantar" : "Sem sala de jantar");
}

std::ostream& operator<<(std::ostream& out, Casa& c){
	c.print(out);

	return out;
}


///////////////////////////  METODOS APARTAMENTO //////////////////////////////////
Apartamento::Apartamento(){
	set_id(0);
	set_valor(0.00);
	set_prop("x");
	set_rua("x");
	set_bairro("x");
	set_cidade("x");
	set_num(0);
	set_quartos(0);
	set_banhei(0);
	set_andar(0);
	set_taxa_condo(0.00);
	set_elev(false);
	set_sacada(false);
}

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
	out << "\n\t Andar: " << this->get_andar()
	<< "\n\t Taxa de condominio: " << this->get_taxa_condo()
	<< "\n\t " << (this->get_elev() ? "Possui elevador" : "Sem elevador")
	<< "\n\t " << (this->get_sacada() ? "Possui sacada" : "Sem sacada");
}

std::ostream& operator<<(std::ostream& out, Apartamento& a){
	a.print(out);

	return out;
}


/////////////////////////////  METODOS CHACARA ////////////////////////////////////
Chacara::Chacara(){
	set_id(0);
	set_valor(0.00);
	set_prop("x");
	set_rua("x");
	set_bairro("x");
	set_cidade("x");
	set_num(0);
	set_quartos(0);
	set_banhei(0);
	set_salao_festa(false);
	set_salao_jogos(false);
	set_campo_fut(false);
	set_churras(false);
	set_piscina(false);
}
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
	out << "\n\t " << (this->get_salao_festa() ? "Possui salão de festa" : "Sem salão de festa")
	<< "\n\t " << (this->get_salao_jogos() ? "Possui salão de jogos" : "Sem salão de jogos")
	<< "\n\t " << (this->get_campo_fut() ? "Possui campo de futebol" : "Sem campo de futebol")
	<< "\n\t " << (this->get_churras() ? "Possui churrasqueira" : "Sem churrasqueira")
	<< "\n\t " << (this->get_piscina() ? "Possui piscina" : "Sem piscina");
}

std::ostream& operator<<(std::ostream& out, Chacara& c){
	c.print(out);

	return out;
}