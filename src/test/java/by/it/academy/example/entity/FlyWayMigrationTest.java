package by.it.academy.example.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FlyWayMigrationTest {
    private FlyWayMigration flyway;

    @Test
    void testSkipAutomaticAndTriggerManualFlywayMigration(){
        Assertions.assertThrows(NullPointerException.class, ()-> {
            flyway.skipAutomaticAndTriggerManualFlywayMigration();
        });
    }

    @Test
    void testInitSqlAndMigrationFlyway(){
        Assertions.assertThrows(NullPointerException.class, ()-> {
                flyway.initSqlAndMigrationFlyway("SELECT * FROM jdbc_test;");
            });
    }
}


