package com.betrybe.sistemadevotacao;

public class PessoaEleitora extends Pessoa {

  private String cpf;

  /**
   * Cria classe Pessoa Eleitora, receberdo cpf.
   */
  public PessoaEleitora(String nome, String cpf) {
    this.setNome(nome);
    this.setCpf(cpf);

  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getCpf() {
    return cpf;
  }
  
}
