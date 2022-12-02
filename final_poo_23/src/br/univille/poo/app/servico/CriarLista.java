package br.univille.poo.app.servico;

import br.univille.poo.app.persistencia.ListaDAO;

public class CriarLista {

    private ListaDAO dao;

    public   CriarLista(){
        dao = new ListaDAO();
    }

    public void criar(String listaName) throws Exception {
        dao.inserir(listaName);

    }

    

}
