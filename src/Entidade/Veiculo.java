package Entidade;

public abstract class Veiculo {
    int codigo;
    String modelo;
    String marca; 
    double preco;
    String combustivel;

    public Veiculo(int codigo, String modelo, String marca, double preco, String combustivel) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
        this.combustivel = combustivel;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }
    
    public abstract String getDescricao();
}
