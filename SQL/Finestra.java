import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Finestra extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JTextField txtMatricola, txtNome, txtCognome;
	JButton btnConferma;


	public Finestra () {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	initComponent();

	}

	public void initComponent() {
		GestioneStudenti gs = new GestioneStudenti();

		JPanel p1 = new JPanel();
		txtMatricola = new JTextField(10);
		txtNome = new JTextField(10);
		txtCognome = new JTextField(10);
		btnConferma = new JButton("conferma");
		btnConferma.addActionListener(new ActionListener() {

@Override

	public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Studente s = new Studente (txtMatricola.getText(), txtNome.getText(), txtCognome.getText());
	gs.inserisciStudente(s);
	
	
	//reset dei campi txt
	txtMatricola.setText(null);
	txtNome.setText(null);
	txtCognome.setText(null);
			}
		});

		p1.add(txtMatricola);p1.add(txtNome);
		p1.add(txtCognome);p1.add(btnConferma);

		this.add(p1, BorderLayout.NORTH);
		}

	public static void main(String [] args) {
		Finestra finestra = new Finestra();
		finestra.setVisible(true);
		}

}
