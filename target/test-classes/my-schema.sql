select 
	employee0_.EMPLOYEE_ID as EMPLOYEE1_2_0_, 
	employee0_.COMMISSION_PCT as COMMISSION2_2_0_, 
	employee0_.DEPARTMENT_ID as DEPARTMENT9_2_0_, 
	employee0_.EMAIL as EMAIL2_0_, 
	employee0_.FIRST_NAME as FIRST4_2_0_, 
	employee0_.HIRE_DATE as HIRE5_2_0_, 
	employee0_.JOB_ID as JOB10_2_0_, 
	employee0_.LAST_NAME as LAST6_2_0_, 
	employee0_.MANAGER_ID as MANAGER11_2_0_, 
	employee0_.PHONE_NUMBER as PHONE7_2_0_, 
	employee0_.SALARY as SALARY2_0_ 
from HR.EMPLOYEES employee0_ 
where employee0_.EMPLOYEE_ID=? 
for update


select 
	employee0_.EMPLOYEE_ID as EMPLOYEE1_2_1_, 
	employee0_.COMMISSION_PCT as COMMISSION2_2_1_, 
	employee0_.DEPARTMENT_ID as DEPARTMENT9_2_1_, 
	employee0_.EMAIL as EMAIL2_1_, 
	employee0_.FIRST_NAME as FIRST4_2_1_, 
	employee0_.HIRE_DATE as HIRE5_2_1_, 
	employee0_.JOB_ID as JOB10_2_1_, 
	employee0_.LAST_NAME as LAST6_2_1_,
	employee0_.MANAGER_ID as MANAGER11_2_1_, 
	employee0_.PHONE_NUMBER as PHONE7_2_1_, 
	employee0_.SALARY as SALARY2_1_, 
	employee1_.EMPLOYEE_ID as EMPLOYEE1_2_0_,
	employee1_.COMMISSION_PCT as COMMISSION2_2_0_, 
	employee1_.DEPARTMENT_ID as DEPARTMENT9_2_0_, 
	employee1_.EMAIL as EMAIL2_0_, 
	employee1_.FIRST_NAME as FIRST4_2_0_, 
	employee1_.HIRE_DATE as HIRE5_2_0_, 
	employee1_.JOB_ID as JOB10_2_0_, 
	employee1_.LAST_NAME as LAST6_2_0_, 
	employee1_.MANAGER_ID as MANAGER11_2_0_,
	employee1_.PHONE_NUMBER as PHONE7_2_0_, 
	employee1_.SALARY as SALARY2_0_ 
from HR.EMPLOYEES employee0_ left outer join HR.EMPLOYEES employee1_ on employee0_.MANAGER_ID=employee1_.EMPLOYEE_ID 
where employee0_.EMPLOYEE_ID=?