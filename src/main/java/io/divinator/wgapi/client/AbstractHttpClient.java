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

import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.ObjectParser;

import java.io.IOException;
import java.util.concurrent.Future;

/**
 * Абстрактный класс, который описывает функционал клиента для передачи GET, POST запросов к Wargaming.net Public API
 *
 * @author Sergey Divin
 */
public abstract class AbstractHttpClient extends AbstractClient {

    private ObjectParser objectParser;

    /**
     * Метод возвращает транспорт HTTP-соединения
     *
     * @return Транспорт HTTP-соединения
     */
    abstract HttpTransport getHttpTransport();

    /**
     * Метод возвращает таймаут соединения в миллисекундах
     *
     * @return Таймаут соединения в миллисекундах
     */
    abstract int getConnectTimeout();

    /**
     * Метод возвращает обьект строителя URL для Wargaming.net Public API
     *
     * @return Обьект строителя URL для Wargaming.net Public API
     */
    abstract WgApiUrlBuilder getUrlBuilder();

    /**
     * Метод устанавливает парсер для преобразования ответа от Wargaming.net Public API в Обьект
     *
     * @param objectParser Парсер для преобразования ответа от Wargaming.net Public API в Обьект
     */
    void setObjectParser(ObjectParser objectParser) {
        this.objectParser = objectParser;
    }

    /**
     * Метод выполняет HTTP-запрос методом GET и возвращает HTTP-ответ
     *
     * @param url Строитель URL для получения данных от Wargaming.net Public API
     * @return HTTP-ответ от WargamingAPI
     * @throws WgApiClientException В случае, если возникла ошибка отправки HTTP-запроса методом GET
     */
    HttpResponse get(WgApiUrlBuilder url) throws WgApiClientException {
        try {
            return request(RequestType.GET, url, null).execute();
        } catch (IOException | WgApiClientException e) {
            throw new WgApiClientException(ExceptionCode.CLIENT_REQUEST_GET_FAILED, e);
        }
    }


    /**
     * Метод выполняет HTTP-запрос методом POST и возвращает HTTP-ответ
     *
     * @param url Строитель URL для получения данных от Wargaming.net Public API
     * @return HTTP-ответ от WargamingAPI
     * @throws WgApiClientException В случае, если возникла ошибка отправки HTTP-запроса методом POST
     */
    HttpResponse post(WgApiUrlBuilder url) throws WgApiClientException {
        try {
            return request(RequestType.POST, url, url.getHttpContent()).execute();
        } catch (IOException | WgApiClientException e) {
            throw new WgApiClientException(ExceptionCode.CLIENT_REQUEST_POST_FAILED, e);
        }
    }

    /**
     * Метод ассинхронно выполняет HTTP-запрос методом GET и возвращает HTTP-ответ
     *
     * @param url Строитель URL для получения данных от Wargaming.net Public API
     * @return HTTP-ответ от WargamingAPI
     * @throws WgApiClientException В случае, если возникла ошибка отправки асинхронного HTTP-запроса методом GET
     */
    Future<HttpResponse> getAsync(WgApiUrlBuilder url) throws WgApiClientException {
        try {
            return request(RequestType.GET, url, null).executeAsync();
        } catch (WgApiClientException e) {
            throw new WgApiClientException(ExceptionCode.CLIENT_REQUEST_GET_ASYNC_FAILED, e);
        }
    }

    /**
     * Метод ассинхронно выполняет HTTP-запрос методом POST и возвращает HTTP-ответ
     *
     * @param url Строитель URL для получения данных от Wargaming.net Public API
     * @return HTTP-ответ от WargamingAPI
     * @throws WgApiClientException В случае, если возникла ошибка отправки асинхронного HTTP-запроса методом POST
     */
    Future<HttpResponse> postAsync(WgApiUrlBuilder url) throws WgApiClientException {
        try {
            return request(RequestType.POST, url, url.getHttpContent()).executeAsync();
        } catch (WgApiClientException e) {
            throw new WgApiClientException(ExceptionCode.CLIENT_REQUEST_POST_ASYNC_FAILED, e);
        }
    }

    /**
     * Метод подготавливает HTTP-запрос к Wargaming.net Public API
     *
     * @param requestType Тип запроса (WgApi.RequestType)
     * @param url         Строитель URL для получения данных от Wargaming.net Public API
     * @param content     Содержимое HTTP-запроса
     * @return подготовленный HTTP-запрос
     * @throws WgApiClientException В случае, если возникла ошибка подготовки HTTP-запроса
     */
    private HttpRequest request(RequestType requestType, WgApiUrlBuilder url, HttpContent content) throws WgApiClientException {
        try {
            return getHttpTransport()
                    .createRequestFactory()
                    .buildRequest(requestType.name(), url.build(), content)
                    .setConnectTimeout(getConnectTimeout())
                    .setParser(objectParser);

        } catch (IOException e) {
            throw new WgApiClientException(ExceptionCode.CLIENT_REQUEST_FAILED);
        }
    }
}
