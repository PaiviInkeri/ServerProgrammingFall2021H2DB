package s21.palvelinohjelmointi.harjoitustyo.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

//interface extending CrudRepository has methods for db-operations without
//inserting SQL queries
public interface FlowerRepository extends CrudRepository<Flower, Long>{

	List<Flower> findAll();
	List<Flower> findByName(String name);
	void save(Optional<Flower> findById);
}

