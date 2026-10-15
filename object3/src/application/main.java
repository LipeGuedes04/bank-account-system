package application;

import java.util.Locale;
import java.util.Scanner;

import entities.ContaBancaria;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		ContaBancaria conta = new ContaBancaria();
		
		System.out.println("Insira o nome do Titular: ");
		conta.titular = sc.nextLine();
		System.out.println("Saldo inicial da Conta: ");
		conta.saldo = sc.nextDouble();
		
		
		System.out.println("Quanto deseja depositar? ");
		double Deposito = sc.nextDouble();
		conta.depositar(Deposito);
		

		System.out.println(conta);
		
		System.out.println("Quanto deseja sacar?");
		double saque = sc.nextDouble();

		if (conta.sacar(saque)) {
		    System.out.println("✅ Saque realizado com sucesso!");
		} else {
		    System.out.println("❌ Erro: Saldo insuficiente para realizar o saque!");
		}

		System.out.println(conta); 
		
		sc.close();

	}

}
