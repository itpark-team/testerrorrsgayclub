package com.example.testerrorrsgayclub.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankClient {
    private int id;
    private String name;
    private int balance;
}
