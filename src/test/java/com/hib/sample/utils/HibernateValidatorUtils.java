package com.hib.sample.utils;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.hibernate.validator.HibernateValidator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


public class HibernateValidatorUtils {

	private static LocalValidatorFactoryBean localValidatorFactory;
	
	
	static
	{
		localValidatorFactory = new LocalValidatorFactoryBean();
        localValidatorFactory.setProviderClass(HibernateValidator.class);
        localValidatorFactory.afterPropertiesSet();
	}
	
	public static Set<ConstraintViolation<Object>> getConstraintViolations(Object entity){		
		return localValidatorFactory.validate(entity);
	}
	
	
}
