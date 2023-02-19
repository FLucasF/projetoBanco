package program;

import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBncaria {
    //os inputs
    static Scanner input = new Scanner(System.in);
    static ArrayList<BankAccount> bankAccounts;
    //////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        bankAccounts = new ArrayList<BankAccount>();
        operations();
    //////////////////////////////////////////////////////////////////////////
    }

    public static void operations() {
        System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos a nossa Agência---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta   |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Sacar         |");
        System.out.println("|   Opção 4 - Transferir    |");
        System.out.println("|   Opção 5 - Listar        |");
        System.out.println("|   Opção 6 - Sair          |");

        int operation = input.nextInt();

        //swith case
        switch (operation) {
            case 1:createAccount();
                break;

            case 2:deposit();
                break;

            case 3:withdraw();
                break;

            case 4:transfer();
                break;

            case 5:list();
                break;

            case 6:
                System.out.println("obrigado por utilizar nossa agência!");
                System.exit(0);

            default:
                System.out.println("Opção inválida.");
                operations();
                break;
            //////////////////////////////////////////////////////////////////////////
        }
    }

    public static void createAccount() {
        System.out.println("\nNome: ");
        String name = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        CredentialPerson person = new CredentialPerson(name, cpf, email);

        BankAccount account = new BankAccount(person);

        bankAccounts.add(account);
        System.out.println("Sua conta foi criada com sucesso.");

        operations();
        //////////////////////////////////////////////////////////////////////////
    }

    private static BankAccount findAccount(int numAccount) {
        BankAccount account = null;
        if(bankAccounts.size() > 0) {
            for(BankAccount c: bankAccounts) {
                if(c.getNumAccount() == numAccount) {
                    account = c;
                    }
                }

            }
            return account;
        //////////////////////////////////////////////////////////////////////////
        }
        public static void deposit() {
            System.out.println("Número da conta: ");
            int numAccount = input.nextInt();

            BankAccount account = findAccount(numAccount);

            if (account != null) {
                System.out.println("Qual valor deseja depositar? ");
                Double depositValue = input.nextDouble();
                account.deposit(depositValue);

            }else{
                System.out.println("Conta não encontrada.");
            }
            operations();
            //////////////////////////////////////////////////////////////////////////
        }
    public static void withdraw() {
        System.out.println("Número da conta: ");
        int numAccount = input.nextInt();

        BankAccount account = findAccount(numAccount);

        if (account != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double withdrawValue = input.nextDouble();

            account.withdraw(withdrawValue);

        } else {
            System.out.println("Conta não encontrada.");
        }

        operations();
            //////////////////////////////////////////////////////////////////////////
        }
    public static void transfer() {
        System.out.print("Número da conta do remetente: ");
        int numSenderAccount = input.nextInt();

        BankAccount senderAccount = findAccount(numSenderAccount);

        if (senderAccount != null) {
            System.out.println("Número da conta do destinatário: ");
            int numRecipientAccount = input.nextInt();

            BankAccount recipientAccount = findAccount(numRecipientAccount);

            if (recipientAccount != null) {
            System.out.println("Valor da transferência");
            Double value = input.nextDouble();

            senderAccount.transfer (recipientAccount, value);

            } else {
                System.out.println("Conta do destinatário não encontrada.");
            }
            } else {
                System.out.println("Conta do remetente não encontrada.");
            }operations();
        }

    public static void list() {
        if (bankAccounts.size() > 0) {
        for (BankAccount account : bankAccounts) {
            System.out.println(account);
        }
        }else {
            System.out.println("Não há contas cadastradas");
        }operations();
    }
}
