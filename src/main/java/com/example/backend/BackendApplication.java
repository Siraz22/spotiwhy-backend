package com.example.backend;

import com.example.backend.entity.Section;
import com.example.backend.entity.Song;
import com.example.backend.repo.SectionRepo;
import com.example.backend.repo.SongRepo;
import com.example.backend.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner{

	@Autowired
	private SongRepo songRepo;
	@Autowired
	private SectionRepo sectionRepo;
	@Autowired
	private SongService songService;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Section acousticSection = new Section("acoustic", "Acoustic Section", "","siraz",new HashSet<>());
		Section soloSection = new Section("solo", "Solo Artist", "","siraz",new HashSet<>());
		Song song1 = new Song("songid1","https://www.youtube.com/watch?v=C1azs50n5r0","I don't care","Eddie Van Deer Meer",new HashSet<>());
		Song song2 = new Song("songid2","https://www.youtube.com/watch?v=9KAQaKydqA0","Daydreamer","Aurora",new HashSet<>());

		this.sectionRepo.save(acousticSection);
		this.sectionRepo.save(soloSection);
		this.songRepo.save(song1);
		this.songRepo.save(song2);

//		acousticSection.getSongs_set().add(song1);
//		acousticSection.getSongs_set().add(song2);
//		soloSection.getSongs_set().add(song1);

		songService.addSongToSection("songid1", "acoustic");
		songService.addSongToSection("songid1", "solo");
		songService.addSongToSection("songid2", "acoustic");

	}
}
