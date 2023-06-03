package Modelo;

import java.time.LocalDateTime;
import java.util.List;

public class Venta {
    private int numVenta;
    private String nombre;
    private String domicilio;
    private String colonia;
    private String cp;
    private String ciudad;
    private String estado;
    private String correoElectronico;
    private String telefono;
    private LocalDateTime fecha;
    private List<ProductoCarrito> productos;

    public Venta() {
    }

    public Venta(int numVenta, String nombre, String domicilio, String colonia, String cp, String ciudad, String estado, String correoElectronico, String telefono, LocalDateTime fecha, List<ProductoCarrito> productos) {
        this.numVenta = numVenta;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.colonia = colonia;
        this.cp = cp;
        this.ciudad = ciudad;
        this.estado = estado;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.fecha = fecha;
        this.productos = productos;
    }

    public int getNumVenta() {
        return numVenta;
    }

    public void setNumVenta(int numVenta) {
        this.numVenta = numVenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<ProductoCarrito> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoCarrito> productos) {
        this.productos = productos;
    }
}
