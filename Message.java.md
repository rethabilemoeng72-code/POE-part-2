# Message.java  
  
import java.util.Random;  
import javax.swing.JOptionPane;  
  
public class Message {  
    private String messageId;  
    private int numMessagesSent;  
    private String recipient;  
    private String messageText;  
    private String messageHash;  
  
    public Message(String recipient, String messageText, int numMessagesSent) {  
        this.recipient = recipient;  
        this.messageText = messageText;  
        this.numMessagesSent = numMessagesSent;  
        this.messageId = generateMessageId();  
        this.messageHash = createMessageHash();  
    }  
  
    // Part 2 requirement: Generate random 10-digit ID  
    public String generateMessageId() {  
        Random rand = new Random();  
        long id = 1000000000L + (long)(rand.nextDouble() * 9000000000L);  
        return String.valueOf(id);  
    }  
  
    // Check ID is not more than 10 digits  
    public boolean checkMessageId() {  
        return messageId.length() <= 10;  
    }  
  
    // Check recipient cell: must start with + and have <=10 chars after, like international  
    public int checkRecipientCell() {  
        if (recipient != null && recipient.startsWith("+") && recipient.length() <= 13 && recipient.length() >= 10) {  
            return 1; // valid  
        }  
        return 0; // invalid  
    }  
  
    // Check message length <= 250 chars  
    public String checkMessageLength() {  
        if (messageText.length() <= 250) {  
            return "Message ready to send.";  
        } else {  
            int excess = messageText.length() - 250;  
            return "Message exceeds 250 characters by " + excess + ", please reduce size.";  
        }  
    }  
  
    // Create hash: first 2 of ID : numSent : first+last word upper  
    public String createMessageHash() {  
        String[] words = messageText.split(" ");  
        String first = words[0];  
        String last = words[words.length - 1];  
        String idPart = messageId.substring(0, 2);  
        return (idPart + ":" + numMessagesSent + ":" + first + last).toUpperCase();  
    }  
  
    // Send message options  
    public String sendMessage() {  
        String[] options = {"Send Message", "Disregard Message", "Store Message to send later"};  
        int choice = JOptionPane.showOptionDialog(null, "Choose what to do with message:",  
                "Send Message", 0, 3, null, options, options[0]);  
  
        if (choice == 0) {  
            return "Message successfully sent.";  
        } else if (choice == 1) {  
            return "Press 0 to delete message.";  
        } else {  
            // Store to JSON (simplified for Part 2)  
            return "Message successfully stored.";  
        }  
    }  
  
    public String printMessages() {  
        return "MessageID: " + messageId + "\n" +  
               "MessageHash: " + messageHash + "\n" +  
               "Recipient: " + recipient + "\n" +  
               "Message: " + messageText;  
    }  
  
    public int returnTotalMessages() {  
        return numMessagesSent;  
    }  
  
    // Getters  
    public String getMessageId() { return messageId; }  
    public String getRecipient() { return recipient; }  
    public String getMessageText() { return messageText; }  
    public String getMessageHash() { return messageHash; }  
}  
