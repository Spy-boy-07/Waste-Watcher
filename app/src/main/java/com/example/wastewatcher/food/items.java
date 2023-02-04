package com.example.wastewatcher.food;

public class items {
    private String itemname;
//    private String itemcategory;
//    private String itemprice;
    private String weight;

    public items() {

    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public items(String itemname, String weight){
        this.itemname=itemname;
//        this.itemcategory=itemcategory;
//        this.itemprice=itemprice;
        this.weight=weight;
    }

    public String getItemname() {
        return itemname;
    }

//    public String getItemcategory() {
//        return itemcategory;
//    }
//
//    public String getItemprice() {
//        return itemprice;
//    }

    public String getWeight() {
        return weight;
    }

    //    public Double getWeight() {
//        return weight;
//    }
}
