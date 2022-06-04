package com.scm.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class SendMail {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendmessage() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("scm19971114@gmail.com"+"(大帅哥)");
        mimeMessageHelper.setTo("786742228@qq.com");
        mimeMessageHelper.setSubject("标题");
        mimeMessageHelper.setText("<a href='www.baidu.com'>百度yixia</a>",true);
        mimeMessageHelper.addAttachment("tupian.log",new File("D:\\server.2022-05-29.0.log"));
        javaMailSender.send(mimeMessage);
    }
}
