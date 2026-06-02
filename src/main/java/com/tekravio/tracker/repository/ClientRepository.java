package com.tekravio.tracker.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tekravio.tracker.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
