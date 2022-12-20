package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import logic.SaleItem;

@Repository
public class SaleItemDao {
	private NamedParameterJdbcTemplate template;
	private Map<String,Object> param = new HashMap<>();
	private RowMapper<SaleItem> mapper = 
			       new BeanPropertyRowMapper<>(SaleItem.class);
	@Autowired
	public void setDataSource(DataSource dataSource) {
		template = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void insert(SaleItem saleitem) {
		String Sql = "insert into saleitem "
			+ " (saleid,seq,itemid,quantity,price) "
			+ " values(:saleid,:seq,:itemid,:quantity,:item.price)";
		SqlParameterSource param = 
				new BeanPropertySqlParameterSource(saleitem);
		template.update(Sql, param);
	}

	public List<SaleItem> list(int saleid) {
		param.clear();
		param.put("saleid", saleid);
		String sql = 
			"select * from saleitem where saleid = :saleid";
		return template.query(sql,param,mapper);
	}
}
