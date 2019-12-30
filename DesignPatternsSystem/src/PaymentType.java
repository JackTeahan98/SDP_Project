import java.text.ParseException;

public interface PaymentType {
    String payment(Member member, Phone phone) throws ParseException;
}
