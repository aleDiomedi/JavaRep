import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.Border;

public class Finestra extends JFrame{
	
	JTextField txtValore, txtTipo, txtData;
	JLabel lblValore, lblTipo, lblData;
	JButton btnConferma;
	
	JTextArea txtListaTransazioni;
	JTextArea txtSaldo;
	
	ContoCorrente contoCorrente;
	
	public Finestra (ContoCorrente contoCorrente) {
		this.contoCorrente = contoCorrente;
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponent();
	}
	
	public void initComponent() {
		JPanel p1 = new JPanel();
		
		txtValore = new JTextField(10);
		lblValore = new JLabel("valore transazione");
		txtTipo = new JTextField(10);
		lblTipo = new JLabel("tipo transazione (prelievo\\deposito)");
		txtData = new JTextField(10);
		lblData = new JLabel("data (gg-mm-aaaa)");
		
		btnConferma = new JButton("conferma transazione");
		
		btnConferma.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//da Stringa a Calendar
				String[] campiData = txtData.getText().split("-");
				Calendar c = Calendar.getInstance();
				c.set(Integer.parseInt(campiData[2]), Integer.parseInt(campiData[1])+1, Integer.parseInt(campiData[0]));
				
				Transazione t = new Transazione(txtTipo.getText(), Float.parseFloat(txtValore.getText()), c);
				//eseguiTransazione tra le altre cose aggiunge la transazione all'elenco
				contoCorrente.eseguiTransazione(t);
				
				//aggiunta transazione alla JTextArea
				String txtTransazioniPrecedenti = txtListaTransazioni.getText();
				txtListaTransazioni.setText(txtTransazioniPrecedenti + t.toString() + "\n");
				
				//valorizzazione txtSaldo con saldo aggiornato
				txtSaldo.setText("saldo: €"+contoCorrente.getSaldo());
				
				//reset dei campi txt
				txtData.setText(null);
				txtTipo.setText(null);
				txtValore.setText(null);
				
			}
		});
		
		p1.add(lblValore);p1.add(txtValore);p1.add(lblTipo);p1.add(txtTipo);
		p1.add(lblData);p1.add(txtData);p1.add(btnConferma);
		
		JPanel p2 = new JPanel();
		
		txtListaTransazioni = new JTextArea();
		txtSaldo = new JTextArea();
		
		p2.add(txtListaTransazioni);
		
		JPanel p3 = new JPanel();
		p3.add(txtSaldo);
		
		this.add(p1, BorderLayout.NORTH);
		this.add(p2, BorderLayout.CENTER);
		this.add(p3,BorderLayout.SOUTH);
		
	}
	public static void main(String [] args) {
		ContoCorrente contoCorrente = new ContoCorrente(1000);
		Finestra finestra = new Finestra(contoCorrente);
		finestra.setVisible(true);
	}
}
