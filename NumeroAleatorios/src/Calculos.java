
import java.util.List;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BetsySanchez
 */
public class Calculos {
    double g;
    double m;
    List<Double> num;
    int tamaño;
    int[] x;
     
    public Calculos(){
        num = new ArrayList<Double>();
        g = 13;
        m = (int)Math.pow(2, g);
    }
    
  /*  public Calculos(int s1, int s2, int s3, int s4,int tam){
        
    }
    */
    private boolean generacionR(int tam){   
        double r;
        int aux;
        for(int i=0;i<tamaño;i++){
            r=((x[i+3])+(x[i]))/m;//6.75
            aux=(int)r;//6
            r=(r-aux)*m;//768
            x[i+4]=(int)r;//asignacion de la siguiente semilla
            r=r/(m-1);//0.7507
            if(r>0.0){
                num.add(r); //Agregar el numero aleatorio a la lista
            }else return false;
        }
        return true;
    }
    
    private void reiniciar(){
        tamaño=0;
        x=new int[0];
        num.clear();
        
    }
    
    public String mostrar(int tam,int s1,int s2,int s3, int s4){
        reiniciar();
        
        tamaño = tam;
        x=new int[tamaño+4];
        x[0]=s1;
        x[1]=s2;
        x[2]=s3;
        x[3]=s4;
        Double[] res;
        if(!generacionR(tam)) return "VALIO CAMOTE";
        String cad="";
        res = num.toArray(new Double[num.size()-1]);
        for(int i=0;i<tamaño;i++){
            String c=(res[i]+"");
            if(c.length()>6){
                c=c.substring(0, 6);
            }     
            cad+=c+"\n";
        }
        String aux = num.size()+"";//se va a quitar esto tambien
        //return aux;//*****************
        return cad;  
    }
}
