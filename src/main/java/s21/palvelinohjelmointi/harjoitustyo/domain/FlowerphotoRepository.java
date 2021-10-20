package s21.palvelinohjelmointi.harjoitustyo.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface FlowerphotoRepository  extends CrudRepository<Flowerphoto, Long>{

//	List<Flowerphoto> findAll();
//	List<Flowerphoto> findByName(String photoname);
//	void save(Optional<Flowerphoto> findById);
}
