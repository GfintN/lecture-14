package by.it.academy.example.dao;

import by.it.academy.example.entity.CommandsSQL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class JdbcTestDbDaoImplTest {
    private JdbcTestDbDaoImpl jdbcTestDbDao;
    private CommandsSQL sql;

    @Test
    void testOpenAndCloseConnection(){
        Assertions.assertDoesNotThrow(()->{jdbcTestDbDao.openConnection();});
        jdbcTestDbDao.closeConnection();
    }

    @Test
    void testSaveDAO(){
        sql.setInsert("x","x");
        Assertions.assertThrows(SQLException.class,()->{
            Assertions.assertEquals(0, jdbcTestDbDao.save(sql));
        });
    }

    @Test
    void testGetDAO(){
        sql.setSelect("x","x");
        Assertions.assertThrows(SQLException.class,()->{
            Assertions.assertEquals(0, jdbcTestDbDao.get(sql));
        });
    }

    @Test
    void testUpdateDAO(){
        sql.setUpdate("x","x");
        Assertions.assertThrows(SQLException.class,()->{
            Assertions.assertEquals(0, jdbcTestDbDao.update(sql));
        });
    }

    @Test
    void testDeleteDAO(){
        sql.setDelete("x","x");
        Assertions.assertThrows(SQLException.class,()->{
            Assertions.assertEquals(0, jdbcTestDbDao.delete(sql));
        });
    }

}
