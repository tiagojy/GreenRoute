public class VeiculoRepository {
    private Veiculo[] veiculos;
    private int quantidade;

    public VeiculoRepository() {
        veiculos = new Veiculo[5];
        quantidade = 0;
    }

    public void adicionar(Veiculo veiculo) {

        if (quantidade < veiculos.length) {

            veiculos[quantidade] = veiculo;
            quantidade++;
        }
    }

    public Veiculo buscar(int indice) {

        if (indice >= 0 && indice < quantidade) {
            return veiculos[indice];
        }

        return null;
    }

    public void atualizar(int indice, Veiculo veiculo) {

        if (indice >= 0 && indice < quantidade) {
            veiculos[indice] = veiculo;
        }
    }

    public void remover(int indice) {

        if (indice >= 0 && indice < quantidade) {

            for (int i = indice; i < quantidade - 1; i++) {
                veiculos[i] = veiculos[i + 1];
            }

            veiculos[quantidade - 1] = null;
            quantidade--;
        }
    }

    public void listar() {
        for (int i = 0; i < quantidade; i++) {
            System.out.println(veiculos[i].getModelo() + " - Autonomia: " + veiculos[i].calcularAutonomia() + " km");
        }
    }
}