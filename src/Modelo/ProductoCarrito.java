package Modelo;

public class ProductoCarrito {
    private Producto productoOriginal;
    private int cantidadCompra;

    public Producto getProductoOriginal() {
        return productoOriginal;
    }

    public void setProductoOriginal(Producto productoOriginal) {
        this.productoOriginal = productoOriginal;
    }

    public int getCantidadCompra() {
        return cantidadCompra;
    }

    public void setCantidadCompra(int cantidadCompra) {
        this.cantidadCompra = cantidadCompra;
    }

    public ProductoCarrito(Producto productoOriginal, int cantidadCompra) {
        this.productoOriginal = productoOriginal;
        this.cantidadCompra = cantidadCompra;
    }
    public String total(){
        double k=this.cantidadCompra*productoOriginal.getPrecio();
        return k+"";
    }
}
