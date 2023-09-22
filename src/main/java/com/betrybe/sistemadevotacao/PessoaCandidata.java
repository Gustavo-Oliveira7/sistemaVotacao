package com.betrybe.sistemadevotacao;

public class PessoaCandidata extends Pessoa {

  int numero;
  int votos;

  /**
   * Cria classe Pessoa Candidata.
   */
  public PessoaCandidata(String nome, int numero) {
    this.setNome(nome);
    this.numero = numero;
    this.votos = 0;
  }

  public void receberVoto() {
    this.votos += 1;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getVotos() {
    return votos;
  }

  public void setVotos(int votos) {
    this.votos = votos;
  }
  
}
