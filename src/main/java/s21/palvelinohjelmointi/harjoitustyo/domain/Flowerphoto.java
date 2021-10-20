package s21.palvelinohjelmointi.harjoitustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

@Entity
public class Flowerphoto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	private String photoname;
	private String phototype;
	@Lob
	private byte[] photo;
	
	public Flowerphoto() {}
	
	public Flowerphoto(String photoname, String phototype, byte[] photo) {
		super();
		this.photoname = photoname;
		this.phototype = phototype;
		this.photo = photo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPhotoname() {
		return photoname;
	}

	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}

	public String getPhototype() {
		return phototype;
	}

	public void setPhototype(String phototype) {
		this.phototype = phototype;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	
	
	

}
