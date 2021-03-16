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
        int [] aleatorios = new int[20];

        for (int i = 0; i < aleatorios.length; i++) {
            int aleatorio = (int) (Math.random() * 100);
            aleatorios[i] = aleatorio;
            System.out.println("Numero: " + aleatorio);
        }
        System.out.println(maximo(aleatorios, 0));

        int [] aleatoriosPar = new int[20];
        int x = 0;
        for (int i = 0; i < aleatorios.length; i++) {
            if (aleatorios[i] % 2 == 0) {
                aleatoriosPar[x] = aleatorios[i];
                x++;
            }
        }
        System.out.println(sumarValores(aleatoriosPar, aleatoriosPar.length - 1));
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

    public static int sumarValores(int[] array, int posArray) {
        int rta;

        if (posArray == 0)
            return array[posArray];
        else
            rta = (array[posArray]) + sumarValores(array, posArray - 1);

        return rta;
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
