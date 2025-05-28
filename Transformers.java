import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Transformer {
    String nombre;
    String facción;
    String tipoPoder;
    String poder;

    // Constructor
    public Transformer(String nombre, String facción, String tipoPoder, String poder) {
        this.nombre = nombre;
        this.facción = facción;
        this.tipoPoder = tipoPoder;
        this.poder = poder;
    }

    // Método para mostrar información del Transformer
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Facción: " + facción + ", Tipo de Poder: " + tipoPoder + ", Poder: " + poder;
    }
}

public class TransformersApp {
    private ArrayList<Transformer> transformersList = new ArrayList<>();
    private JTextArea textArea;
    private JTextField nameField;
    private JComboBox<String> factionComboBox;
    private JComboBox<String> powerTypeComboBox;
    private JTextField powerField;

    // Constructor de la aplicación
    public TransformersApp() {
        // Configuración de la ventana
        JFrame frame = new JFrame("Transformers App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());

        // Elementos de la interfaz
        nameField = new JTextField(10);
        factionComboBox = new JComboBox<>(new String[]{"Autobot", "Decepticon"});
        powerTypeComboBox = new JComboBox<>(new String[]{"Aéreo", "Acuático", "Terrestre"});
        powerField = new JTextField(15);
        JButton addButton = new JButton("Agregar");
        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        // Añadir componentes a la ventana
        frame.add(new JLabel("Nombre:"));
        frame.add(nameField);
        frame.add(new JLabel("Facción:"));
        frame.add(factionComboBox);
        frame.add(new JLabel("Tipo de Poder:"));
        frame.add(powerTypeComboBox);
        frame.add(new JLabel("Poder:"));
        frame.add(powerField);
        frame.add(addButton);
        frame.add(new JScrollPane(textArea));

        // Acción del botón
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarTransformer();
            }
        });

        frame.setVisible(true);
    }

    // Método para agregar un Transformer
    private void agregarTransformer() {
        String nombre = nameField.getText();
        String facción = (String) factionComboBox.getSelectedItem();
        String tipoPoder = (String) powerTypeComboBox.getSelectedItem();
        String poder = powerField.getText();

        // Verificar existencia de Transformer
        for (Transformer t : transformersList) {
            if (t.nombre.equalsIgnoreCase(nombre)) {
                // Actualizar datos si el Transformer ya existe
                t.facción = facción;
                t.tipoPoder = tipoPoder;
                t.poder = poder;
                actualizarTexto();
                return;
            }
        }

        // Agregar nuevo Transformer
        transformersList.add(new Transformer(nombre, facción, tipoPoder, poder));
        actualizarTexto();
    }

    // Método para mostrar la lista de Transformers en el TextArea
    private void actualizarTexto() {
        textArea.setText("");
        for (Transformer t : transformersList) {
            textArea.append(t + "\n");
        }
    }

    public static void main(String[] args) {
        new TransformersApp();
    }
}
