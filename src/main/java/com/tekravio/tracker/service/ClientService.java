package com.tekravio.tracker.service;
import java.util.List;
import com.tekravio.tracker.dto.ClientRequestDTO;
import com.tekravio.tracker.dto.ClientResponseDTO;

public interface ClientService {

    ClientResponseDTO createClient(ClientRequestDTO dto);

    List<ClientResponseDTO> getAllClients();

    ClientResponseDTO getClientById(Long id);

    ClientResponseDTO updateClient(Long id, ClientRequestDTO dto);

    void deleteClient(Long id);
}
