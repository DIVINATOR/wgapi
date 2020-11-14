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
 * Интерфейс описывает Wargaming.net Public API — набор общедоступных методов API, которые предоставляют доступ к
 * проектам Wargaming.net, включая игровой контент, статистику игроков, данные энциклопедии и многое другое.
 */
public interface WgApi {

    /**
     * Метод возвращает объект группы методов Wargaming.net Public API по указанному классу группы методов.
     *
     * @param classMethodBlock Класс группы методов в пакете {@link io.divinator.wgapi.method}
     * @param <T>              Тип объекта группы методов
     * @return Объект группы методов Wargaming.net Public API
     * @throws WgApiException В случае, если произошла ошибка создания объекта, либо не найден публичный конструктор
     *                        по умолчанию, либо не удалось встроить клиент в метод-блок Wargaming.net Public API
     */
    <T extends AbstractMethodBlock> T getMethodBlock(Class<T> classMethodBlock) throws WgApiException;

    /**
     * Метод возвращает текущую версию клиента WgApi
     *
     * @return Версия клиента WgApi
     */
    String getClientVersion();

    /**
     * Метод устанавливает таймаут HTTP-соединения.
     *
     * @param connectTimeOut таймаут HTTP-соединения
     */
    void setConnectTimeOut(int connectTimeOut);

    /**
     * Метод возвращает таймаут соединения в миллисекундах.
     *
     * @return Таймаут соединения в миллисекундах
     */
    int getConnectTimeout();
}
