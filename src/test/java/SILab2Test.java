import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class SILab2Test {
    private final Item nb = new Item("",null,1,0f);
    private final Item wfb = new Item("","bc",1,0f);
    private final Item trueTest = new Item("item","01",300,0.15f);
    private final Item falseTest= new Item("item","11",300,0f);
    List<Item> list = null;
    public static void main(String[] args) {

    }
    @Test
    void nullList(){
        RuntimeException nullEx;
        nullEx = assertThrows(RuntimeException.class,() -> SILab2.checkCart(null,0));
        assertTrue(nullEx.getMessage().contains("allItems list can't be null!"));
    }
    @Test
    void nullBarcode(){
        RuntimeException nullBar;
        List<Item> itemList = new ArrayList<>();
        itemList.add(nb);
        nullBar=assertThrows(RuntimeException.class, () -> SILab2.checkCart(itemList,0));
        String.format("%s",nullBar.getMessage());
        assertTrue(nullBar.getMessage().equals("No barcode!"));
    }
    @Test
    void wrongFormatBarcode(){
        RuntimeException wrongFormat;
        Item item = new Item("","bc",1,1);
        List<Item> list = new ArrayList<>();
        list.add(item);
        wrongFormat = assertThrows(RuntimeException.class, () ->SILab2.checkCart(list,0));
        assertTrue(wrongFormat.getMessage().contains("Invalid character in item barcode!"));
    }
    @Test
    void trueTest(){
        List<Item> list = new ArrayList<>();
        list.add(trueTest);
        assertTrue(SILab2.checkCart(list,300));
    }

    @Test
    void falseTest(){
        List<Item> list = new ArrayList<>();
        list.add(falseTest);
        assertFalse(SILab2.checkCart(list,250));
    }
}
