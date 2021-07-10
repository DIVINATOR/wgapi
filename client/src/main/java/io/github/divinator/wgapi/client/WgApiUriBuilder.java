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

package io.github.divinator.wgapi.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс описывает объект строителя URI для Wargaming.net Public API
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
public final class WgApiUriBuilder implements Cloneable {

    private final Log log = LogFactory.getLog(getClass());

    private static final String QUERY_APPLICATION_ID = "application_id";
    private static final String QUERY_FIELDS = "fields";
    private static final String QUERY_ACCESS_TOKEN = "access_token";

    private RequestScheme wgScheme;
    private Cluster cluster;
    private Region region;
    private String server;
    private String apiName;
    private String applicationID;
    private String methodBlock;
    private String methodName;
    private List<String> fields;
    private Map<String, String> query;
    private List<NameValuePair> params;

    /**
     * Конструктор строителя URL для Wargaming.net Public API
     */
    public WgApiUriBuilder() {
        this.wgScheme = RequestScheme.HTTPS;
        this.fields = new ArrayList<>();
        this.query = new TreeMap<>();
        this.params = new ArrayList<>();
    }

    /**
     * Конструктор реализует клонирование объекта строителя URL для Wargaming.net Public API
     *
     * @param clone Старый строитель URL для Wargaming.net Public API
     */
    private WgApiUriBuilder(WgApiUriBuilder clone) {
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
        this.params = new ArrayList<>(clone.params);
    }

    /**
     * Метод возвращает HTTP-контент (переданные параметры)
     * <p>Используется для подготовки запроса методом POST</p>
     *
     * @return HTTP-контент (переданные параметры)
     */
    public List<NameValuePair> getHttpContent() {
//        List<NameValuePair> httpContent = new ArrayList<>();
//        Map<String, String> query = this.query;
//
//        if (!fields.isEmpty()) {
//            query.put(QUERY_FIELDS, getFieldsToString());
//        }
//
//        query.forEach((key, value) -> httpContent.add(new BasicNameValuePair(key, value)));
//
//        return httpContent;
        return params;
    }

    /**
     * Метод возвращает объект строителя URL для Wargaming.net Public API с указанной схемой запроса
     * <p>
     * Для предотвращения использования access_token злоумышленниками запросы, которые содержат access_token, следует отправлять по защищённому соединению HTTPS.
     * </p>
     *
     * @param wgScheme Схема запроса
     * @return Объект строителя URL для Wargaming.net Public API с указанной схемой запроса
     */
    public WgApiUriBuilder withScheme(RequestScheme wgScheme) {
        WgApiUriBuilder builder = this.clone();
        builder.wgScheme = wgScheme;
        return builder;
    }

    /**
     * Метод возвращает объект строителя URL для Wargaming.net Public API с указанным кластером
     *
     * @param cluster Кластер Wargaming.net Public API
     * @return объект строителя URL для Wargaming.net Public API с указанным кластером
     */
    public WgApiUriBuilder withCluster(Cluster cluster) {
        WgApiUriBuilder builder = this.clone();
        builder.cluster = cluster;
        return builder;
    }

    /**
     * Метод возвращает объект строителя URL для Wargaming.net Public API с указанным регионом кластера
     *
     * @param region Регион кластера Wargaming.net Public API
     * @return объект строителя URL для Wargaming.net Public API с указанным регионом кластера
     */
    public WgApiUriBuilder withRegion(Region region) {
        WgApiUriBuilder builder = this.clone();
        builder.region = region;
        return builder;
    }

    /**
     * Метод возвращает объект строителя URL для Wargaming.net Public API с указанным названием группы методов и названием метода
     *
     * @param methodBlock Название группы методов
     * @param methodName  Название метода
     * @return объект строителя URL для Wargaming.net Public API с указанным названием группы методов и названием метода
     */
    public WgApiUriBuilder withMethod(String methodBlock, String methodName) {
        WgApiUriBuilder builder = this.clone();
        builder.methodBlock = methodBlock;
        builder.methodName = methodName;
        return builder;
    }

    /**
     * Метод возвращает объект строителя URL для Wargaming.net Public API с указанным идентификатором приложения
     *
     * @param applicationID Идентификатор приложения
     * @return объект строителя URL для Wargaming.net Public API с указанным идентификатором приложения
     */
    public WgApiUriBuilder withApplicationID(String applicationID) {
//        return this.withQuery(QUERY_APPLICATION_ID, applicationID);
        return this.withParameter(new Parameter("application_id", applicationID));
    }

    /**
     * Метод возвращает объект строителя URL для Wargaming.net Public API с указанным ключем доступа к приватным данным
     *
     * @param accessToken Ключ доступа к приватным данным
     * @return объект строителя URL для Wargaming.net Public API с указанным ключем доступа к приватным данным
     */
    public WgApiUriBuilder withAccessToken(String accessToken) {
//        return this.withQuery(QUERY_ACCESS_TOKEN, accessToken);
        return this.withParameter(new Parameter("access_token", accessToken));
    }

    /**
     * Метод возвращает объект строителя URL для Wargaming.net Public API с указанным параметром.
     *
     * @param parameters Список параметров
     * @return Объект строителя URL для Wargaming.net Public API с указанным названием и значением параметра
     */
    public WgApiUriBuilder withParameters(Parameter... parameters) {
        WgApiUriBuilder builder = this.clone();
        if (parameters.length > 0) {
            builder.params.addAll(Arrays.asList(parameters));
        }
        return builder;
    }

    public WgApiUriBuilder withParameter(Parameter parameter) {
        WgApiUriBuilder builder = this.clone();
        builder.params.add(parameter);
        return builder;
    }

    /**
     * Метод возвращает объект строителя URL для Wargaming.net Public API с указанным списком полей
     * <p>При добавлении старые значения удаляются</p>
     * @deprecated use {{@link #withParameters(Parameter...)}}
     *
     * @param fields Список полей
     * @return объект строителя URL для Wargaming.net Public API с указанным списком полей
     */
    @Deprecated
    public WgApiUriBuilder withFields(List<String> fields) {
        WgApiUriBuilder builder = this.clone();
        if (fields != null) {
            if (!fields.isEmpty()) {
                builder.fields = fields;
            }
        }
        return builder;
    }

    /**
     * Метод возвращает объект строителя URL для Wargaming.net Public API с указанным полем
     *
     * @deprecated use {{@link #withParameter(Parameter)}}
     * @param field Поле
     * @return объект строителя URL для Wargaming.net Public API с указанным полем
     */
    @Deprecated
    public WgApiUriBuilder withField(String field) {
        WgApiUriBuilder builder = this.clone();
        builder.fields.add(field);
        return builder;
    }

    /**
     * Метод возвращает объект строителя URL для Wargaming.net Public API с указанным массивом параметров
     * <p>При добавлении старые значения удаляются</p>
     *
     * @deprecated use {{@link #withParameters(Parameter...)}}
     * @param queryArray Массив параметров
     * @return объект строителя URL для Wargaming.net Public API с указанным массивом параметров
     */
    @Deprecated
    public WgApiUriBuilder withQueryArray(Map<String, String> queryArray) {
        WgApiUriBuilder builder = this.clone();
        if (queryArray != null) {
            if (!queryArray.isEmpty()) {
                builder.query = queryArray;
            }
        }
        return builder;
    }

    /**
     * Метод возвращает объект строителя URL для Wargaming.net Public API с указанным названием и значением параметра
     *
     * @deprecated use {{@link #withParameter(Parameter)}}
     * @param key   Название параметра
     * @param value Значение параметра
     * @return Объект строителя URL для Wargaming.net Public API с указанным названием и значением параметра
     */
    @Deprecated
    public WgApiUriBuilder withQuery(String key, String value) {
        WgApiUriBuilder builder = this.clone();
        if (value != null) {
            builder.query.put(key, value);
        }
        return builder;
    }

    /**
     * Метод строит URL для Wargaming.net Public API и возвращает в виде GenericUrl
     *
     * @return строит URL для Wargaming.net Public API и возвращает в виде GenericUrl
     * @throws WgApiException В случае, если построить {@link URIBuilder} не удалось
     */
    public URI build() throws WgApiException {
        URIBuilder uriBuilder = new URIBuilder();

        try {
            buildScheme(uriBuilder);
            buildNode(uriBuilder);
            buildMethod(uriBuilder);
            //buildFields(uriBuilder);
            //buildQuery(uriBuilder);
            buildParams(uriBuilder);

            if (log.isDebugEnabled()) {
                log.debug(String.format("URI [%s] build.", uriBuilder));
            }

            return uriBuilder.build();
        } catch (WgApiException | URISyntaxException ex) {
            throw new WgApiException(ErrorCode.CLIENT_BUILD_URL_FAILED, ex);
        }
    }

    /**
     * Метод настраивает схему запроса в {@link URIBuilder}
     *
     * @param uriBuilder {@link URIBuilder}
     */
    private void buildScheme(URIBuilder uriBuilder) {
        uriBuilder.setScheme(wgScheme.name().toLowerCase());
    }


    /**
     * Метод настраивает раздел (сервер) Wargaming.net Public API
     *
     * @param uriBuilder {@link URIBuilder}
     * @throws WgApiException В случае, если не удалось построить раздел (сервер) Wargaming.net Public API по причинам,
     *                        если кластер или регион не указан, либо указан не верно
     */
    private void buildNode(URIBuilder uriBuilder) throws WgApiException {
        try {
            if (!isEmpty(region)) {
                if (!isEmpty(cluster)) {
                    uriBuilder.setHost(cluster.getServerByRegion(region));
                    uriBuilder.setPath(cluster.getApiName());
                } else {
                    throw new WgApiException(ErrorCode.CLIENT_BUILD_URL_NULL_CLUSTER);
                }
            } else {
                throw new WgApiException(ErrorCode.CLIENT_BUILD_URL_NULL_REGION);
            }
        } catch (WgApiException ex) {
            throw new WgApiException(ErrorCode.CLIENT_BUILD_URL_NODE_FAILED, ex);
        }
    }

    /**
     * Метод настраивает метод-блок Wargaming.net Public API
     *
     * @param uriBuilder {@link URIBuilder}
     * @throws WgApiException В случае, если метод-блок не установлен
     */
    private void buildMethod(URIBuilder uriBuilder) throws WgApiException {
        if (!isEmpty(methodBlock)) {
            List<String> pathSegments = uriBuilder.getPathSegments();
            pathSegments.add(methodBlock);
            pathSegments.add(methodName);
            pathSegments.add("");
            uriBuilder.setPathSegments(pathSegments);
        } else {
            throw new WgApiException(ErrorCode.CLIENT_BUILD_URL_NULL_METHOD);
        }
    }

    /**
     * Метод настраивает параметр "fields"
     *
     * @deprecated use {{@link #buildParams(URIBuilder)}}
     * @param uriBuilder {@link URIBuilder}
     */
    @Deprecated
    private void buildFields(URIBuilder uriBuilder) {
        if (!fields.isEmpty()) {
            uriBuilder.setParameter(QUERY_FIELDS, getFieldsToString());
        }
    }

    /**
     * Метод настраивает дополнительные параметры
     *
     * @deprecated use {{@link #buildParams(URIBuilder)}}
     * @param uriBuilder Google URL builder
     */
    @Deprecated
    private void buildQuery(URIBuilder uriBuilder) throws WgApiException {
        if (!query.isEmpty()) {
            query.forEach(uriBuilder::setParameter);
        }

        if (!query.containsKey(QUERY_APPLICATION_ID))
            throw new WgApiException(ErrorCode.CLIENT_BUILD_URL_NULL_APP_ID);
    }

    /**
     * Метод настраивает дополнительные параметры типа {@link NameValuePair}.
     *
     * @param uriBuilder Google URL builder
     */
    private void buildParams(URIBuilder uriBuilder) {
        if(!params.isEmpty()) {
            // Fix.
            //List<NameValuePair> newParams = uriBuilder.getQueryParams();
            //newParams.addAll(params);
            uriBuilder.setParameters(params);
        }
    }

    @Override
    public String toString() {
        try {
            return build().toString();
        } catch (WgApiException e) {
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
    protected WgApiUriBuilder clone() {
        return new WgApiUriBuilder(this);
    }

    /**
     * Метод для проверки строковых параметров на отсутсвие
     *
     * @param value объект
     * @return В случае если объект пуст возвращается true
     */
    private boolean isEmpty(Object value) {
        return value == null || value.toString().length() == 0;
    }

    private String getFieldsToString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!fields.isEmpty()) {
            fields.forEach(field -> stringBuilder.append(String.format("%s,", field)));
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    public String getParamsToString() {
        return params.stream()
                .map(nameValuePair -> String.format("%s=%s", nameValuePair.getName(), nameValuePair.getValue()))
                .collect(Collectors.joining("&"));
    }
}
