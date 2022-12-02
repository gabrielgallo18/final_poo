package br.univille.poo.app.entidade;

import java.util.ArrayList;
import java.util.List;

public class Lista {


    private int Lista_id;
    private String Lista_name;
    private List<Tarefa> tarefas;

    public Lista() {
        tarefas = new ArrayList<>();
    }

    public int getLista_id() {
        return Lista_id;
    }    
    public void setLista_id(int lista_id) {
        Lista_id = lista_id;
    }

    public String getLista_name() {
        return Lista_name;
    }
    public void setLista_name(String lista_name) {
        Lista_name = lista_name;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }
    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    @Override
    public String toString() {
        String result ="Id= " + Lista_id + ", Name= " + Lista_name;

        for(Tarefa t : tarefas){
            result =  result +  t.toString();
        }
        return result;
    }
}

