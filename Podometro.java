/**
 * La clase modela un sencillo pod�metro que registra informaci�n
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author    - pon aqu� tu nombre - 
 */
public class Podometro {
    private final  char HOMBRE = 'H';
    private final  char MUJER = 'M';
    private final  int SABADO = '6';
    private final  int DOMINGO = '7';
    private final  double ZANCADA_HOMBRE = 0.45;
    private final  double ZANCADA_MUJER = 0.41;
    private String marca;
    private double altura;
    private char sexo;
    private double longitudZancada;
    private int totalPasosLaborables;
    private int totalPasosSabado;
    private int totalPasosDomingo;
    private double totalDistanciaSemana;
    private double totalDistanciaFinSemana;
    private int tiempo;
    private int caminatasNoche;

    /**
     * Inicializa el pod�metro con la marca indicada por el par�metro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public Podometro(String queMarca) {
        marca = queMarca;
        altura = 0;
        sexo = 'M';
        longitudZancada = 0;
        totalPasosLaborables = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0;
        totalDistanciaFinSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;
    }

    /**
     * accesor para la marca
     *  
     */
    public String getMarca() {

        return marca;

    }

    /**
     * Simula la configuraci�n del pod�metro.
     * Recibe como par�metros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna adem�s el valor adecuado al atributo longitudZancada
     * 
     * (leer enunciado)
     *  
     */
    public void configurar(double queAltura, char queSexo) {
        altura = queAltura;
        sexo = queSexo;
        if(sexo == 'M'){
            longitudZancada = 0.41;
        }
        else{
            longitudZancada = 0.45;
        }
    }

    /**
     *  Recibe cuatro par�metros que supondremos correctos:
     *    pasos - el n� de pasos caminados
     *    dia - n� de d�a de la semana en que se ha hecho la caminata 
     *              (1 - Lunes, 2 - Martes - .... - 6 - S�bado, 7 - Domingo)
     *    horaInicio � hora de inicio de la caminata
     *    horaFin � hora de fin de la caminata
     *    
     *    A partir de estos par�metros el m�todo debe realizar ciertos c�lculos
     *    y  actualizar� el pod�metro adecuadamente  
     *   
     *   (leer enunciado del ejercicio)
     */
    public void registrarCaminata(int pasos, int dia, int horaInicio,
    int horaFin) {

    }

    /**
     * Muestra en pantalla la configuraci�n del pod�metro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     *  
     */
    public void printConfiguracion() {
        System.out.println("Configuracion del Pod�metro");
        System.out.println("***************************");
        System.out.println("Altura: " + altura + " metros");
        System.out.println("Sexo: " + sexo);
        System.out.println("Longitud Zancada: " + longitudZancada + " metros" );

    }

    /**
     * Muestra en pantalla informaci�n acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstad�sticas() {
        System.out.println("Estadisticas");
        System.out.println("***************************");

        System.out.println("Distancia recorrida toda la semana: " + totalDistanciaSemana + " Km");
        System.out.println("Distancia recorrida fin de semana: " + totalDistanciaFinSemana + " Km");

        System.out.println("Numero pasos dias laborables: " + totalPasosLaborables);
        System.out.println("Numero pasos S�BADO: " + totalPasosSabado);
        System.out.println("Numero pasos DOMINGO: " + totalPasosDomingo);

        System.out.println("Numero caminatas realizadas a partir de las 21h" + caminatasNoche);

        System.out.println("Tiempo total caminado en la semana" + tiempo);
        if(totalPasosLaborables > totalPasosSabado || totalPasosLaborables > totalPasosDomingo){
            System.out.println("D�a/s con m�s pasos caminados: LABORABLES" );
        }
        else if(totalPasosSabado > totalPasosLaborables || totalPasosSabado > totalPasosDomingo){
            System.out.println("D�a/s con m�s pasos caminados: SABADO" );
        }
        else if(totalPasosDomingo > totalPasosLaborables || totalPasosDomingo > totalPasosSabado){
            System.out.println("D�a/s con m�s pasos caminados: DOMINGO" );
        }
    }

    /**
     *  Calcula y devuelve un String que representa el nombre del d�a
     *  en el que se ha caminado m�s pasos - "S�BADO"   "DOMINGO" o  "LABORABLES"
     */
    
    public String diaMayorNumeroPasos() {
        String strDia = "";
        if(totalPasosLaborables > totalPasosSabado || totalPasosLaborables > totalPasosDomingo){
            strDia = "LABORABLES";
        }
        else if(totalPasosSabado > totalPasosLaborables || totalPasosSabado > totalPasosDomingo){
            strDia = "SABADO";
        }
        else if(totalPasosDomingo > totalPasosLaborables || totalPasosDomingo > totalPasosSabado){
            strDia = "DOMINGO";
        }
        else if(totalPasosLaborables >= totalPasosSabado && totalPasosSabado >= totalPasosLaborables){
            strDia = "LABORABLES Y SABADO";
        }
        else if(totalPasosLaborables >= totalPasosDomingo && totalPasosDomingo >= totalPasosLaborables){
            strDia = "LABORABLES Y DOMINGO";
        }
        else if(totalPasosSabado >= totalPasosDomingo && totalPasosDomingo >= totalPasosSabado){
            strDia = "SABADO Y DOMINGO";
        }
        // falta por acabar
        else if(totalPasosLaborables >= totalPasosSabado && totalPasosSabado >= totalPasosLaborables && totalPasosLaborables >= totalPasosDomingo && totalPasosDomingo >= totalPasosLaborables && totalPasosSabado >= totalPasosDomingo && totalPasosDomingo >= totalPasosSabado){
            strDia = "LABORABLES, SABADO Y DOMINGO";
        }
        
        return strDia;
    }

    /**
     * Restablecer los valores iniciales del pod�metro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no var�a
     *  
     */    
    public void reset() {
        altura = 0;
        sexo = 'M';
        longitudZancada = 0;
        totalPasosLaborables = 0;
        totalPasosSabado = 0;
        totalPasosDomingo = 0;
        totalDistanciaSemana = 0;
        totalDistanciaFinSemana = 0;
        tiempo = 0;
        caminatasNoche = 0;
    }
}
