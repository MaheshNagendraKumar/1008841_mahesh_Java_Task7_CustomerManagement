package in.kmnk.customerms.services;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import in.kmnk.customerms.domain.Customer;
import in.kmnk.customerms.globalException.CustomerNotFoundException;
import in.kmnk.customerms.globalException.InsufficientTextException;
import in.kmnk.customerms.globalException.InvalidInputException;
import in.kmnk.customerms.globalException.NoCustomersFoundWithGivenTextException;
import in.kmnk.customerms.utility.CommonMethods;

public class CustomerServiceImpl implements ICustomerService {

	private Map<Integer, Customer> customerStore = new HashMap<>();
	private CommonMethods utilityMethod = new CommonMethods();

	@Override
	public Customer registerCustomer(String fname, String lname) throws InvalidInputException {
		if (utilityMethod.isValid(fname) && utilityMethod.isValid(lname)) {
			int id = utilityMethod.generateId();
			Customer customer = new Customer(id, fname, lname);
			customerStore.put(id, customer);
			return customer;
		}
		return null;
	}

	@Override
	public Customer findCustomerById(int cid) throws InvalidInputException, CustomerNotFoundException {
		if (cid > 0) {
			Optional<Customer> findFirst = customerStore.entrySet().stream()
					.filter(entry -> entry.getValue().getCid() == cid).map(Entry::getValue).findFirst();

			if (findFirst.isPresent()) {
				return findFirst.get();
			}
			throw new CustomerNotFoundException("Customer not found with the given id");
		}
		throw new InvalidInputException("Invalid Input");
	}

	@Override
	public List<Customer> findCustomersByFirstNameAscendingId(String cFirstName)
			throws NoCustomersFoundWithGivenTextException, InsufficientTextException {
		if (cFirstName != null && cFirstName.length() > 3) {
			List<Customer> matchingFirstNameCustomerList = customerStore.entrySet().stream()
					.filter(customerEntry -> customerEntry.getValue().getcFirstName().toLowerCase()
							.startsWith(cFirstName.toLowerCase()))
					.map(Entry::getValue).sorted(Comparator.comparing(Customer::getCid)).collect(Collectors.toList());

			if (!matchingFirstNameCustomerList.isEmpty()) {
				return matchingFirstNameCustomerList;
			}

			throw new NoCustomersFoundWithGivenTextException("No Customer found with the given firstname");
		}
		throw new InsufficientTextException("Insufficient text for search");
	}

}
