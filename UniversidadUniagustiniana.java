import java.util.ArrayList;

public class UniversidadUniagustiniana {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("Juan camilo baez", 19, "2220221008");
        Profesor profesor = new Profesor("Daniel David Leal", 25, "22202247189");

        estudiante.mostrarInfoPersona();
        estudiante.mostrarInfoCurso();
        estudiante.realizarPedido("Café", 2500);

        System.out.println();

        profesor.mostrarInfoPersona();
        profesor.mostrarInfoProfesor();
        profesor.realizarPedido("Sándwich", 4000);
    }
}

class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void mostrarInfoPersona() {
        System.out.println("NOMBRE: " + nombre);
        System.out.println("EDAD: " + edad);
    }
}

class Estudiante extends Persona implements Curso, ClienteCafeteria {
    private String codigoEstudiante;

    public Estudiante(String nombre, int edad, String codigoEstudiante) {
        super(nombre, edad);
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    @Override
    public void mostrarInfoCurso() {
        System.out.println("CODIGO DEL ESTUDIANTE: " + codigoEstudiante);
        System.out.println("SEMESTRE: 4 semestre");
    }

    @Override
    public void realizarPedido(String nombreProducto, double precio) {
        System.out.println("Pedido realizado por " + getNombre() + ": " + nombreProducto + " - $" + precio);
    }
}

class Profesor extends Persona implements ClienteCafeteria {
    private String codigoProfesor;

    public Profesor(String nombre, int edad, String codigoProfesor) {
        super(nombre, edad);
        this.codigoProfesor = codigoProfesor;
    }

    public String getCodigoProfesor() {
        return codigoProfesor;
    }

    public void mostrarInfoProfesor() {
        System.out.println("CODIGO DEL PROFESOR : " + codigoProfesor);
        System.out.println("MATERIA: aplicaciones moviles");
    }

    @Override
    public void realizarPedido(String nombreProducto, double precio) {
        System.out.println("Pedido realizado por el Profesor " + getNombre() + ": " + nombreProducto + " $" + precio);
    }
}

interface Curso {
    void mostrarInfoCurso();
}

interface ClienteCafeteria {
    void realizarPedido(String nombreProducto, double precio);
}


class Cafeteria {
    private String nombre;
    private ArrayList<Producto> productos;

    public Cafeteria(String nombre) {
        this.nombre = nombre;
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void mostrarProductos() {
        System.out.println("Productos disponibles en " + nombre + ":");
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + " - $" + producto.getPrecio());
        }
    }
}



class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}