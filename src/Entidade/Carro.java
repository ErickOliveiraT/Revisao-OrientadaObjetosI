package Entidade;

import java.io.Serializable;

public class Carro extends Veiculo {
    int HP;
    int qtdPessoas;
    double tamPortaMalas;

    public Carro(int HP, int qtdPessoas, double tamPortaMalas, int codigo, String modelo, String marca, double preco, String combustivel) {
        super(codigo, modelo, marca, preco, combustivel);
        this.HP = HP;
        this.qtdPessoas = qtdPessoas;
        this.tamPortaMalas = tamPortaMalas;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getQtdPessoas() {
        return qtdPessoas;
    }

    public void setQtdPessoas(int qtdPessoas) {
        this.qtdPessoas = qtdPessoas;
    }

    public double getTamPortaMalas() {
        return tamPortaMalas;
    }

    public void setTamPortaMalas(double tamPortaMalas) {
        this.tamPortaMalas = tamPortaMalas;
    }

    @Override
    public String getDescricao() {
        return "";
    }
    
    
}
