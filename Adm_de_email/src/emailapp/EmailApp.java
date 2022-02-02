package emailapp;
import java.util.Scanner;
/*Aplicativo de administração de e-mail
Um projeto Java básico focado na aplicação de design orientado a
objetos em uma aplicação do mundo real.

Objetivo do projeto
Você é um especialista em administrador de suporte de TI e está
encarregado da tarefa de criar contas de e-mail para novas contratações.

Seu aplicativo deve fazer o seguinte:

Gere um e-mail com a seguinte sintaxe: firstname.lastname@department.company.com
Determine o departamento (vendas, desenvolvimento, financeiro), se nenhum deixar em branco
Gerar uma String aleatória para uma senha
Definir métodos para alterar a senha, definir a capacidade da caixa de correio e definir
um endereço de e-mail alternativo
Ter métodos get para exibir o nome, o email e a capacidade da caixa de correio */

public class EmailApp {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Creating a new employee (i.e. an object of the Email class)
        Email em1 = new Email("Marcela", "Santos");

        int choice = -1;
        do {
            System.out.println("\n**************************\nEscolha uma das opções abaixo\n1.Mostrar Informações\n2.Trocar Senha"
                    + "\n3.Trocar capacidade de armazenamento de email\n4.Definir email alternativo\n5.Sair");
            choice = s.nextInt();
            switch(choice) {
                case 1:
                    em1.getInfo();
                    break;
                case 2:
                    em1.set_password();
                    break;
                case 3:
                    em1.set_mailCap();
                    break;
                case 4:
                    em1.alternate_email();
                    break;
                case 5:
                    System.out.println("\nOBRIGADO(A)!!!");
                    break;
                default:
                    System.out.println("ESCOLHA INVÁLIDA! ENTRE NOVAMENTE!");
            }

        }while(choice!=5);

    }

}

//https://www.youtube.com/watch?v=U3Ibvu0htNs