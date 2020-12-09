package io.divinator.wgapi.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Класс описывает конфигурацию приложения.
 * Параметры редактируются в файле "wgapiclient.properties".
 */
public class WgApiProperties extends Properties {

    private final static String CLIENT_PROPERTIES = "wgapiclient.properties";

    public WgApiProperties() {
        InputStream in = WgApiProperties.class.getClassLoader().getResourceAsStream(CLIENT_PROPERTIES);

        if (null != in) {
            try {
                this.load(in);
                in.close();
            } catch (IOException e) {
                // ignored
            }
        }
    }

    /**
     * Метод возвращает application_id приложения.
     *
     * @return Application_id приложения.
     */
    public String getApplicationId() {
        return getStringProperty("wgapi.id", null);
    }

    /**
     * Метод возвращает таймаут соединения.
     * <p>
     * По умолчанию таймаут задан в 30000 миллисекунд.
     * </p>
     *
     * @return Таймаут соединения.
     */
    public int getConnectionTimeout() {
        return getIntegerProperty("wgapi.connection.timeout", 30000);
    }

    /**
     * Метод возвращает прокси-хост в случае использования Прокси.
     *
     * @return Прокси-хост.
     */
    public String getProxyHost() {
        return getStringProperty("wgapi.proxy.host", null);
    }


    /**
     * Метод возвращает прокси-порт в случае использования Прокси.
     *
     * @return Прокси-порт.
     */
    public int getProxyPort() {
        return getIntegerProperty("wgapi.proxy.port", 80);
    }

    /**
     * Метод возвращает значение property по его ключу, включая системные property.
     *
     * @param name Ключ property.
     * @return Значение property.
     */
    private String getStringProperty(String name) {
        String prop = null;
        try {
            prop = System.getProperty(name);
        } catch (SecurityException e) {
            // Ignore
        }
        return prop == null ? this.getProperty(name) : prop;
    }

    /**
     * Метод возвращает значение property с типом String по его ключу, включая системные property.
     * <p>
     * В случае если property не найден по ключу, возвращается значение заданное по умолчанию.
     * </p>
     *
     * @param name     Ключ property.
     * @param defaults Значение по умолчанию.
     * @return Значение property.
     */
    private String getStringProperty(String name, String defaults) {
        String prop = getStringProperty(name);
        return prop == null ? defaults : prop;
    }

    /**
     * Метод возвращает значение property с типом boolean по его ключу, включая системные property.
     *
     * @param name     Ключ property.
     * @param defaults Значение по умолчанию.
     * @return Значение property.
     */
    private boolean getBooleanProperty(String name, boolean defaults) {
        String prop = getStringProperty(name);
        return prop == null ? defaults : "true".equalsIgnoreCase(prop);
    }

    /**
     * Метод возвращает значение property с типом int по его ключу, включая системные property.
     *
     * @param name     Ключ property.
     * @param defaults Значение по умолчанию.
     * @return Значение property.
     */
    private int getIntegerProperty(String name, int defaults) {
        String prop = getStringProperty(name);
        return prop == null ? defaults : Integer.parseInt(prop);
    }
}
