#como usar:
#mysql --force < nome_deste_arquivo

#como colocar os dados na tabela
#mysql --local <nome do banco> <arquivo com o mesmo nome da tabela> 
#create database gyouzafoot
#use gyouzafoot;

create database test;
use test;

create table jogadores(
       nome varchar(40),
       int idade,
       int id not null,

       primary key( id )
);

create table historico(
       id    int,
       id_jogador int,
       id_time	  int,
       entrada 	  date,
       saida	  date,
       camisa	  int,
       
       primary key ( id ),

       foreign key (id_jogador) references jogadores( id ),
       foreign key ( id_time ) references time( id )
)