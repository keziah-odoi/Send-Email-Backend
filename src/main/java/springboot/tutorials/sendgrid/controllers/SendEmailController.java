package springboot.tutorials.sendgrid.controllers;

import org.springframework.web.bind.annotation.*;
import springboot.tutorials.sendgrid.dto.DestinationDTO;
import springboot.tutorials.sendgrid.services.SendEmailService;

@RestController
@RequestMapping(value = "/api/v1")
public class SendEmailController {

    private SendEmailService sendEmailService = new SendEmailService();

    @GetMapping("/")
    public String sayHello() {
        return "Hello";
    }

    @PostMapping("/raw")
    public String sendEmail() {
        return sendEmailService.sendEmail(null);

    }  @PostMapping("/")
    public String sendEmailToRecipient(@RequestBody DestinationDTO destinationDTO) {
        return sendEmailService.sendEmail(destinationDTO);

    }
}
