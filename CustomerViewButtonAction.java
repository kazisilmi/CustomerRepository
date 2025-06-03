import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerViewButtonAction implements ActionListener{
	JFrame customerPageFrame;
	public CustomerViewButtonAction(JFrame customerPageFrame){
		this.customerPageFrame = customerPageFrame;
	}
	public void actionPerformed(ActionEvent e){
    	this.customerPageFrame.setVisible(false);
    	CustomerPage customerPage = new CustomerPage();
    	customerPage.getFrame().setVisible(true);
    }
}