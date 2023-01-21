package kata4.model;

public final class Mail {
	
	private final String mail;
	
	public Mail(final String mail) {
		this.mail = mail;
	}
	
	public String getDomain() {
		return mail.substring(mail.indexOf('@')+1);
	}
	
	@Override
	public String toString() {
		return mail;
	}

}
