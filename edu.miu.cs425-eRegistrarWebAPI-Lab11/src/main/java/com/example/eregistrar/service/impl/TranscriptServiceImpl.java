package com.example.eregistrar.service.impl;



import com.example.eregistrar.model.Transcript;
import com.example.eregistrar.repository.TranscriptRepository;
import com.example.eregistrar.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranscriptServiceImpl implements TranscriptService {

    @Autowired
    private TranscriptRepository transcriptRepository;

    @Override
    public Transcript save(Transcript t) {
        return transcriptRepository.save(t);
    }
}
