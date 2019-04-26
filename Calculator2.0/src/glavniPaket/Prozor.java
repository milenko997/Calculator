package glavniPaket;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import listeneri.MyActionListener;
import listeneri.MyActionListener2;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Prozor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Metodi podaci;

	public Prozor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Prozor.class.getResource("/glavniPaket/ninja-simple-512.png")));
		podaci = new Metodi();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Calculator");
		setSize(350, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		GridLayout grid= new GridLayout(5, 4);
		JPanel panel = new JPanel(grid);
		
		JButton sedam= new JButton("7");
		sedam.addActionListener(new MyActionListener());
		panel.add(sedam);
		
		JButton osam= new JButton("8");
		osam.addActionListener(new MyActionListener());
		panel.add(osam);
		
		JButton devet= new JButton("9");
		devet.addActionListener(new MyActionListener());
		panel.add(devet);
		
		JButton podeljeno= new JButton("/");
		podeljeno.addActionListener(new MyActionListener2());
		panel.add(podeljeno);
		
		JButton cetiri= new JButton("4");
		cetiri.addActionListener(new MyActionListener());
		panel.add(cetiri);
		
		JButton pet= new JButton("5");
		pet.addActionListener(new MyActionListener());
		panel.add(pet);
		
		JButton sest= new JButton("6");
		sest.addActionListener(new MyActionListener());
		panel.add(sest);
		
		JButton puta= new JButton("*");
		puta.addActionListener(new MyActionListener2());
		panel.add(puta);
		
		JButton jedan= new JButton("1");
		jedan.addActionListener(new MyActionListener());
		panel.add(jedan);
		
		JButton dva= new JButton("2");
		dva.addActionListener(new MyActionListener());
		panel.add(dva);
		
		JButton tri= new JButton("3");
		tri.addActionListener(new MyActionListener());
		panel.add(tri);
		
		JButton minus= new JButton("-");
		minus.addActionListener(new MyActionListener2());
		panel.add(minus);
		
		JButton zarez= new JButton(".");
		zarez.addActionListener(new MyActionListener2());
		panel.add(zarez);
		
		JButton nula= new JButton("0");
		nula.addActionListener(new MyActionListener());
		panel.add(nula);
		
		JButton clear= new JButton("C");
		clear.addActionListener(new MyActionListener2());
		panel.add(clear);
		
		JButton plus= new JButton("+");
		plus.addActionListener(new MyActionListener2());
		panel.add(plus);
		
		JButton pMinus= new JButton("+-");
		pMinus.addActionListener(new MyActionListener2());
		panel.add(pMinus);
		
		JButton sqrt= new JButton("sqrt");
		sqrt.addActionListener(new MyActionListener2());
		panel.add(sqrt);
		
		JButton kvadrat= new JButton("^2");
		kvadrat.addActionListener(new MyActionListener2());
		panel.add(kvadrat);
		
		JButton del= new JButton("DEL");
		del.addActionListener(new MyActionListener2());
		panel.add(del);
		
		contentPane.add(panel);
		
		JButton jednako= new JButton("=");	
		jednako.addActionListener(new MyActionListener2());
		contentPane.add(jednako, BorderLayout.SOUTH);
		
		jednako.setFont(new Font("Arial", Font.PLAIN, 22));
		clear.setFont(new Font("Arial", Font.PLAIN, 22));
		nula.setFont(new Font("Arial", Font.PLAIN, 22));
		zarez.setFont(new Font("Arial", Font.PLAIN, 22));
		minus.setFont(new Font("Arial", Font.PLAIN, 22));
		tri.setFont(new Font("Arial", Font.PLAIN, 22));
		dva.setFont(new Font("Arial", Font.PLAIN, 22));
		jedan.setFont(new Font("Arial", Font.PLAIN, 22));
		puta.setFont(new Font("Arial", Font.PLAIN, 22));
		sest.setFont(new Font("Arial", Font.PLAIN, 22));
		pet.setFont(new Font("Arial", Font.PLAIN, 22));
		cetiri.setFont(new Font("Arial", Font.PLAIN, 22));
		podeljeno.setFont(new Font("Arial", Font.PLAIN, 22));
		devet.setFont(new Font("Arial", Font.PLAIN, 22));
		osam.setFont(new Font("Arial", Font.PLAIN, 22));
		sedam.setFont(new Font("Arial", Font.PLAIN, 22));
		pMinus.setFont(new Font("Arial", Font.PLAIN, 22));
		sqrt.setFont(new Font("Arial", Font.PLAIN, 22));
		kvadrat.setFont(new Font("Arial", Font.PLAIN, 22));
		del.setFont(new Font("Arial", Font.PLAIN, 22));
		
	}

	public void newNumber(String s) {
		textField.setText(textField.getText()+s);
	}
	public void enterOp(String s) {
		if(podaci.getOperacija()!=null) {
			return;
		}
		else {
			podaci.setOperacija(s);
			try {
				podaci.setPrethodnoUneseno(Double.parseDouble(textField.getText()));
				textField.setText("");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void performOp() {
		if(podaci.getOperacija()== null) {
			return;
		}
		else {
			try {
				podaci.setTrenutnoUneseno(Double.parseDouble(textField.getText()));
				textField.setText(String.valueOf(podaci.akcija()));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void pMinus() {
		if(textField.getText().charAt(0)!='-') {
			textField.setText("-"+textField.getText());
		}
		else {
			textField.setText(textField.getText().substring(1));
		}
	}
	
	public void sqrtOp() {
		if(podaci.getOperacija()!=null) {
			return;
		}
		Double temp=null;
		try {
			temp = Double.parseDouble(textField.getText());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if(temp!=null) {
			textField.setText(String.valueOf(Math.sqrt(temp)));
		}
	}
	
	public void sqrOp() {
		if(podaci.getOperacija()!=null) {
			return;
		}
		Double temp=null;
		try {
			temp = Double.parseDouble(textField.getText());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if(temp!=null) {
			textField.setText(String.valueOf(temp*temp));
		}
	}
	
	public void reset() {
		podaci = new Metodi();
		delete();
	}

	public void delete() {
		textField.setText("");
	}
}
