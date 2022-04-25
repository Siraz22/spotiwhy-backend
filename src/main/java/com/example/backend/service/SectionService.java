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

@Service @Slf4j
@RequiredArgsConstructor
@Transactional
public class SectionService {

    @Autowired
    private final SectionRepo sectionRepo;

    @Autowired
    private final SongRepo songRepo;

    public List<Section> getSections(){
        return sectionRepo.findAll();
    }

    public Section getSectionById(String id){
        Section section = sectionRepo.findById(id).orElseThrow(()->new IllegalStateException("This id doens't exist"));
        return section;
    }

    public void deleteSection(String id){
        sectionRepo.deleteById(id);
    }

    public void addSection(Section section){
        sectionRepo.save(section);
    }

    public void updateSection(String id, Section section){
        Section existingSection = sectionRepo.findById(id).orElseThrow(()-> new IllegalStateException("This id doesn't exist"));

        existingSection.setSectionName(section.getSectionName());
        existingSection.setSectionPhotoURL(section.getSectionPhotoURL());
    }

}