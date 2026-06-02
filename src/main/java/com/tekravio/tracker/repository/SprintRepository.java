package com.tekravio.tracker.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tekravio.tracker.model.Sprint;

public interface SprintRepository extends JpaRepository<Sprint, Long> {

}
