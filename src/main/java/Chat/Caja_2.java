/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Caja_2 {

    //Variables estaticas para poder hacer la conexion cliente-servidor
    static Socket puerto;
    static Socket puerto2;
    static Socket puerto3;
    static DataInputStream datosentrada;
    static DataOutputStream datossalida;
    static DataInputStream datosentrada2;
    static DataOutputStream datossalida2;
    static DataInputStream datosentrada3;
    static DataOutputStream datossalida3;
    //Creacion de variables y objetos para llamar a clase usuario y para indicar cuales el tipo de usuario inicializado
    //si es cliente o servidor
    String Nombre = "Caja 2";//Valor que brinda el valor a la clase Usuario del nombre
    static String ip = "0";
//Variable estatica que permite pasar como parametro la ip a la clase Usuario
    CrearUsuario Nombre1 = new CrearUsuario(Nombre);//Creo un objeto de la clase AsignarIpNombre y le paso el nombre
    CrearUsuario direccion = new CrearUsuario(Nombre, ip);//Creo un objeto de la clase AsignarIpNombre y le paso el nombre junto con la Ip
    //UsuarioCliente tipo = new UsuarioCliente();//Objeto de la clase TipodeUsuario que indica si el inicializado es cliente o servidor
    //Variable del tipo string que almacena el chat
    static String historial = "";
    public JFrame f = new JFrame("Caja_2");
    final JLabel label = new JLabel();
    final JLabel lValor = new JLabel();
    final JLabel lPeso = new JLabel();
    final JLabel lImpuesto = new JLabel();
    public int valorProducto;
    public int pesoProducto;
    public int impuestoProducto;
    public String articulos[] = {"Audifonos", "Celular", "Impresora", "Monitor", "Mouse", "Parlante", "Teclado"};
    public JComboBox cb = new JComboBox(articulos);
    JButton botonenviar = new JButton("Enviar");
    JButton botonSalir = new JButton("Salir");
    static boolean salir = true;

    public void GUI() {
        ip = direccion.getIp();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(400, 100);
        cb.setBounds(50, 50, 90, 20);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
        botonenviar.setBounds(50, 100, 75, 20);
        botonSalir.setBounds(150, 100, 75, 20);
        f.add(cb);
        f.add(label);
        f.add(botonenviar);
        f.add(botonSalir);
        botonenviar.setText("Enviar");
        botonenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonenviarActionPerformed(evt);
            }
        });

    }

    private void botonenviarActionPerformed(java.awt.event.ActionEvent evt) {
        //ENVIO DEL MENSAJE AL SERVIDOR
        try {
            //String mensajesalida = "" + cb.getSelectedIndex();
            asignar_valores(cb.getSelectedIndex());
            datossalida.writeUTF("" + valorProducto);
            datossalida2.writeUTF("" + pesoProducto);
            datossalida3.writeUTF("" + impuestoProducto);
        } catch (Exception e) {

        }

    }

    public void cambio(String str) {
        label.setText(str);
    }

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

    public String selec() {
        return "" + cb.getItemAt(cb.getSelectedIndex());
    }

    public int posicion() {
        return cb.getSelectedIndex();
    }

    public static void main(String[] args) {
        Caja_2 caja = new Caja_2();
        caja.GUI();

        /**
         * while (true) { String data = "" + caja.posicion(); caja.cambio(data);
         * }
         */
        try {

            puerto = new Socket(ip, 1201);//Se recibe el valor de la ip y se inicializa el puerto
            puerto2 = new Socket(ip, 1203);//Se recibe el valor de la ip y se inicializa el puerto
            puerto3 = new Socket(ip, 1205);
//Puerto por donde entran y salen los datos
            datosentrada = new DataInputStream(puerto.getInputStream());
            datossalida = new DataOutputStream(puerto.getOutputStream());
            datosentrada2 = new DataInputStream(puerto2.getInputStream());
            datossalida2 = new DataOutputStream(puerto2.getOutputStream());
            datosentrada3 = new DataInputStream(puerto3.getInputStream());
            datossalida3 = new DataOutputStream(puerto3.getOutputStream());
            String mensaje = "";//Declaracion de la variable en la que se va a almacenar el mensaje
            while (salir) {
                int a = Integer.parseInt(datosentrada.readUTF());
                int b = Integer.parseInt(datosentrada2.readUTF());
                int c = Integer.parseInt(datosentrada3.readUTF());
                int monto = (int) (a + c + (b * 0.15));
                // mensaje = datosentrada.readUTF()+" "+datosentrada2.readUTF()+" "+datosentrada3.readUTF();//Lee y decodifica el mensaje que le ha sido enviado
                mensaje = "" + monto;
                caja.cambio(mensaje);
            }

        } catch (Exception e) {

        }
    }

}
