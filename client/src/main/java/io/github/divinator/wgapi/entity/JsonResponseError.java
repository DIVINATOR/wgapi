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

package io.github.divinator.wgapi.entity;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.client.ErrorCode;

/**
 * Класс описывает сущность "ошибку в запросе" в ответе от Wargaming.net Public API
 *
 * @author Sergey Divin
 */
public final class JsonResponseError {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("field")
    private String field;

    @SerializedName("value")
    private String value;

    /**
     * Метод возвращает код ошибки
     *
     * @return Код ошибки
     */
    public int getCode() {
        return code;
    }

    /**
     * Метод возвращает сообщение об ошибке
     *
     * @return Сообщение об ошибке
     */
    public String getMessage() {
        return prepareMessage(message);
    }

    /**
     * Метод возвращает имя поля в котором произошла ошибка
     *
     * @return Имя поля в котором произошла ошибка
     */
    public String getField() {
        return field;
    }

    /**
     * Метод возвращает переданное значение в случае ошибки
     *
     * @return Переданное значение в случае ошибки
     */
    public String getValue() {
        return value;
    }

    /**
     * Метод возвращает код ошибки полученный от Wargaming.net Public API
     *
     * @return Код ошибки полученный от Wargaming.net Public API
     */
    public ErrorCode getExceptionCode() {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (errorCode.getCode() == getCode()) {
                if (errorCode.name().contains(getMessage())) {
                    return errorCode;
                }
            }
        }

        return ErrorCode.CLIENT_RESPONSE_ERROR_FAILED;
    }

    /**
     * Метод приводит сообщение об ошибке к стандартному
     *
     * @param message Сообщение об ошибке
     * @return Стандартизированное сообщение об ошибке
     */
    private String prepareMessage(String message) {
        return message.replace(getField().toUpperCase(), "FIELD");
    }
}
