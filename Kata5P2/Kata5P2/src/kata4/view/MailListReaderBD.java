package kata4.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import kata4.model.Mail;

public final class MailListReaderBD {
	
	private static final Logger LOGGER = Logger.getLogger(MailListReaderBD.class.getName());
	
	private MailListReaderBD() {}
	
	public static List<Mail> read(final String database) {
		
		String sql = "SELECT * FROM EMAIL";
		
		List<Mail> mails = new ArrayList<Mail>();

		try (Connection conn = connect(database);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			
			while (rs.next()) {
				mails.add(new Mail(rs.getString("Mail")));
			}

		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}
		
		return mails;
		
	}
	
	private static Connection connect(final String database) {

		final String url = "jdbc:sqlite:"+database;

		Connection conn = null;

		try {

			conn = DriverManager.getConnection(url);

		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}

		return conn;
	}

}
