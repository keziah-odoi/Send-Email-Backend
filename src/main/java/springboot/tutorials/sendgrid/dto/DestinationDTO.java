package springboot.tutorials.sendgrid.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sendgrid.helpers.mail.objects.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DestinationDTO {
    @JsonProperty
    private String emailAddress;
    @JsonProperty
    private String recipientName;
}
