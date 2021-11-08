package by.it.academy.example.entity;

import org.flywaydb.core.Flyway;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


public class FlyWayMigration {
    private UserInformationJDBC uInfo;
    private ApplicationContext applicationContext = new AnnotationConfigApplicationContext("by.it.academy.example");
    private Flyway flyway;

    @Bean
    public void skipAutomaticAndTriggerManualFlywayMigration() {
        flyway = Flyway.configure().dataSource(uInfo.getDataSource()).load();
        flyway.migrate();
    }

    @Bean
    public void initSqlAndMigrationFlyway(String sql) {
        flyway = Flyway.configure().dataSource(uInfo.getDataSource()).initSql(sql).load();
        flyway.migrate();
    }

}
