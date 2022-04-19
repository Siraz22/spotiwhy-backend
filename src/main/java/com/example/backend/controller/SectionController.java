package com.example.backend.controller;

import com.example.backend.entity.Section;
import com.example.backend.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
//@RequestMapping(path="/api/v1/")
public class SectionController {

    @Autowired
    private final SectionService sectionService;

    @GetMapping(path="/testing")
    public String getMessage(){
        return "Hello World";
    }

    @GetMapping(path="/sections")
    public ResponseEntity<List<Section>> getSections(){
        return ResponseEntity.ok().body(sectionService.getSections());
    }

//    @PostMapping(path="/addSection")
//    public ResponseEntity<?> addSection(Section section){
//        sectionService.addSection(section);
//        return ResponseEntity.ok().build();
//    }

    @PostMapping(path="/addSection")
    public void addSection(@RequestBody Section section){
        sectionService.addSection(section);
    }

    @DeleteMapping(path="/deleteSection/{sectionId}")
    public ResponseEntity<?> deleteSection(@PathVariable("sectionId") String id){
        sectionService.deleteSection(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path="/updateSection/{sectionId}")
    public ResponseEntity<?> updateSection(@PathVariable("sectionId") String id, Section section){
        sectionService.updateSection(id, section);
        return ResponseEntity.ok().build();
    }
}
