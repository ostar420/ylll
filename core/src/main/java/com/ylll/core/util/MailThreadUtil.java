package com.ylll.core.util;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 *
 * @author YL
 */
public class MailThreadUtil
{
  private static final Executor threadPool = new ScheduledThreadPoolExecutor(10);

  private static Runnable createTask(final MailPO mailPO) {
    return new Runnable(){

		public void run() {
			try {
		          Resource resource = new ClassPathResource("/mail.properties");
		          Properties props = PropertiesLoaderUtils.loadProperties(resource);
		          SendMail sendMail = new SendMail();
		          sendMail.setSmtpServer(props.getProperty("stmpserver"));
		          sendMail.setSmtpPort(Integer.valueOf(Integer.parseInt(props.getProperty("stmpport"))));
		          sendMail.setUsername(props.getProperty("username"));
		          sendMail.setPassword(props.getProperty("password"));
		          sendMail.setTo(props.getProperty("toaddr"));
		          sendMail.setFrom(props.getProperty("fromaddr"));
		          sendMail.setSubject(mailPO.getTitle());
		          sendMail.setContent(mailPO.getContent());
		          sendMail.sendHtml();
		        } catch (IOException e) {
		          e.printStackTrace();
		        }
		}
    	
    	
    };
  }

    /**
     *
     * @param mailPO
     */
    public static void execute(MailPO mailPO)
  {
    threadPool.execute(createTask(mailPO));
  }
}