package Limite;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LimiteInicio extends JPanel {
      
    JLabel labelEndereco = new JLabel("Endereco");
    JLabel labelCidade = new JLabel("Cidade");
    JLabel labelProd = new JLabel("prodVendido");
    JLabel labelCodigo = new JLabel("Código");
    JLabel labelNome = new JLabel("Nome");
    
    public JTextField textEndereco = new JTextField(15);
    public JTextField textCidade = new JTextField(15);
    public JTextField textProd = new JTextField(15);
    public JTextField textCodigo = new JTextField(15);
    public JTextField textNome = new JTextField(15);
    
    JButton btnConsultar = new JButton("Consultar");
    JButton botaoLimpar = new JButton("Limpar");
    
    public LimiteInicio() {
        
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Consultar Loja"));
        
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        
        add(labelCodigo, c);
        
        c.gridy = 1;
        add(labelNome, c);
        
        c.gridy = 2;
        add(labelEndereco, c);
        
        c.gridy = 3;
        add(labelCidade, c);
        
        c.gridy = 4;
        add(labelProd, c);
        
        c.weightx = 2;
        c.gridx = 1;
        c.gridy = 0;
        
        add(textCodigo, c);
        
        c.gridy = 1;
        add(textNome, c);
        
        c.gridy = 2;
        add(textEndereco, c);
        
        c.gridy = 3;
        add(textCidade , c);
        
        c.gridy = 4;
        add(textProd, c);
        
        c.gridy = 5;
        add(btnConsultar, c);
        
    }
    
}