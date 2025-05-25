package Erpcompras.Models;

import java.util.*;

public class Menu {
    private List<Proveedor> proveedores = new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();
    private List<SolicitudCompra> solicitudes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n===== SISTEMA DE GESTIÓN DE COMPRAS ERP =====");
            System.out.println("1. Registrar proveedor");
            System.out.println("2. Registrar producto");
            System.out.println("3. Registrar solicitud de compra");
            System.out.println("4. Listar proveedores");
            System.out.println("5. Listar productos");
            System.out.println("6. Listar solicitudes de compra");
            System.out.println("7. Buscar proveedor por ID");
            System.out.println("8. Buscar producto por nombre");
            System.out.println("9. Buscar solicitud por número");
            System.out.println("13. Aprobar / Rechazar solicitud de compra");
            System.out.println("14. Calcular total de una solicitud");
            System.out.println("15. Salir");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> registrarProveedor();
                case 2 -> registrarProducto();
                case 3 -> registrarSolicitud();
                case 4 -> listar(proveedores);
                case 5 -> listar(productos);
                case 6 -> listar(solicitudes);
                case 7 -> buscarProveedorPorId();
                case 8 -> buscarProductoPorNombre();
                case 9 -> buscarSolicitudPorNumero();
                case 13 -> cambiarEstadoSolicitud();
                case 14 -> calcularTotalSolicitud();
                case 15 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 15);
    }

    private void registrarProveedor() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Persona persona = new Persona(nombre, apellido, dni, telefono, email);
        Proveedor proveedor = new Proveedor(id, persona);
        proveedores.add(proveedor);
        System.out.println("Proveedor registrado.");
    }


    private void registrarProducto() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio unitario: ");
        double precio = Double.parseDouble(scanner.nextLine());
        System.out.print("Unidad de medida (UNIDAD/KILOGRAMO/LITRO/CAJA): ");
        UnidadMedida unidad = UnidadMedida.valueOf(scanner.nextLine().toUpperCase());

        // Primero se pide el proveedor
        System.out.print("ID del proveedor asociado: ");
        int idProv = Integer.parseInt(scanner.nextLine());
        Proveedor proveedor = proveedores.stream()
                .filter(p -> p.getId() == idProv)
                .findFirst()
                .orElse(null);
        if (proveedor == null) {
            System.out.println("Proveedor no encontrado. No se registró el producto.");
            return;
        }

        System.out.println("Tipo de producto:");
        for (TipoProducto tipo : TipoProducto.values()) {
            System.out.println("- " + tipo);
        }
        System.out.print("Seleccione tipo: ");
        TipoProducto tipoProducto = TipoProducto.valueOf(scanner.nextLine().toUpperCase());

        Producto producto = null;
        switch (tipoProducto) {
            case DULCE -> {
                System.out.print("Sabor del dulce: ");
                String sabor = scanner.nextLine();
                producto = new ProductoDulce(id, nombre, precio, unidad, sabor, proveedor);
            }
            case COSMETICO -> {
                System.out.print("Marca del cosmético: ");
                String marca = scanner.nextLine();
                producto = new ProductoCosmetico(id, nombre, precio, unidad, marca, proveedor);
            }
            case PERIFERICO -> {
                System.out.print("Tipo de conexión (USB, BLUETOOTH, etc.): ");
                String conexion = scanner.nextLine();
                producto = new ProductoPeriferico(id, nombre, precio, unidad, conexion, proveedor);
            }
            case SIMPLE -> {
                producto = new ProductoSimple(id, nombre, precio, unidad, proveedor);
            }
            default -> {
                System.out.println("Tipo no válido.");
                return;
            }
        }

        productos.add(producto);
        System.out.println("Producto registrado y enlazado al proveedor.");
    }

    private void registrarSolicitud() {
        System.out.print("Número de solicitud: ");
        int numero = Integer.parseInt(scanner.nextLine());
        System.out.print("ID del proveedor: ");
        int idProv = Integer.parseInt(scanner.nextLine());
        Proveedor proveedor = proveedores.stream().filter(p -> p.getId() == idProv).findFirst().orElse(null);
        if (proveedor == null) {
            System.out.println("Proveedor no encontrado.");
            return;
        }

        List<DetalleSolicitud> detalles = List.of();
        SolicitudCompra solicitud = new SolicitudCompra(numero, proveedor, detalles);
        String continuar = "s";

        do {
            System.out.print("ID del producto: ");
            int idProd = Integer.parseInt(scanner.nextLine());
            Producto producto = productos.stream().filter(p -> p.getId() == idProd).findFirst().orElse(null);
            if (producto == null) {
                System.out.println("Producto no encontrado.");
                continue;
            }
            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine());
            solicitud.agregarDetalle(new DetalleSolicitud(producto, cantidad));
            System.out.print("¿Agregar otro producto? (s/n): ");
            continuar = scanner.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        solicitudes.add(solicitud);
        System.out.println("Solicitud registrada.");
    }

    private void listar(List<?> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay elementos para mostrar.");
            return;
        }
        lista.forEach(System.out::println);
    }

    private void buscarProveedorPorId() {
        System.out.print("ID del proveedor: ");
        int id = Integer.parseInt(scanner.nextLine());
        proveedores.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Proveedor no encontrado.")
                );
    }

    private void buscarProductoPorNombre() {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        productos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Producto no encontrado.")
                );
    }

    private void buscarSolicitudPorNumero() {
        System.out.print("Número de solicitud: ");
        int numero = Integer.parseInt(scanner.nextLine());
        solicitudes.stream()
                .filter(s -> s.getNumero() == numero)
                .findFirst()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Solicitud no encontrada.")
                );
    }

    private void cambiarEstadoSolicitud() {
        System.out.print("Número de solicitud: ");
        int numero = Integer.parseInt(scanner.nextLine());
        SolicitudCompra solicitud = solicitudes.stream()
                .filter(s -> s.getNumero() == numero)
                .findFirst()
                .orElse(null);

        if (solicitud == null) {
            System.out.println("Solicitud no encontrada.");
            return;
        }

        System.out.print("Nuevo estado (APROBADA/RECHAZADA): ");
        try {
            EstadoSolicitud estado = EstadoSolicitud.valueOf(scanner.nextLine().toUpperCase());
            solicitud.setEstado(estado);
            System.out.println("Estado actualizado.");
        } catch (IllegalArgumentException e) {
            System.out.println("Estado no válido.");
        }
    }

    private void calcularTotalSolicitud() {
        System.out.print("Número de solicitud: ");
        int numero = Integer.parseInt(scanner.nextLine());
        solicitudes.stream()
                .filter(s -> s.getNumero() == numero)
                .findFirst()
                .ifPresentOrElse(
                        s -> System.out.println("Total: " + s.calcularTotal()),
                        () -> System.out.println("Solicitud no encontrada.")
                );
    }
}
