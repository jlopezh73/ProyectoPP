package Modelo;

import Modelo.Producto;
import Modelo.Productos;
import Modelo.Venta;

import java.io.*;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ventas {
    private int numVenta;
    File arc1=new File("C:\\Users\\jlope\\Downloads\\inventario.csv");
    File arc2=new File("C:\\Users\\jlope\\Downloads\\ventas.csv");
    File arc3=new File("C:\\Users\\jlope\\Downloads\\ventasProducto.csv");
    public Ventas(){
        numVenta=0;
        try{
            FileReader saca=new FileReader(arc2);
            BufferedReader sac=new BufferedReader(saca);
            String x;
            while((x=sac.readLine())!=null){
                StringTokenizer y=new StringTokenizer(x,",");
                String num=y.nextToken();
                int h=Integer.parseInt(num);
                if(numVenta<h)
                    numVenta=h;

            }
            sac.close();
            saca.close();
            numVenta++;

        }
        catch (Exception e){

        }
    }
    public int getNumVenta() {
        return numVenta;
    }
    public void setNumVenta(int numVenta) {
        this.numVenta = numVenta;
    }
    public void registrarVenta( ArrayList<ProductoCarrito> lista){
        try{
            FileWriter met=new FileWriter(arc2,true);
            BufferedWriter mete=new BufferedWriter(met);

            double total=0;
            try {
                FileWriter esc=new FileWriter(arc3,true);
                BufferedWriter escr=new BufferedWriter(esc);
                for (ProductoCarrito b : lista) {
                    Producto w=b.getProductoOriginal();
                    escr.write(w.getID());
                    escr.write(",");
                    escr.write(w.getNombre());
                    escr.write(",");
                    String auxi=numVenta+"";
                    escr.write(auxi);
                    escr.write(",");
                    auxi=b.getCantidadCompra()+"";
                    escr.write(auxi);
                    escr.write(",");
                    double subi=w.getPrecio()*b.getCantidadCompra();
                    auxi=subi+"";
                    escr.write(auxi);
                    escr.write("\n");
                    total+=subi;
                    this.modifica(new Productos(),b);
                }
                escr.close();
            }
            catch (Exception e){

            }
            String dat= LocalDateTime.now()+"";
            String m=numVenta+"";
            mete.write(m);
            mete.write(",");
            String aux;
            aux=total+"";
            mete.write(aux);
            mete.write(",");
            mete.write(dat);
            mete.write("\n");
            mete.close();
        }
        catch(Exception u){
            System.out.println("Error");
        }
    }
    public void modifica(Productos b,ProductoCarrito v){
        Producto f=v.getProductoOriginal();
        int a=(f.getPiezas()-v.getCantidadCompra());
        Producto n=f;
        n.setPiezas(f.getPiezas()-v.getCantidadCompra());
        b.modificarProducto(f,n);

    }
}
