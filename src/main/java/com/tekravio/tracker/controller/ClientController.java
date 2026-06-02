package com.tekravio.tracker.controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.tekravio.tracker.dto.ClientRequestDTO;
import com.tekravio.tracker.dto.ClientResponseDTO;
import com.tekravio.tracker.service.ClientService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ClientResponseDTO createClient(
    		@Valid @RequestBody ClientRequestDTO dto) {

        return clientService.createClient(dto);
    }
    
    @GetMapping
    public List<ClientResponseDTO> getAllClients() {
        return clientService.getAllClients();
    }
    
    @GetMapping("/{id}")
    public ClientResponseDTO getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }
    
    @PutMapping("/{id}")
    public ClientResponseDTO updateClient(
            @PathVariable Long id,
            @Valid @RequestBody ClientRequestDTO dto) {

        return clientService.updateClient(id, dto);
    }
    
    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable Long id) {

        clientService.deleteClient(id);

        return "Client deleted successfully";
    }
}
