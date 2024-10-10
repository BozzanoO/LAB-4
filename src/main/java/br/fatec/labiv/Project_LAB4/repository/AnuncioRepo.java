package br.fatec.labiv.Project_LAB4.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.fatec.labiv.Project_LAB4.entity.Anuncio;

public interface AnuncioRepo extends JpaRepository<Anuncio, Long>{

    List<Anuncio> findByPrecoLessThanAndDataHoraAfter(Float preco, LocalDateTime dataHora);

}
