package com.example.backend.service;

import com.example.backend.entity.Section;
import com.example.backend.repo.SectionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SectionService {

    @Autowired
    private final SectionRepo sectionRepo;

    public List<Section> getSections(){
        return sectionRepo.findAll();
    }

    public void deleteSection(String id){
        sectionRepo.deleteById(id);
    }

    public void addSection(Section section){
        sectionRepo.save(section);
    }

    @Transactional
    public void updateSection(String id, Section section){
        Section existingSection = sectionRepo.findById(id).orElseThrow(()-> new IllegalStateException("This id doesn't exist"));

        existingSection.setSectionName(section.getSectionName());
        existingSection.setSectionPhotoURL(section.getSectionPhotoURL());
    }

}