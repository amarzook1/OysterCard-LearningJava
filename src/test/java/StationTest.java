import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

class StationTest {
    private Station harrow, bakerloo;
    private OysterCard oysterCard;

    @BeforeEach
    void beforeEach() {
        System.out.println("Initializing Test");
        harrow = new HarrowOnTheHill();
        bakerloo = new Bakerloo();
        oysterCard = new OysterCard(10.0,"Ahmed Marzook");
    }

    @Test
    @DisplayName("Get Station Name")
    void getStationName() {
        Station harrow = new HarrowOnTheHill();
        assertEquals("Harrow_On_The_Hill_Station" , harrow.getName());
    }

    @Test
    @DisplayName("Able to touch in")
    void touchIn() {
        harrow.touchIn(oysterCard);
        assertTrue(oysterCard.isInJourney());
    }

    @Test
    @DisplayName("Able to touch out")
    void touchOut() {
        harrow.touchIn(oysterCard);
        bakerloo.touchOut(oysterCard);
        assertFalse(oysterCard.isInJourney());
    }

    @Test
    @DisplayName("Entry Station is stored")
    void storeEntryStation(){
        harrow.touchIn(oysterCard);
        assertEquals("Harrow_On_The_Hill_Station", oysterCard.getEntryStation().get(0));
    }

    @Test
    @DisplayName("Exit station is stored")
    void storeExitStaion() {
        harrow.touchIn(oysterCard);
        bakerloo.touchOut(oysterCard);
        assertEquals("Bakerloo" , oysterCard.getExitStation().get(0));
    }

    @Test
    @DisplayName("Cant touch out of station unless in journey")
    void touchOutNotInJourney() {
        harrow.touchOut(oysterCard);
        assertFalse(oysterCard.isInJourney());
    }

    @Test
    @DisplayName("Cant touch in station if already in journey")
    void touchInIfAlreadyInJourney() {
        harrow.touchIn(oysterCard);
        assertTrue(oysterCard.isInJourney());
    }

}
