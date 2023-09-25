package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {

  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<String> cpfsComputados;

  /**
   * Gerenciamento Votação.
   */
  public GerenciamentoVotacao() {
    this.pessoasCandidatas = new ArrayList<>();
    this.cpfsComputados = new ArrayList<>();
    this.pessoasEleitoras = new ArrayList<>();
  }

  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata indexPessoaCandidata : pessoasCandidatas) {
      if (indexPessoaCandidata.getNumero() == numero) {
        System.out.println("Número da pessoa candidata já utilizado!");
      } else {
        PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
        pessoasCandidatas.add(pessoaCandidata);
      }
    }
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora indexPessoaEleitora : pessoasEleitoras) {
      if (cpf.equals(indexPessoaEleitora.getCpf())) {
        System.out.println("Pessoa eleitora já cadastrada!");
      } else {
        PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
        pessoasEleitoras.add(pessoaEleitora);
      }
    }
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {

  }

  @Override
  public void mostrarResultado() {

  }
}
