package Limite;

import Entidade.Loja;
import Entidade.Veiculo;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LimiteConsultarVeiculo extends JPanel {
    
    JLabel labelLoja = new JLabel("Selecione a Loja:");
    JLabel labelVeiculos = new JLabel("Veículos:");
    
    JButton verInfo = new JButton("Ver Informações");
    
    JComboBox<String> comboLojas;
    JComboBox<String> comboVeiculos;   
    
    public LimiteConsultarVeiculo(ArrayList<Loja> lojas) {
        
        comboVeiculos = new JComboBox<>();
        comboLojas = new JComboBox<>();
        //Encontrando lojas cadastradas
        for(int i = 0; i < lojas.size(); i++){
            comboLojas.addItem(lojas.get(i).getNome());
        }
        
        //Atualiza o ComboBox de veículos
        atualizaVeiculos(lojas);
 
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Consultar Veículo"));
        
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        
        add(labelLoja, c);
        
        c.gridy = 1;
        add(labelVeiculos, c);
        

        c.weightx = 2;
        c.gridx = 1;
        c.gridy = 0;
        
        add(comboLojas, c);
        
        c.gridx = 0;
        c.gridy = 1;
        add(labelVeiculos, c);
        
        c.gridx = 1;
        add(comboVeiculos, c);
        
        c.gridy = 2;
        add(verInfo, c);
    }
    
    public void atualizaVeiculos(ArrayList<Loja> lojas) {
        //Limpando o ComboBox de veículos cadastrados
        comboVeiculos.removeAllItems();
        //Objendo a loja selecionada
        String nomeLoja = (String) comboLojas.getSelectedItem();
        Loja l;
        for(int i = 0; i < lojas.size(); i++) {
            if(nomeLoja.equals(lojas.get(i).getNome())) {
                l = (Loja) lojas.get(i);
                //Obtendo lista de veículos dessa loja
                ArrayList<Veiculo> v = new ArrayList<>();
                v = l.getVeiculos();
                //Preenchendo o ComboBox de Veiculos
                if (!v.isEmpty()) {
                    for(int j = 0; j < v.size(); j++) {
                        int cod = v.get(j).getCodigo();
                        comboVeiculos.addItem(Integer.toString(cod));
                    }
                }
            }
        }
    }
    
    public Loja getLojaSelec(ArrayList<Loja> lojas) {
        //Objendo a loja selecionada
        String nomeLoja = (String) comboLojas.getSelectedItem();
        Loja l = null;
        for(int i = 0; i < lojas.size(); i++) {
            if(nomeLoja.equals(lojas.get(i).getNome())) {
                l = (Loja) lojas.get(i);
                return l;
            }
        }
        return l;
    }
    
    public String getInfoVeiculo(Loja lj, int cod) {
        ArrayList<Veiculo> v = new ArrayList<>();
        v = lj.getVeiculos();
        String retorno = "Código: " + cod;
        if (!v.isEmpty()) {
            for(int j = 0; j < v.size(); j++) {
                if (cod == v.get(j).getCodigo()) {
                    String mod = v.get(j).getModelo(); 
                    String mar = v.get(j).getMarca();
                    double preco = v.get(j).getPreco();
                    String com = v.get(j).getCombustivel();
                    retorno += "\nModelo: " + mod + "\nMarca: " + mar;
                    retorno += "\nPreço: " + preco + "\nCombustível: " + com;
                }
            }
        }
        return retorno;
    }
}