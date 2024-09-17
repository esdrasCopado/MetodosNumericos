/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;
import java.math.*;

/**
 *
 * @author copad
 */
public class RaicesFunciones {
   
    private int iteraciones=0;
    
    
    /**
     * se calcula la raiz con el metodo de biseccion.
     * @param xi limite del intervalo inferior
     * @param xf limite del intervalo superior
     * @param eamax error estimado
     * @return se imprimira en pantalla todos los valores
     */
    public double biseccion(double xi, double xf, double eamax){
        double fXi;
        double fXr;
        double xr = 0;
        double xrAux = 0;
        double errorEstimado = 100; 
    
        // Se repite el loop hasta que el error sea mas pequeño que eamax
        do {
            
            fXi = f(xi);
            fXr = f(xr = (xi + xf) / 2);
        
           
            if (fXi * fXr < 0) {
                xf = xr;
            } else {
                xi = xr;
            }
        
            // si no es la primera iteracion se calcula el error
            if (xrAux != 0) {
                errorEstimado = Math.abs((xr - xrAux) / xr) * 100;
            }
        
            xrAux = xr;  // Se guarda la actual xr para la siguiente iteracion
            iteraciones++;
        } while (errorEstimado >= eamax);  // continua hasta que el error estimado sea mayor que eamax
        System.out.printf("Resultado de la funcion f(xr): %.4f, numero de iteraciones: %d%n", fXr, iteraciones);
        
        return xr;
    }
    
    /**
     * Metodo de la falsa regla para encontrar la raiz
     * @param xi limite inferior
     * @param xf limite superior
     * @param eamax error estimado
     * @return el resultado de xr o la raiz
     */
    public double reglaFalsa(double xi, double xf, double eamax){
        double fxi,fxf,fxr;
        double xr;
        double errorEstimado=100;
        double xrAux=0;
        
        do
        {
            fxi=g(xi);
            fxf=g(xf);
            xr=xi-((xf-xi)/(fxf-fxi))*fxi;
            fxr=g(xr);
            if((fxi*fxr)<0){
                
                xf=xr;
            }else{
                
                xi=xr;
            }
            
            if(xrAux !=0){
                errorEstimado=Math.abs((xr-xrAux)/xr)*100;
            }
            
            xrAux=xr;
            iteraciones++;
            
        }
        while(errorEstimado>=eamax);
        System.out.printf("Resultado de la funcion f(xr): %.4f, numero de iteraciones: %d%n", fxr, iteraciones);
        return xr;
    }
    
    /**
     * Metodo numerico de Newton Raphson 
     * para encontrar la raiz
     * @param xi valor inicial
     * @param eamax Error aproximado 
     * @return el resultado final de xr
     */
    public double newtonRaphson(double xi, double eamax){
        double fxi,Derivadafxi,xr;
        double errorEstimado=100;
        
        do{
            
            fxi=h(xi);
            Derivadafxi=dh(xi);
            xr=xi-(fxi/Derivadafxi);
            
            errorEstimado=Math.abs((xr-xi)/xr)*100;
            
            xi=xr;
            
            iteraciones++;
            
            
        }while(errorEstimado>=eamax);
        System.out.printf("Resultado de la funcion f(xr): %.4f, numero de iteraciones: %d%n", xr, iteraciones);
        return xr;
        
    }
    /**
     * Metodo numerico secante 
     * @param x1 valor 1
     * @param x2 valor 2
     * @param eamax error aproximado
     * @return el resultado final de xr
     */
    
    public double secante( double x1,double x2, double eamax){
        double fx1,fx2,xr,fxr;
        double errorEstimado=100;
        double xrAux=0;
        
        do{
            
            fx1=g(x1);
            fx2=g(x2);
            xr=x2-((x1-x2)/(fx1-fx2)*fx2);
            fxr=g(xr);
            
            if(iteraciones>0){
                errorEstimado=Math.abs((xr-xrAux)/xr)*100;
            }
            iteraciones++;
            xrAux=xr;
            
            x1=x2;
            x2=xr;
            
            
        }while(errorEstimado>=eamax);
        System.out.printf("Resultado de la funcion f(xr): %.4f, numero de iteraciones: %d%n", xr, iteraciones);
        return xr;
    }
    public double h(double x) {
        return Math.pow(x, 3) - 6 * Math.pow(x, 2) + 11 * x - 6;
    }
    public double dh( double x){
        return 3*Math.pow(x, 2)-12*x+11;
    }

    public double g(double x) {
        return (1 - 0.6 * x) / x;
    }

    public double f(double x) {
        return -2.1 + 6.21 * x - 3.9 * Math.pow(x, 2) + 0.667 * Math.pow(x, 3);
    }
    
    public int getIteraciones(){
        return iteraciones;
    }
}
