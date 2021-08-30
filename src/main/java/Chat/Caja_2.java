/*ITCR
Área Académica Ingeniería en Computadores
II Semestre 2021/Algoritmos y Estructura de Datos I
Tarea Extraclase 1
Estudiante: Luis Pablo Céspedes Sequeira.
Carné: 201156162
IDE: NetBeans 12.2*/
package Chat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
/**
 * Esta clase contiene los atributos y metodos del Usuario que seria el usuario servidor
 * @author Luis Pablo Céspedes Sequeira.
 * @see Caja_2
 */
public class Caja_2 {
    static Socket puerto1;
    static Socket puerto;
    static Socket puerto2;
    static Socket puerto3;
    static DataInputStream datosentrada;
    static DataOutputStream datossalida;
    static DataInputStream datosentrada1;
    static DataOutputStream datossalida1;
    static DataInputStream datosentrada2;
    static DataOutputStream datossalida2;
    static DataInputStream datosentrada3;
    static DataOutputStream datossalida3;
    String Nombre = "Caja 2";//Valor que brinda el valor a la clase Usuario del nombre
    static String ip = "0";
    CrearUsuario Nombre1 = new CrearUsuario("Caja 2");//Creo un objeto de la clase AsignarIpNombre y le paso el nombre
    CrearUsuario direccion = new CrearUsuario("Caja 2", ip);//Creo un objeto de la clase AsignarIpNombre y le paso el nombre junto con la Ip
    //UsuarioCliente tipo = new UsuarioCliente();//Objeto de la clase TipodeUsuario que indica si el inicializado es cliente o servidor
    //Variable del tipo string que almacena el chat
    static String historial = "";
    public JFrame f = new JFrame("Caja Dos");
    static JLabel lArtículo = new JLabel();
    final JLabel lValor = new JLabel();
    final JLabel lImpuesto = new JLabel();
    final JLabel lPeso = new JLabel();
    final JLabel lMonto = new JLabel();
    public int valorProducto;
    public int pesoProducto;
    public int impuestoProducto;
    public String articulos[] = {"Audifonos", "Celular", "Impresora", "Monitor", "Mouse", "Parlante", "Teclado"};
    public JComboBox cb = new JComboBox(articulos);
    JButton b = new JButton("Enviar");
    Panel panel = new Panel("Caja Uno");
     /**
     * Metodo constructor por defecto de la Interfaz
     */
    public void GUI() {
        lArtículo.setHorizontalAlignment(JLabel.CENTER);
        lArtículo.setSize(400, 100);
        lArtículo.setLocation(40, 145);
        lValor.setHorizontalAlignment(JLabel.CENTER);
        lValor.setSize(400, 100);
        lValor.setLocation(40, 175);
        lImpuesto.setHorizontalAlignment(JLabel.CENTER);
        lImpuesto.setSize(400, 100);
        lImpuesto.setLocation(40, 205);
        lPeso.setHorizontalAlignment(JLabel.CENTER);
        lPeso.setSize(400, 100);
        lPeso.setLocation(40, 235);
        lMonto.setHorizontalAlignment(JLabel.CENTER);
        lMonto.setSize(400, 100);
        lMonto.setLocation(40, 285);
        cb.setBounds(30, 110, 90, 20);
        f.setSize(450, 450);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.setBounds(140, 110, 75, 20);
        f.add(cb); 
        f.add(lArtículo);
        f.add(lValor);
        f.add(lImpuesto);
        f.add(lPeso);
        f.add(lMonto);
        f.add(b);
        f.add(panel);
        b.addActionListener(new java.awt.event.ActionListener() {
            /**
             * Metodo que asigna el Metodo al bonton enviar encargado de enviar
             * los datos al otro usuario
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                benviarActionPerformed(evt);
            }
        });

    }

    /**
     * Metodo encargado de la logica del envio de datos al otro usuario
     */
    private void benviarActionPerformed(java.awt.event.ActionEvent evt) {
        //ENVIO DEL MENSAJE AL SERVIDOR
        try {
            String articulo = (String) cb.getItemAt(cb.getSelectedIndex());
            asignar_valores(cb.getSelectedIndex());
            datossalida.writeUTF( articulo);
            datossalida1.writeUTF("" + valorProducto);
            datossalida2.writeUTF("" + pesoProducto);
            datossalida3.writeUTF("" + impuestoProducto);
        } catch (Exception e) {

        }

    }
     /**
     * Metodo parametrizado, encargado de tomar los datos ya recibidos antes o calculados y almacenados en otras variables 
     * del otro usuario, y hacerle los cambios necesarios para asignarlos a las etiquetas que los desplegan
     * @param art Nombre del artículo
     * @param mon El monto total del articulo
     * @param val EL valor sin impuestos del artículo
     * @param imp Valor del Impuesto del articulo
     * @param pes Peso en gramos del articulo
     */
    public void cambio(String art, String mon, int val, int imp, int pes) {
        lArtículo.setText(art);
        lValor.setText("₡"+val);
        lImpuesto.setText("₡"+imp);
        lPeso.setText("" + pes + "   gramos");
        lMonto.setText("₡" + mon);
    }

    /**
     * Metodo parametrizado asigna los datos que van a ser enviados segun el
     * articulo
     *
     * @param cod Numero que identifica el articulo para asi enviar los datos
     * correspondientes a este.
     */
    public void asignar_valores(int cod) {
        if (cod == 0) {
            valorProducto = 5000;
            pesoProducto = 27;
            impuestoProducto = (int) (valorProducto * 0.13);
        }
        if (cod == 1) {
            valorProducto = 113000;
            pesoProducto = 269;
            impuestoProducto = (int) (valorProducto * 0.13);
        }
        if (cod == 2) {
            valorProducto = 81000;
            pesoProducto = 3000;
            impuestoProducto = (int) (valorProducto * 0.13);
        }
        if (cod == 3) {
            valorProducto = 137000;
            pesoProducto = 7500;
            impuestoProducto = (int) (valorProducto * 0.13);
        }
        if (cod == 4) {
            valorProducto = 9000;
            pesoProducto = 137;
            impuestoProducto = (int) (valorProducto * 0.13);
        }
        if (cod == 5) {
            valorProducto = 23000;
            pesoProducto = 2750;
            impuestoProducto = (int) (valorProducto * 0.13);
        }
        if (cod == 6) {
            valorProducto = 41000;
            pesoProducto = 790;
            impuestoProducto = (int) (valorProducto * 0.13);
        }
    }

    /**
     * Metodo Main de la clase Caja_2 que es el segundo usuario.
     * Crea la clase, crea los objetos necesarios de la interfaz y lo de los
     * diferentes puertos por donde se van enviar los datos, se uso un puerto
     * por dato para evitar problemas de ejecución
     */
    public static void main(String[] args) {
        Caja_2 caja = new Caja_2();
        caja.GUI();
        try {
            puerto = new Socket(ip, 1199);//Se recibe el valor de la ip y se inicializa el puerto
            puerto1 = new Socket(ip, 1201);//Se recibe el valor de la ip y se inicializa el puerto
            puerto2 = new Socket(ip, 1203);//Se recibe el valor de la ip y se inicializa el puerto
            puerto3 = new Socket(ip, 1205);
//Puerto por donde entran y salen los datos
            datosentrada = new DataInputStream(puerto.getInputStream());
            datossalida = new DataOutputStream(puerto.getOutputStream());
            datosentrada1 = new DataInputStream(puerto1.getInputStream());
            datossalida1 = new DataOutputStream(puerto1.getOutputStream());
            datosentrada2 = new DataInputStream(puerto2.getInputStream());
            datossalida2 = new DataOutputStream(puerto2.getOutputStream());
            datosentrada3 = new DataInputStream(puerto3.getInputStream());
            datossalida3 = new DataOutputStream(puerto3.getOutputStream());
            while (true) {
                int a = Integer.parseInt(datosentrada1.readUTF());
                int b = Integer.parseInt(datosentrada2.readUTF());
                int c = Integer.parseInt(datosentrada3.readUTF());
                int monto = (int) (a + c + (b * 0.15));
                caja.cambio(datosentrada.readUTF(), String.valueOf(monto), a, c,b);
            }

        } catch (Exception e) {

        }
    }

}
