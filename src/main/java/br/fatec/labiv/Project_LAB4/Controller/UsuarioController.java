package br.fatec.labiv.Project_LAB4.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.labiv.Project_LAB4.entity.Usuario;
import br.fatec.labiv.Project_LAB4.service.UsuarioService;

@RestController
@CrossOrigin
@RequestMapping(value = "/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> todosUsuarios(){
        return service.todosUsuarios();
    }

    @GetMapping(value = "/{id}")
    public Usuario buscarPorId(@PathVariable ("id") Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public Usuario novoUsuario(@RequestBody Usuario usuario){
        return service.novoUsuario(usuario);
    }

}
