package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Transaction;
import com.mindhub.homebanking.models.TransactionType;

import java.time.LocalDateTime; // Importar LocalDateTime en lugar de LocalDate

public class TransactionDTO {
    private Long id;
    private String type;
    private LocalDateTime date; // Cambiar LocalDate a LocalDateTime
    private double amount;
    private String description;

    public TransactionDTO() {
    }

    public TransactionDTO(Transaction transaction) {
        this.id = transaction.getId();
        this.type = transaction.getType().toString();
        this.date = transaction.getDate(); // Actualizar el tipo de dato a LocalDateTime
        this.amount = transaction.getAmount();
        this.description = transaction.getDescription();
    }

    public TransactionDTO(TransactionType type, LocalDateTime date, double amount, String description) { // Cambiar LocalDate a LocalDateTime
        this.type = type.toString();
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDate() { // Cambiar LocalDate a LocalDateTime
        return date;
    }

    public void setDate(LocalDateTime date) { // Cambiar LocalDate a LocalDateTime
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
