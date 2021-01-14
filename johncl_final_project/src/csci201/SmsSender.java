package csci201;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {

 public static final String ACCOUNT_SID =
         "AC6a39f477a926450c8c17bcd0fa226ebb";
 public static final String AUTH_TOKEN =
         "fab656db5fc6b8950814a15626ca1573";

 public static void main(String[] args) {
     Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

     Message message = Message
             .creator(new PhoneNumber("+19493736542"), // to
                     new PhoneNumber("+17605732716"), // from
                     "Test")
             .create();

     System.out.println(message.getSid());
 }
}