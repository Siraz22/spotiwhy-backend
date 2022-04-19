package com.example.backend.controller;
import com.example.backend.entity.Song;
import com.example.backend.service.SectionService;
import com.example.backend.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SongController {

    @Autowired
    final private SongService songService;
    @Autowired
    final private SectionService sectionService;

    @GetMapping(path="/songs")
    public ResponseEntity<List<Song>> getSongs(){
        return ResponseEntity.ok().body(songService.getSongs());
    }

//    @PostMapping(path="/addSong")
//    public ResponseEntity<?> addSong(Song song){
//        songService.addSong(song);
//        //songService.addSongToSection(song.getSongID(),"defaultSection");
//        return ResponseEntity.ok().build();
//    }

    @PostMapping(path="/addSong")
    public void addSong(@RequestBody Song song){
        songService.addSong(song);
        songService.addSongToSection(song.getSongID(),"defaultSection");
    }

//    @DeleteMapping(path="/deleteSong/songId")
//    public ResponseEntity<?> deleteSong(@PathVariable("songId") String id){
//        songService.deleteSong(id);
//        return ResponseEntity.ok().build();
//    }

    @DeleteMapping(path="/deleteSong/{songId}")
    public void deleteSong(@PathVariable("songId") String id){
        //First remove the song from it's parent, ie, the sections that contain this song
        songService.removeSongFromSections(id);
        //Now delete the song
        songService.deleteSong(id);
    }

    @PutMapping(path="/updateSong/{songId}")
    public ResponseEntity<?> updateSong(@PathVariable("songId") String id, @RequestBody Song song) {
        songService.updateSong(id, song);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path="/addSongToSection/{songId}/{sectionId}")
    public ResponseEntity<?> songToSection(@PathVariable("songId") String songId,@PathVariable("sectionId") String sectionId){
        songService.addSongToSection(songId, sectionId);
        return ResponseEntity.ok().build();
    }

}
