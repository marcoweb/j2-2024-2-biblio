package application.repository;

import org.springframework.data.repository.CrudRepository;

import application.model.Autor;

public interface AutorRepository extends CrudRepository<Autor, Long> {
    
}