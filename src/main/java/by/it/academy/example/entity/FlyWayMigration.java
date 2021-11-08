package by.it.academy.example.entity;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;


public class FlyWayMigration {
    private UserInformationJDBC uInfo;
    private Flyway flyway;

    @Bean
    public void skipAutomaticAndTriggerManualFlywayMigration() {
        flyway = Flyway.configure().locations("classpath:db.migration")
                .dataSource(uInfo.getDataSource()).load();
        flyway.migrate();
    }

    @Bean
    public void initSqlAndMigrationFlyway(String sql) {
        flyway = Flyway.configure().dataSource(uInfo.getDataSource()).initSql(sql).load();
        flyway.migrate();
    }

}
