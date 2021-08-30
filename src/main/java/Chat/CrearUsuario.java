/*ITCR
Área Académica Ingeniería en Computadores
II Semestre 2021/Algoritmos y Estructura de Datos I
Tarea Extraclase 1
Estudiante: Luis Pablo Céspedes Sequeira.
Carné: 201156162
IDE: NetBeans 12.2*/
package Chat;
/**
 * Esta clase se encarga de asignar los diferents valores a cada usuario que se encargan de la logica de la coneccion.
 * @author Luis Pablo Céspedes Sequeira.
 * @see CrearUsuario
 */
public class CrearUsuario {
    //Atributos
    private String nombre;
    private String ip;
    //Metodo constructor que asigna el nombre y la ip al mismo tiempo
    public CrearUsuario(String nombre, String ip) {
        this.nombre = nombre;
        this.ip = ip;
    }
    //Metodo Constructor que recibe solo un parametro y le da el valor de nombre
    public CrearUsuario(String nombre) {
        this.nombre = nombre;
    }
    //GETTER AND SETTERS PARA EL NOMBRE Y LA IP
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIp() {
        /*Cuando al usuario se le pide la ip y digita "0" entonces se asume que va a ejecutar todo desde un 
        mismo equipo o maquina entonces automaticamente se le da la ip "127.0.0.1" de no ser así se retorna el valor
        de la ip ingresada*/
        if (ip=="0"){
            return "127.0.0.1";
        }
        
        else{
            return ip;
        }
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
}
