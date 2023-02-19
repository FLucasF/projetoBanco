package program;

import utilitarian.Utils;

//conta bancaria
public class BankAccount {

    private static int counterAccount = 1;
    private int numAccount;
    private CredentialPerson person;
    private Double bankBalance = 0.0;
    private boolean loop = true;

    public BankAccount(CredentialPerson person) {
        this.numAccount = counterAccount;
        this.person = person;
        counterAccount += 1;
    }

    public int getNumAccount() {
        return numAccount;
    }

    public void setNumAccount(int numAccount) {
        this.numAccount = numAccount;
    }

    public CredentialPerson getPerson() {
        return person;
    }

    public void setPerson(CredentialPerson person) {
        this.person = person;
    }

    public Double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(Double bankBalance) {
        this.bankBalance = bankBalance;
    }

    public String toString() {
        return "\nNúmero da conta: " + this.getNumAccount() +
                "\nNome: " + this.person.getName() +
                "\nCPF: " + this.person.getCPF() +
                "\nEmail: " + this.person.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getBankBalance()) +
                "\n";
    }
    public void deposit(Double value) {

        if (value > 0) {
            setBankBalance(getBankBalance() + value);
            System.out.println("O depósito foi realizado com sucesso.");
        } else {
            System.out.println("Não foi possível realizar o processo.");
        }
    }
    public void withdraw(Double value) {
        if(value > 0 && this.getBankBalance() >= value) {
            setBankBalance(getBankBalance() - value);
            System.out.println("Saque realizado com sucesso.");
        }else {
            System.out.println("Não foi possível realizar o saque.");
        }
    }

    public void transfer(BankAccount accountForDeposit, Double value) {
        if(value > 0 && this.getBankBalance() >= value) {
            setBankBalance(getBankBalance() - value);
            accountForDeposit.bankBalance = accountForDeposit.getBankBalance() + value;
            System.out.println("Tranferência realizada com sucesso.");

        } else {
            System.out.println("Não foi possível realizar a transferência.");
        }

    }
}
