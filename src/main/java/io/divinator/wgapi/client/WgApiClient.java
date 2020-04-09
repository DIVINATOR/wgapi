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

import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.ObjectParser;

import java.util.concurrent.Future;

/**
 * Класс описывает обьект клиента для получения данных от Wargaming.net Public API
 *
 * @author Sergey Divin
 */
public final class WgApiClient extends AbstractHttpClient {

    private int connectTimeout;
    private final WgApiUrlBuilder wgGenericUrlBuilder;
    private final HttpTransport httpTransport;
    private final String CLIENT_VERSION = "1.0.0";

    public WgApiClient(HttpTransport httpTransport, JsonFactory jsonFactory, WgApiUrlBuilder wgGenericUrlBuilder) {
        this.httpTransport = httpTransport;
        this.wgGenericUrlBuilder = wgGenericUrlBuilder;
        super.setObjectParser(jsonFactory.createJsonObjectParser());
        setConnectTimeout(30000);
    }

    public WgApiClient(HttpTransport httpTransport, JsonFactory jsonFactory, Region region, String applicationID) {
        this(httpTransport, jsonFactory, new WgApiUrlBuilder().withApplicationID(applicationID).withRegion(region));
    }

    public WgApiClient(HttpTransport httpTransport, Region region, String applicationID) {
        this(httpTransport, GsonFactory.getDefaultInstance(), region, applicationID);
    }

    public WgApiClient(Region region, String applicationID) {
        this(new NetHttpTransport(), region, applicationID);
    }

    public WgApiClient(String applicationID) {
        this(Region.RU, applicationID);
    }


    /**
     * Метод возвращает транспорт HTTP-соединения
     *
     * @return Транспорт HTTP-соединения
     */
    @Override
    protected HttpTransport getHttpTransport() {
        return httpTransport;
    }

    /**
     * Метод возвращает таймаут соединения в миллисекундах
     *
     * @return Таймаут соединения в миллисекундах
     */
    @Override
    public int getConnectTimeout() {
        return connectTimeout;
    }

    /**
     * Метод возвращает обьект строителя URL для Wargaming.net Public API
     *
     * @return Обьект строителя URL для Wargaming.net Public API
     */
    @Override
    protected WgApiUrlBuilder getUrlBuilder() {
        return wgGenericUrlBuilder;
    }

    /**
     * Метод выполняет HTTP-запрос методом GET и возвращает HTTP-ответ
     *
     * @param url Строитель запроса к Wargaming.net Public API
     * @return HTTP-ответ от Wargaming.net Public API
     * @throws WgApiClientException В случае, если возникла ошибка отправки HTTP-запроса методом GET
     */
    @Override
    public HttpResponse get(WgApiUrlBuilder url) throws WgApiClientException {
        return super.get(url);
    }

    /**
     * Метод выполняет HTTP-запрос методом POST и возвращает HTTP-ответ
     *
     * @param url Строитель запроса к Wargaming.net Public API
     * @return HTTP-ответ от Wargaming.net Public API
     * @throws WgApiClientException В случае, если возникла ошибка отправки HTTP-запроса методом POST
     */
    @Override
    public HttpResponse post(WgApiUrlBuilder url) throws WgApiClientException {
        return super.post(url);
    }

    /**
     * Метод ассинхронно выполняет HTTP-запрос методом GET и возвращает HTTP-ответ
     *
     * @param url Строитель URL для получения данных от Wargaming.net Public API
     * @return HTTP-ответ от WargamingAPI
     * @throws WgApiClientException В случае, если возникла ошибка отправки асинхронного HTTP-запроса методом GET
     */
    @Override
    public Future<HttpResponse> getAsync(WgApiUrlBuilder url) throws WgApiClientException {
        return super.getAsync(url);
    }

    /**
     * Метод ассинхронно выполняет HTTP-запрос методом POST и возвращает HTTP-ответ
     *
     * @param url Строитель URL для получения данных от Wargaming.net Public API
     * @return HTTP-ответ от WargamingAPI
     * @throws WgApiClientException В случае, если возникла ошибка отправки асинхронного HTTP-запроса методом POST
     */
    @Override
    public Future<HttpResponse> postAsync(WgApiUrlBuilder url) throws WgApiClientException {
        return super.postAsync(url);
    }

    /**
     * Метод устанавливает парсер для преобразования ответа от Wargaming.net Public API в Обьект
     *
     * @param objectParser Парсер для преобразования ответа от Wargaming.net Public API в Обьект
     */
    @Override
    void setObjectParser(ObjectParser objectParser) {
        super.setObjectParser(objectParser);
    }

    /**
     * Метод устанавливает таймаут соединения в миллисекундах
     *
     * @param connectTimeout Таймаут соединения в миллисекундах
     */
    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    /**
     * Метод возвращает версию клиента
     * @return Версию клиента
     */
    public String getClientVersion() {
        return CLIENT_VERSION;
    }

    /**
     * Метод возвращает обьект переданного в параметры класса метод-блока Wargaming.net Public API с установленным клиентом
     *
     * @param classMethodBlock Класс метод-блока Wargaming.net Public API
     * @param <T>              Тип класса метод-блока Wargaming.net Public API
     * @return обьект переданного в параметры класса метод-блока Wargaming.net Public API с установленным клиентом
     * @throws WgApiClientException В случае, если произошла ошибка создания обьекта, либо не найден публичный конструктор
     *                              по умолчанию, либо не удалось встроить клиент в метод-блок Wargaming.net Public API
     */
    public <T extends AbstractMethodBlock> T getMethodBlock(Class<T> classMethodBlock) throws WgApiClientException {
        return super.getMethodBlock(classMethodBlock, this);
    }
}