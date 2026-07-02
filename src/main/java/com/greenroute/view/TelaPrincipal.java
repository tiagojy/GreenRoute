package com.greenroute.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaPrincipal extends JFrame {

    private JButton btnVeiculos;
    private JButton btnAutonomia;
    private JButton btnCidades;
    private JButton btnEletropostos;
    private JButton btnPlanejamento;
    private JButton btnSair;

    public TelaPrincipal() {

        setTitle("GreenRoute");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(11, 1, 10, 10));

        JLabel titulo = new JLabel("GREEN ROUTE", JLabel.CENTER);

        btnVeiculos = new JButton("Gerenciar Veículos");
        btnVeiculos.addActionListener(e -> {
            new TelaVeiculos();
            dispose();
        });

        btnAutonomia = new JButton("Calcular Autonomia");
        btnCidades = new JButton("Gerenciar Cidades");
        btnEletropostos = new JButton("Gerenciar Eletropostos");
        btnPlanejamento = new JButton("Planejamento de Viagem");
        btnSair = new JButton("Sair");

        painel.add(titulo);
        painel.add(btnVeiculos);
        painel.add(btnAutonomia);
        painel.add(btnCidades);
        painel.add(btnEletropostos);
        painel.add(btnPlanejamento);
        painel.add(btnSair);

        add(painel);

        btnSair.addActionListener(e -> System.exit(0));

        setVisible(true);
    }
}
