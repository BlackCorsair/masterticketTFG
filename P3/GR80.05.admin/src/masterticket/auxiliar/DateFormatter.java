package masterticket.auxiliar;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateFormatter {
	
	/*Paso de formato de fecha datetime-local usada en form de jsp a formato de fecha java.sql.Date*/
	public static java.sql.Date DTLocalToDBDate(String fechaDTLocal) {
		System.out.println("LA FECHA EN FORMATRO STRING ES: " + fechaDTLocal);
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
		java.util.Date  date_evento = null;
		Calendar calen_evento = null;
		try {
			date_evento = (Date) dateFormatter.parse(fechaDTLocal);
			System.out.println("La fecha date_evento despues de parsear es: " + date_evento);
			calen_evento = Calendar.getInstance();
			calen_evento.setTime(date_evento);
			calen_evento.set(Calendar.MILLISECOND, 0);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//Pasamos a formato de Timestamp para la BBDD
		java.sql.Date fecha_db = new java.sql.Date(calen_evento.getTimeInMillis());
		System.out.println(new java.sql.Timestamp(date_evento.getTime()));
		System.out.println(new java.sql.Timestamp(calen_evento.getTimeInMillis()));
		System.out.println("La fecha final de tipo BD que se guarda es: " + fecha_db);
		return fecha_db;
	}
	
	/*Paso de formato date de html/jsp a sql Date (sin horas ni minutos)*/
	public static java.sql.Date DTLocalToDB(String fechaDTLocal) {
		String fecha_extendida = fechaDTLocal + "T00:00";
		System.out.println("La fecha extendida es = " + fecha_extendida);
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
		Date date_evento = null;
		Calendar calen_evento = null;
		java.sql.Date fecha_db = null;
		try {
			date_evento = (Date) dateFormatter.parse(fecha_extendida);
			calen_evento = Calendar.getInstance();
			calen_evento.setTime(date_evento);
			calen_evento.set(Calendar.HOUR_OF_DAY, 0);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//Pasamos a formato de Date (short) para la BBDD
		try {
			fecha_db = java.sql.Date.valueOf(calen_evento.get(Calendar.YEAR) + "-" + calen_evento.get(Calendar.MONTH) + "-" + calen_evento.get(Calendar.DAY_OF_MONTH));
			System.out.println("Fecha de caducidad almacenada en la BD = " + fecha_db);
		}catch(Exception e) {
			System.out.println("Error al almacenar la fecha de caducidad: " + e);
		}

		return fecha_db;		
	}
	
	
	/*Paso de formato de fecha java.sql.Date a formato de fecha datetime-local usada en form de jsp*/
	public static String DBDateToDTLocal(java.sql.Date fechaDB) {
		String fechaDTLocal = null;
		
		//create calander instance and get required params
		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaDB);
		
		int month = cal.get(Calendar.MONTH);
		String monthString = "";

		if(month < 10) {
			monthString = "0" + month;
		}else {
			monthString = "" + month;
		}
		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String dayString = "";

		if(day < 10) {
			dayString = "0" + day;
		}else {
			dayString = "" + day;
		}
		
		int year = cal.get(Calendar.YEAR);
		String yearString = "";

		if(year < 1000) {
			yearString = "0" + year;
			if(year < 100) {
				yearString = "0" + yearString;	
				if(year < 10) {
					yearString = "0" + yearString;	
				}
			}
		}else {
			yearString = "" + year;
		}
		
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		String hourString = "";

		if(hour < 10) {
			hourString = "0" + hour;
		}else {
			hourString = "" + hour;
		}
		
		int minute = cal.get(Calendar.MINUTE);
		String minuteString = "";

		if(minute < 10) {
			minuteString = "0" + minute;
		}else {
			minuteString = "" + minute;
		}
		fechaDTLocal = yearString + "-" + monthString + "-" + dayString +"T" + hourString +":" + minuteString;
		
		return fechaDTLocal;
	}
	
	
}
