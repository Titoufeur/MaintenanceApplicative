package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {


    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void regular5days(){
        Item[] brie = new Item[] {new Item ("regular", 5, 5)};
        GildedRose app = new GildedRose(brie);
        app.updateQuality();
        assertEquals("regular", app.items[0].name);
        assertEquals(4, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void regularSubZero(){
        Item[] brie = new Item[] {new Item ("regular", -1, 5)};
        GildedRose app = new GildedRose(brie);
        app.updateQuality();
        assertEquals("regular", app.items[0].name);
        assertEquals(3, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void backstage(){
        Item[] brie = new Item[] {new Item ("Backstage passes to a TAFKAL80ETC concert", 5, 5)};
        GildedRose app = new GildedRose(brie);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(8, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void backstage10(){
        Item[] brie = new Item[] {new Item ("Backstage passes to a TAFKAL80ETC concert", 10, 5)};
        GildedRose app = new GildedRose(brie);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(7, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void backstageSubZero(){
        Item[] brie = new Item[] {new Item ("Backstage passes to a TAFKAL80ETC concert", -1, 5)};
        GildedRose app = new GildedRose(brie);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void agedBrie5days(){
        Item[] brie = new Item[] {new Item ("Aged Brie", 5, 5)};
        GildedRose app = new GildedRose(brie);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(6, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void agedBrieSubZero(){
        Item[] brie = new Item[] {new Item ("Aged Brie", -1, 5)};
        GildedRose app = new GildedRose(brie);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(6, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void sulfuras(){
        Item[] brie = new Item[] {new Item ("Sulfuras, Hand of Ragnaros", 5, 80)};
        GildedRose app = new GildedRose(brie);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(80, app.items[0].quality);
        assertEquals(5, app.items[0].sellIn);
    }

    @Test
    void sulfurasSubZero(){
        Item[] brie = new Item[] {new Item ("Sulfuras, Hand of Ragnaros", -2, 80)};
        GildedRose app = new GildedRose(brie);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(80, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    @Test
    void conjured(){
        Item[] brie = new Item[] {new Item ("Conjured Mana Cake", 5, 5)};
        GildedRose app = new GildedRose(brie);
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(3, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    void conjuredSubZero(){
        Item[] brie = new Item[] {new Item ("Conjured Mana Cake", -1, 6)};
        GildedRose app = new GildedRose(brie);
        app.updateQuality();
        assertEquals("Conjured Mana Cake", app.items[0].name);
        assertEquals(2, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

}
