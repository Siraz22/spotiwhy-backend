package com.example.backend;

import com.example.backend.entity.Section;
import com.example.backend.entity.Song;
import com.example.backend.repo.SectionRepo;
import com.example.backend.repo.SongRepo;
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

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Section section1 = new Section("sectionid1","section1","photourl","owner1",new HashSet<>());
//		Section section2 = new Section("sectionid2","section2","photourl","owner1",new HashSet<>());
//
//		Song song0 = new Song("songid0","url0","song0","artist1",new HashSet<>());
//		Song song1 = new Song("songid1","url1","song1","artist2",new HashSet<>());
//
//		section1.getSongs_set().add(song0);
//		section1.getSongs_set().add(song1);
//		section2.getSongs_set().add(song0);
//
//		//song1.getSections_set().add(section1);
//		//song2.getSections_set().add(section1);
//		//song1.getSections_set().add(section2);
//
//		this.sectionRepo.save(section1);
//		this.sectionRepo.save(section2);
//
//

		Section defaultSection = new Section("defaultSection", "Default Section", "","siraz",new HashSet<>());
		//Song song2 = new Song("songid2","url2","song2","artist1",new HashSet<>());

		this.sectionRepo.save(defaultSection);
		//this.songRepo.save(song2);

	}
}
