package in.kmnk.customerms.globalException;

public class InsufficientTextException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InsufficientTextException(String message) {
		super(message);
	}

}
