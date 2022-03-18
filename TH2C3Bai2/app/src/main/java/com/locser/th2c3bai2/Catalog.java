package com.locser.th2c3bai2;

import java.util.ArrayList;

public class Catalog extends Goods{
    ArrayList<Product> listSp=null;

    public Catalog(String id, String name) {
        super(id, name);
        this.listSp = new ArrayList<>();
    }

    public Catalog() {
        super();
        this.listSp = new ArrayList<>();
    }

    public boolean isDuplicate(Product p){
        for(Product p1 : listSp){
            if(p1.getId().equalsIgnoreCase(p.getId().trim())){
                return true;
            }
        }
        return false;
    }

    public  boolean addProduct(Product p ){
        boolean isDup = isDuplicate(p);
        if(!isDup){
            p.setDmuc(this);
            return listSp.add(p);
        }
        return !isDup;
    }

    public ArrayList<Product> getListSp(){
        return listSp;
    }

    public int size(){
        return listSp.size();
    }


    public Product get(int i){
        return listSp.get(i);
    }
}
