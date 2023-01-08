package com.vinicius.client.controller;

import com.vinicius.client.dto.ClientDto;
import com.vinicius.client.model.ClientV1;
import com.vinicius.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public ClientDto createClient(@RequestBody ClientDto clientDto){
            clientService.create(clientDto);
            return clientDto;
    }

    @GetMapping("/{id}")
    public ClientDto getClient(@PathVariable("id") Long id){
        ClientDto clientDto = clientService.findById(id);
        return clientDto;
    }

    @GetMapping()
    public List<ClientDto> getClientList(){
        List<ClientDto> clientDtoList = clientService.getAllClients();
        return clientDtoList;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id){
        clientService.deleteById(id);
        return "Client with id: " + id + " delete with success";
    }
}
