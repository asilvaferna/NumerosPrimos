package numerosprimos;

import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class NumerosPrimos {

    /**
     * @param args the command line arguments
     */
    //Codificado por: sAfOrAs
    //LIstar los numeros según el numero de digitos indicado
    //Considero solo hasta numeros menores a 100000 (5 digitos), 
    //por el hecho de k buscar numeros primos a partir de 6 digitos, el proceso se hace muy lento.
    public static boolean isPrimo = false;

    public static void main(String arg[]) {
        int numDigitos = 0;
        int nDigitos = 0;
        numDigitos = pedirDigitos();
        for (int i = 1; i <= 99999; i++) {
            nDigitos = calculaDigitos(i);
            if (nDigitos == numDigitos) {
                evaluaPrimos(i);
                if (evaluaPrimos(i) == true) {
                    System.out.println(i);
                }
            }
        }
    }

    public static int pedirDigitos() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de digitos"));
        while (numero < 0 || numero > 5) {
            numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero de digitos valido"));
        }
        return numero;

    }

    public static int calculaDigitos(int i) {
        int divisionEntera = i;
        int contador = 0;
        while (divisionEntera != 0) {
            divisionEntera = divisionEntera / 10;
            contador++;
        }
        return contador;
    }
    public static boolean evaluaPrimos(int i) {
        if (i < 4) {
            isPrimo = true;
            return true;
        } else if (i % 2 == 0) {
            isPrimo = false;
        } else {
            calculaPrimo(i);
        }
        return isPrimo;
    }

    private static void calculaPrimo(int i) {
        int contador1 = 0;
        int i1 = 1;
        int limite = (i - 1) / 2;
        if (limite % 2 == 0) {
            limite--;
        }
        while (i1 <= limite) {
            if (i % i1 == 0) {
                contador1++;
            }
            i1 += 2;
            if (contador1 == 2) {
                i1 = limite + 1;
            }
        }
        if (contador1 == 1) {
            isPrimo = true;
        }
    }
}
