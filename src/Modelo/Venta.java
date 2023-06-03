package Modelo;

import Modelo.Productos;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Date;

public class Venta {
    private int IDVenta;
    private String IDp;
    private int cantidad;
   private double total;


    public int getIDVenta() {
        return IDVenta;
    }

    public void setIDVenta(int IDVenta) {
        this.IDVenta = IDVenta;
    }

    public String getIDp() {
        return IDp;
    }

    public void setIDp(String IDp) {
        this.IDp = IDp;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


private LocalDateTime fecha;

    public Venta(int IDVenta, String IDp, int cantidad, double total, LocalDateTime fecha) {
        this.IDVenta = IDVenta;
        this.IDp = IDp;
        this.cantidad = cantidad;
        this.total = total;
        this.fecha = fecha;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Venta(int IDVenta, String IDp, int cantidad, double total) {
        this.IDVenta = IDVenta;
        this.IDp = IDp;
        this.cantidad = cantidad;
        this.total = total;
        this.fecha= LocalDateTime.now();
    }
}
