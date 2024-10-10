package br.fatec.labiv.Project_LAB4.service;

import br.fatec.labiv.Project_LAB4.entity.Anuncio;

import java.time.LocalDateTime;
import java.util.List;

public interface AnuncioService {
    
    public List<Anuncio> todosAnuncios();

    public Anuncio novoAnuncio(Anuncio anuncio);

    List<Anuncio> findByPrecoLessThanAndDataHoraAfter(Float preco, LocalDateTime dataHora);
}
