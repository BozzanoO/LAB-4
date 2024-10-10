package br.fatec.labiv.Project_LAB4.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.fatec.labiv.Project_LAB4.repository.AnuncioRepo;
import br.fatec.labiv.Project_LAB4.entity.Anuncio;

@Service
public class AnuncioServiceImpl implements AnuncioService{
    
    LocalDateTime localDateTime = LocalDateTime.now();
    @Autowired
    private AnuncioRepo repo;

    @Override
    public List<Anuncio> todosAnuncios(){
        return repo.findAll();
    }

    @Transactional
    @Override
    public Anuncio novoAnuncio (Anuncio anuncio){
        if (anuncio == null ||
            anuncio.getNomeProduto() == null ||
            anuncio.getNomeProduto().isBlank()||
            anuncio.getPeso()<0.0||
            anuncio.getPreco()<0.0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos");
        }else if (anuncio.getDataHora()== null) {
            anuncio.setDataHora(localDateTime);
        }
        return repo.save(anuncio);
    }

    @Override
    public List<Anuncio> findByPrecoLessThanAndDataHoraAfter (Float preco, LocalDateTime dataHora){
        List<Anuncio> anuncios = repo.findByPrecoLessThanAndDataHoraAfter(preco, dataHora);
        if (anuncios.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum anúncio encontrado!");
        }
        return anuncios;
    }


}
