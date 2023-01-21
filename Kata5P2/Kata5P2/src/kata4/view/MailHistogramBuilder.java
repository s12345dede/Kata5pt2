package kata4.view;

import java.util.List;

import kata4.model.Histogram;
import kata4.model.Mail;

public final class MailHistogramBuilder {
	
	private MailHistogramBuilder() {}
	
	public static Histogram<String> build(final List<Mail> mails) {
		
		final Histogram<String> histogram = new Histogram<>();
		
		mails.forEach(mail -> histogram.increment(mail.getDomain()));
		
		return histogram;
		
	}

}
