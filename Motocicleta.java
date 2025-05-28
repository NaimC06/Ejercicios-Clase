public class Motocicleta {
    private int codigo;       // Identificador único de 4 cifras
    private String marca;     // Marca (e.g., HONDA, BMW, Vespa, Royal Enfield)
    private int cilindraje;   // Cilindraje (300, 500, 800, 1000)
    private String color;     // Color de la motocicleta
    private double precio;     // Precio (debe ser mayor a 1500 y menor a 30000)

    // Constructor
    public Motocicleta(int codigo, String marca, int cilindraje, String color, double precio) {
        this.codigo = codigo;
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.color = color;
        this.precio = precio;
    }

    // Getters
    public int getCodigo() {
        return codigo;
    }

    public String getMarca() {
        return marca;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public String getColor() {
        return color;
    }

    public double getPrecio() {
        return precio;
    }

    // Setters
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrecio(double precio) {
        if(precio > 1500 && precio < 30000) {
            this.precio = precio;
        } else {
            throw new IllegalArgumentException("El precio debe estar entre 1500 y 30000.");
        }
    }
}
