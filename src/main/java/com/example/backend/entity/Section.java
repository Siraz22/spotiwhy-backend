package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="section")
public class Section {
    @Id
    @Column(name="id")
    private String sectionID;
    @Column(name="section_name")
    private String sectionName;
    @Column(name="section_photourl")
    private String sectionPhotoURL;
    @Column(name="section_ownerid")
    private String sectionOwnerId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="section_songs",
        joinColumns = @JoinColumn(name="section_id"),
        inverseJoinColumns = @JoinColumn(name="song_id")
    )
    private Set<Song> songs_set = new HashSet<>();

}
