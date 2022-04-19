package com.example.backend.controller;
import com.example.backend.entity.Song;
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

    @DeleteMapping(path="/deleteSong")
    public ResponseEntity<?> deleteSong(String id){
        songService.deleteSong(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path="/updateSong")
    public ResponseEntity<?> updateSong(String id, Song song) {
        songService.updateSong(id, song);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path="/addSongToSection")
    public ResponseEntity<?> songToSection(String songId, String sectionId){
        songService.addSongToSection(songId, sectionId);
        return ResponseEntity.ok().build();
    }
}
