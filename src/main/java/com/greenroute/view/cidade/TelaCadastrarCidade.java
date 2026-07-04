package com.greenroute.view.cidade;

import com.greenroute.controller.CidadeController;
import com.greenroute.model.Cidade;

import javax.swing.*;
import java.awt.*;

public class TelaCadastrarCidade extends JFrame {

    private CidadeController cidadeController;

    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtEstado;
    private JTextField txtDistancia;

    private JButton btnSalvar;
    private JButton btnCancelar;

    public TelaCadastrarCidade(CidadeController cidadeController) {

        this.cidadeController = cidadeController;

        setTitle("Cadastrar Cidade");

        setSize(350, 300);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel painelFormulario = new JPanel();

        painelFormulario.setLayout(new GridLayout(4, 2, 10, 10));

        painelFormulario.setBorder(
                BorderFactory.createTitledBorder("Dados da Cidade"));

        painelFormulario.add(new JLabel("ID:"));
        txtId = new JTextField();
        painelFormulario.add(txtId);

        painelFormulario.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelFormulario.add(txtNome);

        painelFormulario.add(new JLabel("Estado:"));
        txtEstado = new JTextField();
        painelFormulario.add(txtEstado);

        painelFormulario.add(new JLabel("Distância da Capital (km):"));
        txtDistancia = new JTextField();
        painelFormulario.add(txtDistancia);

        add(painelFormulario, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();

        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");

        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnCancelar);

        add(painelBotoes, BorderLayout.SOUTH);

        btnSalvar.addActionListener(e -> {

            try {

                int id = Integer.parseInt(txtId.getText());

                if (cidadeController.buscarCidadePorId(id) != null) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Já existe uma cidade com esse ID!"
                    );

                    return;
                }

                String nome = txtNome.getText();

                String estado = txtEstado.getText();

                double distancia =
                        Double.parseDouble(txtDistancia.getText());

                Cidade cidade = new Cidade(
                        id,
                        nome,
                        estado,
                        distancia
                );

                cidadeController.cadastrarCidade(cidade);

                JOptionPane.showMessageDialog(
                        this,
                        "Cidade cadastrada com sucesso!"
                );

                dispose();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Erro ao cadastrar cidade!"
                );
            }

        });

        btnCancelar.addActionListener(e -> dispose());

    }

}
