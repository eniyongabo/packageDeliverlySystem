package miu.edu.cs425.eregistrar.service.impl;




import miu.edu.cs425.eregistrar.model.Transcript;
import miu.edu.cs425.eregistrar.repository.TranscriptRepository;
import miu.edu.cs425.eregistrar.service.TranscriptService;
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
