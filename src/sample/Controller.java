package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextArea activity;
    @FXML
    private TextField inputSearch;

    int [] aleatorios = new int[20];

    @FXML
    void generateElements() {
        for (int i = 0; i < aleatorios.length; i++)
            aleatorios[i] = (int) (Math.random() * 20);
    }

    @FXML
    void showMax() {
        activity.appendText("El numero maximo es: " + maximo(aleatorios, 0) + "\n");
    }

    @FXML
    void showArray() {
        activity.appendText("Los numeros que hay en el arreglo son: \n" +
                mostrar(aleatorios, aleatorios.length - 1, 0) + "\n");
    }

    @FXML
    void sumPar() {
        activity.appendText("La suma de los numeros pares son: \n" +
                sumarPar(aleatorios, aleatorios.length - 1) + "\n");
    }

    @FXML
    void showPares() {
        activity.appendText("Los numeros pares en el arreglo son: \n" +
                mostrarPar(aleatorios, aleatorios.length - 1) + "\n");
    }

    @FXML
    void searchLineal() {
        if (isNumeric(inputSearch.getText())) {
            int clave = Integer.parseInt(inputSearch.getText());
            int index = busquedaLineal(aleatorios, clave, aleatorios.length - 1, 0);

            if (index > 0)
                activity.appendText("Se ha encontrado el numero, esta en la posicion: " + index + "\n");
            else
                activity.appendText("El numero no se encuentra en el arreglo" + "\n");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generateElements();
    }

    int maximo (int[] t, int pos) {
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

    int sumarPar(int[] t, int n) {
        if (n == 0)
            return 0;
        if (t[n] % 2 == 0)
            return t[n] + sumarPar(t, n - 1);
        else
            return sumarPar(t, n - 1);
    }

    String mostrar(int[] t, int size, int i) {
        if (i == size)
            return " " + t[i];
        else
            return " " + t[i] + mostrar(t, size, i + 1);
    }

    String mostrarPar(int[] t, int n) {
        if (n == 0)
            return "";
        if (t[n] % 2 == 0)
            return " " + t[n] + mostrarPar(t, n - 1);
        else
            return mostrarPar(t, n - 1);
    }

    int busquedaLineal (int[] A, int clave, int n, int i) {
        if (i == n + 1)
            return -1;
        else if (A[i] == clave)
            return i;
        else
            return busquedaLineal(A, clave, n, i + 1);
    }

    boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
