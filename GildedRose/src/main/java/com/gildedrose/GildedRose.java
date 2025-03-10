package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            switch(items[i].name){
                case AGED_BRIE:
                    handleBrie(items[i]);
                    break;
                case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                    handleBackstage(items[i]);
                    break;
                case SULFURAS_HAND_OF_RAGNAROS:
                    break;
                case CONJURED_MANA_CAKE:
                    handleConjured(items[i]);
                    break;
                default:
                    handleItem(items[i]);
                    break;
            }
        }
    }

    public void handleItem(Item item){
        item.sellIn -= 1;
        if (item.sellIn > 0){
            item.quality -= 1;
        } else{
            item.quality -= 2;
        }
    }

    public void handleBrie(Item item){
        item.sellIn -= 1;
        if (item.quality <50){
            item.quality += 1;
        }
    }

    public void handleBackstage(Item item){
        item.sellIn -= 1;
        if (item.sellIn < 0){
            item.quality = 0;
            return;
        }
        if (item.sellIn < 6){
            item.quality += 3;
        } else if(item.sellIn < 11){
            item.quality += 2;
        }
    }

    public void handleConjured(Item item){
        item.sellIn -= 1;
        if (item.sellIn > 0){
            item.quality -= 2;
        } else{
            item.quality -= 4;
        }
    }
}
