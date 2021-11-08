package by.it.academy.example.dao;

import by.it.academy.example.entity.CommandsSQL;
import java.sql.SQLException;
import java.util.List;

public interface TemplateJdbcTestDbDAO extends DAO <CommandsSQL>{
    List<String> getAllTestDbParameter(CommandsSQL id) throws SQLException;
    List<String> getOneByTwo(CommandsSQL id) throws SQLException;
    int getSelect(CommandsSQL id, String selectTable, String selectColumn, int whereIdIs) throws SQLException;
}
