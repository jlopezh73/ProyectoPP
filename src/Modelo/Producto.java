package Modelo;

public class Producto {
    private String ID;
    private String nombre;
    private int piezas;

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getApartado() {
        return apartado;
    }

    public void setApartado(String apartado) {
        this.apartado = apartado;
    }

    private double precio;
    private String departamento;
    private String apartado;

    public Producto(String ID, String nombre, int piezas, double precio, String departamento, String apartado) {
        this.ID = ID;
        this.nombre = nombre;
        this.piezas = piezas;
        this.precio = precio;
        this.departamento = departamento;
        this.apartado = apartado;
    }
    public String getDepa(){
        if((Integer.parseInt(this.departamento))==1)
            return "Papeleria";
            else if(Integer.parseInt(this.departamento)==2)
                return "Salud y belleza";
            else
                return "Dulces y bebidas";

    }
    public String getApa(){
        String apartamntos[][]={
                {"Escritura","Artes","Papeles","Regalos"},
                {"Shampoo y jabones","desodorantes y perfumes","Cremas y faciales","Tintes y cabello"},
                {"Chocolates","Dulces","Dulces salados","Bebidas"}
        };
        return apartamntos[Integer.parseInt(this.departamento)][Integer.parseInt(this.apartado)];
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPiezas() {
        return piezas;
    }

    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto(String ID, String nombre, int piezas, double precio) {
        this.ID = ID;
        this.nombre = nombre;
        this.piezas = piezas;
        this.precio = precio;
    }
}
