package com.example.backend.controller;

import com.example.backend.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/api/v1/")
public class SectionController {

    @Autowired
    private final SectionService sectionService;

    @GetMapping(path="/testing")
    public String getMessage(){
        return "Hello World";
    }

}
