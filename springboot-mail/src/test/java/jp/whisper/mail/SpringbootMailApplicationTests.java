package jp.whisper.mail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootMailApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    JavaMailSender javaMailSender;

    @Test
    public void testSimpleMail(){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setSubject("这是测试邮件主题");
        msg.setText("这是测试邮件内容");
        msg.setFrom("cndone@gmail.com");
        msg.setSentDate(new Date());
        msg.setTo("cndone@gmail.com");
        javaMailSender.send(msg);
    }

    @Test
    public void testMineMessage() throws MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setSubject("这是测试邮件主题(带附件)");
        helper.setText("这是测试邮件内容(带附件)");
        helper.setFrom("cndone@gmail.com");
        helper.setSentDate(new Date());
        helper.setTo("cndone@gmail.com");
        helper.addAttachment("whisper.png", new File("C:\\whisper.png"));
        javaMailSender.send(msg);
    }

    @Test
    public void testMineMessageWithPic() throws MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setSubject("这是测试邮件主题(带图片)");
        helper.setText("这是测试邮件内容(带图片)，这是第一张图片：<img src='cid:p01'/>，这是第二张图片：<img src='cid:p02'/>", true);
        helper.setFrom("cndone@gmail.com");
        helper.setSentDate(new Date());
        helper.setTo("cndone@gmail.com");
        helper.addInline("p01", new FileSystemResource(new File("C:\\whisper.png")));
        helper.addInline("p02", new FileSystemResource(new File("C:\\whisper2.png")));
        javaMailSender.send(msg);
    }

    @Autowired
    TemplateEngine templateEngine;

    @Test
    public void testThemeleaf() throws MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setSubject("这是测试邮件主题(thymeleaf)");
        Context context = new Context();
        context.setVariable("username", "whisper");
        context.setVariable("position", "Java工程师");
        context.setVariable("dep", "产品研发部");
        context.setVariable("salary", 999999);
        context.setVariable("joblevel", "高级工程师");
        String process = templateEngine.process("mail_01.html", context);
        helper.setText(process, true);
        helper.setFrom("cndone@gmail.com");
        helper.setSentDate(new Date());
        helper.setTo("cndone@gmail.com");
        javaMailSender.send(msg);
    } 
    
    @Test
    public void testFreemark() throws MessagingException, IOException, TemplateException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setSubject("这是测试邮件主题(freemarker)");
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
        configuration.setClassLoaderForTemplateLoading(this.getClass().getClassLoader(),"templates");
        Template template = configuration.getTemplate("mail_01.ftlh");
        Map<String, Object> map = new HashMap<>();
        map.put("username", "whisper");
        map.put("position", "Java工程师");
        map.put("dep", "产品研发部");
        map.put("salary", 999999);
        map.put("joblevel", "高级工程师");
        StringWriter out = new StringWriter();
        template.process(map, out);
        helper.setText(out.toString(), true);
        helper.setFrom("cndone@gmail.com");
        helper.setSentDate(new Date());
        helper.setTo("cndone@gmail.com");
        javaMailSender.send(msg);
    } 

}
