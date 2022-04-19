package com.example.backend.service;
import com.example.backend.entity.Section;
import com.example.backend.entity.Song;
import com.example.backend.repo.SectionRepo;
import com.example.backend.repo.SongRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SongService {

    @Autowired
    final private SongRepo songRepo;
    @Autowired
    final private SectionRepo sectionRepo;

    public List<Song> getSongs(){
        return songRepo.findAll();
    }

    public void deleteSong(String id){
        //Song has already been removed from it's parent sections via the controller class calling service method of Section
        songRepo.deleteById(id);
    }

    public void addSong(Song song){
        songRepo.save(song);
    }

    public void addSongToSection(String songId, String sectionId){
        Section existingSection = sectionRepo.findById(sectionId).orElseThrow(()-> new IllegalStateException("No such Section"));
        Song existingSong = songRepo.findById(songId).orElseThrow(()-> new IllegalStateException("No such Song"));

        if(existingSong!=null && existingSection!=null){
            existingSection.getSongs_set().add(existingSong);

            //This can be commented out, and still we will get the required normalized table - read more
            //existingSong.getSections_set().add(existingSection);
        }
    }

    public void updateSong(String id, Song song){
        Song existingSong = songRepo.findById(id).orElseThrow(()-> new IllegalStateException("This id doesn't exist"));

        existingSong.setSongName(song.getSongName());
        existingSong.setSongArtist(song.getSongArtist());
    }

}
