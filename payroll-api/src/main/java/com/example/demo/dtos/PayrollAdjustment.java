package com.example.demo.dtos;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Jacksonized
public class PayrollAdjustment {
	
	@Schema(description = "Username of effected employee.", example = "tedb")
	private @NotNull String username;
	
	@Schema(description = "Username of manager approving the payroll adjustment", example = "nickj")
	private String approver;
	
	@Schema(description = "Date at which the adjustment was approved.", format = "mm-dd-yyyy", example = "01-01-2024")
	private String approvalDate;
	
	@Schema(description = "List of payroll periods to be adjusted.")
	private List<PayrollPeriod> payrollPeriods;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

	public List<PayrollPeriod> getPayrollPeriods() {
		return payrollPeriods;
	}

	public void setPayrollPeriods(List<PayrollPeriod> payrollPeriods) {
		this.payrollPeriods = payrollPeriods;
	}

	
}
