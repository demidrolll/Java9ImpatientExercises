package org.demidrolll.java9impatient.ch4.task6;

/**
 * Suppose that in Section 4.2.2, “The equals Method” (page 148), the
 * Item.equals method uses an instanceof test. Implement DiscountedItem.equals so
 * that it compares only the superclass if otherObject is an Item, but also includes
 * the discount if it is a DiscountedItem. Show that this method preserves
 * symmetry but fails to be transitive—that is, find a combination of items
 * and discounted items so that x.equals(y) and y.equals(z), but not x.equals(z).
 */

public class App {

    public static void main(String[] args) {
        Item a = new DiscountedItem("a", 1.00, 1.00);
        Item b = new Item("a", 1.00);
        Item c = new DiscountedItem("a", 1.00, 3.00);
        System.out.println(a.equals(b));
        System.out.println(b.equals(a));

        System.out.println(a.equals(b));
        System.out.println(b.equals(c));
        System.out.println(a.equals(c));
    }
}
