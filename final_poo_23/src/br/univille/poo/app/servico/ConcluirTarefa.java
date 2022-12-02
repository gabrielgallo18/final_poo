package br.univille.poo.app.servico;

import br.univille.poo.app.persistencia.TarefaDAO;

public class ConcluirTarefa {


    private TarefaDAO dao;

    public ConcluirTarefa(){
        dao = new TarefaDAO();
    }

    public void concluir(Integer idTarefa) throws Exception {
        dao.atualizar(idTarefa);
    }

}
