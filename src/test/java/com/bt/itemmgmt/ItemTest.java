package com.bt.itemmgmt;

import com.bt.itemmgmt.model.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
public class ItemTest {

    @Test
    public void testConstructor(){
        Item item = new Item();
        Assert.assertEquals(0, item.getItemId());
        Assert.assertEquals(null, item.getItemName());
        Assert.assertEquals(null, item.getDescription());
    }
    @Test
    public void testItemIdSetterMethod(){
        Item item = new Item();
        item.setItemName("Lenovo");
        item.setDescription("Lenovo laptop");
        item.setPrice(15000);

        Assert.assertEquals(15000, item.getPrice(), 0);
        Assert.assertEquals("Lenovo laptop", item.getDescription());
        Assert.assertEquals("Lenovo", item.getItemName());
    }

    @Test
    public void testEquals(){
        Item item = new Item();
        item.setItemId(10);

        Item item2 = new Item();
        item2.setItemId(10);

        assertTrue(item.equals(item2));

    }


}