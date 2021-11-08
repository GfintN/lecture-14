package by.it.academy.example.dao;

import by.it.academy.example.entity.CommandsSQL;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class VoidJdbcTestDbDaoImpl implements JdbcTestDbDAO {
    @Override
    public int save(CommandsSQL id) throws SQLException {
        return 0;
    }

    @Override
    public int get(CommandsSQL id) throws SQLException {
        return 0;
    }

    @Override
    public int update(CommandsSQL commandsSQL) throws SQLException {
        return 0;
    }

    @Override
    public int delete(CommandsSQL id) throws SQLException {
        return 0;
    }

    @Override
    public List<String> getAllTestDbParameter(CommandsSQL id) throws SQLException {
        return null;
    }

    @Override
    public int getOneByTwo(CommandsSQL id) throws SQLException {
        return 0;
    }
}
