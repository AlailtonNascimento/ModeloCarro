/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciarbanco;

import java.util.Scanner;
import java.text.DecimalFormat;
/**
 *
 * @author Meu Computador
 */
public class GerenciarBanco {
    
    static class DadosPessoais {
        private String primeiroNome;
        private String sobrenome;
        private String cpf;

        public DadosPessoais(String primeiroNome, String sobrenome, String cpf) {
            this.primeiroNome = primeiroNome;
            this.sobrenome = sobrenome;
            this.cpf = cpf;
        }

        // Getters para os dados pessoais
        public String getPrimeiroNome() {
            return primeiroNome;
        }

        public String getSobrenome() {
            return sobrenome;
        }

        public String getCpf() {
            return cpf;
        }
    }

    static class ContaBancaria {
        private DadosPessoais dadosPessoais;
        private double saldo;
        private DecimalFormat df = new DecimalFormat("0.00");

        public ContaBancaria(DadosPessoais dadosPessoais) {
            this.dadosPessoais = dadosPessoais;
            this.saldo = 0.0;
        }

        public void depositar(double valor) {
            if (valor <= 0) {
                System.out.println("Valor de depósito inválido. Por favor, tente outro valor");
            } else {
                saldo += valor;
                System.out.println("Depósito de R$" + df.format(valor) +
                        " realizado. Saldo Atual: R$" + df.format(saldo));
            }  
        }

        public void sacar(double valor) {
            if (saldo == 0) {
                System.out.println("Não há saldo disponível!");
            } else if (valor <= 0) {
                System.out.println("Valor de saque inválido. Por favor, tente outro valor.");
            } else if (saldo < valor) {
                System.out.println("Saldo insuficiente!");
            } else {
                saldo -= valor;
                System.out.println("Saque de R$" + df.format(valor) + 
                                   " realizado. Saldo Atual: R$" + df.format(saldo));
            }
        }

        public void exibirSaldo() {
            if (saldo == 0) {
                System.out.println("A conta de " + dadosPessoais.getPrimeiroNome() +
                        " " + dadosPessoais.getSobrenome() + " não possui saldo.");
            } else {
                System.out.println("Saldo da conta de " + dadosPessoais.getPrimeiroNome() +
                        " " + dadosPessoais.getSobrenome() + ": R$" + df.format(saldo));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita informações do usuário
        System.out.print("Digite seu primeiro nome: ");
        String primeiroNome = scanner.nextLine();
        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        // Criação de uma instância da classe DadosPessoais
        DadosPessoais dadosPessoais = new DadosPessoais(primeiroNome, sobrenome, cpf);

        // Criação de uma instância da classe ContaBancaria
        ContaBancaria conta = new ContaBancaria(dadosPessoais);

        int escolha;
        do {
            // Exibe o menu
            System.out.println("\nMenu:");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o valor a depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Digite o valor a sacar: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    conta.exibirSaldo();
                    break;
                case 4:
                    System.out.println("Obrigado por usar nosso sistema bancário!");
                    break;
                default:
                    System.out.println("Inválido. Por favor, escolha uma opção válida.");
            }
        } while (escolha != 4);

        scanner.close();
    }
}


