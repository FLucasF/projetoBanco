package program;

public class CredentialPerson {
    //Contador numero de pessoas
    private static int counter = 1;

    //dados basicos
    private String name;
    private String cpf;
    private String email;
    //construtor


    public CredentialPerson(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        counter += 1;
    }

    //get e set do nome, cpf e email
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public  String toString() {
        return  "\nNome: " + this.getName() +
                "\nCPF: " + this.getCPF() +
                "\nEmail: " + this.getEmail();
    }
}
