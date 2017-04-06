package helpers;

/**
 * Created by v_minjajlo on 23.02.2017.
 */
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class MyUtilMail {
///////////////////////////////////////////////////////////////////////////////////////////////
    public static void mailSend(String subject, String text, String emailTo) throws IOException {

        final String myMail = "vtl.maestro@gmail.com";
        final String myName = "Виталий Маестро";
        final String username = "Виталий Маестро";
        final String password = "vtl06071975vtlvtl";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myMail, myName));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);

            System.out.println(emailTo + " " + subject + " Done");

        } catch (MessagingException e) {
            throw new RuntimeException( e );
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////

//    String  d_email = "address@gmail.com",
//            d_uname = "Name",
//            d_password = "urpassword",
//            d_host = "smtp.gmail.com",
//            d_port  = "465",
//            m_to = "toAddress@gmail.com",
//            m_subject = "Indoors Readable File: " + params[0].getName(),
//            m_text = "This message is from Indoor Positioning App. Required file(s) are attached.";
//    Properties props = new Properties();
//    props.put("mail.smtp.user", d_email);
//    props.put("mail.smtp.host", d_host);
//    props.put("mail.smtp.port", d_port);
//    props.put("mail.smtp.starttls.enable","true");
//    props.put("mail.smtp.debug", "true");
//    props.put("mail.smtp.auth", "true");
//    props.put("mail.smtp.socketFactory.port", d_port);
//    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//    props.put("mail.smtp.socketFactory.fallback", "false");
//
//    SMTPAuthenticator auth = new SMTPAuthenticator();
//    Session session = Session.getInstance(props, auth);
//    session.setDebug(true);
//
//    MimeMessage msg = new MimeMessage(session);
//    try {
//        msg.setSubject(m_subject);
//        msg.setFrom(new InternetAddress(d_email));
//        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
//
//        Transport transport = session.getTransport("smtps");
//        transport.connect(d_host, Integer.valueOf(d_port), d_uname, d_password);
//        transport.sendMessage(msg, msg.getAllRecipients());
//        transport.close();
//
//    } catch (AddressException e) {
//        e.printStackTrace();
//        return false;
//    } catch (MessagingException e) {
//        e.printStackTrace();
//        return false;
//    }
}
