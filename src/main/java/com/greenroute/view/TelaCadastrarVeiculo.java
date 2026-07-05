package com.greenroute.view;

import java.awt.GridLayout;
//import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.greenroute.controller.VeiculoController;
import com.greenroute.model.VeiculoEletrico;
import com.greenroute.model.VeiculoHibrido;

public class TelaCadastrarVeiculo extends JFrame{
    
    private VeiculoController controller;

    private JLabel lblTitulo;

    private JLabel lblTipo;
    private JComboBox<String> cbTipo;

    private JLabel lblId;
    private JTextField txtId;

    private JLabel lblModelo;
    private JTextField txtModelo;

    private JLabel lblAutonomia;
    private JTextField txtAutonomia;

    private JLabel lblCarga;
    private JTextField txtCarga;

    private JLabel lblConsumo;
    private JTextField txtConsumo;

    private JLabel lblTempoRecarga;
    private JTextField txtTempoRecarga;

    // Elétrico
    private JLabel lblConector;
    private JTextField txtConector;

    private JLabel lblTempoRapida;
    private JTextField txtTempoRapida;

    // Híbrido
    private JLabel lblTanque;
    private JTextField txtTanque;

    private JLabel lblConsumoComb;
    private JTextField txtConsumoComb;

    private JLabel lblTipoComb;
    private JTextField txtTipoComb;

    private JLabel lblCombAtual;
    private JTextField txtCombAtual;

    private JButton btnCadastrar;
    private JButton btnLimpar;
    private JButton btnVoltar;

    public TelaCadastrarVeiculo(VeiculoController controller) {
        this.controller = controller;

        setTitle("GreenRoute");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(11, 1, 10, 10));

        lblTitulo = new JLabel("CADASTRO DE VEÍCULO");

        lblTipo = new JLabel("Tipo do veículo:");
        cbTipo = new JComboBox<>();

        cbTipo.addItem("Veículo Elétrico");
        cbTipo.addItem("Veículo Híbrido");

        lblId = new JLabel("ID:");
        txtId = new JTextField(15);

        lblModelo = new JLabel("Modelo:");
        txtModelo = new JTextField(20);

        lblAutonomia = new JLabel("Autonomia Máxima:");
        txtAutonomia = new JTextField(15);

        lblCarga = new JLabel("Carga da Bateria:");
        txtCarga = new JTextField(15);

        lblConsumo = new JLabel("Consumo (kWh/km):");
        txtConsumo = new JTextField(15);

        lblTempoRecarga = new JLabel("Tempo de Recarga:");
        txtTempoRecarga = new JTextField(15);

        // Elétrico

        lblConector = new JLabel("Tipo de Conector:");
        txtConector = new JTextField(15);

        lblTempoRapida = new JLabel("Tempo Recarga Rápida:");
        txtTempoRapida = new JTextField(15);

        // Híbrido

        lblTanque = new JLabel("Capacidade do Tanque:");
        txtTanque = new JTextField(15);

        lblConsumoComb = new JLabel("Consumo Combustível:");
        txtConsumoComb = new JTextField(15);

        lblTipoComb = new JLabel("Tipo de Combustível:");
        txtTipoComb = new JTextField(15);

        lblCombAtual = new JLabel("Combustível Atual:");
        txtCombAtual = new JTextField(15);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(e -> cadastrarVeiculo());

        btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(e -> limparCampos());

        btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            new TelaVeiculos(controller);
            dispose();
        });

        painel.add(lblTitulo);

        painel.add(new JLabel(""));
        painel.add(new JLabel(""));
        painel.add(new JLabel(""));
        

        painel.add(lblTipo);
        painel.add(cbTipo);
        
        
        

        painel.add(lblId);
        painel.add(txtId);

        

        painel.add(lblModelo);
        painel.add(txtModelo);

        
        
        painel.add(lblAutonomia);
        painel.add(txtAutonomia);

        
        

        painel.add(lblCarga);
        painel.add(txtCarga);

        

        painel.add(lblConsumo);
        painel.add(txtConsumo);

        painel.add(lblTempoRecarga);
        painel.add(txtTempoRecarga);

        painel.add(lblConector);
        painel.add(txtConector);

        painel.add(lblTempoRapida);
        painel.add(txtTempoRapida);

        painel.add(lblTanque);
        painel.add(txtTanque);

        painel.add(lblConsumoComb);
        painel.add(txtConsumoComb);

        painel.add(lblTipoComb);
        painel.add(txtTipoComb);

        painel.add(lblCombAtual);
        painel.add(txtCombAtual);

        painel.add(new JLabel(""));
        painel.add(new JLabel(""));

        painel.add(btnCadastrar);
        painel.add(btnLimpar);
        painel.add(btnVoltar);

        add(painel);

        setVisible(true);
    }

    private void cadastrarVeiculo() {
        try {

            int id = Integer.parseInt(txtId.getText());
            String modelo = txtModelo.getText();
            double autonomiaMaxima = Double.parseDouble(txtAutonomia.getText());
            double cargaBateria = Double.parseDouble(txtCarga.getText());
            double consumo = Double.parseDouble(txtConsumo.getText());
            int tempoRecarga = Integer.parseInt(txtTempoRecarga.getText());

            String tipo = cbTipo.getSelectedItem().toString();

            if (tipo.equals("Veículo Elétrico")) {

                String conector = txtConector.getText();
                int tempoRapida = Integer.parseInt(txtTempoRapida.getText());

                VeiculoEletrico eletrico = new VeiculoEletrico(
                        id,
                        modelo,
                        autonomiaMaxima,
                        cargaBateria,
                        consumo,
                        tempoRecarga,
                        conector,
                        tempoRapida
                );

                controller.cadastrar(eletrico);

            } else {

                double tanque = Double.parseDouble(txtTanque.getText());
                double consumoComb = Double.parseDouble(txtConsumoComb.getText());
                String tipoComb = txtTipoComb.getText();
                double combAtual = Double.parseDouble(txtCombAtual.getText());

                VeiculoHibrido hibrido = new VeiculoHibrido(
                        id,
                        modelo,
                        autonomiaMaxima,
                        cargaBateria,
                        consumo,
                        tempoRecarga,
                        tanque,
                        consumoComb,
                        tipoComb,
                        combAtual
                );

                controller.cadastrar(hibrido);

            }

            JOptionPane.showMessageDialog(this,
                    "Veículo cadastrado com sucesso!");

            limparCampos();
            new TelaVeiculos(controller);
            dispose();

        
             

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this,
                    "Digite apenas números nos campos numéricos.");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,
                    e.getMessage());

        }
                    

    }

    private void limparCampos() {

        txtId.setText("");
        txtModelo.setText("");
        txtAutonomia.setText("");
        txtCarga.setText("");
        txtConsumo.setText("");
        txtTempoRecarga.setText("");

        txtConector.setText("");
        txtTempoRapida.setText("");

        txtTanque.setText("");
        txtConsumoComb.setText("");
        txtTipoComb.setText("");
        txtCombAtual.setText("");

        cbTipo.setSelectedIndex(0);
    }
}
