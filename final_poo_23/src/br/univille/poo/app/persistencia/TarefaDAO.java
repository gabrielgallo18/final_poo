package br.univille.poo.app.persistencia;

import br.univille.poo.app.entidade.Lista;
import br.univille.poo.app.entidade.Tarefa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO extends BaseDAO{

    public void inserir(Tarefa tarefa) {
        String sql = "insert into tarefa(descricao, concluido) values(? ,?)";
        try(Connection c = obterConexao();
            PreparedStatement p = c.prepareStatement(sql)){
            p.setString(1,tarefa.getDescricao());
            p.setBoolean(2,tarefa.isConcluido());
            p.execute();
        }catch (SQLException e){
            System.out.println("Erro ao inserir tarefa ");
            e.printStackTrace();
        }
    }

    public void atualizar(Integer idTarefa) {
        String sql = "update tarefa set concluido = true where id = ?";
        try(Connection c = obterConexao();
            PreparedStatement p = c.prepareStatement(sql)){
            p.setInt(1,idTarefa);
            p.execute();
        }catch (SQLException e){
            System.out.println("Erro ao inserir tarefa ");
            e.printStackTrace();
        }
    }

    public void priorizar(Integer idTarefa, String nvlPriori) {
        String sql = "update tarefa set prioridade = ? where id = ?";
        try(Connection c = obterConexao();
            PreparedStatement p = c.prepareStatement(sql)){
            p.setString(1,nvlPriori);
            p.setInt(2,idTarefa);
            p.execute();
        }catch (SQLException e){
            System.out.println("Erro ao colocar tafefa ");
            e.printStackTrace();
        }
    }

    public List<Tarefa> obterTodos() {
        List<Tarefa> lista = new ArrayList<>();
        String sql = "select id, descricao, concluido, prioridade from tarefa";
        try(Connection c = obterConexao();
            PreparedStatement p = c.prepareStatement(sql)){

            ResultSet resultSet = p.executeQuery();
            while(resultSet.next()){
                Tarefa tarefa = new Tarefa();
                tarefa.setId(resultSet.getInt("id"));
                tarefa.setConcluido(resultSet.getBoolean("concluido"));
                tarefa.setDescricao(resultSet.getString("descricao"));
                tarefa.setPrioridade(resultSet.getString("prioridade"));

                lista.add(tarefa);
            }
        }catch (SQLException e){
            System.out.println("Erro a colocar dados na tabela ");
            e.printStackTrace();
        }
        return lista;
    }

    public void vincular(Integer idTarefa, Integer idLista) {
        Tarefa tarefa = new Tarefa();
        String sql1 = "select id, descricao, concluido, prioridade from tarefa where id = ?";
        try(Connection c = obterConexao();
            PreparedStatement p = c.prepareStatement(sql1)){
            p.setInt(1,idTarefa);
            ResultSet resultSetTarefa = p.executeQuery();
            tarefa.setId(resultSetTarefa.getInt("id"));
            tarefa.setConcluido(resultSetTarefa.getBoolean("concluido"));
            tarefa.setDescricao(resultSetTarefa.getString("descricao"));
            tarefa.setPrioridade(resultSetTarefa.getString("prioridade"));
        }catch (SQLException e){
            System.out.println("Erro");
            e.printStackTrace();
        }

        Lista lista = new Lista();
        String sql2 = "select Lista_id, Lista_name from Lista where Lista_id = ?";
        try(Connection c = obterConexao();
            PreparedStatement ps = c.prepareStatement(sql2)){
            ps.setInt(1,idLista);
            ResultSet resultSetLista = ps.executeQuery();
            lista.setLista_id(resultSetLista.getInt("Lista_id"));
            lista.setLista_name(resultSetLista.getString("Lista_name"));
        }catch (SQLException e){
            System.out.println("Erro ao inserir tarefa ");
            e.printStackTrace();
        }

        String sql = "update lista set tarefas = tarefas+"+tarefa.getDescricao()+" where id = ?";
        try(Connection c = obterConexao();
            PreparedStatement p = c.prepareStatement(sql)){
            p.setInt(1,idTarefa);
            p.execute();
        }catch (SQLException e){
            System.out.println("Erro ao inserir tarefa ");
            e.printStackTrace();
        }
    }
}
