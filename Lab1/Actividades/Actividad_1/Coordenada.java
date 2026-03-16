public class Coordenada {
    private double x;
    private double y;

    // Constructor
    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Constructor copia
    public Coordenada(Coordenada c) {
        this.x = c.getX();
        this.y = c.getY();
    }

    // Métodos setter
    void setX(double x) {
        this.x = x;
    }

    void setY(double y) {
        this.y = y;
    }

    // Métodos getter
    double getX() {
        return this.x;
    }

    double getY() {
        return this.y;
    }

    // Método de instancia que calcula la distancia euclideana
    double distancia(Coordenada c) {
        double dx = this.x - c.getX();
        double dy = this.y - c.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Método de clase que calcula la distancia euclideana
    static double distancia(Coordenada c1, Coordenada c2) {
        double dx = c1.getX() - c2.getX();
        double dy = c1.getY() - c2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Método que devuelve los valores de una coordenada en determinado formato
    public String toString() {
        return "[" + this.x + ", " + this.y + "]";
    }
}
