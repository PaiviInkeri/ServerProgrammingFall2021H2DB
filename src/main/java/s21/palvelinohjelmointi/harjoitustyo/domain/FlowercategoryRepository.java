package s21.palvelinohjelmointi.harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FlowercategoryRepository extends CrudRepository<Flowercategory, Long>{

	List<Flowercategory> findByName(String name);

}
