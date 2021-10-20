package s21.palvelinohjelmointi.harjoitustyo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s21.palvelinohjelmointi.harjoitustyo.domain.Flower;
import s21.palvelinohjelmointi.harjoitustyo.domain.FlowerRepository;
import s21.palvelinohjelmointi.harjoitustyo.domain.Flowercategory;
import s21.palvelinohjelmointi.harjoitustyo.domain.FlowercategoryRepository;
import s21.palvelinohjelmointi.harjoitustyo.domain.User;
import s21.palvelinohjelmointi.harjoitustyo.domain.UserRepository;


@SpringBootApplication
public class HarjoitustyoApplication {
	
	private static final Logger log = LoggerFactory.getLogger(HarjoitustyoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(FlowerRepository repository, FlowercategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of students");
			
			crepository.save(new Flowercategory("Viherkasvi"));
			crepository.save(new Flowercategory("Sipulikasvi"));
			crepository.save(new Flowercategory("Ruusu"));
			crepository.save(new Flowercategory("Mehikasvi"));
				
			Flower flower1 = new Flower("Ruusu", "Kastele hyvin", 6, crepository.findByName("Ruusu").get(0));
			Flower flower2 = new Flower("Peikonlehti", "Varjoinen paikka", 15, crepository.findByName("Viherkasvi").get(0));
			Flower flower3 = new Flower("Rahapuu", "Anna kuivahtaa kastelujen välillä", 18, crepository.findByName("Mehikasvi").get(0));
					
			repository.save(flower1);
			repository.save(flower2);
			repository.save(flower3);
			
			User user1 = new User("user", "$2a$10$1DTvwpXVBArGFixHBuzVJObjTuXhIOkx5pse6KsYs8/C2ckxnGEou", "USER");
			User user2 = new User("admin", "$2a$10$cDZgyF4xaPMmmoRW3OVcmuf.8o2YSx8.M7CeRKqi.1PVw.t3E8uEC", "ADMIN");
			
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all books");
			for (Flower flower : repository.findAll()) {
				log.info(flower.toString());
			}
			
			
			
		};	
	}

}
