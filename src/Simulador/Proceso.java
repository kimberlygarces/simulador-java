
package Simulador;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kimberly
 */

 public final class Proceso implements Runnable{
     
     
      private ArrayList<Integer> TInicios;
    private ArrayList<Integer> TFinales;
    
    private int Pid;
    private String Nombre;
    private String caracteres;
    private int Prioridad;
    private int Quantum=2 ;
    
    private int rafaga, Tllegada,TurnaRound, Tfinalizacion,
            Tinicio, Tespera, Tiempofintotal, Tiempocola,  TiempoIniciototal;
    
  
     
  

    public int getPid() {
         return Pid;
     }

     public String getNombre() {
         return Nombre;
     }

     public String getCaracteres() {
         return caracteres;
     }

     public int getPrioridad() {
         return Prioridad;
     }

     public int getRafaga() {
         return rafaga;
     }

     public void setPid(int Pid) {
         this.Pid = Pid;
     }

     public void setNombre(String Nombre) {
         this.Nombre = Nombre;
     }

     public void setCaracteres(String caracteres) {
         this.caracteres = caracteres;
     }

     public void setPrioridad(int Prioridad) {
         this.Prioridad = Prioridad;
     }

     public void setRafaga(int rafaga) {
         this.rafaga = rafaga;
     }
     
        /////////////////////////////////////////////////////////////////
       
          private int Reemplazos;


     public int calcularRafaga() {
         int rafaga = 0;

         for (int i = 0; i < caracteres.length(); i++) {
             if (caracteres.charAt(i) == 'S' || caracteres.charAt(i) == 's') {
                 rafaga++;
             }
         }

         return rafaga;
     }


    public Proceso(int Pid, String Nombre, String caracteres, int Prioridad, int rafaga, int Tllegada, int TurnaRound, int Tfinalizacion, int Tinicio, int Tespera, int Tiempofintotal, int Tiempocola, int Reemplazos) {
      
        
      TInicios = new ArrayList<>();
      TFinales = new ArrayList<>();
        
        this.Pid = Pid;
        this.Nombre = Nombre;
        this.caracteres = caracteres;
        this.Prioridad = Prioridad;
        this.rafaga = calcularRafaga();
        this.Tllegada = Tllegada;
        this.TurnaRound = -1;
        this.Tfinalizacion = -1;
        this.Tinicio = -1;
        this.Tespera = -1;
        this.Tiempofintotal = -1;
        this.Tiempocola = 0;
        this.Reemplazos = 0;
    }

   
 
      
    @Override
    public void run() {
        
        int contadorReemplazos = 0;
        int i = 0;
        
      
        while((contadorReemplazos <  Quantum && Reemplazos < rafaga) ||Prioridad == 0 && i < caracteres.length()){
            if(caracteres.charAt(i) == 'S' || caracteres.charAt(i) == 's'){
              //  escuchar.caracterProcesado(this, caracteres, i);
                
                Reemplazos++;
                contadorReemplazos++;

                StringBuilder stringBuilder = new StringBuilder(caracteres);
                stringBuilder.setCharAt(i, 'x');// cambiamos el caracter 's' por el 'x'
                caracteres = stringBuilder.toString();
 
                try {
                    // Hacemos una pausa para poder apreciar la palabra
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }

            i++;
        }
        
    }


}
    
