package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {

    @Override
    public Connection createConnection() {
        try (FileInputStream file = new FileInputStream("src/main/resources/h2database.properties");) {
            Properties prop = new Properties();
            prop.load(file);
            String driver = prop.getProperty("driver");
            Class.forName(driver);
            return DriverManager.getConnection(prop.getProperty("db_url"), prop.getProperty("user"), prop.getProperty("password"));
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

