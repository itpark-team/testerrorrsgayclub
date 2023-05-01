package com.example.testerrorrsgayclub.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddNewBankClientRequestDto {
    @NotBlank
    @Pattern(regexp = "^[a-z]{2,10}$")
    private String name;

    @Min(0)
    @Max(999)
    private int balance;
}
