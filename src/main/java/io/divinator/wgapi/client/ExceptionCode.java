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

/**
 * Перечисление используемых кодов исключений
 *
 * @author Sergey Divin
 */
public enum ExceptionCode {
    /**
     * Ошибка создания URL
     */
    CLIENT_BUILD_URL_FAILED(1000, "URL creation error"),

    /**
     * Сбой сборки узла публичного API Wargaming.net
     */
    CLIENT_BUILD_URL_NODE_FAILED(1001, "Wargaming.net Public API node build fails"),

    /**
     * Не указан публичный API-кластер Wargaming.net
     */
    CLIENT_BUILD_URL_NULL_CLUSTER(1002, "No Wargaming.net Public API cluster specified"),

    /**
     * Не указан регион публичного API Wargaming.net
     */
    CLIENT_BUILD_URL_NULL_REGION(1003, "No Wargaming.net Public API region specified"),

    /**
     * Не указан метод-блок публичного API Wargaming.net
     */
    CLIENT_BUILD_URL_NULL_METHOD(1004, "No Wargaming.net Public API method-block specified"),

    /**
     * Не указан идентификатор приложения публичного API Wargaming.net
     */
    CLIENT_BUILD_URL_NULL_APP_ID(1005, "No Wargaming.net Public API application id specified"),

    /**
     * Reflection не удалось создать экземпляр объекта метод-блока
     */
    CLIENT_REFLECTION_INSTANCE_METHOD_FAILED(1100, "Reflection failed to create an instance of a method-block object"),

    /**
     * При Reflection объекта метод-блока конструктор по умолчанию не найден
     */
    CLIENT_REFLECTION_INSTANCE_METHOD_NO_CONSTRUCTOR(1101, "When reflecting a method block object, the default constructor was not found"),

    /**
     * Не удалось встроить клиента в метод-блок
     */
    CLIENT_REFLECTION_EMBED_FAILED(1102, "Failed to embed the client in the block method"),

    /**
     * Ошибка при подготовке HTTP-запроса
     */
    CLIENT_REQUEST_FAILED(1200, "Error preparing HTTP request"),

    /**
     * Ошибка отправки HTTP-запроса методом GET
     */
    CLIENT_REQUEST_GET_FAILED(1201, "Error sending HTTP request by GET method"),

    /**
     * Ошибка отправки асинхронного HTTP-запроса методом GET
     */
    CLIENT_REQUEST_GET_ASYNC_FAILED(1202, "Error sending asynchronous HTTP request by GET method"),

    /**
     * Ошибка отправки HTTP-запроса методом POST
     */
    CLIENT_REQUEST_POST_FAILED(1203, "Error sending HTTP request using POST method"),

    /**
     * Ошибка отправки асинхронного HTTP-запроса методом POST
     */
    CLIENT_REQUEST_POST_ASYNC_FAILED(1204, "Error sending asynchronous HTTP request using POST method"),

    /**
     * Получена неизвестная ошибка от публичного API Wargaming.net
     */
    CLIENT_RESPONSE_ERROR_FAILED(1301, "Unknown error received from Wargaming.net Public API"),

    /**
     * Сбой разбора данных
     */
    CLIENT_PARSING_FAILED(1400, "Data parsing failed"),

    /**
     * Запрос успешно обработан
     */
    OK(200, "Request processed successfully"),

    /**
     * Обязательное поле '% FIELD%' не заполнено
     */
    FIELD_NOT_SPECIFIED(402, "Required field \"%FIELD%\" is not filled"),

    /**
     * Информация не найдена
     */
    FIELD_NOT_FOUND(404, "Information not found"),

    /**
     * Указан неверный метод API
     */
    METHOD_NOT_FOUND(404, "Invalid API method specified"),

    /**
     * Указанный метод API отключен
     */
    METHOD_DISABLED(405, "The specified API method is disabled"),

    /**
     * Превышен лимит передаваемых идентификаторов в поле «FIELD»
     */
    FIELD_LIST_LIMIT_EXCEEDED(407, "The limit of transferred identifiers in the \"%FIELD%\" field is exceeded"),

    /**
     * Приложение заблокировано администрацией
     */
    APPLICATION_IS_BLOCKED(407, "Application blocked by administration"),

    /**
     * Неверное значение для параметра 'FIELD%'
     */
    INVALID_FIELD(407, "Invalid value for parameter \"%FIELD%\""),

    /**
     * Неверный идентификатор приложения
     */
    INVALID_APPLICATION_ID(407, "Invalid application id"),

    /**
     * Неверный IP-адрес для серверного приложения
     */
    INVALID_IP_ADDRESS(407, "Invalid IP address for server application"),

    /**
     * Превышены квоты
     */
    REQUEST_LIMIT_EXCEEDED(407, "Quota limits exceeded"),

    /**
     * Недостаточная длина параметра поиска. Допустимое значение зависит от параметра типа
     */
    NOT_ENOUGH_SEARCH_LENGTH(407, "Insufficient search parameter length. The valid value depends on the type parameter"),

    /**
     * Источник данных недоступен
     */
    SOURCE_NOT_AVAILABLE(504, "Data source not available"),

    ;

    private int code;
    private String title;

    ExceptionCode(int code, String title) {
        this.code = code;
        this.title = title;
    }

    /**
     * Метод возвращает код исключения
     *
     * @return Код исключения
     */
    public int getCode() {
        return code;
    }

    /**
     * Метод возвращает описание кода исключения
     *
     * @return Описание кода исключения
     */
    public String getTitle() {
        return title;
    }

    /**
     * Метод устанавливает значение поля %FIELD%
     *
     * @param field значение поля %FIELD%
     */
    public void setField(String field) {
        title = getTitle().replace("%FIELD%", field);
    }
}
