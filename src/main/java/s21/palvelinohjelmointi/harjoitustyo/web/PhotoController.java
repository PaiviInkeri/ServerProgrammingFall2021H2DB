package s21.palvelinohjelmointi.harjoitustyo.web;

import java.io.IOException;	
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import s21.palvelinohjelmointi.harjoitustyo.domain.Flowerphoto;
import s21.palvelinohjelmointi.harjoitustyo.domain.FlowerphotoRepository;

@Controller
public class PhotoController {
	
	//path to file system
	@Value("${upload.path}")
	private String uploadFolder;
	
	//render upload page when "Add a Photo" is clicked
	@GetMapping("/addphoto")
	public String addPhoto() {
		
		return "upload";
	}
	
	@PostMapping("/upload")
	public String uploadPhoto(@RequestParam("file") MultipartFile
			file, Model model, RedirectAttributes redirAttr) {
		
		if (file.isEmpty()) {

			//RedirectAttributes interface stores flash messages in FlashMap data structure
			//as key value pairs. these flash messages survive redirects unlike model attributes
			//However, thymeleaf handles reading them as ordinary model attributes
			redirAttr.addFlashAttribute("error", "Upload failed");
			return "redirect:/flowershop";
			}
		
		//saves picture to folder specified in application properties
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(uploadFolder + file.getOriginalFilename());
			Files.write(path, bytes);
			} catch (IOException e) {
			e.printStackTrace();
			}
		
		
		//an attempt to save pic to db, doesn´t work. Complaining about FlowerphotoRepository.save method
		
//		try {
//			byte[] bytes = file.getBytes();
//			Flowerphoto photo = new Flowerphoto(file.getOriginalFilename(),
//			file.getContentType(), bytes);
//			FlowerphotoRepository.save(photo);
//		//	model.addAttribute("msg", "File " + file.getOriginalFilename() + "
//		//	uploaded");
//			} catch (IOException e) {
//			e.printStackTrace();
//			}
//		
		
			redirAttr.addFlashAttribute("success", "Upload successful");
			return "redirect:/flowershop";
			
	}
		

}
