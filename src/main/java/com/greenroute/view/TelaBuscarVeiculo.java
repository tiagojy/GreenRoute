package com.greenroute.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.greenroute.controller.VeiculoController;

public class TelaBuscarVeiculo extends JFrame{
    private VeiculoController controller;

    private JButton btnBuscar;
    private JButton btnLimpar;
    private JButton btnVoltar;

    public TelaBuscarVeiculo(VeiculoController controller) {
        this.controller = controller;
        
        setTitle("Buscar Veículo");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(11, 1, 10, 10));

        JLabel titulo = new JLabel("BUSCAR VEÍCULO", JLabel.CENTER);

        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(e -> buscarVeiculo());

        btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(e -> limparCampos());

        btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            new TelaVeiculos(controller);
            dispose();
        });

        painel.add(titulo);

        painel.add(btnBuscar);
        painel.add(btnLimpar);
        painel.add(btnVoltar);
        
        add(painel);

        setVisible(true);    
    }

    private void buscarVeiculo() {}

    private void limparCampos() {}
}
