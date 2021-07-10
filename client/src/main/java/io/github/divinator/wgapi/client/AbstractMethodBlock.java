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

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import io.github.divinator.wgapi.entity.JsonResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Абстрактный класс, который описывает "Метод-блок".
 * <p>Для использования "метод-блоков" Wargaming.net Public API, последние должны расширяться данным класом</p>
 *
 * @author Sergey Divin
 */
public abstract class AbstractMethodBlock {

    private final Log log = LogFactory.getLog(getClass());

    private AbstractHttpClient client;

    /**
     * Метод возвращает объект строителя URL для Wargaming.net Public API используемого AbstractHttpClient
     *
     * @return Объект строителя URL для Wargaming.net Public API используемого AbstractHttpClient
     */
    protected WgApiUriBuilder getWgApiUriBuilder() {
        return client.getWgApiUriBuilder();
    }

    /**
     * Метод отправлет http-запрос методом GET и получает данные от Wargaming.net Public API
     *
     * @param <T>       Тип данных после парсинга.
     * @param url       Строитель URL для получения данных от Wargaming.net Public API
     * @param typeToken Универсальный тип. Вынуждает клиентов создавать подкласс этого класса,
     *                  который позволяет получать информацию о типе во время выполнения.
     * @return Обьект данных типа "T"
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    protected <T extends JsonResponse> T get(WgApiUriBuilder url, TypeToken<T> typeToken) throws WgApiException {
        return parseHttpResponse(client.get(url), typeToken);
    }

    /**
     * Метод отправлет http-запрос методом POST и получает данные от Wargaming.net Public API
     *
     * @param url       Строитель URL для получения данных от Wargaming.net Public API
     * @param typeToken Универсальный тип. Вынуждает клиентов создавать подкласс этого класса,
     *                  который позволяет получать информацию о типе во время выполнения.
     * @param <T>       Тип данных после парсинга.
     * @return Обьект данных типа "Т"
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом POST
     */
    protected <T extends JsonResponse> T post(WgApiUriBuilder url, TypeToken<T> typeToken) throws WgApiException {
        return parseHttpResponse(client.post(url), typeToken);
    }

    /**
     * Метод анализирует Http-ответ от Wargaming.net Public API на наличие ошибки
     *
     * @param response Http-ответ до анализа
     * @return Http-ответ после анализа в виде объекта {@link JsonResponse}
     * @throws WgApiException В случае если ошибки разбора ответа от Wargaming.net Public API
     */

    private <T extends JsonResponse> T parseHttpResponse(HttpResponse response, TypeToken<T> typeToken) throws WgApiException {
        try {
            String json = EntityUtils.toString(response.getEntity());

            if (log.isDebugEnabled()) {
                log.debug(String.format("[RESPONSE BODY]: %s", json));
            }

            return new GsonBuilder()
                    .create()
                    .fromJson(json, typeToken.getType());

        } catch (IOException e) {
            throw new WgApiException(ErrorCode.CLIENT_PARSING_FAILED);
        } finally {
            log.debug(String.format("Response body converted to %s object.", JsonResponse.class));
        }
    }
}
