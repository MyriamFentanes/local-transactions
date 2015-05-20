package tutorial;


import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.camel.Exchange;
import org.springframework.jdbc.core.JdbcTemplate;

public class CashService {
	private static final transient Logger LOGGER = Logger
			.getLogger(CashService.class.getName());
	private JdbcTemplate jdbc;
	private DataSource dataSource;
	
	public CashService() {
	}

	public void setDataSource(DataSource ds) {
		LOGGER.info("[CashService -setDataSource]Setting datasource"+ds);
		jdbc = new JdbcTemplate(ds);
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	public void insertTransaction(Exchange exchange){
		LOGGER.info("[CashService -insertTransaction]message body = " + exchange.getIn().getBody());
		jdbc.execute("Insert into transactions values('1','primera','Primera transaccion')");
		
	}
	public void insertNextTransaction(Exchange exchange){
		LOGGER.info("[CashService -insertNextTransaction]message body = " + exchange.getIn().getBody());
		jdbc.execute("Insert into transactions values('1','segunda','Segunda transaccion')");
		
	}
	
}
