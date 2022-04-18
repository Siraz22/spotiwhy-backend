package com.example.backend.service;

import com.example.backend.repo.SectionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SectionService {

    @Autowired
    private final SectionRepo sectionRepo;



}