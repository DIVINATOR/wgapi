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
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Абстрактный класс, который описывает функционал клиента для передачи GET, POST запросов к Wargaming.net Public API
 *
 * @author Sergey Divin
 */
public abstract class AbstractHttpClient extends AbstractClient {

    private final Log log = LogFactory.getLog(getClass());

    /**
     * Метод возвращает транспорт HTTP-соединения
     *
     * @return Транспорт HTTP-соединения
     */
    protected abstract CloseableHttpClient getHttpClient();

    /**
     * Метод возвращает строителя конфигурации запроса HTTP-соединения.
     *
     * @return Строитель конфигурации запроса HTTP-соединения.
     */
    protected RequestConfig.Builder getDefaultRequestConfigBuilder() {
        return RequestConfig.custom()
                .setConnectTimeout(getProperties().getConnectionTimeout());
    }

    /**
     * Метод устанавливает настройки прокси для сроителя конфигурации запроса HTTP-соединения.
     *
     * @param builder Строитель конфигурации запроса HTTP-соединения.
     * @param proxy   Настройки прокси.
     * @return Строитель конфигурации запроса HTTP-соединения с настройками Прокси.
     */
    protected RequestConfig.Builder setProxyConfig(RequestConfig.Builder builder, HttpHost proxy) {
        return builder.setProxy(proxy);
    }

    /**
     * Метод возвращает конфигурацию HTTP-соединения.
     *
     * @return Конфигурация HTTP-соединения
     */
    protected RequestConfig getDefaultRequestConfig() {

        RequestConfig.Builder configBuilder = getDefaultRequestConfigBuilder();

        if (getProperties().getProxyHost() != null) {
            configBuilder = setProxyConfig(
                    configBuilder,
                    new HttpHost(getProperties().getProxyHost(), getProperties().getProxyPort())
            );

            log.debug(String.format(
                    "USE PROXY-HOST: \"%s:%s\"",
                    getProperties().getProxyHost(),
                    getProperties().getProxyPort()
                    )
            );
        }

        return configBuilder.build();
    }

    /**
     * Метод выполняет HTTP-запрос методом GET и возвращает HTTP-ответ.
     *
     * @param uriBuilder Строитель URL для получения данных от Wargaming.net Public API
     * @return HTTP-ответ от Wargaming.net Public API
     * @throws WgApiException В случае, если возникла ошибка отправки HTTP-запроса методом GET
     */
    protected HttpResponse get(WgApiUriBuilder uriBuilder) throws WgApiException {
        try {
            return request(new HttpGet(uriBuilder.build()));
        } catch (WgApiException e) {
            throw new WgApiException(ErrorCode.CLIENT_REQUEST_GET_FAILED, e);
        } finally {
            log.debug(String.format("SEND **GET** request: \"%s\".", uriBuilder));
        }
    }

    /**
     * Метод выполняет HTTP-запрос методом POST и возвращает HTTP-ответ.
     *
     * @param uriBuilder Строитель URL для получения данных от Wargaming.net Public API
     * @return HTTP-ответ от Wargaming.net Public API
     * @throws WgApiException В случае, если возникла ошибка отправки HTTP-запроса методом POST
     */
    protected HttpResponse post(WgApiUriBuilder uriBuilder) throws WgApiException {
        try {
            HttpPost httpPost = new HttpPost(uriBuilder.build());
            httpPost.setEntity(new UrlEncodedFormEntity(uriBuilder.getHttpContent()));
            return request(httpPost);
        } catch (WgApiException | UnsupportedEncodingException e) {
            throw new WgApiException(ErrorCode.CLIENT_REQUEST_POST_FAILED, e);
        } finally {
            try {
                log.debug(String.format(
                        "SEND **POST** request: \"%s\" with HTTP CONTENT: %s.",
                        uriBuilder,
                        new UrlEncodedFormEntity(uriBuilder.getHttpContent()))
                );
            } catch (UnsupportedEncodingException e) {
                log.warn(e);
            }
        }
    }

    /**
     * Метод отправляет HTTP-запрос к Wargaming.net Public API.
     *
     * @param requestType Тип запроса
     * @return HTTP ответ
     * @throws WgApiException В случае, если возникла ошибка отправки HTTP-запроса
     */
    private HttpResponse request(HttpUriRequest requestType) throws WgApiException {
        try {
            return getHttpClient().execute(requestType);
        } catch (IOException e) {
            throw new WgApiException(ErrorCode.CLIENT_REQUEST_FAILED);
        }
    }
}
