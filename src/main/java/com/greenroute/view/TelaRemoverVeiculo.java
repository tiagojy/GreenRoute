package com.greenroute.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaRemoverVeiculo extends JFrame{
    private JButton btnRemoverVeiculo;
    private JButton btnLimpar;
    private JButton btnVoltar;

    public TelaRemoverVeiculo() {
        setTitle("Remover Veículo");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(11, 1, 10, 10));

        JLabel titulo = new JLabel("REMOVER VEÍCULO", JLabel.CENTER);

        btnRemoverVeiculo = new JButton("Remover");
        btnRemoverVeiculo.addActionListener(e -> removerVeiculo());

        btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(e -> limparCampos());

        btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            new TelaVeiculos();
            dispose();
        });

        painel.add(titulo);

        painel.add(btnRemoverVeiculo);
        painel.add(btnLimpar);
        painel.add(btnVoltar);
        add(painel);

        setVisible(true);
    }

    private void removerVeiculo() {}
    private void limparCampos() {}
}
