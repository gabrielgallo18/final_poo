package br.univille.poo.app.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.univille.poo.app.entidade.Lista;


public class ListaDAO extends BaseDAO {

    public void inserir(String listaName) {
        String sql = "insert into lista(Lista_name) values(?)";
        try(Connection c = obterConexao();
            PreparedStatement p = c.prepareStatement(sql)){
            p.setString(1,listaName);
            p.execute();
        }catch (SQLException e){
            System.out.println("Erro ao inserir tarefa ");
            e.printStackTrace();
        }
    }

    public List<Lista> obterTodos() {
        List<Lista> listaSuprema = new ArrayList<>();
        String sql = "select Lista_id, Lista_name from Lista";
        try(Connection c = obterConexao();
            PreparedStatement p = c.prepareStatement(sql)){

            ResultSet resultSet = p.executeQuery();
            while(resultSet.next()){
                Lista lista = new Lista();
                lista.setLista_id(resultSet.getInt("Lista_id"));
                lista.setLista_name(resultSet.getString("Lista_name"));

                listaSuprema.add(lista);
            }
        }catch (SQLException e){
            System.out.println("Erro ao ter a todas as tarefas ");
            e.printStackTrace();
        }
        return listaSuprema;
    }

    public void add(String string) {
    }

}
