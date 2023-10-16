package in.kmnk.customerms.utility;

import in.kmnk.customerms.globalException.CustomeExceptions;

public class CommonMethods {
	int customerCount = 1;

	public int generateId() {
		return customerCount++;
	}

	public boolean isValid(String name) {
		if (name==null || name.length() < 2 || name.length() > 10) {
			throw new CustomeExceptions("");
		}
		return true;
	}
}
