package com.coderhouse.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coderhouse.dtos.FechaDTO;


@Service
public class FechaService {
	
	 @Autowired
	    private RestTemplate restTemplate; // Se usa RestTemplate para hacer la solicitud

	    private static final String API_URL = "http://worldclockapi.com/api/json/utc/now"; // URL de la API externa

	    public FechaDTO obtenerFecha() {
	        try {
	            // Realizar la solicitud GET al servicio externo
	            FechaDTO fechaDTO = restTemplate.getForObject(API_URL, FechaDTO.class);

	            // Verificamos si la respuesta es válida
	            if (fechaDTO != null && fechaDTO.getCurrentDateTime() != null) {
	                return fechaDTO;  // Si todo está bien, retornamos la respuesta
	            } else {
	                // Si la respuesta es inválida, lanzamos una excepción
	                throw new RuntimeException("Respuesta inválida del servicio de fecha");
	            }
	        } catch (Exception e) {
	            // Manejo de excepciones: si algo sale mal con la solicitud externa
	            // Devolvemos un objeto FechaDTO con valores por defecto
	            return getFechaDefault();
	        }
	    }

	    // Método para retornar valores por defecto en caso de error en el servicio externo
	    private FechaDTO getFechaDefault() {
	        FechaDTO fechaDefault = new FechaDTO(null, null, false, null, null);
	        fechaDefault.setCurrentDateTime(LocalDateTime.now().toString());
	        fechaDefault.setUtcOffset("00:00:00");
	        fechaDefault.setDayLightSavingsTime(false);
	        fechaDefault.setDayOfTheWeek("Unknown");
	        fechaDefault.setTimeZoneName("UTC");
	        return fechaDefault;
	    }

}
