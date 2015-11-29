#como usar:
#mysql --force < nome_deste_arquivo

#como colocar os dados na tabela
#mysql --local <nome do banco> <arquivo com o mesmo nome da tabela> 

create database gyouzafoot
use gyouzafoot;

create table jogadores(
       nome varchar(255),
       int idade,
       int id not null auto_increment,

       primary key( id )
);

create table contrato(
       id int not null auto_increment,
       id_jogador int,
       entrada date,
       saida date,
       camisa int,
       
       primary key ( id ),

       foreign key (id_jogador) references jogadores( id )
);

create table jogo(

	id int not null auto_increment,
	nome_adversario varchar(100),
	PTgyouza int,
	PTadversario int,
	data date,
	
	primary key ( id )
);

create table participacao(  

	id int not null auto_increment,
	id_jogador int,
	id_jogo int,
	gol_contra int,
	gol_valido int, 

	primary key ( id ),
	foreing key ( id_jogador ) references jogador( id ),
	foreing key ( id_jogo ) references jogo( id )
);

create table suspensao(
	
	id int not null auto_increment,
	id_jogador int,
	id_jogo int,
	qtde_jogos int,
	
	primary key ( id ),
	foreing key ( id_jogador ) references jogadores( id ),
	foreing key ( id_jogo ) references jogo( id )
);

create table cartao_amarelo(
	
	id int not null auto_increment,
	id_participacao,
	
	primary key ( id ),
	foreing key ( id_participacao ) references participacao( id )
);

create table cartao_vermelho(

	id int not null auto_increment,
	id_participacao,
	
	primary key ( id ),
	foreing key ( id_participacao ) references participacao( id )
);

create table faltas_cometidas(

	id int not null auto_increment,
	id_participacao,
	gravidade int,
	
	primary key ( id ),
	foreing key ( id_participacao ) references participacao( id )
);

create table faltas_tomadas(
	
	id int not null auto_increment,
	id_participacao,
	gravidade int,
	
	primary key ( id ),
	foreing key ( id_participacao ) references participacao( id )
);
