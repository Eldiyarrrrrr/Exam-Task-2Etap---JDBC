package peaksoft.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataBaseConfig {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "1234");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}



