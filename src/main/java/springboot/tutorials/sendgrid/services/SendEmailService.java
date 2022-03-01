package springboot.tutorials.sendgrid.services;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import com.sendgrid.SendGrid;
import springboot.tutorials.sendgrid.dto.DestinationDTO;

import java.io.IOException;


public class SendEmailService {
    @Autowired
    private SendGrid sendGrid = new SendGrid(System.getenv("SENDGRID_API_KEY"));


    public  String sendEmail(DestinationDTO destinationDTO) {
        Email sourceAddress = new Email("adwoabrembah@gmail.com", "Adwoa Brembah");
        Email destinationAddress = new Email(destinationDTO.getEmailAddress(), destinationDTO.getRecipientName());
        String subject = "Test Email";
        String message = "This email was sent at " + System.currentTimeMillis();
        Content content = new Content("text/plain", message);
        Response response = new Response();
        Mail mail = new Mail(sourceAddress, subject, destinationAddress, content);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response = sendGrid.api(request);
            System.out.println(response.getBody());
            System.out.println(response.getStatusCode());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return response.getBody();

    }
}
