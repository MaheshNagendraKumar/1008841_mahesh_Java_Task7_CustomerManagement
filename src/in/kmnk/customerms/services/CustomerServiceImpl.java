package in.kmnk.customerms.services;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import in.kmnk.customerms.domain.Customer;
import in.kmnk.customerms.globalException.CustomeExceptions;
import in.kmnk.customerms.utility.CommonMethods;

public class CustomerServiceImpl implements ICustomerService {

	private Map<Integer, Customer> customerStore;
	private CommonMethods utilityMethod = new CommonMethods();


	@Override
	public Customer registerCustomer(String fname, String lname) throws CustomeExceptions {
		if (utilityMethod.isValid(fname) && utilityMethod.isValid(lname)) {
			int id=utilityMethod.generateId();
			Customer customer = new Customer(id, fname, lname);
			customerStore.put(id, customer);
			return customer;
		}
		return null;
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
		if (cFirstName != null && cFirstName.length() > 3) {
			List<Customer> matchingFirstNameCustomerList = customerStore.entrySet().stream()
					.filter(customerEntry -> customerEntry.getValue().getcFirstName().toLowerCase()
							.startsWith(cFirstName.toLowerCase()))
					.map(Entry::getValue).sorted(Comparator.comparing(Customer::getCid))
					.collect(Collectors.toList());

			if (!matchingFirstNameCustomerList.isEmpty()) {
				return matchingFirstNameCustomerList;
			}

			throw new CustomeExceptions("No Customer found with the given firstname");
		}
		throw new CustomeExceptions("Insufficient text for search");
	}

}
