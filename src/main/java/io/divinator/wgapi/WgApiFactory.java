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

package io.divinator.wgapi;

import io.divinator.wgapi.client.*;

/**
 * Конструктор создает объект Wargaming.net Public API
 */
public class WgApiFactory {

    private static WgApiFactory factory;
    private WgApi wgApi;

    // Приватный конструктор
    private WgApiFactory() {

    }

    /**
     * Метод инициализирует объект класса WgApiFactory.
     * В случае если ранее объект класса WgApiFactory был инициализирован, то возвращается именно он
     *
     * @return Объект класса WgApiFactory
     */
    public static WgApiFactory getCurrentFactory() {
        if (factory == null) {
            factory = new WgApiFactory();
        }

        return factory;
    }

    /**
     * Метод возвращает ранее созданный объект Wargaming.net Public API.
     *
     * @return Объект Wargaming.net Public API
     * @throws WgApiException В случае если ранее обьект Wargaming.net Public API не был создан
     */
    public WgApi getWgApi() throws WgApiException {

        if (wgApi == null) {
            throw new WgApiException(ErrorCode.CLIENT_NO_INIT);
        }

        return wgApi;
    }

    /**
     * Метод возвращает объект Wargaming.net Public API с указанным id приложения.
     * <p>
     * По умолчанию указан регион RU
     *
     * @param applicationId id приложения
     * @return Объект Wargaming.net Public API
     */
    public static WgApi getWgApi(String applicationId) {
        return getCurrentFactory().newInstance(Region.RU, applicationId);
    }

    /**
     * Метод возвращает объект Wargaming.net Public API с указанным регионом и id приложения.
     *
     * @param region        регион приложения
     * @param applicationId id приложения
     * @return Объект Wargaming.net Public API
     */
    public static WgApi getWgApi(Region region, String applicationId) {
        return getCurrentFactory().newInstance(region, applicationId);
    }

    /**
     * Метод возвращает новый объект Wargaming.net Public API с указанным регионом и id приложения.
     *
     * @param region        регион приложения
     * @param applicationId id приложения
     * @return Объект Wargaming.net Public API
     */
    private WgApi newInstance(Region region, String applicationId) {
        wgApi = new WgApiClient(
                new WgApiUriBuilder()
                        .withRegion(region)
                        .withApplicationID(applicationId)
        );

        return wgApi;
    }
}
