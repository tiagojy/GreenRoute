package com.greenroute.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.greenroute.controller.VeiculoController;
import com.greenroute.model.Veiculo;
import com.greenroute.model.VeiculoEletrico;

public class TelaListarVeiculos extends JFrame{
    private VeiculoController controller;

    private JTable tabelaVeiculos;
    private JScrollPane scrollTabela;
    private JButton btnListarVeiculos;
    private JButton btnAtualizarLista;
    private JButton btnVoltar;

    public TelaListarVeiculos(VeiculoController controller) {
        this.controller = controller;

        tabelaVeiculos = new JTable();
        scrollTabela = new JScrollPane(tabelaVeiculos);

        

        setTitle("Listar Veículos");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(11, 1, 10, 10));

        JLabel titulo = new JLabel("LISTAR VEÍCULOS", JLabel.CENTER);

        btnListarVeiculos = new JButton("Listar");
        btnListarVeiculos.addActionListener(e -> listarVeiculos());

        btnAtualizarLista = new JButton("Atualizar");
        btnAtualizarLista.addActionListener(e -> atualizarLista());

        btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            new TelaVeiculos();
            dispose();
        });

        painel.add(titulo);

        painel.add(scrollTabela);

        painel.add(btnListarVeiculos);
        painel.add(btnAtualizarLista);
        painel.add(btnVoltar);
        add(painel);

        carregarTabela();
        setVisible(true);
    }

    private void listarVeiculos() {}

    private void carregarTabela() {

        String[] colunas = {
            "ID",
            "Modelo",
            "Tipo",
            "Autonomia",
            "Carga"
        };

        DefaultTableModel modeloTabela =
                new DefaultTableModel(colunas, 0);

        for (Veiculo v : controller.listar()) {

            String tipo;

            if (v instanceof VeiculoEletrico) {
                tipo = "Elétrico";
            } else {
                tipo = "Híbrido";
            }

            modeloTabela.addRow(new Object[]{

                v.getId(),
                v.getModelo(),
                tipo,
                v.getAutonomiaMaxima(),
                v.getCargaBateriaAtual()

            });

        }

        tabelaVeiculos.setModel(modeloTabela);
    }

    private void atualizarLista() {
        carregarTabela();
    }
}
