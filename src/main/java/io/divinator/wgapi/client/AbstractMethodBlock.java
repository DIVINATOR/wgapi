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

import com.google.gson.reflect.TypeToken;
import io.divinator.wgapi.entity.JsonResponse;

import java.io.IOException;

/**
 * Абстрактный класс, который описывает "Метод-блок".
 * <p>Для использования "метод-блоков" Wargaming.net Public API, последние должны расширяться данным класом</p>
 *
 * @author Sergey Divin
 */
public abstract class AbstractMethodBlock {

    private AbstractHttpClient client;

    /**
     * Метод возвращает обьект строителя URL для Wargaming.net Public API используемого AbstractHttpClient
     *
     * @return Обьект строителя URL для Wargaming.net Public API используемого AbstractHttpClient
     */
    protected WgApiUrlBuilder getWgApiUrlBuilder() {
        return client.getUrlBuilder();
    }

    /**
     * Метод отправлет http-запрос методом GET и получает данные от Wargaming.net Public API
     *
     * @param url       Строитель URL для получения данных от Wargaming.net Public API
     * @param typeToken Универсальный тип. Вынуждает клиентов создавать подкласс этого класса,
     *                  который позволяет получать информацию о типе во время выполнения.
     * @param <T>       Тип данных после парсинга.
     * @return Обьект данных типа "T"
     * @throws WgApiClientException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом GET
     */
    protected <T extends JsonResponse> T get(WgApiUrlBuilder url, TypeToken<T> typeToken) throws WgApiClientException {
        try {
            return (T) analizeJson((JsonResponse) client.get(url).parseAs(typeToken.getType()));
        } catch (IOException | WgApiClientException e) {
            throw new WgApiClientException(ExceptionCode.CLIENT_PARSING_FAILED, e);
        }
    }

    /**
     * Метод отправлет http-запрос методом POST и получает данные от Wargaming.net Public API
     *
     * @param url       Строитель URL для получения данных от Wargaming.net Public API
     * @param typeToken Универсальный тип. Вынуждает клиентов создавать подкласс этого класса,
     *                  который позволяет получать информацию о типе во время выполнения.
     * @param <T>       Тип данных после парсинга.
     * @return Обьект данных типа "Т"
     * @throws WgApiClientException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом POST
     */
    protected <T extends JsonResponse> T post(WgApiUrlBuilder url, TypeToken<T> typeToken) throws WgApiClientException {
        try {
            return (T) analizeJson((JsonResponse) client.post(url).parseAs(typeToken.getType()));
        } catch (IOException | WgApiClientException e) {
            throw new WgApiClientException(ExceptionCode.CLIENT_PARSING_FAILED, e);
        }
    }

    /**
     * Метод анализирует Http-ответ от Wargaming.net Public API на наличие ошибки
     *
     * @param response Http-ответ до анализа
     * @return Http-ответ после анализа
     * @throws WgApiClientException В случае если найдена ошибка
     */
    private JsonResponse analizeJson(JsonResponse response) throws WgApiClientException {

        if (!response.isOk()) {
            throw new WgApiClientException(response.getError());
        }

        return response;
    }
}
