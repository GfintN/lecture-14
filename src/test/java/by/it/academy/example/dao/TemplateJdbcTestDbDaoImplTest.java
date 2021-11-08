package by.it.academy.example.dao;

import by.it.academy.example.entity.CommandsSQL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class TemplateJdbcTestDbDaoImplTest {
    private TemplateJdbcTestDbDaoImpl templateJdbcTestDbDao;
    private CommandsSQL sql;

    @Test
    void testInitTemplate(){
        Assertions.assertDoesNotThrow(()->{templateJdbcTestDbDao.initTemplate();});
    }

    @Test
    void testSaveDAO(){
        sql.setInsert("x","x");
        Assertions.assertThrows(SQLException.class,()->{
            Assertions.assertEquals(0, templateJdbcTestDbDao.save(sql));
        });
    }

    @Test
    void testGetDAO(){
        sql.setSelect("x","x");
        Assertions.assertThrows(SQLException.class,()->{
            Assertions.assertEquals(0, templateJdbcTestDbDao.get(sql));
        });
    }

    @Test
    void testUpdateDAO(){
        sql.setUpdate("x","x");
        Assertions.assertThrows(SQLException.class,()->{
            Assertions.assertEquals(0, templateJdbcTestDbDao.update(sql));
        });
    }

    @Test
    void testDeleteDAO(){
        sql.setDelete("x","x");
        Assertions.assertThrows(SQLException.class,()->{
            Assertions.assertEquals(0, templateJdbcTestDbDao.delete(sql));
        });
    }

    @Test
    void testGetSelectDAO(){
        Assertions.assertThrows(SQLException.class,()->{
            Assertions.assertEquals(0, templateJdbcTestDbDao.getSelect(sql,"x","x",1));
        });
    }
}
