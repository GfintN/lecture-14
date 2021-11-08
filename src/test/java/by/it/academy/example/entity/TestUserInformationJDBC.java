package by.it.academy.example.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.sql.Connection;

public class TestUserInformationJDBC {
    private UserInformationJDBC uInfo;

    @Test
    void getPoolConnection(){
        Connection connection = uInfo.getPoolConnection();
        Assertions.assertNotNull(connection);
    }

    @Test
    void getDataSource(){
        DataSource ds = uInfo.getDataSource();
        Assertions.assertNotNull(ds);
    }

}
