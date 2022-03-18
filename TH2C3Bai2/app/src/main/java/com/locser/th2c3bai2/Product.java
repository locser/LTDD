package com.locser.th2c3bai2;

public class Product extends Goods{
    public Catalog Dmuc;

    public Catalog getDmuc() {
        return Dmuc;
    }

    public void setDmuc(Catalog dmuc) {
        Dmuc = dmuc;
    }

    public Product(String id, String name, Catalog dmuc) {
        super(id, name);
        Dmuc = dmuc;
    }

    public Product(String id, String name) {
        super(id, name);
    }

    Product(){
        super();
    }
}
