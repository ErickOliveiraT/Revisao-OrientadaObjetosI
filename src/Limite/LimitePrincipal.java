package Limite;

import Entidade.Carro;
import Entidade.Loja;
import Entidade.Moto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import revisao.Revisao;
import Controle.ControleCarro;
import Controle.ControleMoto;
import Controle.ControleLoja;
import javax.swing.JOptionPane;

public class LimitePrincipal {
    
    JFrame frame = new JFrame();
    
    JMenuBar menuBar = new JMenuBar();
    
    JMenu menuLoja = new JMenu("Loja");
    JMenuItem menuCadLoja = new JMenuItem("Cadastrar");
    JMenuItem menuConsLoja = new JMenuItem("Consultar");
    
    JMenu menuVeiculo = new JMenu("Veiculo");
    JMenuItem menuCadVeiculo = new JMenuItem("Cadastrar");
    JMenuItem menuConsVeiculo = new JMenuItem("Consultar");
        
    LimiteCadastrarLoja cadLoja;
    LimiteConsultarLoja conLoja;
    LimiteCadastrarVeiculo cadVeiculo;
    LimiteConsultarVeiculo conVeiculo;
    Revisao revisao;
    
    public ArrayList<Loja> lojas = new ArrayList<>();
    
    public LimitePrincipal(int info){
        
        criaPainel(info);
        
        //Reconstrução do frame ao usar o MenuBar
        menuCadLoja.addActionListener((ActionEvent ae) -> {
            System.out.println("Clicou no cad loja");
        });
        menuConsLoja.addActionListener((ActionEvent ae) -> {
            System.out.println("Clicou no consultar loja"); 
        });
        menuCadVeiculo.addActionListener((ActionEvent ae) -> {
            //(1);
            System.out.println("Clicou no cad veículo"); 
        });
        menuConsVeiculo.addActionListener((ActionEvent ae) -> {
            System.out.println("Clicou no consultar veículo"); 
        });
        
        //Tratando botões de cadastrar
        cadVeiculo.btnCadCarro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Submit carro");
                ControleCarro ctrCarro = new ControleCarro();
                ctrCarro.adicionaCarro(cadVeiculo, lojas);
            }
        });
        
        cadVeiculo.btnCadMoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Submit moto");
                ControleMoto ctrMoto = new ControleMoto();
                ctrMoto.adicionaMoto(cadVeiculo, lojas);
            }
        });
        
        cadLoja.botaoOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               System.out.println("Submit loja"); 
               ControleLoja ctrLoja = new ControleLoja();
               lojas = ctrLoja.adicionaLoja(cadLoja, lojas);
            }           
        });
        
        cadLoja.botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cadLoja.textCodigo.setText("");
                cadLoja.textEndereco.setText("");
                cadLoja.textCidade.setText("");
                cadLoja.textProd.setText("");
                cadLoja.textNome.setText("");
            }           
        });
        
        conLoja.btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Submit consultar loja"); 
                ControleLoja ctrLoja = new ControleLoja();
                ctrLoja.consultarLoja(conLoja, lojas);
            }
        });
        
        conVeiculo.comboLojas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               conVeiculo.atualizaVeiculos(lojas);
            } 
        });
        
        conVeiculo.verInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String selec = (String) conVeiculo.comboVeiculos.getSelectedItem();
                int cod = Integer.parseInt(selec);
                Loja lj = conVeiculo.getLojaSelec(lojas);
                String dados = conVeiculo.getInfoVeiculo(lj,cod);
                JOptionPane.showMessageDialog(null, dados);
            }   
        });
    }
    
    public void criaPainel(int op){
        
        Loja loja1 = new Loja("rua x", "itajuba", 0, "Carro", 1, "loja 1");
        Loja loja2 = new Loja("rua y", "itajuba", 0, "Moto", 2, "loja 2");
        
        lojas.add(loja1);
        lojas.add(loja2);
        
        loja1.getVeiculos().add(new Carro(100, 5, 500, 1, "modelo X", "Marca X", 30000, "gasolina"));
        loja2.getVeiculos().add(new Moto(500, 2, false, 2, "Modelo Y", "Marca Y", 20000, "Gasolina"));
        
        cadLoja = new LimiteCadastrarLoja();
        conLoja = new LimiteConsultarLoja();
        cadVeiculo = new LimiteCadastrarVeiculo(this);
        conVeiculo = new LimiteConsultarVeiculo(lojas);
        
        menuLoja.add(menuCadLoja);
        menuLoja.add(menuConsLoja);
               
        menuVeiculo.add(menuCadVeiculo);
        menuVeiculo.add(menuConsVeiculo);
        
        menuBar.add(menuLoja);
        menuBar.add(menuVeiculo);
        
        frame.setJMenuBar(menuBar);
        
        switch(op) {
            case 1:
                frame.add(cadVeiculo);
                break;
            case 2:
                frame.add(cadLoja);
                break;
            case 3:
                frame.add(conVeiculo);
                break;
            case 4:
                frame.add(conLoja);
                break;
        }
        
        frame.setBounds(100, 100, 700, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    
}
