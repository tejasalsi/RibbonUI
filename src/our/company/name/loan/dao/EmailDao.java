package our.company.name.loan.dao;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import our.company.name.application.utils.BooleanAndMessages;
import our.company.name.application.utils.EmailUtils;
import our.company.name.loan.application.enums.UserType;

public interface EmailDao extends GenericDao {

	/**
	 * This method checks the DB table - "User" for the provided Email-ID.
	 * 
	 */
	public BooleanAndMessages isEmailIdUnique(String emailId, UserType userType);

	/**
	 * Using this method an auto-generated email will be sent to given email-ID. 
	 * Step-1: The given email will be checked against user records in DB. 
	 * Step-2: If email-ID found in DB, then it will send mail and return 
	 * BooleanAndMessages(true, str1, str2)
	 */
	public BooleanAndMessages sendPasswordInEmail(String emailID,
			String password);

	/**
	 * This method should be used to send a "General" Email.
	 */
	public BooleanAndMessages sendEmail(EmailUtils emailUtils);

	/* Getters and Setters (START) */
	public JavaMailSenderImpl getMailSender();

	public void setMailSender(JavaMailSenderImpl mailSender);

	public SimpleMailMessage getMailMessage();

	public void setMailMessage(SimpleMailMessage mailMessage);

	/* Getters and Setters (END) */

}
