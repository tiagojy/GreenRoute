package com.greenroute.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.greenroute.controller.VeiculoController;

public class TelaAtualizarVeiculo extends JFrame {
    private VeiculoController controller;

    private JButton btnAtualizar;
    private JButton btnLimpar;
    private JButton btnVoltar;

    public TelaAtualizarVeiculo(VeiculoController controller) {
        this.controller = controller;

        setTitle("Atualizar Veículo");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(11, 1, 10, 10));

        JLabel titulo = new JLabel("ATUALIZAR VEÍCULO", JLabel.CENTER);

        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(e -> atualizarVeiculo());

        btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(e -> limparCampos());

        btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            new TelaVeiculos(controller);
            dispose();
        });

        painel.add(titulo);

        painel.add(btnAtualizar);
        painel.add(btnLimpar);
        painel.add(btnVoltar);

        add(painel);

        setVisible(true);
    }

    private void atualizarVeiculo() {}

    private void limparCampos() {}
}
