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
//    Made method private Test not needed anymore
//    @ParameterizedTest
//    @DisplayName("Allow user to deduct money from card")
//    @CsvSource({"8.0, 2.0" , "5 , 5.0", "10.0 , 0.0", "10.0 , -10"})
//    void deductMoneyFromCard(double expectedValue, double amount) {
//        oysterCard.deductMoneyFromCard(amount);
//        assertEquals((Double) expectedValue , oysterCard.getMoney());
//    }

    @Test
    @DisplayName("When user touch in user is in journey")
    void touchIn() {
        oysterCard.touchIn();
        assertTrue(oysterCard.isInJourney());
    }

    @Test
    @DisplayName("When user touch out user is not in journey")
    void touchOut(){
        oysterCard.touchIn();
        oysterCard.touchOut();
        assertFalse(oysterCard.isInJourney());
    }

    @Test
    @DisplayName("User on default is not in journey until touch in")
    void inJourneyDefault() {
        assertFalse(oysterCard.isInJourney());
    }

    @Test
    @DisplayName("Refuse user to touch unless they have enough balance")
    void touchInMinimumBalance() {
        oysterCard = new OysterCard(0.5, "Ahmed");
        assertFalse(oysterCard.touchIn());
    }

    @Test
    @DisplayName("Deduct money from user account when they touch out")
    void touchOutDeductMoney() {
        oysterCard.touchIn();
        oysterCard.touchOut();
        assertEquals((Double) 9.0, oysterCard.getMoney());
    }

    @Test
    @DisplayName("User can only touch out if in journey")
    void touchOutInJourney() {
        assertTrue(oysterCard.touchOut());
    }

    @Test
    @DisplayName("User cant touch in if already in journey")
    void touchInJourney() {
        oysterCard.touchIn();
        assertFalse(oysterCard.touchIn());
    }

}