package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name="song_photo_url")
    private String songPhotoUrl;

    //NOTE : the manytomany attribute that doesn't have join column tag needn't be saved with its own repository.
    //ie, in this case, if we assign a song to a session using session's repository, the song will be saved to the database regardless.

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "songs_set")
    private Set<Section> sections_set = new HashSet<>();
}
