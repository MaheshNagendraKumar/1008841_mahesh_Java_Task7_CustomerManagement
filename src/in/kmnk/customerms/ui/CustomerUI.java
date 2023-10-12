package in.kmnk.customerms.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.kmnk.customerms.domain.Customer;
import in.kmnk.customerms.globalException.CustomeExceptions;
import in.kmnk.customerms.services.CustomerServiceImpl;

public class CustomerUI {

	public static void main(String[] args) {
		Map<Integer, Customer> customerStore = new HashMap<>();
		int customerCount = 1;

		Customer customer1 = new Customer(1, "mahesh", "karri");
		Customer customer2 = new Customer(2, "Amaresh", "Giri");
		Customer customer3 = new Customer(3, "Asish", "Gopan");
		Customer customer4 = new Customer(4, "Sampath", "Kondapuram");
		Customer customer5 = new Customer(5, "Karthik", "Kante");
		Customer customer6 = new Customer(6, "mahesh", "ganugulu");
		Customer customer7 = new Customer(7, "Amaresh", "karri");
		Customer customer8 = new Customer(8, "Amaresh", "garu");

		CustomerServiceImpl service = new CustomerServiceImpl(customerStore, customerCount);

		try {
			Customer registerCustomer = service.registerCustomer(customer1);
			System.out.println(registerCustomer);
			registerCustomer = service.registerCustomer(customer2);
			System.out.println(registerCustomer);
			registerCustomer = service.registerCustomer(customer3);
			System.out.println(registerCustomer);
			registerCustomer = service.registerCustomer(customer4);
			System.out.println(registerCustomer);
			registerCustomer = service.registerCustomer(customer5);
			System.out.println(registerCustomer);
			registerCustomer = service.registerCustomer(customer6);
			System.out.println(registerCustomer);
			registerCustomer = service.registerCustomer(customer7);
			System.out.println(registerCustomer);
			registerCustomer = service.registerCustomer(customer8);
			System.out.println(registerCustomer);
			
				
			System.out.println("\n\n");
			int cid=2;
			Customer findCustomerById = service.findCustomerById(cid);
			System.out.println(findCustomerById);
			
			
			System.out.println("\n\n");
			String firstname = "aMARESH";
			List<Customer> findCustomersByFirstNameAscendingId = service.findCustomersByFirstNameAscendingId(firstname);
			for(Customer customer:findCustomersByFirstNameAscendingId) {
				System.out.println(customer);
			}

		} catch (CustomeExceptions e) {
			System.out.println(e.getMessage());
		}

	}
}
