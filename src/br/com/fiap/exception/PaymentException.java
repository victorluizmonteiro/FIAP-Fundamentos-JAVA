package br.com.fiap.exception;

public class PaymentException extends Exception {


	 
	private static final long serialVersionUID = 1L;

	public PaymentException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PaymentException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PaymentException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PaymentException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
