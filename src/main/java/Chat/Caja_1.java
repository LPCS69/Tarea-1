/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;


import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Usuario
 */
public class Caja_1 {
    static ServerSocket Server_puerto;
    static Socket puerto;
    static ServerSocket Server_puerto2;
    static Socket puerto2;
    static ServerSocket Server_puerto3;
    static Socket puerto3;
    static DataInputStream datosentrada;
    static DataOutputStream datossalida;
    static DataInputStream datosentrada2;
    static DataOutputStream datossalida2;
    static DataInputStream datosentrada3;
    static DataOutputStream datossalida3;
    CrearUsuario Nombre1 = new CrearUsuario("Caja_Servidor");
    public JFrame f = new JFrame("Caja_Servidor");
    final JLabel label = new JLabel();
    final JLabel lValor = new JLabel();
    final JLabel lPeso = new JLabel();
    final JLabel lImpuesto = new JLabel();
    public int valorProducto;
    public int pesoProducto;
    public int impuestoProducto;
    public String articulos[] = {"Audifonos", "Celular", "Impresora", "Monitor", "Mouse", "Parlante", "Teclado"};
    public JComboBox cb = new JComboBox(articulos);
    JButton b = new JButton("Enviar");
    JButton botonSalir = new JButton ("Salir");
    static boolean salir = true;
    public void GUI() {
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(400, 100);
        cb.setBounds(50, 50, 90, 20);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
        b.setBounds(50, 100, 75, 20);
        botonSalir.setBounds(150, 100, 75, 20);
        f.add(cb);
        f.add(label);
        f.add(b);
        f.add(botonSalir);
        b.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                benviarActionPerformed(evt);
            }
        });
        botonSalir.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });
   }
 public void bSalirActionPerformed(java.awt.event.ActionEvent evt) {                                            
            salir = false;
    }  
 public void benviarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        //ENVIO DEL MENSAJE AL CLIENTE

        
        try{
           String mensajesalida = ""+cb.getSelectedIndex();
           datossalida.writeUTF(""+mensajesalida);
           datossalida2.writeUTF(""+mensajesalida);
           datossalida3.writeUTF(""+mensajesalida);
        }catch (Exception e){

        }
    }  
    public void cambio(String str){
          label.setText(str);
    }
    public void asignar_valores(int cod){
        if (cod ==0){
        valorProducto= 5000;
        pesoProducto= 27;
        impuestoProducto= (int) (valorProducto*0.13);
        }
        if (cod ==1){
        valorProducto= 113000;
        pesoProducto= 269;
        impuestoProducto= (int) (valorProducto*0.13);
        }
        if (cod ==3){
        valorProducto= 81000;
        pesoProducto= 3000;
        impuestoProducto= (int) (valorProducto*0.13);
        }
        if (cod ==3){
        valorProducto= 81000;
        pesoProducto= 3000;
        impuestoProducto= (int) (valorProducto*0.13);
        }
    }
    public String selec(){
        return ""+cb.getItemAt(cb.getSelectedIndex());
    }  
    public int posicion(){
        return cb.getSelectedIndex();
    }


    public static void main(String[] args) {  
        Caja_1 caja = new Caja_1();
        caja.GUI();
       /** while (true) {
            String data = "" + caja.posicion();
            caja.cambio(data);

        }*/
       
        String mensaje = "";//Declaracion de la variable en la que se va a almacenar el mensaje
        try{
            Server_puerto = new ServerSocket(1201);//el server se inicializa en el puerto 1201
            puerto = Server_puerto.accept();//Se le dice al server que acepte la conexion
            Server_puerto2 = new ServerSocket(1203);
            puerto2 = Server_puerto2.accept();
            Server_puerto3 = new ServerSocket(1205);
            puerto3 = Server_puerto3.accept();
            //Puerto por donde entran y salen los datos
            datosentrada = new DataInputStream(puerto.getInputStream());
            datossalida = new DataOutputStream(puerto.getOutputStream());
            datosentrada2 = new DataInputStream(puerto2.getInputStream());
            datossalida2 = new DataOutputStream(puerto2.getOutputStream());
            datosentrada3 = new DataInputStream(puerto3.getInputStream());
            datossalida3 = new DataOutputStream(puerto3.getOutputStream());
            while(salir){
            mensaje = datosentrada.readUTF()+datosentrada2.readUTF()+datosentrada3.readUTF();                
            caja.cambio(mensaje);
            }    
        }catch (Exception e){
        
        }
    }}
     
