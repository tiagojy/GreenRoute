package com.greenroute.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaVeiculos extends JFrame {

    private JButton btnCadastrar;
    private JButton btnListar;
    private JButton btnBuscar;
    private JButton btnAtualizar;
    private JButton btnRemover;
    private JButton btnVoltarTelaPrincipal;

    public TelaVeiculos() {

        setTitle("Cadastro de Veículo");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnCadastrar = new JButton("Cadastrar Veículos");
        btnListar = new JButton("Listar Veículos");
        btnBuscar = new JButton("Buscar Veículo");
        btnAtualizar = new JButton("Atualizar Veículo");
        btnRemover = new JButton("Remover Veículo");

        btnVoltarTelaPrincipal = new JButton("Voltar ao Menu Principal");
        btnVoltarTelaPrincipal.addActionListener(e -> {
            new TelaPrincipal();
            dispose();
        });

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(11, 1, 10, 10));

        painel.add(btnCadastrar);
        painel.add(btnListar);
        painel.add(btnBuscar);
        painel.add(btnAtualizar);
        painel.add(btnRemover);
        painel.add(btnVoltarTelaPrincipal);

        add(painel);

        setVisible(true);
    }
}