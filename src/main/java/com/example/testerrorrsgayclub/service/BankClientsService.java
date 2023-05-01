package com.example.testerrorrsgayclub.service;

import com.example.testerrorrsgayclub.dto.AddNewBankClientRequestDto;
import com.example.testerrorrsgayclub.errors.UserException;
import com.example.testerrorrsgayclub.model.BankClient;
import com.example.testerrorrsgayclub.repository.BankClientsRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BankClientsService {
    private final BankClientsRepository bankClientsRepository;
    private final ModelMapper modelMapper;

    public List<BankClient> getAll() {
        return bankClientsRepository.getAllBankClients();
    }

    public BankClient getById(int id) throws Exception {
        Optional<BankClient> result = bankClientsRepository.getBankClientById(id);

        if (result.isEmpty()) {
            throw new UserException("BankClientsService getById", String.format("Client with id = %d not found", id), 400);
        }

        return result.get();
    }

    public void addNew(AddNewBankClientRequestDto addNewBankClientRequestDto) {
        BankClient bankClient = modelMapper.map(addNewBankClientRequestDto, BankClient.class);
        bankClientsRepository.addNewBankClient(bankClient);
    }


}
