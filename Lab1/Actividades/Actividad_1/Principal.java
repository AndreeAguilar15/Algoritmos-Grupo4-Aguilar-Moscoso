import java.util.Scanner;

public class Principal {

    public static void mostrarRectangulo(Rectangulo r, String nombre) {
        System.out.println("Rectangulo " + nombre + " = " + r.toString());
    }

    public static Rectangulo rectanguloSobre(Rectangulo a, Rectangulo b) {
        Coordenada a1 = a.getEsquina1();
        Coordenada a2 = a.getEsquina2();
        Coordenada b1 = b.getEsquina1();
        Coordenada b2 = b.getEsquina2();

        // Obtener las coordenadas mínimas y máximas de cada rectángulo
        double aMinX = Math.min(a1.getX(), a2.getX());
        double aMaxX = Math.max(a1.getX(), a2.getX());
        double aMinY = Math.min(a1.getY(), a2.getY());
        double aMaxY = Math.max(a1.getY(), a2.getY());

        double bMinX = Math.min(b1.getX(), b2.getX());
        double bMaxX = Math.max(b1.getX(), b2.getX());
        double bMinY = Math.min(b1.getY(), b2.getY());
        double bMaxY = Math.max(b1.getY(), b2.getY());

        double sobreMinX = Math.max(aMinX, bMinX);
        double sobreMaxX = Math.min(aMaxX, bMaxX);
        double sobreMinY = Math.max(aMinY, bMinY);
        double sobreMaxY = Math.min(aMaxY, bMaxY);

        Coordenada c1 = new Coordenada(sobreMinX, sobreMinY);
        Coordenada c2 = new Coordenada(sobreMaxX, sobreMaxY);

        return new Rectangulo(c1, c2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una esquina del 1er rectángulo:");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        System.out.println("Ingrese la esquina opuesta del 1er rectángulo:");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        Coordenada c1a = new Coordenada(x1, y1);
        Coordenada c1b = new Coordenada(x2, y2);
        Rectangulo A = new Rectangulo(c1a, c1b);

        System.out.println("Ingrese una esquina del 2do rectángulo:");
        x1 = sc.nextDouble();
        y1 = sc.nextDouble();
        System.out.println("Ingrese la esquina opuesta del 2do rectángulo:");
        x2 = sc.nextDouble();
        y2 = sc.nextDouble();

        Coordenada c2a = new Coordenada(x1, y1);
        Coordenada c2b = new Coordenada(x2, y2);
        Rectangulo B = new Rectangulo(c2a, c2b);

        mostrarRectangulo(A, "A");
        mostrarRectangulo(B, "B");

        if (Verificador.seSobreponen(A, B)) {
            System.out.println("Rectángulos A y B se sobreponen.");
            Rectangulo sobreposicion = rectanguloSobre(A, B);
            System.out.println("Área de sobreposición = " +
                    String.format("%.2f", sobreposicion.calculoArea()));
        } else if (Verificador.estanJuntos(A, B)) {
            System.out.println("Rectángulos A y B se juntan.");
        } else if (Verificador.sonDisjuntos(A, B)) {
            System.out.println("Rectángulos A y B son disjuntos.");
        }

        // --- Prueba de ContainerRect ---
        System.out.println("\n--- Almacenando rectángulos en ContainerRect ---");
        ContainerRect contenedor = new ContainerRect(5); // Capacidad para 5
        contenedor.addRectangulo(A);
        contenedor.addRectangulo(B);
        
        System.out.println(contenedor.toString());
        System.out.println("Total de rectángulos guardados: " + ContainerRect.numRec);

        sc.close();
    }
}
