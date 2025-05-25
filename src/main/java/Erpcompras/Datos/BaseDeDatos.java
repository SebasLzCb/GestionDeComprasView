// BaseDeDatos.java
package Erpcompras.Datos;

import java.util.ArrayList;
import java.util.List;
import Erpcompras.Models.Proveedor;
import Erpcompras.Models.Producto;
import Erpcompras.Models.SolicitudCompra;

public class BaseDeDatos {
    public static List<Proveedor> proveedores = new ArrayList<>();
    public static List<Producto> productos = new ArrayList<>();
    public static List<SolicitudCompra> solicitudes = new ArrayList<>();
}