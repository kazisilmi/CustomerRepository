public class Customer{
	private String name;
	private double initialBalance;
	private float finalBalance;

	public Customer(String name, double initialBalance, float finalBalance){
		this.name = name;
		this.initialBalance = initialBalance;
		this.finalBalance = finalBalance;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public double getInitialBalance(){
		return initialBalance;
	}
	public void setInitialBalance(double initialBalance){
		this.initialBalance = initialBalance;
	}
	public float getFinalBalance(){
		return finalBalance;
	}
	public void setFinalBalance(float finalBalance){
		this.finalBalance = finalBalance;
	}
}