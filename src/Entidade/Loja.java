package Entidade;

import java.util.ArrayList;

public class Loja {
    String endereco;
    String cidade;
    public ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
    double valorEstoque;
    String prodVendido;
    int codigo;
    String nome;

    public Loja(String endereco, String cidade, double valorEstoque, String prodVendido, int codigo, String nome) {
        this.endereco = endereco;
        this.cidade = cidade;
        this.valorEstoque = valorEstoque;
        this.prodVendido = prodVendido;
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(ArrayList<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public double getValorEstoque() {
        return valorEstoque;
    }

    public void setValorEstoque(double valorEstoque) {
        this.valorEstoque = valorEstoque;
    }

    public String getProdVendido() {
        return prodVendido;
    }

    public void setProdVendido(String prodVendido) {
        this.prodVendido = prodVendido;
    }
    
    
    
}
