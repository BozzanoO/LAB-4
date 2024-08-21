package br.fatec.labiv.Project_LAB4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.fatec.labiv.Project_LAB4.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    
}