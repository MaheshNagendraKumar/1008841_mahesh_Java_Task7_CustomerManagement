package in.kmnk.customerms.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.kmnk.customerms.domain.Customer;
import in.kmnk.customerms.globalException.CustomeExceptions;
import in.kmnk.customerms.services.CustomerServiceImpl;

public class CustomerUI {
	CustomerServiceImpl service = new CustomerServiceImpl();

	public static void main(String[] args) {
		  CustomerUI ui=new CustomerUI();

		try {
			ui.registerAndDisplay("mahesh", "karri");
			ui.registerAndDisplay("Amaresh", "Giri");
//			ui.registerAndDisplay(null,null);
			ui.registerAndDisplay("Asish", "Gopan");
			ui.registerAndDisplay("Sampath", "Kondapur");
			
			
				
			System.out.println("\n\n");
			int cid=3;
			ui.fetchAndDisplay(cid);
			
			
			System.out.println("\n\n");
			String firstname = "aMar";
			ui.displayFilteredCustomers(firstname);
			

		} catch (Exception e) {
			System.out.println("Something went wrong");
		}

	}
	
	public void fetchAndDisplay(int id) {
		Customer customer=service.findCustomerById(id);
		display(customer);
	}
	
	public void registerAndDisplay(String first, String last) {
		try {
		Customer customer = service.registerCustomer(first, last);
		display(customer);
		}catch(CustomeExceptions e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void displayFilteredCustomers(String firstname) {
		List<Customer> findCustomersByFirstNameAscendingId = service.findCustomersByFirstNameAscendingId(firstname);
		for(Customer customer:findCustomersByFirstNameAscendingId) {
			System.out.println(customer);
		}
	}
	
	void display(Customer customer) {
		System.out.println("customer-"+customer.getCid()+"-"+customer.getcFirstName());
	}
}
