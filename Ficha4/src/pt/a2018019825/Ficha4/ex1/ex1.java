package pt.a2018019825.Ficha4.ex1;

import java.util.Iterator;

public class ex1 {
   
    public static void main(String[] args) {
        DezReais dr = new DezReais();

        itDezReais itDezReais = new itDezReais(dr);

        for (int i = 0; i < 10; i++) {
            dr.add(i*0.1);
        }

        while (itDezReais.hasNext())
            System.out.println("Ultimo: " + itDezReais.next());


        DezReaisMutavel drm = new DezReaisMutavel();
        itDezReaisMutavel idrm = new itDezReaisMutavel(drm);
        for (int i = 0; i < 10; i++) {
            drm.add(i*0.1+5.0);
        }

        int i =0;Double dlb;
        while (idrm.hasNext() && (dlb = idrm.next()) < 5.4)
            System.out.println((i++) + ": ultimo: "+dlb);

        idrm.remove();

        itDezReaisMutavel idrm2 = new itDezReaisMutavel(drm);
        i=0;
        while (idrm.hasNext())
            System.out.println((i++)+": Sem 5.4"+ idrm2.next());

    }

    public static Double maior(Iterable<Double> d){
        Iterator<Double> it = d.iterator();
        Double m,temp;

        m = it.next();

        while (it.hasNext()){
            temp = it.next();
            if (temp>m) m = temp;
        }
        return m;
    }


    public static <T extends Comparable<? super T> > T maiorg(Iterable<T> d){
        Iterator<T> it = d.iterator();
        T m,temp;

        m = it.next();
        while (it.hasNext()){
            temp = it.next();
            if (temp.compareTo(m) > 0) m = temp;
        }
        return m;
    }



}
