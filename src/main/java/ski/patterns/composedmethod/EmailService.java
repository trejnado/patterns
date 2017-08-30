package ski.patterns.composedmethod;

public class EmailService {

    public void send(EmailTemplate emailTemplate) {
        System.out.println("Sending:\n" + emailTemplate);
    }
}