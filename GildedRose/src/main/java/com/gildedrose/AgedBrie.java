package com.gildedrose;

public class AgedBrie extends Item{

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public int updateQuality(int value){
        int res = (value * (-1));
        if (res < 51 && res >= 0){
            return res;
        } else{
            return value;
        }
    }
}
