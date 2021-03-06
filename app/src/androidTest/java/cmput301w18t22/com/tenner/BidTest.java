package cmput301w18t22.com.tenner;

import android.test.ActivityInstrumentationTestCase2;

import java.math.BigDecimal;

import cmput301w18t22.com.tenner.classes.Bid;
import cmput301w18t22.com.tenner.classes.User;

public class BidTest extends ActivityInstrumentationTestCase2 {

    public BidTest() {
        super(Bid.class);

    }

    public void testSetOwner() {

        Bid bid = new Bid();
        User user = new User();
        bid.setOwner(user);
        assertEquals(bid.getOwner(), user);

    }

    public void testSetValue() {
        Bid bid = new Bid();
        Double val = 2.0;

        BigDecimal Bg = new BigDecimal(val);
        bid.setValue(Bg);

        assertEquals(Bg, bid.getValue());
    }


    public void testGetOwner() {
        Bid bid = new Bid();
        User user = new User();
        bid.setOwner(user);
        assertEquals(bid.getOwner(), user);
    }

    public void testGetValue() {
        Bid bid = new Bid();
        Double val = 2.0;

        BigDecimal Bg = new BigDecimal(val);
        bid.setValue(Bg);

        assertEquals(Bg, bid.getValue());
    }

}