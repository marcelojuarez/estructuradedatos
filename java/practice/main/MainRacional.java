package main;

import number.Racional;

public class MainRacional{
    public static void main(String[]  args){
        Racional n1 = new Racional(2,5);
        Racional n2 = new Racional(1,3);
        Racional n4 = new Racional(3,9);
        Racional n3 = new Racional();
        Racional n5 = new Racional(3,5);
        
        //n3 = n1.suma(n2);
        n3 = n1.resta(n5);
        //System.out.println("el numerador :"+ n3.getNumerador());
        //System.out.println("el denominador :"+ n3.getDenominador());
        System.out.println("numero es: "+n3);
        //System.out.println("los numeros n4 y n2 son iguales? \n"+ n4.equals(n2));
        
    }
}
