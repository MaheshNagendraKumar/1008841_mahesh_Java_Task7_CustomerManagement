package in.kmnk.customerms.utility;

import in.kmnk.customerms.globalException.InvalidInputException;

public class CommonMethods {
	int customerCount = 1;

	public int generateId() {
		return customerCount++;
	}

	public boolean isValid(String name) throws InvalidInputException {
		if (name==null || name.length() < 2 || name.length() > 10) {
			throw new InvalidInputException("Invalid input");
		}
		return true;
	}
}
