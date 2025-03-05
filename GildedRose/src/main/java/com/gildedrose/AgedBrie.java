package com.gildedrose;

public class AgedBrie extends Item{

    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    public void updateQuality(){
        this.sellIn -= 1;
        if (this.quality < 50){
            this.quality += 1;
        }
    }
}
