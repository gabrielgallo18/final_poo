package br.univille.poo.app.view;

import javax.swing.*;

import br.univille.poo.app.entidade.Tarefa;
import br.univille.poo.app.servico.CriaLista;

import br.univille.poo.app.servico.CriarTarefa;

import br.univille.poo.app.servico.ListarTarefas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame {

    private CriaLista criaLista = new CriaLista();
    private JPanel panel;
    private JTextArea campoTextArea;
    private JComboBox<String> opcoesComboBox;
    private ViewListener listener;
    private String[] opcoes = {"Alta","Média","Baixa"};

    public Janela(){
        setTitle("Cadastro de Tarefas");
        setSize(800,550);
        configurarJanela();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addListener(ViewListener listener){
        this.listener = listener;
    }

    private void configurarJanela() {
        panel = new JPanel();
        panel.setLayout(null);

        campoTextArea = new JTextArea(40,100);
        campoTextArea.setBounds(50,40,700,90);
        campoTextArea.setBorder(BorderFactory.createLineBorder(getForeground()));



        JLabel label = new JLabel("Tarefa");
        label.setBounds(50,10,200,30);
        label.setOpaque(true);




        JLabel label2 = new JLabel("Prioridade");
        label2.setBounds(50,200,200,60);
        label2.setOpaque(true);

        opcoesComboBox = new JComboBox<>(opcoes);
        opcoesComboBox.setBounds(50,260,700,30);

        JButton salvarBotao = new JButton("Inserir");
        salvarBotao.setBounds(650, 380, 100, 25);
        salvarBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // listener.onSalvar();
                Tarefa t = new Tarefa();
                t.setDescricao(campoTextArea.getText());
                t.setConcluido(false);
                CriarTarefa t1 = new CriarTarefa();
                System.out.println(t1);
                try {
                    t1.criar(t);
                    ListarTarefas listarTarefas = new ListarTarefas();
                    for(Tarefa t2 : listarTarefas.obterTodos()){
                    System.out.println(t2);
                    }
                } catch (Exception ex) {

                    ex.printStackTrace();
                }
            }
        });

        JButton cancelarBotao = new JButton("Cancelar");
        cancelarBotao.setBounds(530, 380, 100, 25);

        panel.add(label);
        panel.add(label2);
        panel.add(salvarBotao);
        panel.add(cancelarBotao);
        panel.add(opcoesComboBox);
        panel.add(campoTextArea);
        popularLista();
        add(panel);
    }

    private void popularLista(){
        ListarTarefas listarTarefas = new ListarTarefas();
        for(Tarefa t : listarTarefas.obterTodos()){
            panel.add(ItemLista(t));
            panel.add(Box.createVerticalStrut(20));
        }
    }

    private JPanel ItemLista(Tarefa t){
        JPanel panel = new JPanel();
        JLabel label = new JLabel(t.getDescricao());
        JCheckBox CheckBox = new JCheckBox("");
        CheckBox.setSelected(true);

        panel.setBorder(BorderFactory.createEtchedBorder());
        panel.add(label);
        panel.add(CheckBox);
        return panel;
    }

    interface ViewListener{

        void onSalvar();
    }

}
