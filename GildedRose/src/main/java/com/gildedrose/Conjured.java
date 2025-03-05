package com.gildedrose;

public class Conjured extends Item{

    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public int updateQuality(int value){
        int res = value * 2;
        if (res >= 0){
            return res;
        } else {
            return 0;
        }
    }
}
