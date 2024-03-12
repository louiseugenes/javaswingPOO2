package jframe;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class MaiorMenorAverage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField numbersTextField;
	private JTextField averageTextField;
	private JTextField maiorTextField;
	private JTextField menorTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaiorMenorAverage frame = new MaiorMenorAverage();
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
	public MaiorMenorAverage() {
		
		setTitle("Calculadora de Maior, Menor e Média - by: Luis Eugênio");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel confirmLabel = new JLabel("Digite o número:");
		confirmLabel.setBounds(10, 11, 153, 30);
		confirmLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(confirmLabel);
		
		JButton confirmButton = new JButton("OK");
		confirmButton.setBackground(new Color(128, 128, 255));
		confirmButton.setBounds(173, 48, 153, 30);
		contentPane.add(confirmButton);
		
		JButton showButton = new JButton("Exibir");
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showValorMaxMinAverage();
			}
		});
		showButton.setBackground(new Color(128, 128, 255));
		showButton.setBounds(336, 168, 153, 30);
		contentPane.add(showButton);
		
		numbersTextField = new JTextField();
		numbersTextField.setBounds(10, 48, 153, 30);
		contentPane.add(numbersTextField);
		numbersTextField.setColumns(10);
		
		maiorTextField = new JTextField();
		maiorTextField.setBounds(173, 127, 153, 30);
		contentPane.add(maiorTextField);
		maiorTextField.setColumns(10);
		
		menorTextField = new JTextField();
		menorTextField.setBounds(173, 168, 153, 30);
		contentPane.add(menorTextField);
		menorTextField.setColumns(10);
		
		averageTextField = new JTextField();
		averageTextField.setBounds(173, 209, 153, 30);
		contentPane.add(averageTextField);
		averageTextField.setColumns(10);
		
		JLabel maiorLabel = new JLabel("Maior >>>");
		maiorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		maiorLabel.setBounds(10, 127, 153, 30);
		maiorLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(maiorLabel);
		
		JLabel menorLabel = new JLabel("Menor >>>");
		menorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menorLabel.setBounds(10, 168, 153, 30);
		menorLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(menorLabel);
		
		JLabel averageLabel = new JLabel("Média >>>");
		averageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		averageLabel.setBounds(10, 208, 153, 30);
		averageLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(averageLabel);
		
		JLabel waringLabel = new JLabel("<html><b>Aviso</b>: Os números devem ser separados por <b>VÍRGULA</b>, ex: 1,2,3,4</html>");
		waringLabel.setHorizontalAlignment(SwingConstants.CENTER);
		waringLabel.setBounds(345, 42, 174, 73);
		waringLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(waringLabel);
	}
	
    private void showValorMaxMinAverage() {
    	String[] numbersStr = numbersTextField.getText().split(",");
        List<Double> numbers = new ArrayList<>();
    	try {
    		for (String numStr : numbersStr) {
                double num = Double.parseDouble(numStr.trim());
                numbers.add(num);
    		}

            if (!numbers.isEmpty()) {
                double maxValue = Double.MIN_VALUE;
                double minValue = Double.MAX_VALUE;
                double sum = 0.0;

                for (double num : numbers) {
                    if (num > maxValue) {
                        maxValue = num;
                    }
                    if (num < minValue) {
                        minValue = num;
                    }
                    sum += num;
                }

                double averageValue = sum / numbers.size();

                maiorTextField.setText(String.valueOf(maxValue));
                menorTextField.setText(String.valueOf(minValue));
                averageTextField.setText(String.valueOf(averageValue));

            } else {
                JOptionPane.showMessageDialog(this, "Por favor, digite os números!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um valor numérico válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
