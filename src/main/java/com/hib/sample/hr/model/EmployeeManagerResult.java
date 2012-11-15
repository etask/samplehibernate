package com.hib.sample.hr.model;

public class EmployeeManagerResult {
	
	private String employeeName;
	private String managerName;
	private String deptName;
	
	public EmployeeManagerResult(String a, String b, String c)
	{
		this.employeeName = a;
		this.managerName = b;
		this.deptName = c;
	}
	
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	

}
