Flyway on maven *:

Use " <quote>mvn flyway:migrate " to start migration

Use " <quote>mvn flyway:validate " to check the current database schema against the available migrations.

*Use " <quote>mvn flyway:init -Dflyway.initialVersion="?" -Dflyway.initialDescription="?" " create a versioned structure

Use " <quote>mvn flyway:clear " to drops all objects in the configured schemas;

or use FlyWayMigration.class

NEW! initSqlAndMigrationFlyway add your string sql command.

My docker repo 
<quote>https://hub.docker.com/repository/docker/gfintn/my-postgres/general

Start Main class