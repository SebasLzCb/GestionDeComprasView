# **Práctica de laboratorio 02: Diseño de una interfaz gráfica de usuario básica utilizando contenedores y componentes gráficos**

## **Información General**

- **Título:** Sistema de Gestión de Compras ERP con interfaz grafica  
- **Número de práctica:** 1  
- **Asignatura:**
- Programación Orientada a Objetos  
- **Carrera:**
- Ingeniería en Ciencias de la Computación  
- **Estudiantes:**
- Sebastián Loza
- Ivanna Nievecela  
- **Fecha:**
- 25 de Mayo del 2025  
- **Profesor:**
- Ing.Gabriel Alejandro Leon Paredes 

---

## 🎯 **Objetivo**

- Diseñar una interfaz gráfica básica aplicando principios de diseño con AWT.
- Utilizar contenedores y componentes gráficos de Java para simular operaciones del sistema ERP de compras.
- Fomentar la reutilización de código, el orden lógico del sistema y la separación por capas.
- Aplicar el paradigma de programación orientada a eventos.
- Integrar el sistema gráfico con la lógica existente desarrollada en la práctica anterior.

---
## **Descripción**

En esta segunda fase del proyecto, se implementó una interfaz gráfica de usuario utilizando AWT (Abstract Window Toolkit) para simular las funcionalidades del sistema ERP de compras desarrollado previamente.
Se crearon interfaces visuales independientes para:

Registrar productos y proveedores.

Registrar y mostrar solicitudes de compra.

Buscar entidades y calcular totales.

Mostrar listados y permitir operaciones interactivas.

Cada ventana permite ingresar datos a través de TextFields, seleccionar opciones con Choice o Checkbox, y ejecutar acciones con Buttons.

---

## **Ejecución**

Para compilar y ejecutar el proyecto:

1. **Compilar el código**:
   ```bash
   javac Main.java
- Ejecutar la aplicación:
  ```bash
  java Main
  ```
--- 

Al iniciar el sistema, aparecerá un menú gráfico desde el cual se puede acceder a todas las funcionalidades mediante botones.


## **Diagrama de Clases (Interfaz Gráfica)**

Se deben incluir las clases que representan las ventanas gráficas, como ProductoView, ProveedorView, SolicitudView, etc.

Estructura del Proyecto
``` plaintext
src/
 └── main/
      └── java/
           └── Erpcompras/
                ├── Models/
                │    ├── Producto.java
                │    ├── ProductoSimple.java
                │    ├── ProductoDulce.java
                │    ├── ProductoCosmetico.java
                │    ├── ProductoPeriferico.java
                │    ├── Proveedor.java
                │    └── SolicitudCompra.java
                │    ├── UnidadMedida.java
                │    ├── EstadoSolicitud.java
                │    └── Calculable.java
                ├── View/
                │    ├── MenuPrincipalView.java
                │    ├── ProductoView.java
                │    ├── ProveedorView.java
                │    ├── SolicitudView.java
                │    ├── BuscarproductoView.java
                │    ├── BuscarProveedor.java
                │    ├── BuscarSolicitud.java
                │    ├── CalcularTotalView.java
                │    ├── ListarProveedoresView.java
                │    ├── ListarProductosView.java
                │    ├── ListarSolicitudesView.java
                │    ├── LoginView.java
                │    ├── BaseView.java
                │    ├── AprobarRechazarView.java
                │    └── AppAWT.java

``` 
Relación entre Clases (Vista)
MenuView: Ventana principal que dirige a las demás.

ProductoView, ProveedorView: Ventanas de registro.

SolicitudView: Permite registrar una solicitud e ingresar productos.

BusquedaView: Ofrece búsquedas por ID, nombre o número de solicitud.

calcularTotalView: Muestra el total de una solicitud específica.

Nota: Cada clase gráfica se conecta con las clases modelo (Producto, Proveedor, etc.) para manipular los datos reales.

Interfaz Gráfica del Sistema (Flujo General)

Al ejecutar la aplicación gráfica se muestra:

``` markdown
========= ERP GESTIÓN DE COMPRAS (INTERFAZ GRÁFICA) =========

[Botón] Registrar proveedor
[Botón] Registrar producto
[Botón] Registrar solicitud de compra
[Botón] Listar proveedores
[Botón] Listar productos
[Botón] Listar solicitudes
[Botón] Buscar proveedor / producto / solicitud
[Botón] Aprobar o rechazar solicitud
[Botón] Calcular total de solicitud
[Botón] Salir
Cada botón abre una nueva ventana (Frame) correspondiente a la operación seleccionada.

```
## Tecnologías Utilizadas

- Java 24
- Git y GitHub
- IDE IntelliJ IDEA
- Principios de POO (abstracción, herencia, polimorfismo, encapsulamiento)
- Enums y Lambdas en Java

## Cómo Ejecutar el Proyecto
Clonar el repositorio:
``` bash
git clone <https://github.com/SebasLzCb/icc-est-u1-gestionDeCompras.git>
Abrir el proyecto en IntelliJ IDEA.
```

## Compilar el proyecto.

Ejecutar la clase AppAWT.java.

Interactuar desde la consola.

Consideraciones de Diseño

## Consideraciones de Diseño

Separación clara entre modelo y vista: El código mantiene la lógica en Models y la interfaz en View.

Modularidad: Cada ventana se implementa en su propia clase.

Facilidad de mantenimiento: Se puede mejorar la UI sin afectar la lógica interna.

Componentes reutilizables: Algunos Frames reutilizan métodos y estructuras comunes.
