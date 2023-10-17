package in.kmnk.customerms.globalException;

public class NoCustomersFoundWithGivenTextException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoCustomersFoundWithGivenTextException(String message) {
		super(message);
	}

}
