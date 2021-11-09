#ifndef classes_h
#define classes_h

#include <string>
#include <iostream>
#include <vector>
#include <sstream>
#include <fstream>
#include <typeinfo>
#include <cstdlib>
using namespace std;

class Imovel{	
	int id;
	float valor;
	string prop;
	string rua;
	string bairro;
	string cidade;
	int num;
	int quartos;
	int banhei;
		
	public:
		int get_id();
		void set_id(int id);
		float get_valor();
		void set_valor(float valor);
		string get_prop();
		void set_prop(string prop);
		string get_rua();
		void set_rua(string rua);
		string get_bairro();
		void set_bairro(string bairro);
		string get_cidade();
		void set_cidade(string cidade);
		int get_num();
		void set_num(int num);
		int get_quartos();
		void set_quartos(int quartos);
		int get_banhei();
		void set_banhei(int banhei);
		void print(ostream&);
		friend std::ostream& operator<<(std::ostream&, Imovel&);
};

class Casa : public Imovel{
	int andares;
	bool sala_jantar;
	
	public:
		Casa();
		~Casa();
		int get_andares();
		void set_andares(int andares);
		bool get_sala_jantar();
		void set_sala_jantar(bool sala_jantar);
		void print(ostream&);
		friend std::ostream& operator<<(std::ostream&, Casa&);
};

class Apartamento : public Imovel{
	int andar;
	float taxa_condo;
	bool elev;
	bool sacada;
	
	public:
		Apartamento();
		~Apartamento();
		int get_andar();
		void set_andar(int andar);
		float get_taxa_condo();
		void set_taxa_condo(float taxa);
		bool get_elev();
		void set_elev(bool elev);
		bool get_sacada();
		void set_sacada(bool sacada);
		void print(ostream& out);
		friend std::ostream& operator<<(std::ostream&, Apartamento&);
};

class Chacara : public Imovel{
	bool salao_festa;
	bool salao_jogos;
	bool campo_fut;
	bool churras;
	bool piscina;
	
	public:
		Chacara();
		~Chacara();
		bool get_salao_festa();
		void set_salao_festa(bool salao_festa);
		bool get_salao_jogos();
		void set_salao_jogos(bool salao_jogos);
		bool get_campo_fut();
		void set_campo_fut(bool campo_fut);
		bool get_churras();
		void set_churras(bool churras);
		bool get_piscina();
		void set_piscina(bool piscina);
		void print(ostream& out);
		friend std::ostream& operator<<(std::ostream&, Chacara&);
};

#endif
