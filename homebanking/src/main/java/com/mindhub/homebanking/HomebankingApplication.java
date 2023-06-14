package com.mindhub.homebanking;

import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.models.Transaction;
import com.mindhub.homebanking.models.TransactionType;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import com.mindhub.homebanking.repositories.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository, TransactionRepository transactionRepository) {
		return (args) -> {

			Client client1 = new Client("Melba", "Morel", "melba@gmail.com");

			Client client2 = new Client("Lucas", "Romo", "lucas@gmail.com");

			clientRepository.save(client1);
			clientRepository.save(client2);

			Account account1 = new Account("VIN001", LocalDate.now(), 7000);

			Account account2 = new Account("VIN002", LocalDate.now(), 1500);

			Account account3 = new Account("VIN003", LocalDate.now(), 897);

			client1.addAccount(account1);

			client1.addAccount(account2);

			client2.addAccount(account3);

			accountRepository.save(account1);
			accountRepository.save(account2);
			accountRepository.save(account3);

			// Agregar transacciones para la cuenta account1
			Transaction transaction1 = new Transaction(TransactionType.CREDIT, LocalDateTime.of(2023, 6, 12, 9, 30), 1000, "loren");
			Transaction transaction2 = new Transaction(TransactionType.DEBIT, LocalDateTime.of(2023, 6, 11, 14, 15), -500, "loren");
			Transaction transaction8 = new Transaction(TransactionType.CREDIT, LocalDateTime.of(2023, 6, 10, 17, 45), 1000, "loren");

			account1.addTransaction(transaction1);
			account1.addTransaction(transaction2);
			account1.addTransaction(transaction8);

			transactionRepository.save(transaction1);
			transactionRepository.save(transaction2);
			transactionRepository.save(transaction8);

			// Agregar transacciones para la cuenta account2
			Transaction transaction3 = new Transaction(TransactionType.CREDIT, LocalDateTime.of(2023, 6, 9, 11, 0), 200, "shopping");
			Transaction transaction4 = new Transaction(TransactionType.DEBIT, LocalDateTime.of(2023, 6, 8, 16, 30), -100, "pet shop");

			account2.addTransaction(transaction3);
			account2.addTransaction(transaction4);

			transactionRepository.save(transaction3);
			transactionRepository.save(transaction4);

			// Agregar transacciones para la cuenta account3
			Transaction transaction5 = new Transaction(TransactionType.CREDIT, LocalDateTime.of(2023, 6, 7, 13, 45), 50, "deposit");
			Transaction transaction6 = new Transaction(TransactionType.DEBIT, LocalDateTime.of(2023, 6, 6, 10, 15), -20, "olnlyfans");

			account3.addTransaction(transaction5);
			account3.addTransaction(transaction6);

			transactionRepository.save(transaction5);
			transactionRepository.save(transaction6);

		};
	}

}
