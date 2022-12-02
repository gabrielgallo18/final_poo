package br.univille.poo.app.servico;

import br.univille.poo.app.persistencia.TarefaDAO;

public class VincularTarefa {

    private TarefaDAO dao;

    public VincularTarefa(){
        dao = new TarefaDAO();
    }

    public void vincular(Integer tarefaId, Integer listaId) throws Exception {
        dao.vincular(tarefaId,listaId);
    }
}
