import javax.swing.*;
import java.awt.*;

public class CustomerView{

	private JFrame frame;
	private JPanel panel;
	private JTextArea customerTextArea;
	private JButton customerButton;

	public CustomerView(){
		frame = new JFrame("Customer Records");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		panel = new JPanel();
		panel.setLayout(null);
        
        customerTextArea = new  JTextArea();
        customerTextArea.setEditable(false);
        customerTextArea.setBounds(50,50,400,370);
        panel.add(customerTextArea);
         
        customerButton = new JButton(" Create new Customer");
        customerButton.setBounds(100,360,200,50);
        customerButton.addActionListener(new CustomerViewBackButtonAction(frame));
        panel.add(customerButton);

        frame.add(panel);
        loadCustomerData();
	}
	private void  loadCustomerData(){
		Customer[] customers = CustomerRepository.getAll();
		if(customers.length == 0){
			customerTextArea.setText("No customer records found.");
		}else{
			StringBuilder builder = new StringBuilder();
			for (int i=0; i < customers.length; i++){
				builder.append("Name: ").append(customers[i].getName())
				       .append(", Initial Balance: ").append(customers[i].getInitialBalance())
				       .append(", Final Balance: ").append(customers[i].getFinalBalance())
				       .append("\n");
			}
			customerTextArea.setText(builder.toString());
		}
	}
	public JFrame getFrame(){
		return frame;
	}
}