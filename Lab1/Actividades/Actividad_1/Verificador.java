public class Verificador {
    public static boolean seSobreponen(Rectangulo a, Rectangulo b) {
        Coordenada a1 = a.getEsquina1();
        Coordenada a2 = a.getEsquina2();
        Coordenada b1 = b.getEsquina1();
        Coordenada b2 = b.getEsquina2();

        double aMinX = Math.min(a1.getX(), a2.getX());
        double aMaxX = Math.max(a1.getX(), a2.getX());
        double aMinY = Math.min(a1.getY(), a2.getY());
        double aMaxY = Math.max(a1.getY(), a2.getY());

        double bMinX = Math.min(b1.getX(), b2.getX());
        double bMaxX = Math.max(b1.getX(), b2.getX());
        double bMinY = Math.min(b1.getY(), b2.getY());
        double bMaxY = Math.max(b1.getY(), b2.getY());

        if (aMaxX <= bMinX || bMaxX <= aMinX || aMaxY <= bMinY || bMaxY <= aMinY) {
            return false;
        }
        return true;
    }

    public static boolean estanJuntos(Rectangulo a, Rectangulo b) {
        Coordenada a1 = a.getEsquina1();
        Coordenada a2 = a.getEsquina2();
        Coordenada b1 = b.getEsquina1();
        Coordenada b2 = b.getEsquina2();

        double aMinX = Math.min(a1.getX(), a2.getX());
        double aMaxX = Math.max(a1.getX(), a2.getX());
        double aMinY = Math.min(a1.getY(), a2.getY());
        double aMaxY = Math.max(a1.getY(), a2.getY());

        double bMinX = Math.min(b1.getX(), b2.getX());
        double bMaxX = Math.max(b1.getX(), b2.getX());
        double bMinY = Math.min(b1.getY(), b2.getY());
        double bMaxY = Math.max(b1.getY(), b2.getY());

        return (aMaxX == bMinX || bMaxX == aMinX || aMaxY == bMinY || bMaxY == aMinY) &&
                !seSobreponen(a, b);
    }

    public static boolean sonDisjuntos(Rectangulo a, Rectangulo b) {
        return !seSobreponen(a, b) && !estanJuntos(a, b);
    }
}
