package jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java. util. Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomicGame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField numberChoiceField;
	private JButton verifyButton;
	private JButton tryAgainButton;
	private JLabel numberSubtitleLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandomicGame frame = new RandomicGame();
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
	public RandomicGame() {
		setTitle("Jogo do advinhe - by: Luis Eugênio");
		JOptionPane.showMessageDialog(this, "Bem-vindo ao jogo! Escolha um número entre 1 e 10. Boa sorte!", "Bem-vindo", JOptionPane.INFORMATION_MESSAGE);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 233);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel numberTitleLabel = new JLabel("<html><h1>Advinhe o Número</h1><html>");
		numberTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numberTitleLabel.setBounds(53, 11, 230, 49);
		contentPane.add(numberTitleLabel);
		
		numberSubtitleLabel = new JLabel("<html><h4>Digite o Número:</h4><html>");
		numberSubtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numberSubtitleLabel.setBounds(100, 58, 132, 27);
		contentPane.add(numberSubtitleLabel);
		
		numberChoiceField = new JTextField();
		numberChoiceField.setBounds(78, 96, 175, 35);
		contentPane.add(numberChoiceField);
		numberChoiceField.setColumns(10);
		
		verifyButton = new JButton("<html><h2><b>Arriscar</b></h2><html>");
		verifyButton.setBounds(78, 142, 175, 35);
		//verifyButton.setVisible(true);
		contentPane.add(verifyButton);
		
		verifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verifySortNumber();
			}
		});
		
		tryAgainButton = new JButton("<html><h2><b>Tente Novamente</b></h2><html>");
		tryAgainButton.setBounds(78, 96, 180, 45);
		tryAgainButton.setVisible(false);
		contentPane.add(tryAgainButton);
		
		
		tryAgainButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        numberChoiceField.setVisible(true);
		        verifyButton.setVisible(true);
		        tryAgainButton.setVisible(false);
		    }
		});
	}
	
	private void verifySortNumber() {

    	try {
    		Random randomNumber = new Random();
    		String numberChoiced = numberChoiceField.getText();
    		
    		int sortedNumber = randomNumber.nextInt(10);
    		int convertedToIntNumber = Integer.parseInt(numberChoiced);
    		
            if (convertedToIntNumber != 0) {
            	if (sortedNumber != convertedToIntNumber) {
            		JOptionPane.showMessageDialog(this, "Não foi dessa vez :/", "Loose", JOptionPane.ERROR_MESSAGE);
            		numberChoiceField.setVisible(false);
            		verifyButton.setVisible(false);
            		tryAgainButton.setVisible(true);
            		numberSubtitleLabel.setVisible(false);
            	}
            	else {
            		JOptionPane.showMessageDialog(this, "Parabéns, você ganhou!! :D", "Win!!", JOptionPane.INFORMATION_MESSAGE);
            		numberChoiceField.setVisible(false);
            		verifyButton.setVisible(false);
            		tryAgainButton.setVisible(true);
            		numberSubtitleLabel.setVisible(false);
            	}

            } else {
                JOptionPane.showMessageDialog(this, "Por favor, digite o número!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um valor numérico válido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
