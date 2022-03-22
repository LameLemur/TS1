package lab05;

import lab04teacher.DBManager;
import lab04teacher.Mail;
import lab04teacher.MailHelper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockMailHelperTest {

    DBManager mockDBManager = Mockito.mock(DBManager.class);
    MailHelper mailHelper = new MailHelper(mockDBManager);

//    @Test
//    public void negativeVerifySendMailOnce() {
//
//        mailHelper.sendMail(Mockito.anyInt());
//
//        Mockito.verify(mockDBManager, times(2)).findMail(Mockito.anyInt());
//    }

    @Test
    public void positiveVerifySendMailOnce() {

        mailHelper.sendMail(Mockito.anyInt());

        Mockito.verify(mockDBManager).findMail(Mockito.anyInt());
    }

    @Test
    public void mockText() {

        int mailId = 1;
        Mail mail = getMail();

        Mockito.when(mockDBManager.findMail(mailId)).thenReturn(mail);
        mailHelper.sendMail(mailId);

        Mockito.verify(mockDBManager).findMail(mailId);
    }

    @Test
    public void checkMailReturnsCorrectTo() {

        int mailId = Mockito.anyInt();
        Mockito.when(mockDBManager.findMail(mailId)).thenReturn(getMail());
        mailHelper.sendMail(mailId);
        assertEquals("test@test.test", mailHelper.getMail().getTo());
    }

    @Test
    public void checkMailReturnsCorrectBody() {

        int mailId = Mockito.anyInt();
        Mockito.when(mockDBManager.findMail(mailId)).thenReturn(getMail());
        mailHelper.sendMail(mailId);
        assertEquals("bodybodybodytest", mailHelper.getMail().getBody());
    }

     @Test
    public void checkMailReturnsCorrectSubject() {

        int mailId = Mockito.anyInt();
        Mockito.when(mockDBManager.findMail(mailId)).thenReturn(getMail());
        mailHelper.sendMail(mailId);
        assertEquals("subjecttest", mailHelper.getMail().getSubject());
    }

    private Mail getMail() {
        Mail mail = new Mail();
        mail.setTo("test@test.test");
        mail.setBody("bodybodybodytest");
        mail.setSubject("subjecttest");
        return mail;
    }
}
