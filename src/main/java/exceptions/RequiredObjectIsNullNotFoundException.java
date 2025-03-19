package exceptions;

public class RequiredObjectIsNullNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RequiredObjectIsNullNotFoundException() {
		super("It is not allowed to persist a null object");
	}

	public RequiredObjectIsNullNotFoundException(String msg) {
		super(msg);
	}
}
