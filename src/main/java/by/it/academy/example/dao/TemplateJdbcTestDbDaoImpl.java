package by.it.academy.example.dao;

import by.it.academy.example.entity.CommandsSQL;
import by.it.academy.example.entity.UserInformationJDBC;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class TemplateJdbcTestDbDaoImpl implements TemplateJdbcTestDbDAO{
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    public void initTemplate(){
        UserInformationJDBC uInfo = new UserInformationJDBC();
        jdbcTemplate = new JdbcTemplate(uInfo.getDataSource());
        namedJdbcTemplate = new NamedParameterJdbcTemplate(uInfo.getDataSource());
    }

    @Override
    public int save(CommandsSQL id) throws SQLException {
        try{
        jdbcTemplate.execute(id.getInsert());
            return 1;
        }catch (Exception x){
            return 0;
        }
    }

    @Override
    public int get(CommandsSQL id) throws SQLException {
        try{
            jdbcTemplate.execute(id.getSelect());
            return 1;
        }catch (Exception x){
            return 0;
        }
    }

    @Override
    public int update(CommandsSQL id) throws SQLException {
        try {
            jdbcTemplate.execute(id.getUpdate());
            return 1;
        }catch (Exception x){
            return 0;
        }
    }

    @Override
    public int delete(CommandsSQL id) throws SQLException {
        try {
            jdbcTemplate.execute(id.getDelete());
            return 1;
        }catch (Exception x){
            return 0;
        }
    }

    @Override
    public List<String> getAllTestDbParameter(CommandsSQL id) throws SQLException {
        try{
            List<String> data = jdbcTemplate.queryForList(id.getSelect(), String.class);
            return data;
    }catch (Exception x){
        return null;
    }

    }

    @Override
    public List<String> getOneByTwo(CommandsSQL id) throws SQLException {
        try{
            List<String> data = jdbcTemplate.queryForList(id.getJoin(), String.class);
            return data;
        }catch (Exception x){
            return null;
        }
    }

    @Override
    public int getSelect(CommandsSQL id, String selectTable, String selectColumn, int whereIdIs) throws SQLException {
        id.setSelect(selectTable, selectColumn);
            StringBuffer select = new StringBuffer(id.getSelect());
            select.append(" WHERE id = :").append(whereIdIs);
            return namedJdbcTemplate.queryForObject(String.valueOf(select),
                    new MapSqlParameterSource("id", whereIdIs), Integer.class);

    }
}
