package _02_GlobalUtils;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendMailWithReport {
	public static void sendEmailWithAttachment(String to, String from, String host, String filePath,
			final String username, final String password) {
		// Get system properties
		Properties properties = new Properties();

		// Setup mail server properties
		properties.put("mail.smtp.host", host); // E.g., "smtp.gmail.com"
		properties.put("mail.smtp.port", "587"); // For TLS
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true"); // Enable TLS

		// Get the Session object.
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("Automation Testing Report");

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Fill the message
			messageBodyPart.setText("Please find the attached automation testing report.");

			// Create a multipart message
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is the attachment
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(filePath);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("ExtentReport.html");
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	public static void mailReportcred() {
		String to = "maiyya007@gmail.com"; // Change accordingly
		String from = "pravin.13dev@gmail.com"; // Change accordingly
		String host = "smtp.gmail.com"; // Gmail SMTP server
		String filePath = "C:\\Users\\ganes\\eclipse-workspace\\Automation_Testing1\\target\\report.html"; // Path to
																											// the
																											// report
		String username = "pravin.13dev@gmail.com"; // Gmail username
		String password = "pravin@321"; // Gmail password (or app-specific password)

		SendMailWithReport.sendEmailWithAttachment("maiyya007@gmail.com", "pravin.13dev@gmail.com", "smtp.gmail.com",
				"C:\\Users\\ganes\\eclipse-workspace\\Automation_Testing1\\target\\report.html",
				"pravin.13dev@gmail.com", "pravin@321");
	}
}
