/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaMail;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author gomes
 */
public class JavaMail {
    public static void sendEmail(String emailDestinatario, String senhaDestinatario){
        Properties props = new Properties();
 try {
        /** Parâmetros de conexão com servidor Gmail */
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
 
            Session session = Session.getInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   return new PasswordAuthentication("naorespondaappp@gmail.com", "@dm!n!@#");
                             }
                        });
 
            /** Ativa Debug para sessão */
            session.setDebug(true);
 
            
 
                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("naorespondaappp@gmail.com")); //Remetente
 
                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse(emailDestinatario);  
 
                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject("Usuário criado com sucesso");//Assunto
                  message.setText("Segue senha para usuário do sistema da Farmácia!"
                          + "Senha: "+senhaDestinatario);
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);
 
             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
    }
}
