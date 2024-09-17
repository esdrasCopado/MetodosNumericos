/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import implementaciones.RaicesFunciones;

/**
 *
 * @author copad
 */
public class PruebaRaicesFunciones {

    public static void main(String[] args) {
        resultadosBiseccion();
        resultadosFalsaRegla();
        resultadosNewtonRaphson();
        resultadoSecante();

    }
    
    
    public static void resultadosBiseccion() {
        double valores[][] = {
            {0.4, 1.8, 3.0},
            {0.6, 2.2, 4.0}
        };
        System.out.println("                      Metodo Biseccion                          ");
        System.out.println("----------------------------------------------------------------");
        RaicesFunciones raicesFuncion = new RaicesFunciones();

        for (int i = 0; i < valores[0].length; i++) {
            System.out.printf("    limite inferior xi: %.4f, limite superior xf: %.4f%n", valores[0][i], valores[1][i]);
            double resultado = raicesFuncion.biseccion(valores[0][i], valores[1][i], 0.1);
            System.out.printf("Resultado: %.4f%n", resultado);
            System.out.println("----------------------------------------------------------------");
        }
    }
    public static void resultadosFalsaRegla(){
        
        System.out.println("                    Metodo Regla falsa                          ");
        System.out.println("----------------------------------------------------------------");
        RaicesFunciones raicesFuncion = new RaicesFunciones();
        System.out.printf("Resultado: %.4f%n", raicesFuncion.reglaFalsa(1.5, 2.0, 0.001));
    }
    public static void resultadosNewtonRaphson() {
        double valores[]=
            {0.5, 1.8, 3.6}
        ;
        System.out.println("                    Metodo NewtonRaphson                        ");
        System.out.println("----------------------------------------------------------------");
        RaicesFunciones raicesFuncion = new RaicesFunciones();

        for (int i = 0; i < valores.length; i++) {
            System.out.printf("    limite inferior xi: %.4f%n", valores[i]);
            double resultado = raicesFuncion.newtonRaphson(valores[i], 0.001);
            System.out.printf("Resultado: %.4f%n", resultado);
            System.out.println("----------------------------------------------------------------");
        }
    }

    public static void resultadoSecante() {

        System.out.println("                       Metodo secante                           ");
        System.out.println("----------------------------------------------------------------");
        RaicesFunciones raicesFuncion = new RaicesFunciones();
        System.out.printf("Resultado: %.4f%n", raicesFuncion.secante(-1.5, 2.0, 0.001));
    }
    
    

    
}
