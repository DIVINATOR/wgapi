/*
 * Copyright [2020] [Sergey Divin]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.divinator.wgapi.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * Класс описывает объект клиента для получения данных от Wargaming.net Public API.
 * <p>
 * Для получения объекта Wargaming.net Public API удобнее воспользоваться фабрикой {@link io.divinator.wgapi.WgApiFactory}
 *
 * @author Sergey Divin
 */
public final class WgApiClient extends AbstractHttpClient {

    public final static String CLIENT_VERSION = "2.1.0";
    private final Log log = LogFactory.getLog(getClass());
    private final WgApiUriBuilder wgApiUriBuilder;
    private final WgApiProperties properties;

    /**
     * Конструктор объекта клиента {@link WgApiClient}
     *
     * @param wgApiUriBuilder Строитель URI запроса для Wargaming.net Public API
     */
    public WgApiClient(WgApiUriBuilder wgApiUriBuilder) {
        this.wgApiUriBuilder = wgApiUriBuilder;
        this.properties = new WgApiProperties();
        log.debug("WgApiClient initialized.");
    }

    /**
     * Метод возвращает обьект переданного в параметры класса метод-блока Wargaming.net Public API с установленным клиентом
     *
     * @param classMethodBlock Класс метод-блока Wargaming.net Public API
     * @param <T>              Тип класса метод-блока Wargaming.net Public API
     * @return обьект переданного в параметры класса метод-блока Wargaming.net Public API с установленным клиентом
     * @throws WgApiException В случае, если произошла ошибка создания обьекта, либо не найден публичный конструктор
     *                        по умолчанию, либо не удалось встроить клиент в метод-блок Wargaming.net Public API
     */
    public <T extends AbstractMethodBlock> T getMethodBlock(Class<T> classMethodBlock) throws WgApiException {
        return super.getMethodBlock(classMethodBlock, this);
    }

    /**
     * Метод возвращает текущую версию клиента WgApi
     *
     * @return Версия клиента WgApi
     */
    public String getClientVersion() {
        return CLIENT_VERSION;
    }

    /**
     * Метод устанавливает таймаут HTTP-соединения.
     * @param connectTimeOut таймаут HTTP-соединения
     * @deprecated use {{@link #getProperties()}}
     */
    @Deprecated
    public void setConnectTimeOut(int connectTimeOut) {

    }

    /**
     * Метод возвращает таймаут соединения в миллисекундах.
     *
     * @return Таймаут соединения в миллисекундах
     */
    public int getConnectTimeout() {
        return getProperties().getConnectionTimeout();
    }

    /**
     * Метод возвращает объект HTTP-клиента.
     *
     * @return Объект HTTP-клиента
     */
    @Override
    protected CloseableHttpClient getHttpClient() {
        return HttpClientBuilder
                .create()
                .setDefaultRequestConfig(
                        getDefaultRequestConfig()
                )
                .build();
    }

    /**
     * Метод возвращает объект строителя URL для Wargaming.net Public API используемого AbstractHttpClient
     *
     * @return Объект строителя URL для Wargaming.net Public API используемого AbstractHttpClient
     */
    protected WgApiUriBuilder getWgApiUriBuilder() {
        return wgApiUriBuilder;
    }

    /**
     * Метод возвращает настройки приложения указанные в файле "wgapiclient.properties".
     *
     * @return Настройки приложения.
     */
    @Override
    public WgApiProperties getProperties() {
        return properties;
    }
}
