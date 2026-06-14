import model.Veiculo;
import repository.VeiculoRepository;

public class VeiculoController {

    private VeiculoRepository repository;

    public VeiculoController() {
        repository = new VeiculoRepository();
    }

    public void cadastrar(Veiculo veiculo) {
        repository.adicionar(veiculo);
    }

    public Veiculo buscarPorId(int id) {
        return repository.buscarPorId(id);
    }

    public boolean atualizar(int id, Veiculo novoVeiculo) {
        return repository.atualizar(id, novoVeiculo);
    }

    public boolean remover(int id) {
        return repository.remover(id);
    }

    public void listar() {

        Veiculo[] veiculos = repository.listar();

        for (int i = 0; i < repository.getQuantidade(); i++) {

            System.out.println(
                    "ID: " + veiculos[i].getId()
                    + " | Modelo: " + veiculos[i].getModelo()
            );

        }
    }
}