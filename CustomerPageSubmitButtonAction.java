import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerPageSubmitButtonAction implements ActionListener{
	JTextField nameTextField;
	JTextField initialBalanceTextField;
	JTextField finalBalanceTextField;

	public CustomerPageSubmitButtonAction(JTextField nameTextField,JTextField initialBalanceTextField,JTextField finalBalanceTextField){
		this.nameTextField = nameTextField;
		this.initialBalanceTextField = initialBalanceTextField;
		this.finalBalanceTextField = finalBalanceTextField;
	}
	public void actionPerformed(ActionEvent e){
		try{
			String name = nameTextField.getText().trim();
			double initialBalance = Double.parseDouble(initialBalanceTextField.getText().trim());
			float finalBalance = Float.parseFloat(finalBalanceTextField.getText().trim());

			Customer customer = new Customer(name, initialBalance, finalBalance);
			CustomerRepository.insert(customer);
			JOptionPane.showMessageDialog(null, "Customer saved successfully!");

			nameTextField.setText("");
			initialBalanceTextField.setText("");
			finalBalanceTextField.setText("");
			
		}catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(null, "Invalid values!");
		}

	}
    
}