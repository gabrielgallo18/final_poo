package br.univille.poo.app.servico;

import br.univille.poo.app.entidade.Lista;
import br.univille.poo.app.persistencia.ListaDAO;

import java.util.List;

public class ListarListas {

    private ListaDAO dao;

    public ListarListas(){
        dao = new ListaDAO();
    }

    public List<Lista> obterTodos(){
        return dao.obterTodos();
    }

}
