# Test unit  
  
import org.junit.jupiter.api.Test;  
import static org.junit.jupiter.api.Assertions.*;  
  
public class MessageTest {  
  
    // Test 1: Message ID is 10 digits or less  
    @Test  
    public void testCheckMessageId() {  
        Message msg = new Message("+27831234567", "Hi there", 1);  
        assertTrue(msg.checkMessageId(), "Message ID should be <= 10 digits");  
        assertEquals(10, msg.getMessageId().length());  
    }  
  
    // Test 2: Valid recipient cell - should pass  
    @Test  
    public void testValidRecipientCell() {  
        Message msg = new Message("+27831234567", "Hello World", 1);  
        assertEquals(1, msg.checkRecipientCell(), "Valid number with + and 10-13 chars should return 1");  
    }  
  
    // Test 3: Invalid recipient cell - no + or too long  
    @Test  
    public void testInvalidRecipientCell() {  
        Message msg1 = new Message("0831234567", "Hello", 1); // no +  
        assertEquals(0, msg1.checkRecipientCell());  
  
        Message msg2 = new Message("+278312345678901234", "Hello", 1); // too long  
        assertEquals(0, msg2.checkRecipientCell());  
    }  
  
    // Test 4: Message length valid (<=250)  
    @Test  
    public void testValidMessageLength() {  
        Message msg = new Message("+27831234567", "Hi there", 1);  
        assertEquals("Message ready to send.", msg.checkMessageLength());  
    }  
  
    // Test 5: Message length invalid (>250)  
    @Test  
    public void testInvalidMessageLength() {  
        // Create a message with 260 characters  
        String longText = "a".repeat(260);  
        Message msg = new Message("+27831234567", longText, 1);  
        String result = msg.checkMessageLength();  
        assertTrue(result.contains("exceeds 250 characters"));  
        assertTrue(result.contains("10")); // 260-250 = 10 excess  
    }  
  
    // Test 6: Message Hash is correctly formatted  
    @Test  
    public void testCreateMessageHash() {  
        Message msg = new Message("+27831234567", "Hi there", 1);  
        // Hash format: first 2 of ID : num : FIRSTLAST uppercase  
        String hash = msg.getMessageHash();  
        assertNotNull(hash);  
        assertTrue(hash.contains(":1:"));  
        assertTrue(hash.contains("HITHERE") || hash.contains("HI"));  
    }  
  
    // Test 7: Total messages returned correctly  
    @Test  
    public void testReturnTotalMessages() {  
        Message msg = new Message("+27831234567", "Test message", 5);  
        assertEquals(5, msg.returnTotalMessages());  
    }  
  
    // Test 8: Print messages contains all info  
    @Test  
    public void testPrintMessages() {  
        Message msg = new Message("+27831234567", "Hello World", 1);  
        String printed = msg.printMessages();  
        assertTrue(printed.contains("+27831234567"));  
        assertTrue(printed.contains("Hello World"));  
        assertTrue(printed.contains("MessageID:"));  
        assertTrue(printed.contains("MessageHash:"));  
    }  
}  
