/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ 
 * Universidad de los Andes (Bogota - Colombia)
 * Departamento de Ingenieria de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_empleado 
 * Autor: Mario Sanchez - 14/06/2005 
 * Autor: Mario Sanchez - 14/06/2005
 * Autor: Pablo Barvo - 22/08/2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.sistemapacientes.mundo;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Esta clase sirve para representar una fecha y hacer algunas operaciones basicas
 */
public class Fecha
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Dia del mes
     */
    private int dia;

    /**
     * Mes
     */
    private int mes;

    /**
     * Año
     */
    private int anio;

    //-----------------------------------------------------------------
    // Metodos
    //-----------------------------------------------------------------

    /**
     * Inicializa una fecha con los parametros proporcionados <br>
     * <b>post: </b> El objeto fecha tiene sus datos basicos asignados con los parametros proporcionados
     * @param d Dia. d > 0 y d <= 31 y d es un valor valido segun el mes
     * @param m Mes. m > 0 y m <= 12
     * @param a Año.
     */
    public void inicializar( int d, int m, int a )
    {
        dia = d;
        mes = m;
        anio = a;
    }

    /**
     * Construye una nueva fecha inicializada en el dia de hoy. <br>
     * <b>post: </b> El objeto fecha tiene sus datos basicos asignados con los datos del dia de hoy
     */
    public void inicializarHoy( )
    {
        // Usamos un calendario Gregoriano inicializado en el dia de hoy
        GregorianCalendar gc = new GregorianCalendar( );

        // Sacamos los valores de dia, mes y año del calendario
        dia = gc.get( Calendar.DAY_OF_MONTH );
        mes = gc.get( Calendar.MONTH ) + 1;
        anio = gc.get( Calendar.YEAR );
    }

    /**
     * Retorna el dia de esta fecha
     * @return dia
     */
    public int darDia( )
    {
        return dia;
    }

    /**
     * Retorna el mes de esta fecha
     * @return mes
     */
    public int darMes( )
    {
        return mes;
    }

    /**
     * Retorna el año de esta fecha
     * @return año
     */
    public int darAnio( )
    {
        return anio;
    }

    /**
     * Este metodo sirve para dar la diferencia en meses que hay entre dos fechas.
     * @param fecha La fecha contra la que se esta comparando. fecha != null
     * @return Retorna el numero de meses
     */
    public int darDiferenciaEnMeses( Fecha fecha )
    {
        int diferencia = 0;

        int otroAnho = fecha.darAnio( );
        int otroMes = fecha.darMes( );
        int otroDia = fecha.darDia( );

        // Calcula la diferencia en meses
        diferencia = 12 * ( otroAnho - anio ) + ( otroMes - mes );

        //Si el dia no es mayor, resta un mes
        if( otroDia < dia )
            diferencia--;

        return diferencia;
    }

    /**
     * Retorna una cadena que representa la fecha
     * @return La cadena sigue el formato dia-mes-año
     */
    public String toString( )
    {
        return "" + dia + "-" + mes + "-" + anio;
    }
}
