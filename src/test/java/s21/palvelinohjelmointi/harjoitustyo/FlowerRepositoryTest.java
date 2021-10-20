package s21.palvelinohjelmointi.harjoitustyo;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import s21.palvelinohjelmointi.harjoitustyo.domain.Flower;
import s21.palvelinohjelmointi.harjoitustyo.domain.FlowerRepository;
import s21.palvelinohjelmointi.harjoitustyo.domain.FlowercategoryRepository;


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class FlowerRepositoryTest {

	@Autowired
	FlowerRepository flowerRepository;
	FlowercategoryRepository fcatRepository;
	
	
	@Test
	public void findByNameTest() {
		List<Flower> flowers = flowerRepository.findByName("Ruusu");
		Assertions.assertThat(flowers.get(0).getName()).isEqualTo("Ruusu");
		
	}
	
	
	//test leaves data into db
//	@Test
//	public void insertNewFlower() {
//		Flower flower = new Flower("Hyasintti", "joulukukka", 10 );
//		flowerRepository.save(flower);
//		List<Flower> flowers = flowerRepository.findByName("Hyasintti");
//		Assertions.assertThat(flowers.get(0).getName()).isEqualTo("Hyasintti");
//
//	}
}
