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
    CrearUsuario direccion = new CrearUsuario(Nombre,ip);//Creo un objeto de la clase AsignarIpNombre y le paso el nombre junto con la Ip
    //UsuarioCliente tipo = new UsuarioCliente();//Objeto de la clase TipodeUsuario que indica si el inicializado es cliente o servidor
    //Variable del tipo string que almacena el chat
    static String historial = "";
    public JFrame f = new JFrame("Caja_2");
    final JLabel label = new JLabel();
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
            String mensajesalida = "";//Declaracion de la variable que almacena el mensaje que será enviado
            mensajesalida = ""+cb.getSelectedIndex();//Declaracion de la variable que almacena el mensaje que será enviado
            datossalida.writeUTF(""+ mensajesalida);//se envia el mensaje del cliente al server codificado
            datossalida2.writeUTF(""+ mensajesalida);
            datossalida3.writeUTF(""+ mensajesalida);
        } catch (Exception e) {

        }

    }     
    public void cambio(String str) {
        label.setText(str);
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
        
    /**    while (true) {
            String data = "" + caja.posicion();
            caja.cambio(data);
        }
      */  
     try{
           
            
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
            String mensaje="";//Declaracion de la variable en la que se va a almacenar el mensaje
            while(salir){
                mensaje = datosentrada.readUTF()+datosentrada2.readUTF()+datosentrada3.readUTF();//Lee y decodifica el mensaje que le ha sido enviado
                caja.cambio(mensaje);
            }
        
        }catch (Exception e){
        
        }
    }
    
}
