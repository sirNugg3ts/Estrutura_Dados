package pt.a2018019825.Ficha4.ex1;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class itDezReaisMutavel implements Iterator<Double> {
    int posUltimo = -1;
    boolean podeRemover = false;
    DezReaisMutavel dr;
    int modificacoesConhecidas=0;

    public itDezReaisMutavel(DezReaisMutavel doubles) {
        this.dr = doubles;
        modificacoesConhecidas = dr.getModificacoes();
    }

    public void verificaMod(){
        if (modificacoesConhecidas!=dr.getModificacoes())
            throw new ConcurrentModificationException();
    }


    @Override
    public boolean hasNext() {
        verificaMod();
        return posUltimo + 1 < dr.size();
    }

    @Override
    public Double next() {
verificaMod();
        if (posUltimo+1 >= dr.size())
            throw new NoSuchElementException();
        podeRemover = true;

        return dr.get(++posUltimo);
    }

    public void remove(){
        verificaMod();
        if (!podeRemover) throw new IllegalStateException();
        podeRemover=false;
        dr.remove(posUltimo);
        posUltimo--;
        modificacoesConhecidas++;
    }
}
