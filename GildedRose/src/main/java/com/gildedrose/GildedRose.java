package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            switch(items[i].name){
                case "Aged Brie":
                    handleBrie(items[i]);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    handleBackstage(items[i]);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    handleSulfuras(items[i]);
                    break;
                case "Conjured Mana Cake":
                    handleConjured(items[i]);
                    break;
                default:
                    handleItem(items[i]);
                    break;
            }
            /*
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }*/
        }
    }

    public void handleItem(Item item){
        item.sellIn -= 1;
        if (item.sellIn > 0){
            item.quality -= 1;
        } else{
            item.quality = 0;
        }
    }

    public void handleBrie(Item item){
        item.sellIn -= 1;
        if (item.quality <50){
            item.quality += 1;
        }
    }

    public void handleSulfuras(Item item){
        item.quality = 80;
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
            item.quality = 0;
        }
    }
}
