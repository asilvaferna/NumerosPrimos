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
        if (numDigitos <= 0) {
            System.out.println("Ingrese como parámetro, un numero de digitos correcto (mayor que 0): ");
        }
//Sacar trozos del for para otros metodos
        for (int i = 1; i <= 99999; i++) {
            int divisionEntera = i;

            int contador = 0;
//suprimir el while por un metodo
            while (divisionEntera != 0) {
                divisionEntera = divisionEntera / 10;
                contador++;
            }
            nDigitos = contador;

            if (nDigitos == numDigitos) {
                if (i < 4) {
                    isPrimo = true;
                } else if (i % 2 == 0) {
                    isPrimo = false;
                } else {
                    int contador1 = 0;
                    int i1 = 1;
                    int limite = (i - 1) / 2;
                    if (limite % 2 == 0) {
                        limite--;
                    }
//suprimir el while por un metodo
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

                if (isPrimo == true) {
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
}
