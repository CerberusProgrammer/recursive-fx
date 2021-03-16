package sample;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ejercicio1();
    }

    void ejercicio1 () {
        int[] a = generarAleatorios();

        System.out.println(maximo(a, 0));
        System.out.println(sumarPar(a, a.length - 1));
        System.out.println("Todos:" + mostrar(a, a.length - 1));
        System.out.println("Todos par:" + mostrarPar(a, a.length - 1));
    }

    int[] generarAleatorios() {
        int [] aleatorios = new int[20];

        for (int i = 0; i < aleatorios.length; i++)
            aleatorios[i] = (int) (Math.random() * 20);

        return aleatorios;
    }

    static int maximo (int t[], int pos) {
        int res;

        if(pos == t.length - 1)
            res = t[pos];
        else {
            int k;
            k = maximo (t,pos + 1);

            if (t[pos] > k)
                res = t[pos];
            else
                res = k;
        }
        return(res);
    }

    public static int sumarPar(int[] t, int n) {
        if (n == 0)
            return 0;
        if (t[n] % 2 == 0)
            return t[n] + sumarPar(t, n - 1);
        else
            return sumarPar(t, n - 1);
    }

    static String mostrar(int t[], int n) {
        if (n == 0)
            return " " + t[n];
        else
            return " " + t[n] + mostrar(t, n - 1);
    }

    static String mostrarPar(int t[], int n) {
        if (n == 0)
            return "";
        if (t[n] % 2 == 0)
            return " " + t[n] + mostrarPar(t, n - 1);
        else
            return mostrarPar(t, n - 1);
    }

    int busquedaLineal (int A[], int clave, int n, int i) {
        if (i == n + 1)
            return -1;
        else if (A[i] == clave)
            return i;
        else
            return busquedaLineal(A, clave, n, i + 1);
    }


    /*
    *
    * Llene de forma aleatoria un arreglo de 20 elementos numéricos y realice las siguiente acciones.
    1.Obtener el elemento máximo del arreglo.
    2.Sumar los números pares del arreglo
    3.Mostrar el arreglo.
    4.Mostrar los números pares del arreglo.
    5.Realice la búsqueda lineal.
    * */
}
