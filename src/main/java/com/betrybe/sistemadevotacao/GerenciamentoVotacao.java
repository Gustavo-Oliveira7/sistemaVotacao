package com.betrybe.sistemadevotacao;

import java.util.ArrayList;
import java.util.Objects;

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
      }
    }
    PessoaCandidata pessoaCandidata = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(pessoaCandidata);
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora indexPessoaEleitora : pessoasEleitoras) {
      if (Objects.equals(indexPessoaEleitora.getCpf(), cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
      }
    }
    PessoaEleitora pessoaEleitora = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(pessoaEleitora);
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    for (String indexCpfs : cpfsComputados) {
      if (Objects.equals(indexCpfs, cpfPessoaEleitora)) {
        System.out.println("Pessoa eleitora já votou!");
      }
    }
    for (PessoaCandidata indexPessoaCandidata : pessoasCandidatas) {
      if (indexPessoaCandidata.getNumero() == numeroPessoaCandidata) {
        indexPessoaCandidata.receberVoto();
        cpfsComputados.add(cpfPessoaEleitora);
      }
    }
  }

  @Override
  public void mostrarResultado() {
    if (cpfsComputados.isEmpty()) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    } else {
      int votosTotais = cpfsComputados.size();

      for (PessoaCandidata indexPessoa : pessoasCandidatas) {
        int votosRecebidos = indexPessoa.getVotos();
        System.out.println("Nome: "
            + indexPessoa.getNome()
            + " - "
            + votosRecebidos
            + " votos ( "
            + Math.round((float) (votosRecebidos * 100) / votosTotais));
      }
      System.out.println("Total de votos: " + votosTotais);
    }

  }
}
