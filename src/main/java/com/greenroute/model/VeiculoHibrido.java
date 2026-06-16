package com.greenroute.model;

public class VeiculoHibrido extends Veiculo {
    private double capacidadeTanqueCombustivel;
    private double consumoCombustivel;
    private String tipoCombustivel;

    public VeiculoHibrido(int id, String modelo, double autonomiaMaxima, double combustivelAtual, double consumoKwhPorKm, int tempoRecargaCompleta, double capacidadeTanqueCombustivel, double consumoCombustivel, String tipoCombustivel) {

        super(id, modelo, autonomiaMaxima, combustivelAtual, consumoKwhPorKm, tempoRecargaCompleta);

        this.capacidadeTanqueCombustivel = capacidadeTanqueCombustivel;
        this.consumoCombustivel = consumoCombustivel;
        this.tipoCombustivel = tipoCombustivel;
    }

    // MÉTODOS GET PARA CADA ATRIBUTO

    public double getCapacidadeTanqueCombustivel() {
        return capacidadeTanqueCombustivel;
    }

    public double getConsumoCombustivel() {
        return consumoCombustivel;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    // MÉTODOS SET PARA CADA ATRIBUTO

    public void setCapacidadeTanqueCombustivel(double capacidadeTanqueCombustivel) {
        this.capacidadeTanqueCombustivel = capacidadeTanqueCombustivel;
    }

    public void setConsumoCombustivel(double consumoCombustivel) {
        this.consumoCombustivel = consumoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    @Override
    public double calcularAutonomia() {
        return 0;
    }
}
