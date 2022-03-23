
package tp_global;

import java.util.*;

public class TP_Global {

    public static void main(String[] args) {

        ArrayList<Cliente> clientes = new ArrayList<>(); //Creación de arraylist

        inicioSecion(clientes);
    }

    private static void inicioSecion (ArrayList<Cliente> AC) { //Método en la que aplico recursivivdad
        
        String nombre, contra;
        int rol = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Bienvenido a la APP de delivery de HYC");
        System.out.println("A continuación cargue los datos requerido para poder realizar las operaciones.");
        System.out.print("Ingrese su nombre -> ");
        nombre = input.nextLine();
        System.out.println("Ingrese su contraseña ->");
        contra = input.nextLine();

        switch (verificacion(nombre, contra, AC)) {
            case 1: 
                agregarCliente(AC);
                inicioSecion(AC); //Llamada a la recursividad
                break;
                
            case 2:
                rol = 2;
                menu(2, nombre);
                break;
                
            case 3:
                rol = 1;
                menu(1, nombre);
                break;

            default: 
                System.out.println("Algo ha salido mal :(");
                break;                
        }
    }
    
    //Función que verifica que tipo de usuario ingresó para saber si aplicar descuento o no
    private static int verificacion (String nombre, String contra, ArrayList <Cliente> AC) {
        
        int opcion = 0, i;
        
        boolean bandera = false;

        Scanner input = new Scanner(System.in);
        
        for (i = 0; i < AC.size(); i++) {

            if ((AC.get(i).getNombre().equals(nombre)) && (AC.get(i).getContra().equals(contra))) {

                System.out.println("USUARIO CORRECTO");
                System.out.println("BIENVENIDO " + nombre);
                bandera = true;
                return 3;
            }
        }
            
        if (bandera == false) { //If en caso de que el usuario no exista
            
            do {
                
                System.out.println("SU CUENTA NO EXISTE");
                System.out.println("¿Desea crear una cuenta?. Todos los usuarios existentes obtienen un 10% de descuento");
                System.out.println("1. SI");
                System.out.println("2. NO");
                opcion = input.nextInt();
                
            } while ((opcion != 1) && (opcion != 2));
            
            if (opcion == 1) {
                
                return 1;
                
            }
            
        }
        
        return 2;        
        
    }
    
    //Método para cargar nuevos clientes
    public static void agregarCliente (ArrayList<Cliente> AC) {
        
        String nombre = null, contra = null, contra2 = null;
        int rol = 0;
        boolean opcion = false;
        
        Scanner leer = new Scanner (System.in);
        
        Cliente a = new Cliente();
        
        //Aplico manejo de excepciones
        do {
            try {
                System.out.println("A continuacion ingrese los datos requeridos");
                System.out.println("Nombre:");
                nombre = leer.next();
                System.out.println("Contraseña:");
                contra = leer.next();
                System.out.println("Repita la Contraseña:");
                contra2 = leer.next();
                
                if (contra.equals(contra2)) {
                    opcion = true;
                } else {
                    System.out.println("ERROR. Las contraseñas no coinciden");
                    opcion = false;
                }
            } catch (Exception e) {
                leer.next();
                System.out.println("ERROR. El dato ingresado es incorrecto.");
                System.out.println("");
            }
        }
        while (opcion == false); 
        
        System.out.println("");
        a = new Cliente(nombre, contra, 1);
        AC.add(a);

    }
    
    private static void menu (int rol, String nombre) {

        Local local = new Local("HYC", "Aristides 1500");

        Hashtable<Integer, Producto> tablaProductos = new Hashtable<>();

        HamburguesaComun HC = new HamburguesaComun("Hamburguesa Comun", 500, local);
        tablaProductos.put(1, HC);

        HamburguesaDoble HD = new HamburguesaDoble("Hamburguesa Doble", 1000, local);
        tablaProductos.put(2, HD);

        PanchoSimple PS = new PanchoSimple("Pancho Simple", 200, local);
        tablaProductos.put(3, PS);

        PapasFritas PF = new PapasFritas("Papas Fritas", 150, local);
        tablaProductos.put(4, PF);

        CocaCola CC = new CocaCola("Coca-Cola", 100, local);
        tablaProductos.put(5, CC);

        Fanta F = new Fanta("Fanta", 100, local);
        tablaProductos.put(6, F);

        Sprite S = new Sprite("Sprite", 100, local);
        tablaProductos.put(7, S);


        int opcion = 0;
        double montoPagar = 0, montoTotal = 0;

        Scanner input = new Scanner(System.in);

        Stack ordenCompra = new Stack();

        System.out.println();
        System.out.println("A CONTINUACION ARME SU PEDIDO");
            
        do {
            
            System.out.println();
            System.out.println("OPCIONES");
            System.out.println("------------------------------------------------");
            System.out.println("1. Hamburguesa común");
            System.out.println("2. Hamburguesa doble");
            System.out.println("3. Pancho simple");
            System.out.println("4. Papas fritas");
            System.out.println("5. Coca-Cola");
            System.out.println("6. Fanta");
            System.out.println("7. Sprite");
            System.out.println("8. Finalizar pedido");
            System.out.println("------------------------------------------------");

            if (!ordenCompra.empty()) {//Si la orden de compra "es diferente a vacio", es decir, si tiene valores, entra en el if

                System.out.println("PEDIDO");

                Iterator iter1 = ordenCompra.iterator();//Extraigo el comportamiento de recorrido de la pila.

                while (iter1.hasNext()) { //Gracias al método "hasNext()" permite conocer si hay o no elementos en la pila (array, etc)

                    System.out.println("->" + iter1.next()); //La función "next()" devuelve el valor siguiente como cadena

                }

                System.out.println("------------------------------------------------");

                if (rol == 1) { //if para el usuario registrado

                    montoPagar = montoTotal;

                    montoPagar -= montoPagar * 0.1; //Cálculo de descuento

                    System.out.println("MONTO TOTAL A PAGAR: $" + montoPagar);

                }
                else {

                    if (rol == 2) { //if para usuario no registrado

                        System.out.println("MONTO TOTAL A PAGAR: $" + montoTotal);

                    }

                }

                System.out.println("------------------------------------------------");

            }
            
            opcion = input.nextInt();

            switch (opcion) {
                
                case 1:

                    ordenCompra.push(tablaProductos.get(1).getNombre()); //push agrega lo que sea a una pila. En este caso, agrego un elemento de hash table
                    montoTotal += tablaProductos.get(1).getPrecio(); //Extraigo de la hash table el precio del producto para almacenarlo en el monto
                    break;
                
                case 2:

                    ordenCompra.push(tablaProductos.get(2).getNombre());
                    montoTotal += tablaProductos.get(2).getPrecio();
                    break;
                
                case 3:

                    ordenCompra.push(tablaProductos.get(3).getNombre());
                    montoTotal += tablaProductos.get(3).getPrecio();
                    break;
                
                case 4:

                    ordenCompra.push(tablaProductos.get(4).getNombre());
                    montoTotal += tablaProductos.get(4).getPrecio();
                    break;

                case 5:

                    ordenCompra.push(tablaProductos.get(5).getNombre());
                    montoTotal += tablaProductos.get(5).getPrecio();
                    break;
                    
                case 6:

                    ordenCompra.push(tablaProductos.get(6).getNombre());
                    montoTotal += tablaProductos.get(6).getPrecio();
                    break;
                    
                case 7:

                    ordenCompra.push(tablaProductos.get(7).getNombre());
                    montoTotal += tablaProductos.get(7).getPrecio();
                    break;

                case 8:
                    
                    do {
                        
                        System.out.println("¿Seguro desea finalizar el pedido?");
                        System.out.println("1. SI");
                        System.out.println("2. NO");
                        opcion = input.nextInt();
                        
                    } while ((opcion != 1) && (opcion != 2));
                    
                    if (opcion == 1) {
                        
                        System.out.println();
                        System.out.println("Adios " + nombre + " :)");
                        System.out.println("Gracias por comprar en " + tablaProductos.get(1).local.getNombre()); //Nuevamente uso hash table. Obtengo el nombre del local, y de este objeto obtengo el nombre del mismo. (Aquí aplico agregación)
                        opcion = 8;

                    }
                    else {
                        
                        opcion = 0; //Igualo la opción a 0 para "reiniciar todo"

                    }
                    
                    break;
                    
                default:

                    System.out.println();
                    System.out.println("Error. Seleccione una de las opciones");
                    break;       
            }

        } while (opcion != 8); //Condición de salida
    }

}
