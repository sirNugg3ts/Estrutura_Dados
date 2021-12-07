package pt.a2018019825.Ficha4.ex1;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class itDezReaisPositivo implements Iterator<Double> {
    int posUltimo = -1;
    boolean podeRemover = false;
    DezReaisMutavel dr;
    int modificacoesConhecidas=0;

    public itDezReaisPositivo(DezReaisMutavel doubles) {
        this.dr = doubles;
        modificacoesConhecidas = dr.getModificacoes();
    }

    private int nextPositivoIndex(int from){
        if (from >= dr.size()) return -1;
        while(dr.get(from)<0)
            if (++from >= dr.size())
                return -1;
            return  from;
    }

    public void verificaMod(){
        if (modificacoesConhecidas!=dr.getModificacoes())
            throw new ConcurrentModificationException();
    }


    @Override
    public boolean hasNext() {
        verificaMod();
        return nextPositivoIndex(posUltimo+1) >= 0;
    }

    @Override
    public Double next() {
        verificaMod();
        posUltimo = nextPositivoIndex(++posUltimo);
        return dr.get(posUltimo);

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
