package com.ylll.core.util;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class SendMail
{
  private String smtpServer;
  private Integer smtpPort;
  private String from;
  private String to;
  private String username;
  private String password;
  private String subject;
  private String content;

  public SendMail()
  {
  }

  public SendMail(String smtpServer, Integer smtpPort, String from, String to, String username, String password, String subject, String content)
  {
    this.smtpServer = smtpServer;
    this.smtpPort = smtpPort;
    this.from = from;
    this.to = to;
    this.username = username;
    this.password = password;
    this.subject = subject;
    this.content = content;
  }

  public boolean sendHtml()
  {
    try
    {
      Properties props = retrieveProps();

      Session session = retrieveSession(props);

      MimeMessage msg = new MimeMessage(session);
      msg.setFrom(new InternetAddress(this.from));

      InternetAddress[] addresses = { new InternetAddress(this.to) };

      msg.setRecipients(Message.RecipientType.TO, addresses);

      //this.subject = transferChinese(this.subject);

      msg.setSubject(this.subject);

      Multipart mp = new MimeMultipart();
      MimeBodyPart mbpContent = new MimeBodyPart();

      mbpContent.setContent(this.content, "text/html; charset=utf-8");
      mp.addBodyPart(mbpContent);
      msg.setContent(mp);

      msg.setSentDate(new Date());

      Transport.send(msg);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  private Properties retrieveProps() throws Exception {
    Properties props = new Properties();
    props.put("mail.smtp.host", this.smtpServer);
    //props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.port", this.smtpPort);
    props.put("mail.smtp.auth", "true");
    return props;
  }

  private Session retrieveSession(Properties props) {
    Session session = Session.getDefaultInstance(props, new Authenticator()
    {
      public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(SendMail.this.username, SendMail.this.password);
      }
    });
    return session;
  }

  private String transferChinese(String strText)
  {
    try {
      strText = MimeUtility.encodeText(new String(strText.getBytes(), "UTF-8"), "UTF-8", "B");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return strText;
  }

//  public static void main(String[] args)
//  {
//    MailPO mailPO = new MailPO();
//    mailPO.setTitle("this is a test mail嗷嗷");
//    mailPO.setContent("新华网北京5月11日电 外交部发言人华春莹11日宣布：应巴西联邦共和国总统罗塞夫、哥伦比亚共和国总统桑托斯、秘鲁共和国总统乌马拉、智利共和国总统巴切莱特邀请，国务院总理李克强将于5月18日至26日对上述四国进行正式访问");
//    MailThreadUtil.execute(mailPO);
//  }

  public String getSmtpServer()
  {
    return this.smtpServer;
  }

  public void setSmtpServer(String smtpServer) {
    this.smtpServer = smtpServer;
  }

  public Integer getSmtpPort() {
    return this.smtpPort;
  }

  public void setSmtpPort(Integer smtpPort) {
    this.smtpPort = smtpPort;
  }

  public String getFrom() {
    return this.from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return this.to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSubject() {
    return this.subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}