package listeneri;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import glavniPaket.Prozor;

public class MyActionListener2 implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton btn= (JButton)e.getSource();
		Prozor prozor= (Prozor) btn.getTopLevelAncestor();
		
		if(btn.getText().equals(".")) {
			prozor.newNumber(btn.getText());
		}
		else if(btn.getText().equals("=")){
			prozor.performOp();
		}
		else if(btn.getText().equals("C")) {
			prozor.reset();
		}
		else if(btn.getText().equals("DEL")) {
			prozor.delete();
		}
		else if(btn.getText().equals("+-")) {
			prozor.pMinus();
		}
		else if(btn.getText().equals("sqrt")) {
			prozor.sqrtOp();
		}
		else if(btn.getText().equals("^2")) {
			prozor.sqrOp();
		}
		else {
			prozor.enterOp(btn.getText());
		}
	}

}
