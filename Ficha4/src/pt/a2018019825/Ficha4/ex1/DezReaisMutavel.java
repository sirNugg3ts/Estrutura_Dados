package pt.a2018019825.Ficha4.ex1;

import java.util.Iterator;

public class DezReaisMutavel implements Iterable<Double> {
    private final int CAPACITY = 10;
    private Double [] tab = new Double[ CAPACITY ];
    protected int last=0;
    private int modificacoes = 0;

    public Double get(int pos){return tab[pos];}

    public int size(){return last;}

    public boolean add(Double x){
        if (size() >= CAPACITY) throw new RuntimeException();
        tab[last++]=x;
        modificacoes++;

        return true;
    }

    public void remove(int pos){
        for (int i=0;i<last-1;i++){
            tab[i] = tab[i+1];
        }
        if (last > -1) last--;
        modificacoes++;

    }

    public int getModificacoes(){return modificacoes;}

    @Override
    public Iterator<Double> iterator() {
        //return new itDezReaisMutavel(this);
        return new itDezReaisPositivo(this);
    }


}

