package com.entropik.wereabletest;

/**
 * Created by Pablo on 8/10/13.
 */
import java.util.ArrayList;

public class Model {

    public static ArrayList<Item> Items;

    public static void LoadModel() {

        Items = new ArrayList<Item>();
        Items.add(new Item(1, "Contacts/1.jpg", "Anita Sulivan"));
        Items.add(new Item(2, "Contacts/2.jpg", "Periko Palotes"));
        Items.add(new Item(3, "Contacts/3.jpg", "Toni Mc.Nil"));
        Items.add(new Item(4, "Contacts/4.jpg", "Jonnatan Dos Santos"));
        Items.add(new Item(5, "Contacts/5.jpg", "Martin McFly"));
        Items.add(new Item(6, "Contacts/6.jpg", "Louis \"El mendas\""));
        Items.add(new Item(7, "Contacts/7.jpg", "Franky the Jungle"));
    }

    public static Item GetbyId(int id){

        for(Item item : Items) {
            if (item.Id == id) {
                return item;
            }
        }
        return null;
    }

    public static Item get_menu(int pos)
    {
        return Items.get(pos);
    }

}
