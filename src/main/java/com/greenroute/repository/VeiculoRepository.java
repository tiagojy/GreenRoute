package com.greenroute.repository;

import com.greenroute.model.Veiculo;

public class VeiculoRepository {
    private Veiculo[] veiculos;
    private int quantidade;

    public VeiculoRepository() {
        veiculos = new Veiculo[10];
        quantidade = 0;
    }

    public void adicionar(Veiculo veiculo) {
        if (quantidade < veiculos.length) {
            veiculos[quantidade] = veiculo;
            quantidade++;
        }
    }

    public Veiculo buscar(int id) {
        if (id >= 0 && id < quantidade) {
            return veiculos[id];
        }

        return null;
    }

    public void atualizar(int id, Veiculo veiculo) {
        if (id >= 0 && id < quantidade) {
            veiculos[id] = veiculo;
        }
    }

    public void remover(int id) {
        if (id >= 0 && id < quantidade) {

            for (int i = id; i < quantidade - 1; i++) {
                veiculos[i] = veiculos[i + 1];
            }

            veiculos[quantidade - 1] = null;
            quantidade--;
        }
    }

    public void listar() {
        System.out.println("=== LISTA DE VEÍCULOS ===");
        for (int i = 0; i < quantidade; i++) {
            System.out.println("Veículo: " + veiculos[i].getModelo() + " - ID: " + veiculos[i].getId() + " - Autonomia: " + veiculos[i].calcularAutonomia() + " km");
        }
    }

    public int getQuantidade() {
        return quantidade;
    }
}