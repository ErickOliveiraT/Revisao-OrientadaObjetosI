package Controle;

import Entidade.Loja;
import Limite.LimiteCadastrarLoja;
import Limite.LimitePrincipal;
import Limite.LimiteConsultarLoja;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControleLoja {
   
    public ArrayList<Loja> adicionaLoja(LimiteCadastrarLoja limite, ArrayList<Loja> lojas) {
        
        String tmp;
        tmp = limite.textCodigo.getText();
        int cod = Integer.parseInt(tmp);
        String end = limite.textEndereco.getText();
        String cid = limite.textCidade.getText();
        String pro = limite.textProd.getText();
        String nom = limite.textNome.getText();
        
        //Nova loja
        Loja lj = new Loja(end, cid, 0, pro, cod, nom);
        //Adicionando loja
        lojas.add(lj);
        
        return lojas;
    }
    
    public void consultarLoja(LimiteConsultarLoja limite, ArrayList<Loja> lojas) {
        
        String tmp = limite.textCodigo.getText();
        
        if (tmp.equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, digite um código válido");
            return;
        }
            
        int cod = Integer.parseInt(tmp);
        boolean found = false;
        
        for(int i = 0; i < lojas.size(); i++) {
            if(cod == lojas.get(i).getCodigo()) {
                found = true;
                String cid = lojas.get(i).getCidade();
                String end = lojas.get(i).getEndereco();
                String nom = lojas.get(i).getNome();
                String pro = lojas.get(i).getProdVendido();
                limite.textCidade.setText(cid);
                limite.textCodigo.setText(tmp);
                limite.textEndereco.setText(end);
                limite.textProd.setText(pro);
                limite.textNome.setText(nom);
            }
        }
        if (found == false) {
            JOptionPane.showMessageDialog(null, "Código não encontrado!");
        }
    }
    
    public boolean existeLoja(int cod, ArrayList<Loja> lojas) {
        
        for(int i = 0; i < lojas.size(); i++) {
            if(cod == lojas.get(i).getCodigo()) {
                return true;
            }
        }
  
        return false;
    }
}
