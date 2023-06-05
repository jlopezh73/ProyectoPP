package Modelo;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Usuarios {
    File archivo=new File("res/usuarios.csv");
    private int numUsuarios;
    public ArrayList todosUsuarios(){
        try {
            FileReader saca = new FileReader(archivo);
            BufferedReader sac=new BufferedReader(saca);
            ArrayList<Usuario> lista=new ArrayList<>();
            String w;
            while((w=sac.readLine())!=null){
                StringTokenizer y=new StringTokenizer(w,",");
                String cara[]=new String[4];
                for(int i=0;i<4;i++){
                    cara[i]=y.nextToken();
                }
                Usuario u=new Usuario(cara[0],cara[1],cara[2],cara[3]);
                lista.add(u);
            }
            return lista;
        }
        catch (Exception e){
            return null;
        }
    }
    public void eliminaUsuario(int id){
        try {
            ArrayList<Usuario> lista=todosUsuarios();
            FileWriter sac = new FileWriter(archivo);
            BufferedWriter saca=new BufferedWriter(sac);
            for(Usuario ui:lista){
                if((Integer.parseInt(ui.getID()))!=id){
                    saca.write(ui.getNombre());
                    saca.write(",");
                    saca.write(ui.getContraseña());
                    saca.write(",");
                    saca.write(ui.getNombreCompleto());
                    saca.write(",");
                    String auxi=ui.getID()+"";
                    saca.write(auxi);
                    saca.write("\n");
                }
            }
            saca.close();

        }
        catch (Exception e){

        }
    }
    public Usuarios(){
        numUsuarios=0;
        try{
            FileReader sac=new FileReader(archivo);
            BufferedReader saca=new BufferedReader(sac);
            while(saca.readLine()!=null){
                numUsuarios++;

            }
        }
        catch(Exception e){
            System.out.println("error"+e.getMessage());
        }
    }
    public  Usuario validaUsuario(String user,String passwrod){
        try{
            FileReader met=new FileReader(archivo);
            BufferedReader mete=new BufferedReader(met);
            for(int i=0;i<numUsuarios;i++){
                String k=mete.readLine();
                StringTokenizer f=new StringTokenizer(k,",");
                String name=f.nextToken();
                String pass=f.nextToken();
                String namec=f.nextToken();
                String id=f.nextToken();
                Usuario a=new Usuario(name,pass,namec,id);
                if(a.getNombre().equals(user)&&a.getContraseña().equals(passwrod)){
                    mete.close();
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
    public void agregarUsuario(Usuario u){
        try {
            FileReader met=new FileReader(archivo);
            BufferedReader mete=new BufferedReader(met);
            boolean bandera = false;
            int num=0;
            for (int i = 0; i < numUsuarios; i++) {
                String k=mete.readLine();
                StringTokenizer f=new StringTokenizer(k,",");
                String name=f.nextToken();
                String pass=f.nextToken();
                String namec=f.nextToken();
                String id=f.nextToken();
                Usuario o=new Usuario(name,pass,namec,id);
                if (u.getNombre().equals(o.getNombre())) {
                    bandera = true;
                }
                num++;
            }
            num++;
            mete.close();
            if (bandera == false) {
                try {
                    FileWriter sac=new FileWriter(archivo,true);
                    BufferedWriter saca=new BufferedWriter(sac);
                    saca.write(u.getNombre());
                    saca.write(",");
                    saca.write(u.getContraseña());
                    saca.write(",");
                    saca.write(u.getNombreCompleto());
                    saca.write(",");
                    String auxi=num+"";
                    saca.write(auxi);
                    saca.write("\n");
                    numUsuarios++;
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
    public void modificarusuario(Usuario u,Usuario w){
        Usuario usuarios[] = new Usuario[numUsuarios];
        try {
            FileReader lee=new FileReader(archivo);
            BufferedReader sac=new BufferedReader(lee);

            for (int i = 0; i < numUsuarios; i++) {
                String k=sac.readLine();
                StringTokenizer f=new StringTokenizer(k,",");
                String name=f.nextToken();
                String pass=f.nextToken();
                String namec=f.nextToken();
                String id=f.nextToken();
                Usuario a=new Usuario(name,pass,namec,id);
                usuarios[i]=a;
                if(usuarios[i].getNombre().equals(u.getNombre())&&usuarios[i].getContraseña().equals(u.getContraseña())){
                    usuarios[i]=w;
                }
            }
            sac.close();
        }
        catch(Exception e){
            System.out.println("error");
        }
        try{
           FileWriter mete=new FileWriter(archivo);
           BufferedWriter met=new BufferedWriter(mete);
            for(int i=0;i<numUsuarios;i++){
                met.write(usuarios[i].getNombre());
                met.write(",");
                met.write(usuarios[i].getContraseña());
                met.write(",");
                met.write(usuarios[i].getNombreCompleto());
                met.write(",");
                met.write(usuarios[i].getID());
                met.write("\n");
            }
            met.close();
        }
        catch (Exception e){
            System.out.println("error");
        }
    }
}
