package in.kmnk.customerms.domain;

public class Customer {

	private long cid;
	private String cFirstName;
	private String cLastName;

	public Customer(long cid, String cFirstName, String cLastName) {
		super();
		this.cid = cid;
		this.cFirstName = cFirstName;
		this.cLastName = cLastName;
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getcFirstName() {
		return cFirstName;
	}

	public void setcFirstName(String cFirstName) {
		this.cFirstName = cFirstName;
	}

	public String getcLastName() {
		return cLastName;
	}

	public void setcLastName(String cLastName) {
		this.cLastName = cLastName;
	}

	@Override
	public String toString() {
		return "Customer : cid=" + cid + ", FirstName=" + cFirstName + ", LastName=" + cLastName ;
	}

}
