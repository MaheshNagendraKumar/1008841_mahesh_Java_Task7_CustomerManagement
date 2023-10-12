package in.kmnk.customerms.services;

import java.util.List;

import in.kmnk.customerms.domain.Customer;

public interface ICustomerService {
	
	// keep employee store List<Employee>
//	public Customer registerCustomer(String efirstName, String elastName);
	public Customer registerCustomer(Customer c);
	
	public Customer findCustomerById(int eid);
	
	// find customers by firstName
	public List<Customer> findCustomersByFirstNameAscendingId(String cFirstName);
}
