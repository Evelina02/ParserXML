package by.javatc.parser.dao;

public class XMLDAOException extends Exception {

	private static final long serialVersionUID = 3L;
	
	public XMLDAOException() {}
	
	public XMLDAOException(String message){
		super(message);
	}
	public XMLDAOException(String message, Exception e){
		super(message, e);
	}
	
	public XMLDAOException(Throwable cause) {
		super(cause);
	}
}
