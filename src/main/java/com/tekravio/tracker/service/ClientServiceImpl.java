package com.tekravio.tracker.service;
import java.util.List;
import com.tekravio.tracker.dto.ClientRequestDTO;
import com.tekravio.tracker.dto.ClientResponseDTO;
import com.tekravio.tracker.exception.ResourceNotFoundException;
import com.tekravio.tracker.model.Client;
import com.tekravio.tracker.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.tekravio.tracker.dto.ClientRequestDTO;
import com.tekravio.tracker.dto.ClientResponseDTO;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public ClientResponseDTO createClient(ClientRequestDTO dto) {
		Client client = new Client();

	    client.setName(dto.getName());
	    client.setIndustry(dto.getIndustry());
	    client.setContactEmail(dto.getContactEmail());
	    client.setCountry(dto.getCountry());

	    Client savedClient = clientRepository.save(client);

	    ClientResponseDTO response = new ClientResponseDTO();

	    response.setId(savedClient.getId());
	    response.setName(savedClient.getName());
	    response.setIndustry(savedClient.getIndustry());
	    response.setContactEmail(savedClient.getContactEmail());
	    response.setCountry(savedClient.getCountry());

	    return response;
	}

	@Override
	public List<ClientResponseDTO> getAllClients() {
		List<Client> clients = clientRepository.findAll();

	    List<ClientResponseDTO> responseList = new ArrayList<>();

	    for (Client client : clients) {

	        ClientResponseDTO dto = new ClientResponseDTO();

	        dto.setId(client.getId());
	        dto.setName(client.getName());
	        dto.setIndustry(client.getIndustry());
	        dto.setContactEmail(client.getContactEmail());
	        dto.setCountry(client.getCountry());

	        responseList.add(dto);
	    }

	    return responseList;
	}

	@Override
	public ClientResponseDTO getClientById(Long id) {
		Client client = clientRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

	    ClientResponseDTO dto = new ClientResponseDTO();

	    dto.setId(client.getId());
	    dto.setName(client.getName());
	    dto.setIndustry(client.getIndustry());
	    dto.setContactEmail(client.getContactEmail());
	    dto.setCountry(client.getCountry());

	    return dto;
	}

	@Override
	public ClientResponseDTO updateClient(Long id, ClientRequestDTO dto) {
		Client client = clientRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

	    client.setName(dto.getName());
	    client.setIndustry(dto.getIndustry());
	    client.setContactEmail(dto.getContactEmail());
	    client.setCountry(dto.getCountry());

	    Client updatedClient = clientRepository.save(client);

	    ClientResponseDTO response = new ClientResponseDTO();

	    response.setId(updatedClient.getId());
	    response.setName(updatedClient.getName());
	    response.setIndustry(updatedClient.getIndustry());
	    response.setContactEmail(updatedClient.getContactEmail());
	    response.setCountry(updatedClient.getCountry());

	    return response;
	}

	@Override
	public void deleteClient(Long id) {
		Client client = clientRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

	    clientRepository.delete(client);
		
	}

}
