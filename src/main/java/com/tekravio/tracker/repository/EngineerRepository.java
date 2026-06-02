package com.tekravio.tracker.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.tekravio.tracker.model.PrimaryStack;
import com.tekravio.tracker.model.Engineer;

public interface EngineerRepository extends JpaRepository<Engineer, Long> {
	List<Engineer> findByPrimaryStackAndIsAvailable(
	        PrimaryStack primaryStack,
	        Boolean isAvailable);
}