package com.gildedrose;

public class Conjured extends Item{

    public Conjured(int sellIn, int quality) {
        super("Conjured", sellIn, quality);
    }

    public void updateQuality(){
        this.sellIn -= 1;
        this.quality -= 2;
    }
}
