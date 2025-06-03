import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerPageViewButtonAction implements ActionListener{
	JFrame customerPageFrame;
    public CustomerPageViewButtonAction(JFrame customerPageFrame){
    	this.customerPageFrame = customerPageFrame;
    }
    public void actionPerformed(ActionEvent e){
    	this.customerPageFrame.setVisible(false);
    	CustomerView customerView = new CustomerView();
    	customerView.getFrame().setVisible(true);
    }
}