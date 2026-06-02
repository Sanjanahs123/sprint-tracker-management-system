package com.tekravio.tracker.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tekravio.tracker.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
