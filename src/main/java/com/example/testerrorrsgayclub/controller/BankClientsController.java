package com.example.testerrorrsgayclub.controller;


import com.example.testerrorrsgayclub.aspect.LogExecuteTimeAnnotation;
import com.example.testerrorrsgayclub.dto.AddNewBankClientRequestDto;
import com.example.testerrorrsgayclub.dto.ExceptionResponseDto;
import com.example.testerrorrsgayclub.model.BankClient;
import com.example.testerrorrsgayclub.service.BankClientsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/bank-clients")
@AllArgsConstructor
public class BankClientsController {
    private final BankClientsService bankClientsService;

    @GetMapping(value = "/get-by-id/{id}")
    @LogExecuteTimeAnnotation
    public BankClient getById(@PathVariable int id) throws Exception {
        return bankClientsService.getById(id);
    }

    @GetMapping(value = "/get-all")
    @LogExecuteTimeAnnotation
    public List<BankClient> getAll() throws Exception {
        return bankClientsService.getAll();
    }

    @PostMapping(value = "/add-new")
    @LogExecuteTimeAnnotation
    public void addNew(@Valid @RequestBody AddNewBankClientRequestDto addNewBankClientRequestDto) {
        bankClientsService.addNew(addNewBankClientRequestDto);
    }
}
