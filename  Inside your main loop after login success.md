#   
  
// Inside your main loop after login success:  
String recipient = JOptionPane.showInputDialog("Enter recipient number (+27617328972):");  
String text = JOptionPane.showInputDialog("Enter your message (max 250):");  
  
Message myMessage = new Message(recipient, text, 1);  
  
if (myMessage.checkRecipientCell() == 0) {  
    JOptionPane.showMessageDialog(null, "Cell phone number is incorrectly formatted or does not contain an international code.");  
} else {  
    JOptionPane.showMessageDialog(null, myMessage.checkMessageLength());  
    JOptionPane.showMessageDialog(null, myMessage.printMessages());  
    JOptionPane.showMessageDialog(null, myMessage.sendMessage());  
}  
