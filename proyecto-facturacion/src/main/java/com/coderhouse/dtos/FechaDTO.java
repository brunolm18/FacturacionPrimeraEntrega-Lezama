package com.coderhouse.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

public class FechaDTO {
	
	@Schema(description = "Fecha y hora actual en formato ISO 8601", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024-11-23T01:33Z")
	private String currentDateTime;
	

    @Schema(description = "Desviación horaria UTC", example = "+00:00")
    private String utcOffset;

    @Schema(description = "Indica si es horario de verano", example = "false")
    private boolean isDayLightSavingsTime;

    @Schema(description = "Día de la semana",example = "Saturday")
    private String dayOfTheWeek;

    @Schema(description = "Nombre de la zona horaria",example = "UTC")
    private String timeZoneName;
    
    
    
    
	public FechaDTO(String currentDateTime, String utcOffset, boolean isDayLightSavingsTime, String dayOfTheWeek,
			String timeZoneName) {
		super();
		this.currentDateTime = currentDateTime;
		this.utcOffset = utcOffset;
		this.isDayLightSavingsTime = isDayLightSavingsTime;
		this.dayOfTheWeek = dayOfTheWeek;
		this.timeZoneName = timeZoneName;
	}
	public String getCurrentDateTime() {
		return currentDateTime;
	}
	public void setCurrentDateTime(String currentDateTime) {
		this.currentDateTime = currentDateTime;
	}
	public String getUtcOffset() {
		return utcOffset;
	}
	public void setUtcOffset(String utcOffset) {
		this.utcOffset = utcOffset;
	}
	public boolean isDayLightSavingsTime() {
		return isDayLightSavingsTime;
	}
	public void setDayLightSavingsTime(boolean isDayLightSavingsTime) {
		this.isDayLightSavingsTime = isDayLightSavingsTime;
	}
	public String getDayOfTheWeek() {
		return dayOfTheWeek;
	}
	public void setDayOfTheWeek(String dayOfTheWeek) {
		this.dayOfTheWeek = dayOfTheWeek;
	}
	public String getTimeZoneName() {
		return timeZoneName;
	}
	public void setTimeZoneName(String timeZoneName) {
		this.timeZoneName = timeZoneName;
	}
	
}
    