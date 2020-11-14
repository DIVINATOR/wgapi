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

import org.apache.http.NameValuePair;

import java.util.List;

/**
 * Класс описывает параметр запроса к Wargaming.net Public API
 */
public class Parameter implements NameValuePair {

    private final String key;
    private final String value;

    private static final String DELIMITER_FIELD = ",";

    /**
     * Конструктор класса описывающий создание параметра из ключа и строкового значения.
     *
     * @param key   Ключ параметра
     * @param value Значение параметра
     */
    public Parameter(String key, String value) {
        this.key = key.toLowerCase();
        this.value = value.toLowerCase();
    }

    /**
     * Конструктор класса описывающий создание параметра из ключа и списка значений.
     *
     * <p>
     * Поля разделяются запятыми. Вложенные поля разделяются точками.
     * Для исключения поля используется знак «-» перед названием поля.
     *
     * @param key   Ключ параметра
     * @param value Список значений параметра
     */
    public Parameter(String key, List<String> value) {
        this(key, String.join(DELIMITER_FIELD, value));
    }

    public Parameter(String key, boolean value) {
        this(key, value ? 1 : 0);
    }

    /**
     * Конструктор класса описывающий создание параметра из ключа и числового значения.
     *
     * @param key   Ключ параметра
     * @param value Список значений параметра
     */
    public Parameter(String key, Number value) {
        this(key, String.valueOf(value));
    }

    /**
     * Gets the name of this pair.
     *
     * @return the name of this pair, never {@code null}.
     */
    @Override
    public String getName() {
        return this.key;
    }

    /**
     * Gets the value of this pair.
     *
     * @return the value of this pair, may be {@code null}.
     */
    @Override
    public String getValue() {
        return this.value;
    }
}
