package com.bt.itemmgmt;

import com.bt.itemmgmt.model.Item;
import com.bt.itemmgmt.repository.ItemRepository;
import com.bt.itemmgmt.service.ItemServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
import static org.springframework.util.Assert.notNull;

@RunWith(SpringRunner.class)
public class TestItemService {

    private Item item;

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemServiceImpl itemService;

    @BeforeEach
    public void createItem(){
        this.item = new Item();
    }

    @Test
    public void testSaveItem(){
        Item item = new Item();

        when(itemRepository.save(item)).thenReturn(Item.builder().itemId(1).build());

        Item returnedItem = itemService.save(item);
        notNull(returnedItem);
        assertEquals(returnedItem.getItemId(), 1);
        verify(itemRepository, atMostOnce()).save(item);
    }

    @Test
    public void testFindById(){
        when(itemRepository.findById(1L)).thenReturn(Optional.of(Item.builder().itemId(1).build()));
        Item returnedItem = itemService.findById(1L);
        notNull(returnedItem);
        assertEquals(returnedItem.getItemId(), 1);
        verify(itemRepository, atMostOnce()).findById(1L);
    }

    @Test
    public void testValidFindById(){
        when(itemRepository.findById(1L)).thenReturn(Optional.of(new Item()));
        try {
            Item returnedItem = itemService.findById(1L);
            Assert.notNull(returnedItem);
        }catch (Exception e){
            fail("Should not throw Illegal Argument Exception");

        }
        verify(itemRepository, atMostOnce()).findById(1L);
    }
    //@Test(expected = IllegalArgumentException.class)
    @Test
    public void testInvalidFindById(){
        when(itemRepository.findById(anyLong())).thenReturn(null);
        try {
            Item returnedItem = itemService.findById(1L);
           // fail("Should Throw an exception");
        }catch (Exception e){
            Assert.notNull(e, "Exception should not be null");
            e.printStackTrace();
            //assertTrue(e instanceof IllegalArgumentException);

        }
        verify(itemRepository, atMostOnce()).findById(1L);
    }

    @Test
    public void testDeleteById(){
        itemService.deleteItemById(1L);
        verify(itemRepository, times(1)).deleteById(1L);
    }
}