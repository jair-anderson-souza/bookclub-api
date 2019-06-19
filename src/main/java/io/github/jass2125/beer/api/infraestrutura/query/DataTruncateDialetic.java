package io.github.jass2125.beer.api.infraestrutura.query;

import org.hibernate.dialect.PostgreSQL82Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;

/**
 *
 * @author <a href="https://victorhsr.github.io" target="_blank">Victor Hugo</a>
 *         Created on 14 de set de 2018
 * @project bids-api
 *
 **/
public class DataTruncateDialetic extends PostgreSQL82Dialect {

	public DataTruncateDialetic() {
		super();
		new SQLFunctionTemplate(StandardBasicTypes.TIMESTAMP, "DATE(?1)");
	}

}
