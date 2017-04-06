package helpers;

import java.security.Security;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class NewSimpleMail {
    private static String mailhost = "mail.intelserv.kiev.ua";

    private String myMail;
    private String password;

    public NewSimpleMail(String myMail, String password){
        this.myMail = myMail;
        this.password = password;
    }

    public synchronized void sendMail(String subject, String body, String sender, String recipients) throws Exception {

//        myMail = "v_minjajlo";
//      final String myName = "v_minjajlo";
//      final String username = "v_minjajlo";
//      final String proxyHost = "squid.office.intelserv.com";
//      final String proxyPost = "3128";

//      System.setProperty("mail.socket.debug", "true");
//      Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Properties props = new Properties();

        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", mailhost);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "25");
//        props.put("mail.smtp.socks.host", proxyHost);
//        props.put("mail.smtp.socks.port", proxyPost);
//        props.setProperty("proxySet","true");
//        props.setProperty("socksProxyHost",proxyHost);
//        props.setProperty("socksProxyPort",proxyPost);
//        props.put("mail.socket.debug", "true");
//        props.put("mail.smtp.ssl.enable", "true");
//        props.put("mail.smtp.socketFactory.port", "25");
//        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.socketFactory.fallback", "false");
//        props.setProperty("mail.smtp.quitwait", "false");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myMail, password);
            }
        });

        MimeMessage message = new MimeMessage(session);
        message.setSender(new InternetAddress(sender));
        message.setSubject(subject, "utf-8");
        message.setContent(body, "text/plain; charset=utf-8");
        if (recipients.indexOf(',') > 0)
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
        else
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipients));

        Transport.send(message);

    }

}
