import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


class Carros {
    int codigo;
    String marca;
    int cilindraje;
    double precio;

    public Carros(int codigo, String marca, int cilindraje, double precio) {
        this.codigo = codigo;
        this.marca = marca;
        this.cilindraje = cilindraje;
        this.precio = precio;
    }

    @Override
    public String toString(){
        return "Código: " + codigo + ", Marca: " + marca + ", Cilindraje: " + cilindraje + ", Precio: " + precio;
    }
}

public class Ventana extends JFrame implements ActionListener{
    private ArrayList<Carros> listaCarros= new ArrayList<>();
    private JTabbedPane tabbedPane1;
    private JTextField txtCodigo;
    private JComboBox cboMarca;
    private JComboBox cboCilindraje;
    private JTextField txtPrecio;
    private JTextArea txtMostrarIngresar;
    private JButton btnIngresar;
    private JComboBox cboBuscarMarca;
    private JTextField txtBuscarPrecio;
    private JTextArea txtMostrarBuscar;
    private JButton btnBuscar;
    private JComboBox cboListarCarros;
    private JTextArea txtMostrarListar;
    private JButton btnListar;
    private JPanel main;

    public Ventana() {
        setTitle("REVISAR CARROS");
        setSize(600, 400);
        setLayout(new FlowLayout());

        txtCodigo = new JTextField(3);
        cboBuscarMarca = new JComboBox<>(new String[]{"KIA", "BMW", "TOYOTA", "JAC", "MERCEDES"});
        cboCilindraje = new JComboBox<>(new Integer[]{1300, 1600, 2000, 2400, 2700});
        txtPrecio = new JTextField(6);

        JButton btnIngresar = new JButton("Agregar Carro");
        btnIngresar.addActionListener(this);

        txtMostrarIngresar = new JTextArea(10, 50);
        txtMostrarIngresar.setEditable(false);

        add(new JLabel("Código:"));
        add(txtCodigo);
        add(new JLabel("Marca:"));
        add(cboMarca);
        add(new JLabel("Cilindraje:"));
        add(cboCilindraje);
        add(new JLabel("Precio:"));
        add(txtPrecio);
        add(btnIngresar);
        add(new JScrollPane(txtMostrarIngresar));

        // Predefinidos
        private void agregarCarrosPredefinidos(){
            listaCarros.add(new Carros(001,"KIA", 1600, 5000));
            listaCarros.add(new Carros(002,"KIA", 1600, 5000));
            listaCarros.add(new Carros(003,"KIA", 1600, 5000));
            listaCarros.add(new Carros(004,"KIA", 1600, 5000));
            mostrarCarros();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int codigo = Integer.parseInt(txtCodigo.getText());
            String marca = (String) cboMarca.getSelectedItem();
            int cilindraje = (Integer) cboCilindraje.getSelectedItem();
            double precio = Double.parseDouble(txtPrecio.getText());

            if (precio > 5000 && precio < 100000) {
                Carros nuevoCarro = new Carros(codigo, marca, cilindraje, precio);
                int index = buscarCarro(codigo);
                if (index == -1) {
                    listaCarros.add(nuevoCarro);
                } else {
                    listaCarros.set(index, nuevoCarro);
                }
                mostrarCarros();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "El precio debe estar entre 5000 y 1000000.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Entrada no válida.");
        }
    }

    private void mostrarCarros(){
        StringBuilder sb = new StringBuilder();
        for (Carros m:listaCarros){
            sb.append(m.toString()).append("\n");
        }
        txtMostrarIngresar.setText(sb.toString());
    }

    private int buscarCarro(int codigo) {
        for (int i = 0; i < listaCarros.size(); i++) {
            if (listaCarros.get(i).codigo == codigo) {
                return i;
            }
        }
        return -1;
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtPrecio.setText("");
        cboMarca.setSelectedIndex(0);
        cboCilindraje.setSelectedIndex(0);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
