public class ContainerRect {
    private Rectangulo[] rectangulos;
    private double[] distancias;
    private double[] areas;
    private int n;
    public static int numRec = 0;

    public ContainerRect(int n) {
        this.n = n;
        this.rectangulos = new Rectangulo[n];
        this.distancias = new double[n];
        this.areas = new double[n];
    }

    public void addRectangulo(Rectangulo r) {
        if (numRec < n) {
            rectangulos[numRec] = r;
            //Distancia euclidea entre sus coordenadas 
            distancias[numRec] = r.getEsquina1().distancia(r.getEsquina2());
            //Area
            areas[numRec] = r.calculoArea();
            numRec++;
        } else {
            System.out.println("No es posible guardar el rectángulo. Capacidad máxima alcanzada.");
        }
    }

    @Override
    public String toString() {
        String result = "Listado de Rectángulos:\n";
        for (int i = 0; i < numRec; i++) {
            result += "Rectángulo " + (i + 1) + ": " + rectangulos[i].toString() + "\n";
            result += "  Distancia: " + distancias[i] + "\n";
            result += "  Área: " + areas[i] + "\n";
        }
        return result;
    }
}
