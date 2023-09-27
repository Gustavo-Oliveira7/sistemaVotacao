package com.betrybe.sistemadevotacao;

import java.util.Scanner;

public class Principal {
  static GerenciamentoVotacao votacao = new GerenciamentoVotacao();

  /**
   * inicia a execução do programa.
   */

  public static void main(String[] args) {
    ///menuVotacao();

    cadastroPessoasCandidadatas();

    ///cadastroPessoasEleitoras();
  }

  /**
   * cadastra pessoas candidatas.
   */

  public static void cadastroPessoasCandidadatas() {
    System.out.println("Cadastrar Pessoa candidata?\n1 - Sim\n2 - Não\n"
        + "Entre com o número correspondente à opção desejada:");
    Scanner scanner = new Scanner(System.in);
    int opcaoSelecionada = scanner.nextInt();

    switch (opcaoSelecionada) {
      case 1:
        System.out.println("Entre com o nome da pessoa candidata:");
        String nomeCandidata = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numeroCandidata = scanner.nextInt();
        votacao.cadastrarPessoaCandidata(nomeCandidata, numeroCandidata);
        cadastroPessoasCandidadatas();
        break;
      case 2:
        cadastroPessoasEleitoras();
        break;
      default:
        System.out.println("Opção inválida");
        cadastroPessoasCandidadatas();
    }
  }

  /**
   * cadastra pessoas eleitoras.
   */
  public static void cadastroPessoasEleitoras() {
    System.out.println("Cadastrar Pessoa eleitora?\n1 - Sim\n2 - Não\n"
        + "Entre com o número correspondente à opção desejada:");
    Scanner scanner = new Scanner(System.in);
    int opcaoSelecionada = scanner.nextInt();
    switch (opcaoSelecionada) {
      case 1:
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nomeEleitora = scanner.next();
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpfEleitora = scanner.next();
        votacao.cadastrarPessoaEleitora(nomeEleitora, cpfEleitora);
        cadastroPessoasEleitoras();
        break;

      case 2:
        menuVotacao();
        break;

      default:
        System.out.println("Opção inválida");
        cadastroPessoasEleitoras();

    }
  }

  /**
   * Abre o menu votação.
   */
  public static void menuVotacao() {
    System.out.println("Entre com o número correspondente à opção desejada:\n1 - Votar\n"
        + "2 - Resultado Parcial\n"
        + "3 - Finalizar Votação");
    Scanner scanner = new Scanner(System.in);
    int opcaoSelecionada = scanner.nextInt();
    switch (opcaoSelecionada) {
      case 1:
        System.out.println("Entre com o cpf da pessoa eleitora");
        String cpfEleitora = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numeroCandidato = scanner.nextInt();
        votacao.votar(cpfEleitora, numeroCandidato);
        menuVotacao();
        break;
      case 2:
        votacao.mostrarResultado();
        break;
      case 3:
        votacao.mostrarResultado();
        menuVotacao();
        break;
      default:
        System.out.println("Opção inválida");
        menuVotacao();
    }
  }
}
