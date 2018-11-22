package Limite;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Controle.ControleLoja;

public class LimiteCadastrarVeiculo extends JPanel{
    
    String[] veiculos = {"Carro", "Moto"};
    JComboBox<String> comboVeiculos = new JComboBox<>(veiculos);
    
    public JComboBox<String> comboLojas;
    
    JPanel painelComum = new JPanel(); //Painel com os Atributos comuns
    
    JPanel painelCM = new JPanel(); //Painel sul (CardLayout que mostra moto ou carro)
    JPanel painelCarro = new JPanel(); //Painel dos atributos especiais do carro
    JPanel painelMoto = new JPanel(); //Painel dos atributos especiais da moto
    
    //Labels comuns:
    JLabel labelLoja = new JLabel("Loja");
    JLabel labelCodigo = new JLabel("Codigo");
    JLabel labelModelo = new JLabel("Modelo");
    JLabel labelMarca = new JLabel("Marca");
    JLabel labelPreco = new JLabel("Preco");
    JLabel labelCombustivel = new JLabel("Combustivel");
    JLabel labelVeiculo = new JLabel("Veiculo");
    
    //Atributos exclusivos para carros
    JLabel labelHP = new JLabel("HP");
    JLabel labelQtdPessoas = new JLabel("Qtd de Pessoas");
    JLabel labelTamPM = new JLabel("Tamanho do PM");
    
    //Atributos exclusivos para motos
    JLabel labelCilindradas = new JLabel("Cilindradas");
    JLabel labelQtdRodas = new JLabel("Qtd de Rodas");
    JLabel labelPortaMalas = new JLabel("Possui porta malas");
    
    //Botões de Cadastro
    JButton btnCadCarro = new JButton("Cadastrar Carro"); 
    JButton btnCadMoto = new JButton("Cadastrar Moto"); 
    
    //Campos de texto:
    public JTextField textCodigo = new JTextField(15);
    public JTextField textModelo = new JTextField(15);
    public JTextField textMarca = new JTextField(15);
    public JTextField textPreco = new JTextField(15);
    public JTextField textCombustivel = new JTextField(15);
    
    public JTextField textHP = new JTextField(15);
    public JTextField textQtdPessoas = new JTextField(15);
    public JTextField textTamPM = new JTextField(15);
    
    public JTextField textCilindradas = new JTextField(15);
    public JTextField textqtdRodas = new JTextField(15);
    public JCheckBox checkPM = new JCheckBox("Possui porta Malas");
    
    LimitePrincipal limPrincipal;
    ControleLoja ctrLoja;
    
    public LimiteCadastrarVeiculo(LimitePrincipal limPrincipal){
        this.limPrincipal = limPrincipal;
        criaPainel();
    }
    
    public void criaPainel(){
        comboLojas = new JComboBox<>();
        
        for(int i = 0; i< limPrincipal.lojas.size(); i++){
            comboLojas.addItem(limPrincipal.lojas.get(i).getNome());
        }
        
        comboLojas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String option = (String)comboLojas.getSelectedItem();
                String veiculo = "";
                
                //Busca o veículo que a loja vende:
                for(int i = 0; i < limPrincipal.lojas.size(); i++){
                    if(option.equals(limPrincipal.lojas.get(i).getNome())){
                        veiculo = (String) limPrincipal.lojas.get(i).getProdVendido();
                        break;
                    }
                }
                
                //Atualiza o tipo de veículo na parte de parte de acordo com a loja:
                CardLayout layout = (CardLayout) painelCM.getLayout();
                layout.show(painelCM, veiculo);
            }
        });
        
        painelComum.setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        
        painelComum.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white), "Atributos Comuns"));
        
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        
        painelComum.add(labelLoja, c);
        
        c.gridy = 1;
        painelComum.add(labelCodigo, c);
        
        c.gridy = 2;
        painelComum.add(labelModelo, c);
        
        c.gridy = 3;
        painelComum.add(labelMarca, c);
        
        c.gridy = 4;
        painelComum.add(labelPreco, c);
        
        c.gridy = 5;
        painelComum.add(labelCombustivel, c);
        
        c.gridy = 6;
        painelComum.add(labelVeiculo, c);
        
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 2;
        
        painelComum.add(comboLojas, c);
        
        c.gridy = 1;
        painelComum.add(textCodigo, c);
        
        c.gridy = 2;
        painelComum.add(textModelo, c);
        
        c.gridy = 3;
        painelComum.add(textMarca, c);
        
        c.gridy = 4;
        painelComum.add(textPreco, c);
        
        c.gridy = 5;
        painelComum.add(textCombustivel, c);
        
        c.gridy = 6;
        painelComum.add(comboVeiculos, c);
        
        painelCarro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red), "Carro"));
        
        painelCarro.setLayout(new GridBagLayout());
        
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        
        painelCarro.add(labelHP, c);
        
        c.gridy = 1;
        painelCarro.add(labelQtdPessoas, c);
        
        c.gridy = 2;
        painelCarro.add(labelTamPM, c);
        
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 2;
        
        painelCarro.add(textHP, c);
        
        c.gridy = 1;
        painelCarro.add(textQtdPessoas, c);
        
        c.gridy = 2;
        painelCarro.add(textTamPM, c);
        
        c.gridy = 3;
        painelCarro.add(btnCadCarro, c);
        
        painelMoto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red), "Moto"));
        
        painelMoto.setLayout(new GridBagLayout());
        
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        
        painelMoto.add(labelCilindradas, c);
        
        c.gridy = 1;
        painelMoto.add(labelQtdRodas, c);
        
        c.gridy = 2;
        painelMoto.add(labelPortaMalas, c);
        
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 2;
        
        painelMoto.add(textCilindradas, c);
        
        c.gridy = 1;
        painelMoto.add(textqtdRodas, c);
        
        c.gridy = 2;
        painelMoto.add(checkPM, c);
        
        c.gridy = 3;
        painelMoto.add(btnCadMoto, c);
        
        c.gridy = 6;
        c.gridx = 0;
        c.weightx = 3;
        painelComum.add(painelCarro, c);
        
        //Cartões que vão compor o CardLayout
        painelCM.setLayout(new CardLayout());
        painelCM.add("Carro", painelCarro);
        painelCM.add("Moto", painelMoto);
        
        setLayout(new BorderLayout());
        add(painelComum, BorderLayout.NORTH);
        add(painelCM, BorderLayout.CENTER);
    }
}
