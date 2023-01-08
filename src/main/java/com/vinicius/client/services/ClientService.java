package com.vinicius.client.services;

import com.vinicius.client.dto.ClientDto;
import com.vinicius.client.model.ClientV1;
import com.vinicius.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public ClientDto create(ClientDto clientDto){
        ClientV1 clientv1 = ClientV1.builder().name(clientDto.getName())
                .email(clientDto.getEmail())
                .cpf(clientDto.getCpf())
                .build();
        clientRepository.save(clientv1);
        return clientDto;
    }

    public ClientDto findById(Long id) {
        Optional<ClientV1> clientV1 = clientRepository.findById(id);
            return convertDto(clientV1.get());
    }

    public ClientDto convertDto(ClientV1 clientV1){
        ClientDto clientDto = new ClientDto();
        clientDto.setCpf(clientV1.getCpf());
        clientDto.setName(clientV1.getName());
        clientDto.setEmail(clientV1.getEmail());
        return clientDto;
    }

    public List<ClientDto> getAllClients() {
        List<ClientDto> clientDtoList = clientRepository.findAll().stream()
                .map(clientV1 -> convertDto(clientV1)).toList();
        return clientDtoList;
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}

