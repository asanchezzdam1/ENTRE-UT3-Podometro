/**
 * La clase modela un sencillo podómetro que registra información
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * @author    - pon aquí tu nombre - 
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
     * Inicializa el podómetro con la marca indicada por el parámetro.
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
        //Devuelve la marca
        return marca;

    }

    /**
     * Simula la configuración del podómetro.
     * Recibe como parámetros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna además el valor adecuado al atributo longitudZancada
     * 
     * (leer enunciado)
     *  
     */
    public void configurar(double queAltura, char queSexo) {
        //Establece la altura
        altura = queAltura;
        //Establece el sexo
        sexo = queSexo;
        if(sexo == 'M' || sexo == MUJER){
            longitudZancada = Math.floor(altura * ZANCADA_MUJER);
        }
        else if (sexo == 'H' || sexo == HOMBRE){
            longitudZancada = Math.ceil(altura * ZANCADA_HOMBRE);
        }

    }

    /**
     *  Recibe cuatro parámetros que supondremos correctos:
     *    pasos - el nº de pasos caminados
     *    dia - nº de día de la semana en que se ha hecho la caminata 
     *              (1 - Lunes, 2 - Martes - .... - 6 - Sábado, 7 - Domingo)
     *    horaInicio – hora de inicio de la caminata
     *    horaFin – hora de fin de la caminata
     *    
     *    A partir de estos parámetros el método debe realizar ciertos cálculos
     *    y  actualizará el podómetro adecuadamente  
     *   
     *   (leer enunciado del ejercicio)
     */
    public void registrarCaminata(int pasos, int dia, int horaInicio,int horaFin) {
        //Hacer comprobaciones de que tanto el dia como las horas son corretas
        if (dia <= 0 || dia >= 8){
            System.out.println("Dia incorrecto ponga un numero de 1 al 7");
        }
        else if(horaInicio <= 0000 || horaInicio >= 2359){
            System.out.println("Hora de incio incorrecta");
        }
        else if (horaFin <= 0000 || horaFin >= 2359){
            System.out.println("Hora de Fin Incorrecta");
        }
        // Teniendo en cuenta que la noche acaba sobre las 6 de la madrugada
        if (horaInicio >= 2100 || horaInicio <= 0600 ){
            caminatasNoche ++;
        }
        // Para saber que dia estamos
        switch (dia) {
            // Caso Sabado
            case 6:{
                    totalDistanciaFinSemana += (pasos * longitudZancada);
                    totalPasosSabado += pasos;
                    break;
                } 
            // Caso Domingo
            case 7:{
                    totalDistanciaFinSemana += (pasos * longitudZancada);
                    totalPasosDomingo += pasos;
                    break;
                } 
            // Caso Entre Semana
            default : {
                    totalDistanciaSemana += (pasos * longitudZancada);
                    totalPasosLaborables += pasos;
                    break;
                }
        }
        // Se calcula el tiempo de la caminata
        tiempo += horaFin - horaInicio;
    }

    /**
     * Muestra en pantalla la configuración del podómetro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     *  
     */
    public void printConfiguracion() {
        System.out.println("Configuracion del Podómetro");
        System.out.println("***************************");
        System.out.println("Altura: " + altura / 100 + " metros");
        System.out.println("Sexo: " + sexo);
        System.out.println("Longitud Zancada: " + longitudZancada / 100 + " metros" );

    }

    /**
     * Muestra en pantalla información acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void printEstadísticas() {
        System.out.println("Estadisticas");
        System.out.println("***************************");

        System.out.println("Distancia recorrida toda la semana: " + totalDistanciaSemana / 1000 + " Km");
        System.out.println("Distancia recorrida fin de semana: " + totalDistanciaFinSemana / 1000 + " Km");

        System.out.println("Numero pasos dias laborables: " + totalPasosLaborables);
        System.out.println("Numero pasos SÁBADO: " + totalPasosSabado);
        System.out.println("Numero pasos DOMINGO: " + totalPasosDomingo);

        System.out.println("Numero caminatas realizadas a partir de las 21h: " + caminatasNoche);

        System.out.println("Tiempo total caminado en la semana: " + tiempo / 60 + " horas y " + (tiempo % 60 ) + " minutos.");
        if(totalPasosLaborables > totalPasosSabado || totalPasosLaborables > totalPasosDomingo){
            System.out.println("Día/s con más pasos caminados: LABORABLES" );
        }
        else if(totalPasosSabado > totalPasosLaborables || totalPasosSabado > totalPasosDomingo){
            System.out.println("Día/s con más pasos caminados: SABADO" );
        }
        else if(totalPasosDomingo > totalPasosLaborables || totalPasosDomingo > totalPasosSabado){
            System.out.println("Día/s con más pasos caminados: DOMINGO" );
        }
        else{
            System.out.println("Ningun dia");
        }
    }

    /**
     *  Calcula y devuelve un String que representa el nombre del día
     *  en el que se ha caminado más pasos - "SÁBADO"   "DOMINGO" o  "LABORABLES"
     */

    public String diaMayorNumeroPasos() {
        String strDia = "";
        if(totalPasosLaborables > totalPasosSabado && totalPasosLaborables > totalPasosDomingo){
            strDia = "LABORABLES";
        }
        else if(totalPasosSabado > totalPasosLaborables && totalPasosSabado > totalPasosDomingo){
            strDia = "SABADO";
        }
        else if(totalPasosDomingo > totalPasosLaborables && totalPasosDomingo > totalPasosSabado){
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
        else {
            strDia = "LABORABLES, SABADO Y DOMINGO";
        }

        return strDia;
    }

    /**
     * Restablecer los valores iniciales del podómetro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no varía
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
