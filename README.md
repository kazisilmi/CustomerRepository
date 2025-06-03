# CustomerRepository
import java.io.*;

public class CustomerRepository{
	private static final String FILENAME = "customers.txt";

	private static File getDataSource(){
		final File file = new File(FILENAME);
		if(!file.exists()){
			try{
				file.createNewFile();
			}catch(IOException e){
				System.out.println("Error creating file: "+FILENAME+ ":"+e.getMessage());
			}
		}
		return file;
	}
	public static void insert(Customer customer){
		FileWriter writer = null;
		try{
			writer = new FileWriter(getDataSource(),true);
			writer.write(format(customer)+"\n");

		}catch(IOException e){
			System.out.println("Error writing file: "+FILENAME+ ":"+e.getMessage());
		}finally{
			if(writer != null){
				try{
					writer.close();
				}catch(IOException e){
			        System.out.println("Error closing file: "+FILENAME+ ":"+e.getMessage());
			    }
			}
		}
	}
	public static Customer[] getAll(){
		int len = getTotalNumberofCustomers();
		int counter = 0;
		Customer[] customers = new Customer[len];
		FileReader reader = null;
		BufferedReader bufferedReader = null;
		try{
			reader = new FileReader(getDataSource());
			bufferedReader = new BufferedReader(reader);
			String line;
			while((line = bufferedReader.readline()) !=null){
				String[] words = line.split(",");
				if(words.length == 3){
					String name = words[0];
					double innitialBalance = Double.parseDouble(words[1]);
					float finalBalance = Float.parseFloat(words[2]);
					customers[counter++] = new Customer(name, innitialBalance, finalBalance);
				}
			}
		}catch(IOException e){
			System.out.println("Error getting file: "+FILENAME+ ":"+e.getMessage());
		}finally{
			closeResources(reader, bufferedReader);
		}
		return customers;
	}
	public static int getTotalNumberofCustomers(){
		int total = 0;
		FileReader reader = null;
		BufferedReader bufferedReader = null;
		try{
			reader = new FileReader(getDataSource());
			bufferedReader = new BufferedReader(reader);
			while(bufferedReader.readline() !=null){
				total++;
			}
		}catch(IOException e){
			System.out.println("Error getting file: "+FILENAME+ ":"+e.getMessage());
		}finally{
			closeResources(reader, bufferedReader);
		}
		return total;
	}
	public static void closeResources(FileReader reader, BufferedReader bufferedReader){
		if(bufferedReader != null){
			try{
				bufferedReader.close();
			}catch(IOException e){
                System.out.println("Error closing file: "+FILENAME+ ":"+e.getMessage());
			}
		}
		if( reader != null){
			try{
				reader.close();

			}catch(IOException e){
				 System.out.println("Error closing file: "+FILENAME+ ":"+e.getMessage());
			}
		}
	}
	private static String format(Customer customer){
		return customer.getName()+ ","+ customer.getInitialBalance()+","+ customer.getFinalBalance();
	}
}
