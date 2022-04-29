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

		Section acousticSection = new Section("acoustic", "Acoustics", "https://corporateentertainmentagency.com/wp-content/uploads/2016/02/Vintage-Band-London-1.jpg","siraz","Explore Unplugged Music",new HashSet<>());
		Section soloSection = new Section("solo", "Solo Covers", "https://c4.wallpaperflare.com/wallpaper/508/967/634/audience-band-concert-crowd-wallpaper-preview.jpg","siraz","Songs of solo artist",new HashSet<>());
		Section beatlesSection = new Section("beatles", "The Beatles", "https://c4.wallpaperflare.com/wallpaper/896/440/837/music-album-covers-the-beatles-abbey-road-wallpaper-preview.jpg","siraz","John Lennon, Paul McCartney, George Harrison and Ringo Starr",new HashSet<>());
		Section auroraSection = new Section("aurora", "AURORA", "https://img.apmcdn.org/d8d2d1cfa612fafbbd22d866c48654d5520fb442/uncropped/97e9f3-20190228-aurora-performs-in-the-current-studio-03.jpg","siraz","Music from Norway. Meep Moop",new HashSet<>());
		Section coverSection = new Section("covers", "Cover Songs", "https://wallpaperaccess.com/full/93287.jpg","siraz","Better than the Studio Version?",new HashSet<>());
		Section taylorSection = new Section("taylorswift", "Taylor Swift", "https://pbs.twimg.com/media/FMXiDoWacAI2nlX?format=jpg&name=4096x4096","siraz","You need to Calm Down",new HashSet<>());

		Song song1 = new Song("songid1","https://www.youtube.com/watch?v=C1azs50n5r0","I Don't Care - Fingerstyle Cover","Eddie Van Deer Meer","https://i.ytimg.com/vi/C1azs50n5r0/hqdefault.jpg",new HashSet<>());
		Song song2 = new Song("songid2","https://www.youtube.com/watch?v=9KAQaKydqA0","Daydreamer","Aurora","https://i.ytimg.com/vi/9KAQaKydqA0/hqdefault.jpg",new HashSet<>());
		Song song3 = new Song("songid3","https://www.youtube.com/watch?v=2SUwOgmvzK4","The Less I Know the Better","Tame Impala","https://i.ytimg.com/vi/2SUwOgmvzK4/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAEG6PLv9i5OMY5VPH3iPppPr1QQw",new HashSet<>());
		Song song4 = new Song("songid4","https://www.youtube.com/watch?v=2GGRdwfhl-U","Riptide - Taylor Swift Cover","Taylor Swift","https://i.ytimg.com/vi/2GGRdwfhl-U/hqdefault.jpg",new HashSet<>());
		Song song5 = new Song("songid5","https://www.youtube.com/watch?v=N78b0BOIwXo","Forgotten Love","Aurora","https://i.ytimg.com/vi/N78b0BOIwXo/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDy8-c_NJBgAy8XomQ0hKqPAlNwvw",new HashSet<>());
		Song song6 = new Song("songid6","https://www.youtube.com/watch?v=KQetemT1sWc","Here Comes the Sun","The Beatles","https://i.ytimg.com/vi/KQetemT1sWc/hqdefault.jpg",new HashSet<>());

		this.sectionRepo.save(acousticSection);
		this.sectionRepo.save(soloSection);
		this.sectionRepo.save(auroraSection);
		this.sectionRepo.save(coverSection);
		this.sectionRepo.save(beatlesSection);
		this.sectionRepo.save(taylorSection);

		this.songRepo.save(song1);
		this.songRepo.save(song2);
		this.songRepo.save(song3);
		this.songRepo.save(song4);
		this.songRepo.save(song5);
		this.songRepo.save(song6);

//		acousticSection.getSongs_set().add(song1);
//		acousticSection.getSongs_set().add(song2);
//		soloSection.getSongs_set().add(song1);

		songService.addSongToSection("songid1", "acoustic");
		songService.addSongToSection("songid1", "solo");
		songService.addSongToSection("songid1", "covers");

		songService.addSongToSection("songid2", "acoustic");
		songService.addSongToSection("songid2", "aurora");

		songService.addSongToSection("songid3", "solo");

		songService.addSongToSection("songid4", "solo");
		songService.addSongToSection("songid4", "taylorswift");
		songService.addSongToSection("songid4", "covers");

		songService.addSongToSection("songid5", "aurora");
		songService.addSongToSection("songid5", "solo");
		songService.addSongToSection("songid5", "acoustic");

		songService.addSongToSection("songid6", "beatles");

	}
}
