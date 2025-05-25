package com.xwz.frota.frota_api.service;

import com.xwz.frota.frota_api.model.Carro;
import com.xwz.frota.frota_api.model.Moto;
import com.xwz.frota.frota_api.model.Veiculo;
import com.xwz.frota.frota_api.repository.VeiculoRepository;
import com.xwz.frota.frota_api.repository.VeiculoRepositoryCustomImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    public Veiculo atualizarVeiculo(int id, Veiculo novoVeiculo) {
        Optional<Veiculo> veiculoExistente = veiculoRepository.findById(id);

        if (veiculoExistente.isEmpty()) {
            throw new RuntimeException("Veículo com ID " + id + " não encontrado");
        }

        Veiculo veiculo = veiculoExistente.get();

        veiculo.setModelo(novoVeiculo.getModelo());
        veiculo.setFabricante(novoVeiculo.getFabricante());
        veiculo.setAno(novoVeiculo.getAno());
        veiculo.setPreco(novoVeiculo.getPreco());
        veiculo.setCor(novoVeiculo.getCor());

        if (veiculo instanceof Carro && novoVeiculo instanceof Carro) {
            ((Carro) veiculo).setQuantidadePortas(((Carro) novoVeiculo).getQuantidadePortas());
            ((Carro) veiculo).setTipoCombustivel(((Carro) novoVeiculo).getTipoCombustivel());
        } else if (veiculo instanceof Moto && novoVeiculo instanceof Moto) {
            ((Moto) veiculo).setCilindrada(((Moto) novoVeiculo).getCilindrada());
        } else {
            throw new RuntimeException("Tipo de veículo incompatível para atualização.");
        }

        return veiculoRepository.save(veiculo);
    }


    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> buscarPorId(int id) {
        return veiculoRepository.findById(id);
    }

    // Salva ou atualiza um veículo
    public Veiculo salvar(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public void excluirPorId(Integer id) {
        if (!veiculoRepository.existsById(id)) {
            throw new RuntimeException("Veículo com ID " + id + " não encontrado");
        }
        veiculoRepository.deleteById(id);
    }

    public List<Veiculo> buscarPorFiltros(String tipo, String modelo, String cor, Integer ano) {
        return veiculoRepository.buscarPorFiltros(tipo, modelo, cor, ano);
    }
    // E assim por diante, conforme seus filtros
}
