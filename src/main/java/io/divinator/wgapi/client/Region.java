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
 * Перечисление поддерживаемых регионов Wargaming.net Public API для запросов
 *
 * @author Sergey Divin
 */
public enum Region {

    /**
     * Россия
     */
    RU("ru"),

    /**
     * Европа
     */
    EU("eu"),

    /**
     * США
     */
    NA("na"),

    /**
     * Азия
     */
    ASIA("asia"),

    /**
     * Playstation
     */
    PS4("ps4"),

    /**
     * X-Box
     */
    XBOX("xbox");

    private String name;

    /**
     * Конструктор региона для запроса к Wargaming.net Public API
     *
     * @param name Имя региона Wargaming.net Public API
     */
    Region(String name) {
        this.name = name;
    }

    /**
     * Метод возвращает имя региона Wargaming.net Public API
     *
     * @return Имя региона Wargaming.net Public API
     */
    public String getName() {
        return name;
    }

    /**
     * Метод для сравнения регионов запроса
     *
     * @param region Сравниваемый регион
     * @return true в случае успеха, false в случае неудачи
     */
    public boolean equals(Region region) {
        return (region != null) && this.getName().equals(region.getName());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
