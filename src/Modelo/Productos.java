package Modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Productos {
    File archivo=new File("res/inventario.csv");
    private int numProductos;
    public ArrayList todosProductos(){
        ArrayList <Producto> lista=new ArrayList<>();
        try {
            FileReader saca = new FileReader(archivo);
            BufferedReader sac=new BufferedReader(saca);
            String w;
            while((w=sac.readLine())!=null){
                StringTokenizer y=new StringTokenizer(w,",");
                String cad[]=new String[6];
                for(int i=0;i<6;i++){
                    cad[i]=y.nextToken();
                }
                int pie=Integer.parseInt(cad[2]);
                double pre=Double.parseDouble(cad[3]);
                Producto p=new Producto(cad[0],cad[1],pie,pre,cad[4],cad[5]);
                lista.add(p);
            }
            return lista;
        }
        catch (Exception e){
            return null;
        }
    }
    public Productos(){
        try{
        FileReader saca=new FileReader(archivo);
        BufferedReader sac=new BufferedReader(saca);
        numProductos=0;
        while(sac.readLine()!=null){
            numProductos++;
        }
        }
        catch(Exception e){
            System.out.println("error"+e.getMessage());
        }
    }


    public void eliminaProducto(int id){
        ArrayList <Producto> todos=todosProductos();
        try{
            FileWriter mete=new FileWriter(archivo);
            BufferedWriter met=new BufferedWriter(mete);
            for(Producto ñ:todos){
                if((Integer.parseInt(ñ.getID()))!=id){
                    met.write(ñ.getID());
                    met.write(",");
                    met.write(ñ.getNombre());
                    met.write(",");
                    String aux=ñ.getPiezas()+"";
                    met.write(aux);
                    met.write(",");
                    aux=ñ.getPrecio()+"";
                    met.write(aux);
                    met.write(",");
                    met.write(ñ.getDepartamento());
                    met.write(",");
                    met.write(ñ.getApartado());
                    met.write("\n");
                }
            }
            met.close();
        }
        catch(Exception e){

        }
    }
    public  boolean validaProducto(Producto u){
        try{
            FileReader met=new FileReader(archivo);
            BufferedReader mete=new BufferedReader(met);
            for(int i=0;i<numProductos;i++){
                String k=mete.readLine();
                StringTokenizer f=new StringTokenizer(k,",");
                String name=f.nextToken();
                String pass=f.nextToken();
                String piez=f.nextToken();
                int pie=Integer.parseInt(piez);
                String pres= f.nextToken();
                double pre=Double.parseDouble(pres);
                String dep=f.nextToken();
                String apa=f.nextToken();
                Producto a=new Producto(name,pass,pie,pre,dep,apa);
                if(a.getNombre().equals(u.getNombre())&&a.getID().equals(u.getID())){
                    mete.close();
                    met.close();
                    return true;
                }
            }
            met.close();
            mete.close();
            return false;
        }
        catch(Exception e){
            System.out.println("Error"+e.getMessage());
            return false;
        }

    }
    public void agregarUsuario(Producto u){
        try {
            FileReader met=new FileReader(archivo);
            BufferedReader mete=new BufferedReader(met);
            boolean bandera = false;
            for (int i = 0; i < numProductos; i++) {
                String k=mete.readLine();
                StringTokenizer f=new StringTokenizer(k,",");
                String name=f.nextToken();
                String pass=f.nextToken();
                String piez=f.nextToken();
                int pie=Integer.parseInt(piez);
                String pres= f.nextToken();
                double pre=Double.parseDouble(pres);
                String dep=f.nextToken();
                String apa=f.nextToken();
                Producto a=new Producto(name,pass,pie,pre,dep,apa);
                if (u.getNombre().equals(a.getNombre())) {
                    bandera = true;
                }
            }
            mete.close();
            if (bandera == false) {
                try {
                    String cad = String.format("%s,%s,%d,%f,%s,%s\n", u.getID(), u.getNombre(), u.getPiezas(), u.getPrecio(),u.getDepartamento(),u.getApartado());
                    FileWriter sac=new FileWriter(archivo,true);
                    BufferedWriter saca=new BufferedWriter(sac);
                    saca.write(cad);
                    numProductos++;
                    saca.close();
                } catch (Exception e) {
                    System.out.println("error");
                }
            }
        }
        catch (Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }
    public void modificarProducto(Producto u,Producto w){
        Producto usuarios[] = new Producto[numProductos];
        try {
            FileReader lee=new FileReader(archivo);
            BufferedReader sac=new BufferedReader(lee);

            for (int i = 0; i < numProductos; i++) {
                String k=sac.readLine();
                StringTokenizer f=new StringTokenizer(k,",");
                String name=f.nextToken();
                String pass=f.nextToken();
                String piez=f.nextToken();
                int pie=Integer.parseInt(piez);
                String pres= f.nextToken();
                double pre=Double.parseDouble(pres);
                String dep=f.nextToken();
                String apa=f.nextToken();
                Producto a=new Producto(name,pass,pie,pre,dep,apa);
                usuarios[i]=a;
                if(usuarios[i].getNombre().equals(u.getNombre())&&usuarios[i].getID().equals(u.getID())){
                    usuarios[i]=w;
                }
            }
            sac.close();
            lee.close();
        }
        catch(Exception e){
            System.out.println("error");
        }
        try{
            FileWriter mete=new FileWriter(archivo);
            BufferedWriter met=new BufferedWriter(mete);
            for(int i=0;i<numProductos;i++){
                met.write(usuarios[i].getID());
                met.write(",");
                met.write(usuarios[i].getNombre());
                met.write(",");
                String aux=usuarios[i].getPiezas()+"";
                met.write(aux);
                met.write(",");
                aux=usuarios[i].getPrecio()+"";
                met.write(aux);
                met.write(",");
                met.write(usuarios[i].getDepartamento());
                met.write(",");
                met.write(usuarios[i].getApartado());
                met.write("\n");
            }
            met.close();
            mete.close();
        }
        catch (Exception e){
            System.out.println("error");
        }
    }
    public ArrayList departamento(String y){
        ArrayList <Producto> lista=new ArrayList<>();
        try {
            FileReader saca = new FileReader(archivo);
            BufferedReader sac=new BufferedReader(saca);
            for (int i = 0; i < numProductos; i++) {
                String k=sac.readLine();
                StringTokenizer f=new StringTokenizer(k,",");
                String name=f.nextToken();
                String pass=f.nextToken();
                String piez=f.nextToken();
                int pie=Integer.parseInt(piez);
                String pres= f.nextToken();
                double pre=Double.parseDouble(pres);
                String dep=f.nextToken();
                String apa=f.nextToken();
                Producto a=new Producto(name,pass,pie,pre,dep,apa);
                if(a.getDepartamento().equals(y)){
                    lista.add(a);
                }
            }
            return lista;
        }
        catch(Exception e){
            System.out.println("Error");
            return null;
        }
    }
    public ArrayList Aparta(String y,String h){
        ArrayList <Producto> lista=new ArrayList<>();
        try {
            FileReader saca = new FileReader(archivo);
            BufferedReader sac=new BufferedReader(saca);
            for (int i = 0; i < numProductos; i++) {
                String k=sac.readLine();
                StringTokenizer f=new StringTokenizer(k,",");
                String name=f.nextToken();
                String pass=f.nextToken();
                String piez=f.nextToken();
                int pie=Integer.parseInt(piez);
                String pres= f.nextToken();
                double pre=Double.parseDouble(pres);
                String dep=f.nextToken();
                String apa=f.nextToken();
                Producto a=new Producto(name,pass,pie,pre,dep,apa);
                if(a.getDepartamento().equals(y)&&a.getApartado().equals(h)&&a.getPiezas()>0){
                    lista.add(a);
                }
            }
            return lista;
        }
        catch(Exception e){
            System.out.println("Error");
            return null;
        }
    }
    public boolean cantidad(Producto u,int x){
        try{
            FileReader met=new FileReader(archivo);
            BufferedReader mete=new BufferedReader(met);
            for(int i=0;i<numProductos;i++){
                String k=mete.readLine();
                StringTokenizer f=new StringTokenizer(k,",");
                String name=f.nextToken();
                String pass=f.nextToken();
                String piez=f.nextToken();
                int pie=Integer.parseInt(piez);
                String pres= f.nextToken();
                double pre=Double.parseDouble(pres);
                String dep=f.nextToken();
                String apa=f.nextToken();
                Producto a=new Producto(name,pass,pie,pre,dep,apa);
                if(a.getNombre().equals(u.getNombre())&&a.getID().equals(u.getID())&&a.getPiezas()>=x){
                    mete.close();
                    met.close();
                    return true;
                }
            }
            met.close();
            mete.close();
            return false;
        }
        catch(Exception e){
            System.out.println("Error"+e.getMessage());
            return false;
        }

    }
    public Producto encuentra(String id){
        try{
            FileReader met=new FileReader(archivo);
            BufferedReader mete=new BufferedReader(met);
            for(int i=0;i<numProductos;i++){
                String k=mete.readLine();
                StringTokenizer f=new StringTokenizer(k,",");
                String name=f.nextToken();
                String pass=f.nextToken();
                String piez=f.nextToken();
                int pie=Integer.parseInt(piez);
                String pres= f.nextToken();
                double pre=Double.parseDouble(pres);
                String dep=f.nextToken();
                String apa=f.nextToken();
                Producto a=new Producto(name,pass,pie,pre,dep,apa);
                if(a.getID().equals(id)){
                    mete.close();
                    met.close();
                    return a;
                }
            }
            met.close();
            mete.close();
            return null;
        }
        catch(Exception e){
            System.out.println("Error"+e.getMessage());
            return null;
        }

    }
}
