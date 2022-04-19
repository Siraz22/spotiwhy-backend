package com.example.backend.service;
import com.example.backend.entity.Section;
import com.example.backend.entity.Song;
import com.example.backend.repo.SectionRepo;
import com.example.backend.repo.SongRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PreRemove;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
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

    //reference = https://stackoverflow.com/questions/1082095/how-to-remove-entity-with-manytomany-relationship-in-jpa-and-corresponding-join/14911910#14911910
    @PreRemove
    public void removeSongFromSections(String songId){
        Song songToDelete = songRepo.findById(songId).orElseThrow(()-> new IllegalStateException("Song with this id doesn't exist"));
        List<Section> localSections = sectionRepo.findAll();

        for(Section section : sectionRepo.findAll()){
            log.info("Section before" + String.valueOf(section.getSongs_set()));
            if(section.getSongs_set().contains(songToDelete)){
                section.getSongs_set().remove(songToDelete);
            }
            log.info("Section after" + String.valueOf(section.getSongs_set()));
        }
    }

    public void updateSong(String id, Song song){
        Song existingSong = songRepo.findById(id).orElseThrow(()-> new IllegalStateException("This id doesn't exist"));

        existingSong.setSongName(song.getSongName());
        existingSong.setSongArtist(song.getSongArtist());
    }

}
