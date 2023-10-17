package in.kmnk.customerms.ui;

import java.util.List;

import in.kmnk.customerms.domain.Customer;
import in.kmnk.customerms.globalException.CustomerNotFoundException;
import in.kmnk.customerms.globalException.InsufficientTextException;
import in.kmnk.customerms.globalException.InvalidInputException;
import in.kmnk.customerms.globalException.NoCustomersFoundWithGivenTextException;
import in.kmnk.customerms.services.CustomerServiceImpl;

public class CustomerUI {
	CustomerServiceImpl service = new CustomerServiceImpl();

	public static void main(String[] args) {
		CustomerUI ui = new CustomerUI();

		try {
			ui.registerAndDisplay("k", "kumar");
			ui.registerAndDisplay("mahesh", "karri");
			ui.registerAndDisplay("Amaresh", "Giri");
			ui.registerAndDisplay(null, null);
			ui.registerAndDisplay("Asish", "Gopan");
			ui.registerAndDisplay("SaMpath", "Kondapurama");
			ui.registerAndDisplay("SAmpath", "KoNdapur");
			ui.registerAndDisplay("sampath", "KondapUr");

			System.out.println("\n\nEnter customer id to find: ");

			int cid = 7;
			ui.fetchAndDisplay(cid);

			System.out.println("\n\n");
			String firstname = "samp";
			ui.displayFilteredCustomers(firstname);

		} catch (Exception e) {
			System.out.println("Something went wrong");
		}

	}

	public void fetchAndDisplay(int id) {
		try {
			Customer customer = service.findCustomerById(id);
			display(customer);
		} catch (InvalidInputException | CustomerNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public void registerAndDisplay(String first, String last) {
		try {
			Customer customer = service.registerCustomer(first, last);

			display(customer);
		} catch (InvalidInputException e) {
			System.out.println(e.getMessage());
		}
	}

	public void displayFilteredCustomers(String firstname) {
		try {
			List<Customer> findCustomersByFirstNameAscendingId = service.findCustomersByFirstNameAscendingId(firstname);
			for (Customer customer : findCustomersByFirstNameAscendingId) {
				System.out.println(customer);
			}
		} catch (NoCustomersFoundWithGivenTextException | InsufficientTextException e) {
			System.out.println(e.getMessage());
		}
	}

	void display(Customer customer) {
		System.out.println("customer-" + customer.getCid() + "-" + customer.getcFirstName());
	}
}
