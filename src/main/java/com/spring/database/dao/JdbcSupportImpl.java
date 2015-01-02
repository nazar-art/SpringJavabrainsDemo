package com.spring.database.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcSupportImpl extends JdbcDaoSupport {

    public static final String SELECT_COUNT_FROM_CIRCLE = "SELECT COUNT(*) FROM circle";

    public int getCircleCount() {
//        jdbcTemplate.setDataSource(getDataSource());
        return getJdbcTemplate().queryForInt(SELECT_COUNT_FROM_CIRCLE);
    }

}
