package Controle;

import Entidade.Moto;
import Entidade.Loja;
import Limite.LimiteCadastrarVeiculo;
import java.util.ArrayList;

public class ControleMoto {
    
    public void adicionaMoto(LimiteCadastrarVeiculo limite, ArrayList<Loja> lojas) {
        
        String tmp;
        
        //Atributos comuns
        String mod = limite.textModelo.getText();
        String mar = limite.textMarca.getText();
        String com = limite.textCombustivel.getText();
        tmp = limite.textPreco.getText();
        double preco = Double.parseDouble(tmp);
        tmp = limite.textCodigo.getText();
        int cod = Integer.parseInt(tmp);
        
        //Atributos de moto:
        tmp = limite.textCilindradas.getText();
        int cil = Integer.parseInt(tmp);
        tmp = limite.textqtdRodas.getText();
        int rod = Integer.parseInt(tmp);
        boolean pm = limite.checkPM.isSelected();
        
        //Nome da loja
        tmp = (String) limite.comboLojas.getSelectedItem();
               
        //Moto nova
        Moto m = new Moto(cil, rod, pm, cod, mod, mar, preco, com); 
           
        Loja l;
        for(int i = 0; i < lojas.size(); i++) {
            if(tmp.equals(lojas.get(i).getNome())) {
                l = (Loja) lojas.get(i);
                //Atualizando valor do estoque:
                double valor = l.getValorEstoque();
                valor += preco;
                l.setValorEstoque(valor);
                //Adicionando carro:
                l.veiculos.add(m);
                break;
            }
        }
    }
}
