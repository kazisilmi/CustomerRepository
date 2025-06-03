import javax.swing.*;

public class CustomerPage{
	private JFrame frame;
	private JPanel panel;
	private JTextField nameTextField;
	private JTextField initialBalanceTextField;
	private JTextField finalBalanceTextField;
	private JButton submitButton;
	private JButton viewButton;

	public CustomerPage(){
		frame = new JFrame("Customer entry form");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setLayout(null);

		JLabel nameLabel = new JLabel("Customer Name: ");
		nameLabel.setBounds(50,40,80,40);
		panel.add(nameLabel);
        
        nameTextField = new JTextField();
        nameTextField.setBounds(150,40,160,40);
        panel.add(nameTextField);

        JLabel initialBalanceLabel = new JLabel("Initial Balance: ");
		initialBalanceLabel.setBounds(50,80,80,40);
		panel.add(initialBalanceLabel);

		initialBalanceTextField = new JTextField();
        initialBalanceTextField.setBounds(150,80,160,40);
        panel.add(initialBalanceTextField);
        
        JLabel finalBalanceLabel = new JLabel("Final Balance: ");
		finalBalanceLabel.setBounds(50,120,80,40);
		panel.add(finalBalanceLabel);

		finalBalanceTextField = new JTextField();
        finalBalanceTextField.setBounds(150,120,160,40);
        panel.add(finalBalanceTextField);

        submitButton = new JButton("Submit ");
        submitButton.setBounds(150,170,160,40);
        submitButton.addActionListener(new CustomerPageSubmitButtonAction(nameTextField, initialBalanceTextField, finalBalanceTextField));
        panel.add(submitButton);

        viewButton = new JButton("View ");
        viewButton.setBounds(150,230,160,40);
        viewButton.addActionListener(new CustomerPageViewButtonAction(frame));
        panel.add(viewButton);
        
        frame.add(panel);

	}
	public JFrame getFrame(){
		return frame;
	}
}