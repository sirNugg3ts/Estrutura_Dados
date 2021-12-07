package pt.a2018019825.Ficha4.ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DezReais implements Iterable<Double> {
    private final int CAPACITY = 10;
    private Double [] tab = new Double[ CAPACITY ];
    protected int last=0;

    public Double get(int pos){return tab[pos];}

    public int size(){return last;}

    public boolean add(Double x){
        if (size() >= CAPACITY) throw new RuntimeException();
        tab[last++]=x;
        return true;
    }

    @Override
    public Iterator<Double> iterator() {
        return new itDezReais(this);
    }


}

