package com.example.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="song")
public class Song {
    @Id
    @Column(name="id")
    private String songID;
    @Column(name="song_url")
    private String songURL;
    @Column(name="song_name")
    private String songName;
    @Column(name="song_artist")
    private String songArtist;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "songs_set")
    private Set<Section> sections_set = new HashSet<>();
}
