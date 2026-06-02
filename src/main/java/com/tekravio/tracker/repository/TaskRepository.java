package com.tekravio.tracker.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.tekravio.tracker.model.TaskPriority;
import com.tekravio.tracker.model.TaskStatus;
import com.tekravio.tracker.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findByStatusAndPriorityAndSprintId(
	        TaskStatus status,
	        TaskPriority priority,
	        Long sprintId);
}
