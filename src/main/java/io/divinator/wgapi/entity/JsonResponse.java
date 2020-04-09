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

package io.divinator.wgapi.entity;

import com.google.api.client.util.Key;

/**
 * Класс описывает формат Json-ответа от Wargaming.net Public API
 *
 * @author Sergey Divin
 */
public final class JsonResponse<T> {

    @Key("status")
    private String status;

    @Key("meta")
    private JsonResponseMeta meta = new JsonResponseMeta();

    @Key("error")
    private JsonResponseError error = new JsonResponseError();

    @Key("data")
    private T data;

    /**
     * Метод проверяет наличие ошибки в ответе от WargamingAPI
     *
     * @return true - в случае если в ответе ошибки нет, false - если ошибка есть
     */
    public boolean isOk() {
        return status.equals("ok");
    }

    /**
     * Метод возвращает количество сущностей в поле data
     *
     * @return Количество сущностей в поле data
     */
    public int getMetaCount() {
        return meta.getCount();
    }


    public JsonResponseError getError() {
        return error;
    }

    /**
     * Метод возвращает мета-данные запроса
     *
     * @return Мета-данные запроса
     */
    public JsonResponseMeta getMeta() {
        return meta;
    }

    /**
     * Метод возвращает данные ответа от WargamingApi
     *
     * @return Данные ответа от WargamingApi
     */
    public T getData() {
        return data;
    }
}
