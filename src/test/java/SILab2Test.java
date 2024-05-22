import org.junit.jupiter.api.Test;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    //private Item item1 = new Item("jogurt", "0123", 100, 0);
    private Item item2 = new Item("jogurt", "a", 100, 0);
    private Item item3 = new Item(null, null, 100, 0);
    private Item item4 = new Item("jogurt", "0123", 400, 0.5F);
    private Item item5 = new Item("jogurt", "0123", 40, 0);
    //List<Item> item1 = new List<Item>(item)

    private List<Item> createList(Item elems) {
        return new ArrayList<>(Arrays.asList(elems));
    }

    @Test
    void testEveryBranch(){

        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 10));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(createList(item2), 10));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(createList(item3), 10));
        assertTrue(ex.getMessage().contains("No barcode!"));

        assertFalse(SILab2.checkCart(createList(item4), 10));

        assertTrue(SILab2.checkCart(createList(item5), 1000));
    }

    @Test
    void multipleConditions(){
        assertFalse(SILab2.checkCart(createList(item5), 10));
    }

}