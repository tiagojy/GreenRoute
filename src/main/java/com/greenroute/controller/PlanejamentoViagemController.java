package com.greenroute.controller;

import com.greenroute.model.Cidade;
import com.greenroute.model.Veiculo;

import java.util.Scanner;

public class PlanejamentoViagemController {

    private VeiculoController veiculoController;
    private CidadeController cidadeController;

    public PlanejamentoViagemController(VeiculoController veiculoController,
                                        CidadeController cidadeController) {
        this.veiculoController = veiculoController;
        this.cidadeController = cidadeController;
    }

    public void menuPlanejamento() {

        Scanner sc = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("\n=== PLANEJAMENTO DE VIAGEM ===");
            System.out.println("1 - Planejar Viagem");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    planejarViagem();
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    public void planejarViagem() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o ID do veículo: ");
        int idVeiculo = sc.nextInt();

        System.out.print("Digite o ID da cidade de destino: ");
        int idCidade = sc.nextInt();

        Veiculo veiculo = veiculoController.procurarId(idVeiculo);
        Cidade cidade = cidadeController.procurarId(idCidade);

        if (veiculo == null) {
            System.out.println("Veículo não encontrado!");
            return;
        }

        if (cidade == null) {
            System.out.println("Cidade não encontrada!");
            return;
        }

        double autonomiaAtual = veiculo.calcularAutonomia();
        double distanciaDestino = cidade.getDistanciaDaCapital();

        System.out.println("\n=== RESULTADO DA VIAGEM ===");
        System.out.println("Veículo: " + veiculo.getModelo());
        System.out.println("Cidade: " + cidade.getNome());
        System.out.println("Autonomia Atual: " + autonomiaAtual + " km");
        System.out.println("Distância do destino: " + distanciaDestino + " km");

        if (autonomiaAtual >= distanciaDestino) {

            double autonomiaRestante = autonomiaAtual - distanciaDestino;

            System.out.println("Viagem possível sem necessidade de recarga.");
            System.out.println("Autonomia restante após a viagem: "
                    + autonomiaRestante + " km");

        } else {

            double distanciaFaltante = distanciaDestino - autonomiaAtual;

            System.out.println("Autonomia insuficiente para chegar ao destino.");
            System.out.println("Faltam " + distanciaFaltante
                    + " km de autonomia para concluir a viagem.");
            System.out.println("Sugestão: procurar um eletroposto para recarga.");
        }
    }
}
