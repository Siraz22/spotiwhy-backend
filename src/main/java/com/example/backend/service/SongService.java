package com.example.backend.service;

import com.example.backend.repo.SongRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SongService {

    @Autowired
    final private SongRepo songRepo;

}
