package Controle;

import Entidade.Carro;
import Entidade.Loja;
import Limite.LimiteCadastrarVeiculo;
import java.util.ArrayList;

public class ControleCarro {
    
    public void adicionaCarro(LimiteCadastrarVeiculo limite, ArrayList<Loja> lojas) {
        
        String tmp;
        
        //Atributos comuns
        String mod = limite.textModelo.getText();
        String mar = limite.textMarca.getText();
        String com = limite.textCombustivel.getText();
        tmp = limite.textPreco.getText();
        double preco = Double.parseDouble(tmp);
        tmp = limite.textCodigo.getText();
        int cod = Integer.parseInt(tmp);
        
        //Atributos de carro
        tmp = limite.textHP.getText();
        int hp = Integer.parseInt(tmp);
        tmp = limite.textQtdPessoas.getText();
        int qnt = Integer.parseInt(tmp);
        tmp = limite.textTamPM.getText();
        double tam = Double.parseDouble(tmp); 
        
        //Nome da loja
        tmp = (String) limite.comboLojas.getSelectedItem();
        
        //Carro novo
        Carro car = new Carro(hp, qnt, tam, cod, mod, mar, preco, com);
        
        Loja l;
        for(int i = 0; i < lojas.size(); i++) {
            if(tmp.equals(lojas.get(i).getNome())) {
                l = (Loja) lojas.get(i);
                //Atualizando valor do estoque:
                double valor = l.getValorEstoque();
                valor += preco;
                l.setValorEstoque(valor);
                //Adicionando carro:
                l.veiculos.add(car);
                break;
            }
        }
    }
    
    
}
