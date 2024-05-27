package org.example.Ejercicio3;
import java.util.Scanner;

public class Principal {

    public static final int OPCION_ANADE_PRODUCTO = 1;
    public static final int OPCION_MUESTRA_PRODUCTOS = 2;
    public static final int OPCION_MUESTRA_PRODUCTOS_PRECIO = 3;
    public static final int OPCION_ANADE_CLIENTE = 4;
    public static final int OPCION_MUESTRA_CLIENTES = 5;
    public static final int OPCION_COMPRA = 6;
    public static final int OPCION_MUESTRA_CARROS = 7;
    public static final int OPCION_MUESTRA_CARROS_PRECIO = 8;
    public static final int OPCION_SALIR = 9;

    public static void mostrarMenu() {
        System.out.println("==================================================");
        System.out.println(" Chomon ONLINE ");
        System.out.println("==================================================");
        System.out.println("1.-  Añade producto");
        System.out.println("2.-  Muestra productos");
        System.out.println("3.-  Muestra productos por precio");
        System.out.println("4.-  Añade cliente");
        System.out.println("5.-  Muestra clientes");
        System.out.println("6.-  Realiza compra");
        System.out.println("7.-  Muestra carros");
        System.out.println("8.-  Muestra carros precio");
        System.out.println("9.-  Salir");
        System.out.println("==================================================");
        System.out.print("Introduce una opción: ");
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc;
        int opcion;
        ListaProductos miListaProductos = new ListaProductos();
        miListaProductos.setLista(MYSQL.cargarProductos());

        ListaPersonas miListaClientes = new ListaPersonas();
        miListaClientes.setLista(MYSQL.cargarClientes());

        ListaCarros miListaCarros = new ListaCarros();
        miListaCarros.setLista(MYSQL.cargarCarros());

        Producto productoAux;
        Persona clienteAux;
        Carro carroAux;

        do {
            mostrarMenu();
            sc = new Scanner(System.in);
            opcion = sc.nextInt();
            switch (opcion) {
                case OPCION_ANADE_PRODUCTO: {
                    System.out.println("Alta de producto: ");
                    productoAux = new Producto();
                    productoAux.alta();
                    miListaProductos.anadirProducto(productoAux);
                    MYSQL.addproducto(productoAux);
                    break;
                }
                case OPCION_MUESTRA_PRODUCTOS: {
                    System.out.println("Listado de productos: ");
                    miListaProductos.mostrarProductos();
                    break;
                }
                case OPCION_MUESTRA_PRODUCTOS_PRECIO: {
                    sc = new Scanner(System.in);
                    System.out.print("Busqueda de producto por precio.\n");
                    System.out.print("Precio: ");
                    Float precio = Float.valueOf(sc.next());
                    for (Producto producto: miListaProductos.getLista()) {
                        if (producto.getPrecio()>precio){
                            System.out.println(producto);
                        }
                    }
                    break;
                }
                case OPCION_ANADE_CLIENTE : {
                    System.out.println("Alta de cliente: ");
                    clienteAux = new Persona();
                    clienteAux.alta();
                    miListaClientes.anadirPersona(clienteAux);
                    MYSQL.addcliente(clienteAux);
                    break;
                }
                case OPCION_MUESTRA_CLIENTES : {
                    System.out.println("Listado de personas: ");
                    miListaClientes.mostrarPersonas();
                    break;
                }
                case OPCION_COMPRA : {
                    System.out.println("Selecciona un cliente de la lista: ");
                    miListaClientes.mostrarPersonas();
                    int numero = sc.nextInt();
                    if (numero >= 0 && numero <= miListaClientes.numeroPersonas()) {
                        carroAux = new Carro();
                        carroAux.setCliente(miListaClientes.personaPosicionI(numero));
                        carroAux.compra(miListaProductos);
                        miListaCarros.anadirCarro(carroAux);
                        MYSQL.addCarro(carroAux);
                        // Para evitar que se creen dos entidades carros para la misma persona
                        miListaCarros.setLista(MYSQL.cargarCarros());
                    } else {
                        System.out.println("Introduce un número de producto válido");
                    }
                    break;
                }
                case OPCION_MUESTRA_CARROS : {
                    System.out.println("Carros dados de alta");
                    miListaCarros.mostrarCarros();
                    break;
                }
                case OPCION_MUESTRA_CARROS_PRECIO : {
                    System.out.println("Carros con información específica: ");
                    miListaCarros.mostrarCarrosPrecio();
                    break;
                }
                case OPCION_SALIR : {
                    System.out.println("Fin del programa. Recuerda pulsar ALT+F4 para cerrar la ventana");
                    break;
                }
                default : {
                    System.out.println("Introduce una opción válida");
                    break;
                }
            }

        } while (opcion != OPCION_SALIR);

    }

}
