package org.training.employeesmanagement.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class EmployeeDto {

	@NotNull
	@Pattern(regexp = "[a-zA-Z ]+", message = "Invalid employee name")
	private String empName;

	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "Invalid email Id")
	private String empEmail;

	@NotNull
	@Pattern(regexp = "[a-zA-Z_ ]+", message = "Invalid Role")
	private String role;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
