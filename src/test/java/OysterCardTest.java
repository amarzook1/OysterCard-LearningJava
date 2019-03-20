import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class OysterCardTest {

    private OysterCard oysterCard;

    @BeforeEach
    void beforeEach() {
        System.out.println("Initializing Test");
        oysterCard = new OysterCard(10.0, "Ahmed");
    }

    @Test
    @DisplayName("Getting current amount of money")
    void getCurrentAmount() {
        assertEquals((Double) 10.0, oysterCard.getMoney());
    }

    @Test
    @DisplayName("Getting customer name")
    void getCustomerName() {
        assertEquals("Ahmed", oysterCard.getCustomerName());
    }

    @ParameterizedTest
    @DisplayName("Allow user to add money to card")
    @CsvSource({"12.0, 2.0" , "15.0 , 5.0", "10.0 , 0.0", "10.0 , -10"})
    void addMoneyToCard(double expectedValue, double amount) {
        oysterCard.addMoneyToCard(amount);
        assertEquals((Double) expectedValue , oysterCard.getMoney());
    }

    @Test
    @DisplayName("Oyster Card has a top up limit")
    void cardTopUpLimit(){
        oysterCard.addMoneyToCard(100.0);
        assertEquals((Double) 10.0, oysterCard.getMoney());
    }


}