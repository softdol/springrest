package myTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HikariTest {
	
	public static void main(String[] args) {
		
		HikariConfig config = new HikariConfig();
		//config.setDriverClassName("oracle.jdbc.OracleDriver");
		config.setJdbcUrl("jdbc:oracle:thin:@3.39.84.37:1521:XE");
		config.setUsername("hr");
		config.setPassword("12345678");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		
		HikariDataSource ds = new HikariDataSource(config);
		
		try(
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees");
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				log.info(rs.getString("first_name") + " " + rs.getString("last_name"));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

}
