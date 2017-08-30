package ski.patterns.composedmethod;

public class EmailTemplate {

    private String recipient;
    private String body;

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Email to '" + recipient + "', body:\n" + body;
    }
}
