package in.kmnk.customerms.services;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import in.kmnk.customerms.domain.Customer;
import in.kmnk.customerms.globalException.CustomeExceptions;

public class CustomerServiceImpl implements ICustomerService {

	Map<Integer, Customer> customerStore;
	int customerCount;

	public CustomerServiceImpl(Map<Integer, Customer> customerStore, int customerCount) {
		super();
		this.customerStore = customerStore;
		this.customerCount = customerCount;
	}

	@Override
	public Customer registerCustomer(Customer c) throws CustomeExceptions {

		if (c.getcFirstName().length() >= 2 && c.getcFirstName().length() <= 10 && c.getcLastName().length() >= 2
				&& c.getcLastName().length() <= 10) {

			customerStore.put(customerCount++, c);
			return c;
		}
		throw new CustomeExceptions("invalid Input");
	}

	@Override
	public Customer findCustomerById(int cid) throws CustomeExceptions {
		if (cid > 0) {
			Optional<Customer> findFirst = customerStore.entrySet().stream()
					.filter(entry -> entry.getValue().getCid() == cid).map(Entry::getValue).findFirst();

			if (findFirst.isPresent()) {
				return findFirst.get();
			}
			throw new CustomeExceptions("Customer not found with the given id");
		}
		throw new CustomeExceptions("Invalid Input");
	}

	@Override
	public List<Customer> findCustomersByFirstNameAscendingId(String cFirstName) {
		// TODO Auto-generated method stub
		if(cFirstName.length() > 3) {
			List<Customer> matchingFirstNameCustomerList = customerStore.entrySet().stream()
					.filter(customerEntry -> customerEntry.getValue().getcFirstName().toLowerCase()
							.startsWith(cFirstName.toLowerCase()))
					.map(Entry::getValue)
					.sorted(Comparator.comparing(Customer::getCid))
					.collect(Collectors.toList());
			
			if (!matchingFirstNameCustomerList.isEmpty()) {
				return matchingFirstNameCustomerList;
			}
			
			throw new CustomeExceptions("No Customer found with the given firstname");
		}
		throw new CustomeExceptions("Insufficient text for search");
	}
}
