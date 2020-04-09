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

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.UrlEncodedContent;

import java.util.*;

/**
 * Класс описывает обьект строителя URL для Wargaming.net Public API
 * <p>
 * Все запросы в URI-формате имеют следующий вид: <b>http(s)://"server"/"API_name"/"method block"/"method name"/?"get params"</b>
 * </p>
 * <p>
 * Где:
 * <ul>
 * <li>"server" - URI игрового сервера на соответствующем кластере</li>
 * <li>"API_name" - версия API</li>
 * <li>"method block" - название группы методов</li>
 * <li>"method name" - название метода</li>
 * <li>"get params" - параметры метода GET для запроса</li>
 * </ul>
 * <p>Любые текстовые параметры необходимо передавать в кодировке UTF-8</p>
 *
 * @author Sergey Divin
 */
public final class WgApiUrlBuilder implements Cloneable {

    private RequestScheme wgScheme;
    private Cluster cluster;
    private Region region;
    private String server;
    private String apiName;
    private String applicationID;
    private String methodBlock;
    private String methodName;
    private List<String> fields;
    private Map<String, Object> query;

    /**
     * Конструктор строителя URL для Wargaming.net Public API
     */
    public WgApiUrlBuilder() {
        this.wgScheme = RequestScheme.HTTPS;
        this.fields = new ArrayList<>();
        this.query = new TreeMap<>();
    }

    /**
     * Конструктор реализует клонирование обьекта строителя URL для Wargaming.net Public API
     *
     * @param clone Старый строитель URL для Wargaming.net Public API
     */
    private WgApiUrlBuilder(WgApiUrlBuilder clone) {
        this.wgScheme = clone.wgScheme;
        this.cluster = clone.cluster;
        this.region = clone.region;
        this.server = clone.server;
        this.apiName = clone.apiName;
        this.methodBlock = clone.methodBlock;
        this.methodName = clone.methodName;
        this.applicationID = clone.applicationID;
        this.fields = new ArrayList<>(clone.fields);
        this.query = new TreeMap<>(clone.query);
    }

    /**
     * Метод возвращает обьект строителя URL для Wargaming.net Public API с указанной схемой запроса
     * <p>
     * Для предотвращения использования access_token злоумышленниками запросы, которые содержат access_token, следует отправлять по защищённому соединению HTTPS.
     * </p>
     *
     * @param wgScheme Схема запроса
     * @return Обьект строителя URL для Wargaming.net Public API с указанной схемой запроса
     */
    public WgApiUrlBuilder withScheme(RequestScheme wgScheme) {
        WgApiUrlBuilder builder = this.clone();
        builder.wgScheme = wgScheme;
        return builder;
    }

    /**
     * Метод возвращает обьект строителя URL для Wargaming.net Public API с указанным кластером
     *
     * @param cluster Кластер Wargaming.net Public API
     * @return Обьект строителя URL для Wargaming.net Public API с указанным кластером
     */
    public WgApiUrlBuilder withCluster(Cluster cluster) {
        WgApiUrlBuilder builder = this.clone();
        builder.cluster = cluster;
        return builder;
    }

    /**
     * Метод возвращает обьект строителя URL для Wargaming.net Public API с указанным регионом кластера
     *
     * @param region Регион кластера Wargaming.net Public API
     * @return Обьект строителя URL для Wargaming.net Public API с указанным регионом кластера
     */
    public WgApiUrlBuilder withRegion(Region region) {
        WgApiUrlBuilder builder = this.clone();
        builder.region = region;
        return builder;
    }

    /**
     * Метод возвращает обьект строителя URL для Wargaming.net Public API с указанным названием группы методов и названием метода
     *
     * @param methodBlock Название группы методов
     * @param methodName  Название метода
     * @return Обьект строителя URL для Wargaming.net Public API с указанным названием группы методов и названием метода
     */
    public WgApiUrlBuilder withMethod(String methodBlock, String methodName) {
        WgApiUrlBuilder builder = this.clone();
        builder.methodBlock = methodBlock;
        builder.methodName = methodName;
        return builder;
    }

    /**
     * Метод возвращает обьект строителя URL для Wargaming.net Public API с указанным идентификатором приложения
     *
     * @param applicationID Идентификатор приложения
     * @return Обьект строителя URL для Wargaming.net Public API с указанным идентификатором приложения
     */
    public WgApiUrlBuilder withApplicationID(String applicationID) {
        this.applicationID = applicationID;
        return this.withQuery("application_id", applicationID);
    }

    /**
     * Метод возвращает обьект строителя URL для Wargaming.net Public API с указанным ключем доступа к приватным данным
     *
     * @param accessToken Ключ доступа к приватным данным
     * @return Обьект строителя URL для Wargaming.net Public API с указанным ключем доступа к приватным данным
     */
    public WgApiUrlBuilder withAccessToken(String accessToken) {
        return this.withQuery("access_token", accessToken);
    }

    /**
     * Метод возвращает обьект строителя URL для Wargaming.net Public API с указанным списком полей
     * <p>При добавлении старые значения удаляются</p>
     *
     * @param fields Список полей
     * @return Обьект строителя URL для Wargaming.net Public API с указанным списком полей
     */
    public WgApiUrlBuilder withFields(List<String> fields) {
        WgApiUrlBuilder builder = this.clone();
        if (fields != null) {
            builder.fields = fields;
        }
        return builder;
    }

    /**
     * Метод возвращает обьект строителя URL для Wargaming.net Public API с указанным полем
     *
     * @param field Поле
     * @return Обьект строителя URL для Wargaming.net Public API с указанным полем
     */
    public WgApiUrlBuilder withField(String field) {
        WgApiUrlBuilder builder = this.clone();
        builder.fields.add(field);
        return builder;
    }

    /**
     * Метод возвращает обьект строителя URL для Wargaming.net Public API с указанным массивом параметров
     * <p>При добавлении старые значения удаляются</p>
     *
     * @param queryArray Массив параметров
     * @return Обьект строителя URL для Wargaming.net Public API с указанным массивом параметров
     */
    public WgApiUrlBuilder withQueryArray(Map<String, Object> queryArray) {
        WgApiUrlBuilder builder = this.clone();
        if (queryArray != null) {
            builder.query = queryArray;
        }
        return builder;
    }

    /**
     * Метод возвращает обьект строителя URL для Wargaming.net Public API с указанным названием и значением параметра
     *
     * @param key   Название параметра
     * @param value Значение параметра
     * @return Обьект строителя URL для Wargaming.net Public API с указанным названием и значением параметра
     */
    public WgApiUrlBuilder withQuery(String key, Object value) {
        WgApiUrlBuilder builder = this.clone();
        builder.query.put(key, value);
        return builder;
    }

    /**
     * Метод возвращает HTTP-контент (переданные параметры)
     * <p>Используется для подготовки запроса методом POST</p>
     *
     * @return HTTP-контент (переданные параметры)
     */
    public HttpContent getHttpContent() {
        Map<String, Object> query = this.query;
        query.put("fields", fields);
        return new UrlEncodedContent(query);
    }

    /**
     * Метод возвращает путь URL из названиея группы методов и названием метода
     *
     * @return Путь URL из названиея группы методов и названием метода
     */
    private String getMethod() {
        return String.format("/%s/%s/", methodBlock, methodName);
    }

    /**
     * Метод строит URL для Wargaming.net Public API и возвращает в виде GenericUrl
     *
     * @return строит URL для Wargaming.net Public API и возвращает в виде GenericUrl
     * @throws WgApiClientException В случае, если построить Google URL builder не удалось
     */
    public GenericUrl build() throws WgApiClientException {

        if(applicationID == null) {
            throw new WgApiClientException(ExceptionCode.CLIENT_BUILD_URL_NULL_APP_ID);
        }

        GenericUrl url = new GenericUrl();

        try {
            buildScheme(url);
            buildNode(url);
            buildMethod(url);
            buildFields(url);
            buildQuery(url);
        } catch (WgApiClientException ex) {
            throw new WgApiClientException(ExceptionCode.CLIENT_BUILD_URL_FAILED, ex);
        }

        return url;
    }

    /**
     * Метод настраивает схему запроса в GenericUrl
     *
     * @param url Google URL builder
     */
    private void buildScheme(GenericUrl url) {
        url.setScheme(wgScheme.toString());
    }


    /**
     * Метод настраивает раздел (сревер) Wargaming.net Public API
     *
     * @param url Google URL builder
     * @throws WgApiClientException В случае, если не удалось построить раздел (сервер) Wargaming.net Public API по причинам,
     *                              если кластер или регион не указан, либо указан не верно
     */
    private void buildNode(GenericUrl url) throws WgApiClientException {
        try {
            if (!isEmpty(region)) {
                if (!isEmpty(cluster)) {
                    url.setHost(cluster.getServerByRegion(region));
                    url.appendRawPath(String.format((char) 47 + "%s", cluster.getApiName()));
                } else {
                    throw new WgApiClientException(ExceptionCode.CLIENT_BUILD_URL_NULL_CLUSTER);
                }
            } else {
                throw new WgApiClientException(ExceptionCode.CLIENT_BUILD_URL_NULL_REGION);
            }
        } catch (NullPointerException | WgApiClientException ex) {
            throw new WgApiClientException(ExceptionCode.CLIENT_BUILD_URL_NODE_FAILED, ex);
        }
    }

    /**
     * Метод настраивает метод-блок Wargaming.net Public API
     *
     * @param url Google URL builder
     * @throws WgApiClientException В случае, если метод-блок не установлен
     */
    private void buildMethod(GenericUrl url) throws WgApiClientException {
        if (!isEmpty(methodBlock)) {
            url.appendRawPath(getMethod());
        } else {
            throw new WgApiClientException(ExceptionCode.CLIENT_BUILD_URL_NULL_METHOD);
        }
    }

    /**
     * Метод настраивает параметр "fields"
     *
     * @param url Google URL builder
     */
    private void buildFields(GenericUrl url) {
        if (!fields.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            fields.forEach(field -> stringBuilder.append(String.format("%s,", field)));
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            url.set("fields", stringBuilder.toString());
        }
    }

    /**
     * Метод настраивает дополнительные параметры
     *
     * @param url Google URL builder
     */
    private void buildQuery(GenericUrl url) {
        if (!query.isEmpty()) {
            query.forEach(url::set);
        }
    }

    @Override
    public String toString() {
        try {
            return build().toString();
        } catch (WgApiClientException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Метод возвращает клон строителя URL для Wargaming.net Public API
     *
     * @return Клон строителя URL для Wargaming.net Public API
     */
    @Override
    protected WgApiUrlBuilder clone() {
        return new WgApiUrlBuilder(this);
    }

    /**
     * Метод для проверки строковых параметров на отсутсвие
     *
     * @param value Обьект
     * @return В случае если обьект пуст возвращается true
     */
    private boolean isEmpty(Object value) {
        return value == null || value.toString().length() == 0;
    }
}
