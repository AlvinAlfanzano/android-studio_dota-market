package Model;

import java.util.ArrayList;

public class Item {

    public static ArrayList<Item> arrayItem = new ArrayList<>();
    String namaItem;
    int priceItem;
    int stockItem;

    public Item(String namaItem, int priceItem, int stockItem) {
        this.namaItem = namaItem;
        this.priceItem = priceItem;
        this.stockItem = stockItem;
    }

    public String getNamaItem() {
        return namaItem;
    }

    public void setNamaItem(String namaItem) {
        this.namaItem = namaItem;
    }

    public int getPriceItem() {
        return priceItem;
    }

    public void setPriceItem(int priceItem) {
        this.priceItem = priceItem;
    }

    public int getStockItem() {
        return stockItem;
    }

    public void setStockItem(int stockItem) {
        this.stockItem = stockItem;
    }
}
