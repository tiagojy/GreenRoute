package com.greenroute.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.greenroute.controller.VeiculoController;

public class TelaVeiculos extends JFrame {

    private VeiculoController controller;

    private JButton btnCadastrar;
    private JButton btnListar;
    private JButton btnBuscar;
    private JButton btnAtualizar;
    private JButton btnRemover;
    private JButton btnVoltarTelaPrincipal;

    public TelaVeiculos(VeiculoController controller) {
        this.controller = controller;

        setTitle("Cadastro de Veículo");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnCadastrar = new JButton("Cadastrar Veículos");
        btnCadastrar.addActionListener(e -> {
            new TelaCadastrarVeiculo(controller);
            dispose();
        });

        btnListar = new JButton("Listar Veículos");
        btnListar.addActionListener(e -> {
            new TelaListarVeiculos(controller);
            dispose();
        });

        btnBuscar = new JButton("Buscar Veículo");
        btnBuscar.addActionListener(e -> {
            new TelaBuscarVeiculo(controller).setVisible(true);
            dispose();
        });

        btnAtualizar = new JButton("Atualizar Veículo");
        btnAtualizar.addActionListener(e -> {
            new TelaAtualizarVeiculo(controller);
            dispose();
        });

        btnRemover = new JButton("Remover Veículo");
        btnRemover.addActionListener(e -> {
            new TelaRemoverVeiculo(controller);
            dispose();
        });

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