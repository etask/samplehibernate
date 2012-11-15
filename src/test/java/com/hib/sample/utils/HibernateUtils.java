package com.hib.sample.utils;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateUtils {

	/*@Autowired
	static Configuration hibernateConfiguration;*/

	private Configuration hibernateConfiguration;
	
	public HibernateUtils(Configuration hibernateConfiguration)
	{
		this.hibernateConfiguration = hibernateConfiguration;
	}
	
	public void generateSchema() {

		SchemaExport export = new SchemaExport(hibernateConfiguration);
		export.setOutputFile("my-schema.sql");
		export.setDelimiter(";");
		export.execute(true, false, false, true);
	}

}
