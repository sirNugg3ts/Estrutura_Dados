package pt.isec.a2018019825.Ficha1;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int chave =50;
        int v1 = 0;
        int v2 = 60;

        int[] array = criaArrayCom(10, 10, true);
        System.out.println("Array:" + Arrays.toString(array));

        System.out.println("Alinea 1 - Resultado: " + alinea1(array,chave));
        System.out.println("Alinea 2 - Resultado: " + alinea2(array,chave));
        System.out.println("Alinea 3 - Resultado: " + alinea3(array,chave));
        System.out.println("Alinea 4 - Resultado: " + alinea4(array,chave));
        System.out.println("Alinea 5 - Resultado: " + alinea5(array,chave));
        System.out.println("Alinea 6 - Resultado: "+ alinea6(array,v1,v2));
    }

    static int[] criaArrayCom(
            int valor,
            int dimensao,
            boolean diferentes) {
        int[] m = new int[dimensao];
        if (diferentes) {
            for (int i = 0; i < dimensao; i++)
                m[i] = i * 10;
            if ((valor % 10 != 0) || (0 > valor) || (valor > (dimensao - 1) * 10))
                m[0] = valor;
        } else {
            Random r = new Random();
            int gama = (Math.abs(valor) < 10) ? 10 : Math.abs(valor);
            for (int i = 0; i < dimensao; i++)
                m[i] = r.nextInt(gama * 4) - gama * 2;
            m[0] = valor;
        }
        Arrays.sort(m);
        return m;
    }


    //alinea 1
    static boolean alinea1(int[] tab, int chave) {
        int start = 0; int end = tab.length;
        int meio = (start + end) / 2;

        if (end==0) return false;

        if (tab[meio] == chave) {
            return true;
        }
        if (tab[meio] > chave){
            end = meio - 1;
        }
        else{
            start = meio + 1;
        }

        if (end < start)
            return false;

        if (end < tab.length) end++;
        int[] newt=Arrays.copyOfRange(tab,start,end);

        boolean result = alinea1(newt, chave);
        return result;
    }
    //alinea 1

    //alinea 2
    static boolean alinea2(int[] tab,int chave){
        if (tab.length == 0) return false;
        int start = 0; int end = tab.length-1;
        int meio=(start+end)/2;

        while(tab[meio] != chave){
            if (tab[meio] > chave)
                end = meio - 1;

            else
                start = meio + 1;


            meio=(start+end)/2;

            if (end<start)
                return false;
        }
        return true;
    }
    //alinea2

    //alinea 3
    static int alinea3(int[] tab,int chave){
        if (tab.length == 0) return -1;
        int start = 0; int end = tab.length-1;
        int meio=(start+end)/2;

        while(tab[meio] != chave){
            if (tab[meio] > chave)
                end = meio - 1;

            else
                start = meio + 1;


            meio=(start+end)/2;

            if (end<start)
                return -1;
        }
        return meio;
    }
    //alinea 3

    //alinea 4
    static int alinea4(int[] tab,int chave){
        if (tab.length == 0) return -1;
        int start = 0; int end = tab.length-1;
        int meio=(start+end)/2;

        while(tab[meio] != chave){
            if (tab[meio] > chave)
                end = meio - 1;

            else
                start = meio + 1;


            if (end<start)
                return meio*-1;
            meio=(start+end)/2;



        }
        return meio;
    }
    //alinea 4

    //alinea 5
    static double alinea5(int[] tab,int chave){
        int pos = alinea4(tab,chave);
        double percentagem;
        if (pos >= 0){
            percentagem = (double)pos/tab.length;
        }else{
            int posInsert = -pos;
            percentagem = posInsert/(double)tab.length;
        }
        return percentagem;
    }
    //alinea 5

    //alinea 6

    static int alinea6(int[]tab,int v1,int v2){
        if (tab.length == 0) return 0;

        int n1 = alinea4(tab,v1);

        int n2 = alinea4(tab,v2);
        if (n1<0) n1 = -n1+1;
        if (n2<0) n2 = -n2+1;else n2--;
       if (v1==v2) return 0;
        return n2-n1;
    }

    //alinea 6
    

}
