package br.com.doadores.exception;

public class UsernameNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsernameNotFoundException(String text) {
		super(text);
	}
}
