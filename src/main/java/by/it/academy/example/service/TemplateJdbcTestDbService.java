package by.it.academy.example.service;

import by.it.academy.example.dao.TemplateJdbcTestDbDAO;
import by.it.academy.example.entity.CommandsSQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class TemplateJdbcTestDbService{
    private final Logger logger = LoggerFactory.getLogger("LOGS");
    private CommandsSQL sql;
    private StringBuilder builder;

    @Autowired
    @Qualifier("templateJdbcTestDbDaoImpl")
    private TemplateJdbcTestDbDAO templateJdbcTestDbDAO;

    public void getTemplateJdbcTestDbDAO(TemplateJdbcTestDbDAO templateJdbcTestDbDAO){
        this.templateJdbcTestDbDAO = templateJdbcTestDbDAO;
    }

    public void addData(String id, String name, String number){
        sql = new CommandsSQL();
        builder = new StringBuilder();
        builder.append("id=").append(id).append(",name=").append(name).append(",number=").append(name);
        sql.setInsert("test_db.jdbc_test",String.valueOf(builder));
        try {templateJdbcTestDbDAO.save(sql);
        } catch (SQLException e) {
            logger.error("Fail Add in JdbcTestDbService",e);
        }
    }

    public void chengData(String id, String name, String number){
        sql = new CommandsSQL();
        builder = new StringBuilder();
        builder.append("id=").append(id).append(",name=").append(name).append(",number=").append(name);
        sql.setUpdate("test_db.jdbc_test",String.valueOf(builder));
        try {templateJdbcTestDbDAO.update(sql);
        } catch (SQLException e) {
            logger.error("Fail Cheng in JdbcTestDbService",e);
        }
    }

    public void deleteData(String id, String name, String number){
        sql = new CommandsSQL();
        builder = new StringBuilder();
        builder.append("id=").append(id).append(",name=").append(name).append(",number=").append(name);
        sql.setDelete("test_db.jdbc_test",String.valueOf(builder));
        try {templateJdbcTestDbDAO.delete(sql);
        } catch (SQLException e) {
            logger.error("Fail Delete in JdbcTestDbService",e);
        }
    }

    public void selectData(String id, String name, String number){
        sql = new CommandsSQL();
        builder = new StringBuilder();
        builder.append("id=").append(id).append(",name=").append(name).append(",number=").append(name);
        sql.setSelect("test_db.jdbc_test",String.valueOf(builder));
        try {templateJdbcTestDbDAO.get(sql);
        } catch (SQLException e) {
            logger.error("Fail Select in JdbcTestDbService",e);
        }
    }
    public List<String> joinData(String tableJoin, String columnOne, String columnTwo){
        sql = new CommandsSQL();
        sql.setJoin("test_db.jdbc_test",tableJoin,columnOne,columnTwo);
        try {
            return templateJdbcTestDbDAO.getOneByTwo(sql);
        } catch (SQLException e) {
            logger.error("Fail Join in JdbcTestDbService",e);
            return null;
        }
    }
    public List<String> getAllData(String id, String name, String number){
        sql = new CommandsSQL();
        builder = new StringBuilder();
        builder.append("id=").append(id).append(",name=").append(name).append(",number=").append(name);
        sql.setSelect("test_db.jdbc_test",String.valueOf(builder));
        try {
            return templateJdbcTestDbDAO.getAllTestDbParameter(sql);
        } catch (SQLException e) {
            logger.error("Fail getAll in JdbcTestDbService",e);
            return null;
        }
    }
    public int getSelectDataWhereId(int whereIdIs){
        sql = new CommandsSQL();
        try {
            return templateJdbcTestDbDAO.getSelect(sql, "test_db.jdbc_test", "id", whereIdIs);
        } catch (SQLException e) {
            logger.error("Fail getSelectWhereId in JdbcTestDbService",e);
            return 0;
        }
    }
}
