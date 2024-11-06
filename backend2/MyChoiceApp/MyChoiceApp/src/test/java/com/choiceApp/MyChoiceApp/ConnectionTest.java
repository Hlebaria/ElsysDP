package com.choiceApp.MyChoiceApp;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.postgresql.ds.PGConnectionPoolDataSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
public class ConnectionTest {

    private String dbUser;
    private String dbPassword;
    private String dbName;

    private Connection c;

    @Test
    void GetDbVars() {

        Dotenv dotenv = Dotenv.configure().filename("database.env").load();

        dbUser = dotenv.get("POSTGRES_USER");
        dbPassword = dotenv.get("POSTGRES_PASSWORD");
        dbName = dotenv.get("POSTGRES_DB");

        dbPassword = dbPassword.replace("'", "");

        System.out.println("POSTGRES_USER: " + dbUser);
        System.out.println("POSTGRES_PASSWORD: " + dbPassword);
        System.out.println("POSTGRES_DB: " + dbName);

        assertNotNull(dbUser);
        assertNotNull(dbPassword);
        assertNotNull(dbName);
    }

    @Test
    void Connection() throws SQLException {

        GetDbVars();

        PGConnectionPoolDataSource p = new PGConnectionPoolDataSource();
        p.setPassword(dbPassword);
        p.setUser(dbUser);
        p.setDatabaseName(dbName);
        p.setServerNames(new String[]{"127.0.0.1"});
        p.setPortNumbers(new int[]{6543});
        c = p.getConnection();

    }

    @Test
    void printer() {
        System.out.println("\ncheck");
    }
}
