package br.fatec.labiv.Project_LAB4.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.fatec.labiv.Project_LAB4.entity.Anuncio;
import br.fatec.labiv.Project_LAB4.service.AnuncioService;

@RestController
@CrossOrigin
@RequestMapping(value = "/anuncio")
public class AnuncioController {
    @Autowired
    private AnuncioService service;

    @GetMapping
    public List<Anuncio> todosAnuncios(){
        return service.todosAnuncios();
    }

    @PostMapping
    public Anuncio novoAnuncio(@RequestBody Anuncio anuncio){
        return service.novoAnuncio(anuncio);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Anuncio>> buscarPorCondicao(
            @RequestParam Float preco,
            @RequestParam String dataHora) {
        try {
            LocalDateTime dataHoraParsed = LocalDateTime.parse(dataHora);
            List<Anuncio> anuncios = service.findByPrecoLessThanAndDataHoraAfter(preco, dataHoraParsed);
            return new ResponseEntity<>(anuncios, HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(null, e.getStatusCode());
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
