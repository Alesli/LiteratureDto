package com.itstep.literature.jdbc;

import java.io.IOException;
import java.util.Properties;

/**
 * класс, для чтения данных из файла connection.properties при подключении к БД
 *
 * @author Слижова Олеся
 */
class PropertyReader {

    Properties getProperties(String fileName) {

        Properties properties = new Properties();

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("property/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
