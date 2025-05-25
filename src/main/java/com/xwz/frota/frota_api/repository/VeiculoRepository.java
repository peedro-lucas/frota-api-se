package com.xwz.frota.frota_api.repository;

import com.xwz.frota.frota_api.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> , VeiculoRepositoryCustom{


}




