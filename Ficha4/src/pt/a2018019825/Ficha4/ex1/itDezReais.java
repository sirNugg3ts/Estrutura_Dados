package pt.a2018019825.Ficha4.ex1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class itDezReais implements Iterator<Double> {
    int posUltimo = -1;
    DezReais dr;

    public itDezReais(DezReais doubles) {
        this.dr = doubles;
    }


    @Override
    public boolean hasNext() {
        return posUltimo + 1 < dr.size();
    }

    @Override
    public Double next() {

        if (posUltimo+1 >= dr.size())
            throw new NoSuchElementException();

        return dr.get(++posUltimo);
    }
}
