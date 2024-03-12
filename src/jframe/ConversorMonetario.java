package jframe;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ConversorMonetario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField valorReaisText;
	private JTextField valorConvertidoText;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorMonetario frame = new ConversorMonetario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConversorMonetario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 203);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(10, 95, 202, 22);
		contentPane.add(comboBox);
		comboBox.addItem("Dolar");
        comboBox.addItem("Euro");
        comboBox.addItem("Libra Esterlina");
    
		
		JLabel lblNewLabel = new JLabel("Escolha o tipo de moeda que gostaria de converter:");
		lblNewLabel.setBounds(10, 76, 293, 18);
		contentPane.add(lblNewLabel);
		
		JLabel valorReaisLabel = new JLabel("Digite o Valor em Reais");
		valorReaisLabel.setBounds(10, 11, 137, 27);
		contentPane.add(valorReaisLabel);
		
		valorReaisText = new JTextField();
		valorReaisText.setBounds(180, 11, 168, 22);
		contentPane.add(valorReaisText);
		valorReaisText.setColumns(10);
		
		JLabel valorConvertidoLabel = new JLabel("Valor convertido:");
		valorConvertidoLabel.setBounds(10, 36, 117, 22);
		contentPane.add(valorConvertidoLabel);
		
		valorConvertidoText = new JTextField();
		valorConvertidoText.setBounds(180, 36, 168, 22);
		contentPane.add(valorConvertidoText);
		valorConvertidoText.setColumns(10);
		
		JButton botaoConverter = new JButton("Converter");
		botaoConverter.setBounds(214, 119, 134, 34);
		contentPane.add(botaoConverter);
		
		botaoConverter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	converterValor();
            }
        });

	}
	
    private void converterValor() {
    	try {
            double reais = Double.parseDouble(valorReaisText.getText());

            double valorConvertido = 0.00;

            if (comboBox != null) {
                String moedaSelecionada = comboBox.getSelectedItem().toString();

                double taxaDolar = 4.98;
                double taxaLibraEsterlina = 6.40;
                double taxaEuro = 5.45;

                switch (moedaSelecionada) {
                    case "Dolar":
                        valorConvertido = reais / taxaDolar;
                        valorConvertidoText.setText(String.format("$ %.2f", valorConvertido));
                        break;
                    case "Euro":
                        valorConvertido = reais / taxaEuro;
                        valorConvertidoText.setText(String.format("€ %.2f", valorConvertido));
                        break;
                    case "Libra Esterlina":
                        valorConvertido = reais / taxaLibraEsterlina;
                        valorConvertidoText.setText(String.format("£ %.2f", valorConvertido));
                        break;
                }

            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecione uma moeda.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um valor numérico válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}
