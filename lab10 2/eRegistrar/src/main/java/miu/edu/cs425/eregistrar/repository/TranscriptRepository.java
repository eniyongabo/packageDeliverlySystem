package miu.edu.cs425.eregistrar.repository;



import miu.edu.cs425.eregistrar.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Long> {
}
