import com.msm.enums.Color;
import com.msm.enums.TasteLevel;
import com.msm.exception.MsmBusinessException;
import com.msm.main.Apple;
import com.msm.peeler.BasicPeeler;
import com.msm.peeler.ValyrianPeeler;
import org.junit.After;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by praveenr on 01/08/2016.
 */
public class TestApple {


    @Before
    public void setUp() {

    }

    @Test(expected = MsmBusinessException.class)
    public void testConstructorWithNullValuesFails() throws Exception {
        Apple apple = new Apple(null, null, null, null);
    }

    @Test(expected = MsmBusinessException.class)
    public void testCreateFailsWhenWeightNotBetween10and100gm() throws Exception {
        Apple apple = new Apple(Color.BLUE, 5.0, TasteLevel.ONE, false);
    }

    @Test
    public void testWhenCreatedRedOrGreenUsesBasicPeeler() throws Exception {

        Apple redApple = new Apple(Color.RED, 15.0, TasteLevel.ONE, false);
        Apple greenApple = new Apple(Color.GREEN, 15.0, TasteLevel.ONE, false);
        assertTrue("Red apple with basic peeler", redApple.getPeeler() instanceof BasicPeeler);
        assertTrue("Green apple with basic peeler", greenApple.getPeeler() instanceof BasicPeeler);

    }

    @Test
    public void testWhenCreatedBlueUsesValryianPeeler() throws Exception {

        Apple redApple = new Apple(Color.BLUE, 15.0, TasteLevel.ONE, false);
        assertTrue("Blue apple with valyrian peeler", redApple.getPeeler() instanceof ValyrianPeeler);
    }


    @Test
    public void testCreateSuccessWhenAllValuesCorrect() throws Exception {

        Apple apple = new Apple(Color.BLUE, 15.0, TasteLevel.ONE, false);
        assertEquals(apple.getColor(), Color.BLUE);
        assertEquals(15.0, apple.getWeight().getValue(), 0.0);
        assertEquals(apple.getTasteLevel(), TasteLevel.ONE);
        assertFalse(apple.hasWorm());

    }

    @Test(expected = MsmBusinessException.class)
    public void testWhenAppleHasWormItCantBePeeledThrowsException() throws Exception {

        Apple apple = new Apple(Color.BLUE, 15.0, TasteLevel.FOUR, Boolean.TRUE);
        apple.peel();

    }

    @Test(expected = MsmBusinessException.class)
    public void testWhenAppleTasteLevelLessThanThreeCantBePeeledThrowsException() throws Exception {

        Apple apple = new Apple(Color.BLUE, 15.0, TasteLevel.TWO, Boolean.FALSE);
        apple.peel();

    }

    @Test
    public void testWhenHasTasteLevelGreaterThanThreeAndNoWormCanBePeeled() throws Exception {
        Apple apple = new Apple(Color.BLUE, 15.0, TasteLevel.FOUR, Boolean.FALSE);
        assertEquals(apple.getColor(), Color.BLUE);
        assertEquals(15.0, apple.getWeight().getValue(), 0.0);
        assertEquals(apple.getTasteLevel(), TasteLevel.FOUR);
        assertFalse(apple.hasWorm());
        apple.peel();

    }

    @Test(expected = MsmBusinessException.class)
    public void testWhenAppleNotPeeledBeforeEatingThrowsException() throws Exception {
        Apple apple = new Apple(Color.BLUE, 15.0, TasteLevel.FOUR, Boolean.FALSE);
        apple.eat();
    }

    @Test
    public void testAppleCanBeEatenWhenPeeled() throws Exception {
        Apple apple = new Apple(Color.BLUE, 15.0, TasteLevel.FOUR, Boolean.FALSE);
        apple.peel();
        apple.eat();
    }


    @After
    public void tearDown() {

    }


}
