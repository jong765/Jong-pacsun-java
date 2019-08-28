package com.pacsun.util;

import java.util.HashMap;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.pacsun.constants.EmailConstants;

public class HtmlEmail implements EmailConstants {

	private String smtpHost;
	private String mailSmtpAuth;
	private String smtpUser;
	private String smtpPassword;
	private String emailSubject;
	private InternetAddress[] addressTo;
	private String content;
	private HashMap<String, String> propMap;

	public void sendEmail() {

		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", smtpHost);
		properties.put("mail.smtp.auth", mailSmtpAuth);

		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(smtpUser, smtpPassword);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(smtpUser));
			message.addRecipients(Message.RecipientType.TO, addressTo);

			message.setSubject(emailSubject);
			message.setContent(this.getContent(), "text/html");
			message.setHeader("X-Priority", "1");

			Transport.send(message);
			System.out.println("Email sent....");
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}

	public void setAddressTo() {
		StringTokenizer st = new StringTokenizer(propMap.get(EMAIL_RECIPIENTS), ",");
		this.addressTo = new InternetAddress[st.countTokens()];
		int i = 0;

		try {
			while (st.hasMoreElements()) {
				this.addressTo[i++] = new InternetAddress((String) st.nextElement());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public HashMap<String, String> getPropMap() {
		return propMap;
	}

	public void setPropMap(HashMap<String, String> propMap) {
		this.propMap = propMap;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public String getMailSmtpAuth() {
		return mailSmtpAuth;
	}

	public void setMailSmtpAuth(String mailSmtpAuth) {
		this.mailSmtpAuth = mailSmtpAuth;
	}

	public String getSmtpUser() {
		return smtpUser;
	}

	public void setSmtpUser(String smtpUser) {
		this.smtpUser = smtpUser;
	}

	public String getSmtpPassword() {
		return smtpPassword;
	}

	public void setSmtpPassword(String smtpPassword) {
		this.smtpPassword = smtpPassword;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

}