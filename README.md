# Biblioteca

Projeto para a aplicação de padrões de código da disciplina de Desenvolvimento de Software II - UNISINOS.

## How to Run

Apenas rode a classe Main e vá selecionando as opções pelo menu que aparecerá no console!

## Padrões Aplicados

* Singleton

A classe Biblioteca implementa o padrão singleton, uma vez que durante a execução do sistema somente é necessária uma instância deste objeto.

* Builder

As classes Livro e Periodico implementam o padrão Builder para criação dos objetos. Ele é útil para estas classes pois elas apresentam diversos atributos e assim a sua criação fica mais dinâmica, sem a necessidade de diversos construtores com parâmetros diferentes.

* Facade

O padrão Facade é utilizado na classe BibliotecaFacade para fornecer um ponto de responsabilidade única para que o cliente consuma. Os métodos da Facade são chamados na classe Main.

* Factory e Strategy

Estes dois padrões são utilizados em conjunto para gerar relatórios ao usuário.
Com o padrão Factory é possível retornar a classe que implementa a interface IReportStrategy correta para a criação do relatório solicitado pelo usuário.
A classe ReportFactory é a responsável por retornar a Strategy correta.
Todas as classes de relatório devem implementar a interface IReportStrategy para que tenham o método showData() onde a lógica para mostrar o relatório deve ser implementada. Um exemplo é a classe LivrosEntregaAtrasadaRelatorio.
