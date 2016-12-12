/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin12;

import javax.swing.JOptionPane;
import java.time.LocalTime;

/**
 *
 * @author Adri
 */
public class Garaje {

    protected int numCoches;
    protected String matricula[];
    protected int tiempo[];

    public Garaje() {
        this.numCoches = 0;
        this.matricula = new String[5];
        this.tiempo = new int [5];
    }
    
    public int getNumCoches() {
        return numCoches;
    }
    public void setTime(int time){
        tiempo[0]=time;
    }
    public boolean compruebaPlazas() {
        if (numCoches <5) {
            JOptionPane.showMessageDialog(null, "Plazas disponibles");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Completo");
            return false;
        }
    }

    public void añadeCoche(String matricula){
        if (compruebaPlazas()) {
            this.matricula[numCoches] = matricula;
            this.tiempo[numCoches] = LocalTime.now().getHour();
            numCoches ++;
        }
    }
    public int calculaPosicion(String mat){
        int posicion=10;
        for(int i=0; i<numCoches;i++){
            if(matricula[i].equals(mat)){
                posicion=i;
            }
        }
        return posicion;
    }
    
    public double precioEstancia(String mat) { //double
        int pos=10;
        int horas;
        double precio=0;
        pos=calculaPosicion(mat);
        if(pos!=10){
            horas=LocalTime.now().getHour()-tiempo[pos];
            if(horas>3){
                precio= (3*1.50)+((horas-3)*0.20);
            }else precio=horas*1.50;
        }
        return precio;
        
    }

    public void imprimeRecibo(String matricula) { 
        JOptionPane.showMessageDialog(null, "La matricula es: " + matricula);
        JOptionPane.showMessageDialog(null, "El tiempo de estancia es: " + (LocalTime.now().getHour()-tiempo[calculaPosicion(matricula)]));
        JOptionPane.showMessageDialog(null, "El precio de la estancia es: " + precioEstancia(matricula));
        int cartosRec = Integer.parseInt(JOptionPane.showInputDialog("Introduce os cartos: "));
        JOptionPane.showMessageDialog(null, "Cartos recibidos: " + cartosRec);
        JOptionPane.showMessageDialog(null, "Cartos devoltos: " + (cartosRec - precioEstancia(matricula)));
        JOptionPane.showMessageDialog(null, "Graciñas, deicalogue");
        
    }
}
