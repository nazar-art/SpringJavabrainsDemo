package com.spring.database.dao;

import com.spring.database.model.Circle;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Component
public class JdbcDaoImpl {

    //    public static final String URL = "jdbc:derby://localhost:1527/db";
//    public static final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    public static final String SELECT_FROM_CIRCLE_WHERE_ID = "SELECT * FROM circle WHERE id = ?";
    public static final String SELECT_ALL_FROM_CIRCLE = "SELECT * FROM circle";
    public static final String SELECT_COUNT_FROM_CIRCLE = "SELECT COUNT(*) FROM circle";
    public static final String SELECT_NAME_FROM_CIRCLE = "SELECT name FROM circle WHERE id = ?";
    public static final String INSERT_INTO_CIRCLE = "INSERT INTO circle (id, name) VALUES (?, ?)";
    public static final String INSERT_INTO_CIRCLE_BY_NAME = "INSERT INTO circle (id, name) VALUES (:id, :name)";

    private Logger log = Logger.getLogger(JdbcDaoImpl.class);
    //    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcTemplate simpleJdbcTemplate;

    public Circle getCircle(int circleId) {
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs;
        Circle circle = null;
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(SELECT_FROM_CIRCLE_WHERE_ID);
            ps.setInt(1, circleId);

            rs = ps.executeQuery();
            if (rs.next()) {
                circle = new Circle(circleId, rs.getString("name"));
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            log.error(e);
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                log.error(e);
            }
        }
        return circle;
    }

    public String getCircleName(int circleId) {
        return jdbcTemplate.queryForObject(SELECT_NAME_FROM_CIRCLE, new Object[]{circleId}, String.class);
    }

    public Circle getCircleById(int circleId) {
        return jdbcTemplate.queryForObject(SELECT_FROM_CIRCLE_WHERE_ID, new Object[]{circleId}, new CircleMapper());
    }

    public List<Circle> getAllCircles() {
        return jdbcTemplate.query(SELECT_ALL_FROM_CIRCLE, new CircleMapper());
    }

    private static final class CircleMapper implements RowMapper<Circle> {

        @Override
        public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
            Circle circle = new Circle();
            circle.setId(rs.getInt("id"));
            circle.setName("name");
            return circle;
        }
    }

    public int getCircleCount() {
//        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate.queryForInt(SELECT_COUNT_FROM_CIRCLE);
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//        this.dataSource = dataSource;
    }

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*public void insertCircle(Circle circle) {
        jdbcTemplate.update(INSERT_INTO_CIRCLE, circle.getId(), circle.getName());
    }*/

    public void insertCircle(Circle circle) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", circle.getId()).addValue("name", circle.getName());
        namedParameterJdbcTemplate.update(INSERT_INTO_CIRCLE_BY_NAME, namedParameters);
    }

    public void createTriangleTable() {
        String sql = "CREATE TABLE TRIANGLE (ID INTEGER, NAME VARCHAR(50))";
        jdbcTemplate.execute(sql);
    }
}
