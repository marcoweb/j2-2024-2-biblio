package application.repository;

import org.springframework.data.repository.CrudRepository;

import application.model.Editora;

public interface EditoraRepository extends CrudRepository<Editora, Long> {
    
}
