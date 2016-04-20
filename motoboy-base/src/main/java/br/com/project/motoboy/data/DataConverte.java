package br.com.project.motoboy.data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataConverte {
	
	public static String dataConverte(Date date) {
		
		String dateConvertida = new SimpleDateFormat("dd/MM/yyyy").format(date);
		return dateConvertida;
	}
}
