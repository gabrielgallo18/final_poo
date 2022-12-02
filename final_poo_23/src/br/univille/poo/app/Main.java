package br.univille.poo.app;

import br.univille.poo.app.persistencia.CriarTabelas;
import br.univille.poo.app.view.Janela;

public class Main{
  public static void main(String[] args) {

    Janela j = new Janela();

    CriarTabelas.criarTabelas();
  }

}

