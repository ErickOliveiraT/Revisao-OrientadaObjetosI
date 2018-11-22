package Entidade;

public class Moto extends Veiculo{
    
    int cilindradas;
    int qtdRodas;
    boolean possuiPortaMalas;

    public Moto(int cilindradas, int qtdRodas, boolean possuiPortaMalas, int codigo, String modelo, String marca, double preco, String combustivel) {
        super(codigo, modelo, marca, preco, combustivel);
        this.cilindradas = cilindradas;
        this.qtdRodas = qtdRodas;
        this.possuiPortaMalas = possuiPortaMalas;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public int getQtdRodas() {
        return qtdRodas;
    }

    public void setQtdRodas(int qtdRodas) {
        this.qtdRodas = qtdRodas;
    }

    public boolean isPossuiPortaMalas() {
        return possuiPortaMalas;
    }

    public void setPossuiPortaMalas(boolean possuiPortaMalas) {
        this.possuiPortaMalas = possuiPortaMalas;
    }

    @Override
    public String getDescricao() {
        return "";
    }
    
    
}
