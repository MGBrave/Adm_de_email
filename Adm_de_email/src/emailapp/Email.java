package emailapp;

import java.util.Scanner;
import java.util.Random;

public class Email {

    public Scanner s = new Scanner(System.in);

    // Setting up the variables
    // Defined as 'private' so that these cannot be accessed directly
    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alter_email;

    // Constructor to receive the first name and the last name
    public Email(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        System.out.println("Novo Funcionário: " + this.fname + " " + this.lname);

        // Call a method asking for the department - return the department
        this.dept = this.setDept();

        // Call a method that returns a random password
        this.password = this.generate_password(8);

        // Combine elements to generate an email
        this.email = this.generate_email();
    }

    // Generating the email according to the given syntax
    private String generate_email() {
        return this.fname.toLowerCase() + "." + this.lname.toLowerCase() + "@" + this.dept.toLowerCase()
                + ".company.com";
    }

    // Ask for the department
    private String setDept() {
        System.out.println(
                "CODIGO DOS DEPARTAMENTOS:\n1 Para Vendas\n2 para Desenvolvimento\n3 para Financeiro\n0 para Nenhum dos anteriores");
        boolean flag = false;
        do {
            System.out.print("Entre com o código do departamento: ");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    return "Vendas";
                case 2:
                    return "Desenvolvimento";
                case 3:
                    return "Financeiro";
                case 0:
                    return "Nenhum dos anteriores";
                default:
                    System.out.println("***ESCOLHA INVÁLIDA***");
            }
        } while (!flag);
        return null;
    }

    // Generating a random password
    private String generate_password(int length) {
        Random r = new Random();

        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%&?";
        String values = Capital_chars + Small_chars + numbers + symbols;

        String password = "";
        for (int i = 0; i < length; i++) {
            password = password + values.charAt(r.nextInt(values.length()));
        }
        return password;
    }

    // Change the password
    public void set_password() {
        boolean flag = false;
        do {
            System.out.print("TEM CERTEZA DE QUE VOCÊ DESEJA TROCAR A SENHA? (S/N) : ");
            char choice = s.next().charAt(0);
            if (choice == 'S' || choice == 'n') {
                flag = true;
                System.out.print("Digite sua senha atual: ");
                String temp = s.next();
                if (temp.equals(this.password)) {
                    System.out.println("Digite a nova senha: ");
                    this.password = s.next();
                    System.out.println("SENHA TROCADA COM SUCESSO!");
                } else {
                    System.out.println("SENHA INCORRETA!");
                }
            } else if (choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("TROCA DE SENHA CANCELADA!");
            } else {
                System.out.println("***ENTRE COM UMA ESCOLHA VÁLIDA***");
            }
        } while (!flag);
    }

    // Set the mailbox capacity
    public void set_mailCap() {
        System.out.println("Capacidade atual= " + this.mailCapacity + "mb");
        System.out.print("Entrar com a nova capacidade: ");
        this.mailCapacity = s.nextInt();
        System.out.println("CAPACIDADE DA CAIXA DE EMAIL TROCADA COM SUCESSO!");

    }

    // Set the alternate email
    public void alternate_email() {
        System.out.print("Digite um e-mail alternativo: ");
        this.alter_email = s.next();
        System.out.println("Email Alternativo configurado com Sucesso!");
    }

    // Displaying the employee's information
    public void getInfo() {
        System.out.println("NOME: " + this.fname + " " + this.lname);
        System.out.println("DEPARTAMENTO: " + this.dept);
        System.out.println("EMAIL: " + this.email);
        System.out.println("SENHA: " + this.password);
        System.out.println("CAPACIDADE DA CAIXA DE EMAIL: " + this.mailCapacity + "mb");
        System.out.println("EMAIL ALTERNATIVO: " + this.alter_email);
    }
}