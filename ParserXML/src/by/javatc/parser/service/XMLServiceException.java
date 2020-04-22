package by.javatc.parser.service;

public class XMLServiceException extends Exception {

	private static final long serialVersionUID = 3L;
	
	public XMLServiceException() {}
	
	public XMLServiceException(String message){
		super(message);
	}
	public XMLServiceException(String message, Exception e){
		super(message, e);
	}
	
	public XMLServiceException(Throwable cause) {
		super(cause);
	}
}
