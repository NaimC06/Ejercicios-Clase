import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Motocicleta {
    int codigo;
    String marca;
    int cilindraje;
    String color;
    double precio;

    public Motocicleta(int codigo, String marca, int cilindraje, String color, double precio) {
        this.codigo = codigo;
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.color = color;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Marca: " + marca + ", Cilindraje: " + cilindraje + 
                ", Color: " + color + ", Precio: " + precio;
    }
}

public class Ventana extends JFrame implements ActionListener {
    private ArrayList<Motocicleta> listaMotocicletas = new ArrayList<>();
    private JTextArea textArea;
    private JTextField codigoField;
    private JComboBox<String> marcaComboBox;
    private JComboBox<Integer> cilindrajeComboBox;
    private JComboBox<String> colorComboBox;
    private JTextField precioField;

    public Ventana() {
        setTitle("Gestión de Motocicletas");
        setSize(600, 400);
        setLayout(new FlowLayout());

        codigoField = new JTextField(4);
        marcaComboBox = new JComboBox<>(new String[]{"HONDA", "BMW", "VESPA", "ROYAL ENFIELD"});
        cilindrajeComboBox = new JComboBox<>(new Integer[]{300, 500, 800, 1000});
        colorComboBox = new JComboBox<>(new String[]{"Rojo", "Azul", "Verde", "Negro", "Blanco"});
        precioField = new JTextField(10);
        
        JButton agregarButton = new JButton("Agregar Motocicleta");
        agregarButton.addActionListener(this);
        
        textArea = new JTextArea(10, 50);
        textArea.setEditable(false);
        
        add(new JLabel("Código:"));
        add(codigoField);
        add(new JLabel("Marca:"));
        add(marcaComboBox);
        add(new JLabel("Cilindraje:"));
        add(cilindrajeComboBox);
        add(new JLabel("Color:"));
        add(colorComboBox);
        add(new JLabel("Precio:"));
        add(precioField);
        add(agregarButton);
        add(new JScrollPane(textArea));

        // Predefinidos
        agregarMotocicletasPredefinidas();
    }

    private void agregarMotocicletasPredefinidas() {
        // Código de ejemplo para agregar motocicletas predefinidas
        listaMotocicletas.add(new Motocicleta(1001, "HONDA", 300, "Rojo", 2000));
        listaMotocicletas.add(new Motocicleta(1002, "BMW", 500, "Azul", 2500));
        listaMotocicletas.add(new Motocicleta(1003, "VESPA", 800, "Verde", 3000));
        listaMotocicletas.add(new Motocicleta(1004, "ROYAL ENFIELD", 1000, "Negro", 4000));
        mostrarMotocicletas();
    }

    private void mostrarMotocicletas() {
        StringBuilder sb = new StringBuilder();
        for (Motocicleta m : listaMotocicletas) {
            sb.append(m.toString()).append("\n");
        }
        textArea.setText(sb.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int codigo = Integer.parseInt(codigoField.getText());
            String marca = (String) marcaComboBox.getSelectedItem();
            int cilindraje = (Integer) cilindrajeComboBox.getSelectedItem();
            String color = (String) colorComboBox.getSelectedItem();
            double precio = Double.parseDouble(precioField.getText());

            if (precio > 1500 && precio < 30000) {
                Motocicleta nuevaMotocicleta = new Motocicleta(codigo, marca, cilindraje, color, precio);
                int index = buscarMotocicleta(codigo);
                if (index == -1) {
                    listaMotocicletas.add(nuevaMotocicleta);
                } else {
                    listaMotocicletas.set(index, nuevaMotocicleta);
                }
                mostrarMotocicletas();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "El precio debe estar entre 1500 y 30000.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Entrada no válida.");
        }
    }

    private int buscarMotocicleta(int codigo) {
        for (int i = 0; i < listaMotocicletas.size(); i++) {
            if (listaMotocicletas.get(i).codigo == codigo) {
                return i;
            }
        }
        return -1;
    }

    private void limpiarCampos() {
        codigoField.setText("");
        precioField.setText("");
        marcaComboBox.setSelectedIndex(0);
        cilindrajeComboBox.setSelectedIndex(0);
        colorComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ventana ventana = new Ventana();
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setVisible(true);
        });
    }
}


    public static void main(String[] args) {
        new Ventana();
    }
}
