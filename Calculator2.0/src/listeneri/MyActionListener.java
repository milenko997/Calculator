package listeneri;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import glavniPaket.Prozor;

public class MyActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton btn = (JButton) e.getSource();
		Prozor prozor = (Prozor) btn.getTopLevelAncestor();
	
		prozor.newNumber(btn.getText());
	}

}
