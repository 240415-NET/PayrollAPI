package com.example.demo.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@RequiredArgsConstructor
public class PayrollPeriod {
	
	@Schema(description = "Date of effected payroll.", format = "mm-dd-yyyy", example = "01-01-2024")
	private @NonNull String date;
	
	@Schema(description = "Type of hours worked.", allowableValues = {"Paid Time Off", "Unpaid Time Off", "Holiday", "Floating Holiday", "Relocation", "Medical"})
	private @NonNull String type;
	
	@Schema(description = "Number of hours worked on the date under the given type.", example = "8")
	private @NonNull int hours;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}
	
}
