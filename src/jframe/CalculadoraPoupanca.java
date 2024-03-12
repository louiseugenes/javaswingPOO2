package jframe;

import javax.swing.*;
import java.awt.event.*;

public class CalculadoraPoupanca extends JFrame {
	
	private static final long serialVersionUID = 1L;
    private JLabel labelValor;
    private JTextField textFieldValor;
    private JLabel labelNumeroAnos;
    private JTextField textFieldNumeroAnos;
    private JLabel labelTotalPoupado;
    private JTextField textFieldTotalPoupado;
    private JLabel labelDepositoMensal;
    private JButton calcularButton;
    private JTextField textFieldDepositoMensal;

    public CalculadoraPoupanca() {
        setTitle("Calculadora de Poupança");
        setSize(354, 197);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        labelValor = new JLabel("Juros ao mês %:");
        labelValor.setBounds(0, 0, 169, 28);
        textFieldValor = new JTextField();
        textFieldValor.setBounds(169, 0, 169, 28);
        labelNumeroAnos = new JLabel("Num. de anos:");
        labelNumeroAnos.setBounds(0, 22, 169, 28);
        textFieldNumeroAnos = new JTextField();
        textFieldNumeroAnos.setBounds(169, 22, 169, 28);
        textFieldTotalPoupado = new JTextField();
        textFieldTotalPoupado.setBounds(169, 76, 169, 28);
        textFieldTotalPoupado.setEditable(false);
        getContentPane().setLayout(null);

        getContentPane().add(labelValor);
        getContentPane().add(textFieldValor);
        getContentPane().add(labelNumeroAnos);
        getContentPane().add(textFieldNumeroAnos);
        
        labelDepositoMensal = new JLabel("Déposito mensal R$:");
        labelDepositoMensal.setBounds(0, 51, 169, 28);
        getContentPane().add(labelDepositoMensal);
        labelTotalPoupado = new JLabel("Total poupado R$:");
        labelTotalPoupado.setBounds(0, 76, 169, 28);
        getContentPane().add(labelTotalPoupado);
        getContentPane().add(textFieldTotalPoupado);
        
        calcularButton = new JButton("Calcular");
        calcularButton.setBounds(169, 119, 169, 28);
        getContentPane().add(calcularButton);
        
        textFieldDepositoMensal = new JTextField();
        textFieldDepositoMensal.setBounds(169, 51, 169, 28);
        getContentPane().add(textFieldDepositoMensal);
        
        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularTotalPoupado();
            }
        });
    }
   
    
    private void calcularTotalPoupado() {
        try {
        	double percentual = Double.parseDouble(textFieldValor.getText()) / 100;
            int anos = Integer.parseInt(textFieldNumeroAnos.getText());
            double depositoMensal = Double.parseDouble(textFieldDepositoMensal.getText());

            double totalPoupado = 0;

            for (int i = 0; i < anos; i++) {
                for (int j = 0; j < 12; j++) { // 12 meses = 1 ano
                    totalPoupado += depositoMensal;
                    totalPoupado *= (1 + percentual);
                }
            }

            textFieldTotalPoupado.setText(String.format("R$ %.2f", totalPoupado));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um valor numérico válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraPoupanca().setVisible(true);
            }
        });
    }
}
