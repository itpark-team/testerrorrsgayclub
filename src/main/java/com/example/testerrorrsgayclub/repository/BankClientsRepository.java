package com.example.testerrorrsgayclub.repository;

import com.example.testerrorrsgayclub.model.BankClient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class BankClientsRepository {

    private List<BankClient> bankClients;
    private int globalId;

    public BankClientsRepository() {
        bankClients = new ArrayList<>();
        Collections.addAll(bankClients,
                new BankClient(1, "Vasya", 123),
                new BankClient(2, "Petya", 345)
        );
        globalId = 2;
    }

    public void addNewBankClient(BankClient bankClient) {
        globalId++;
        bankClient.setId(globalId);
        bankClients.add(bankClient);
    }

    public List<BankClient> getAllBankClients() {
        return bankClients;
    }

    public Optional<BankClient> getBankClientById(int id) {
        return bankClients.stream().filter(bankClient -> bankClient.getId() == id).findFirst();
    }
}
