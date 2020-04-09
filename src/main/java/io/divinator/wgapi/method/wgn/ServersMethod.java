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

package io.divinator.wgapi.method.wgn;

import com.google.gson.reflect.TypeToken;
import io.divinator.wgapi.client.AbstractMethodBlock;
import io.divinator.wgapi.client.Cluster;
import io.divinator.wgapi.client.WgApiClientException;
import io.divinator.wgapi.client.WgApiUrlBuilder;
import io.divinator.wgapi.entity.JsonResponse;
import io.divinator.wgapi.entity.wgn.servers.GameServer;

import java.util.List;
import java.util.Map;

/**
 * Класс описывет Метод-блок для получения информации об игровых серверах Wargaming.
 *
 * @author Sergey Divin
 */
public class ServersMethod extends AbstractMethodBlock {

    private final static String METHOD_BLOCK = "servers";

    /**
     * Метод возвращает обьект строителя URL для Wargaming.net Public API используемого AbstractHttpClient
     *
     * @return Обьект строителя URL для Wargaming.net Public API используемого AbstractHttpClient
     */
    @Override
    protected WgApiUrlBuilder getWgApiUrlBuilder() {
        return super.getWgApiUrlBuilder().withCluster(Cluster.WARGAMING);
    }

    /**
     * Метод возвращает количество пользователей онлайн на игровых серверах Wargaming.
     * <p>Переданные переменные в метод могут быть NULL</p>
     *
     * @param fields   Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                 Для исключения поля используется знак «-» перед названием поля.
     *                 Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
     * @param game     Идентификатор игры. Максимальное ограничение: 100. Допустимые значения:
     *                 <p>
     *                 "wotb" — World of Tanks Blitz
     *                 "wot" — World of Tanks
     *                 "wows" — World of Warships
     * @param language Язык локализации. По умолчанию: "ru". Допустимые значения:
     *                 <p>
     *                 "en" — English
     *                 "ru" — Русский (используется по умолчанию)
     *                 "pl" — Polski
     *                 "de" — Deutsch
     *                 "fr" — Français
     *                 "es" — Español
     *                 "zh-cn" — 简体中文
     *                 "zh-tw" — 繁體中文
     *                 "tr" — Türkçe
     *                 "cs" — Čeština
     *                 "th" — ไทย
     *                 "vi" — Tiếng Việt
     *                 "ko" — 한국어
     * @return Количество пользователей онлайн на игровых серверах Wargaming
     * @throws WgApiClientException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом GET
     */
    public Map<String, List<GameServer>> getGameServers(List<String> fields, String game, String language) throws WgApiClientException {
        WgApiUrlBuilder urlBuilder = getWgApiUrlBuilder()
                .withMethod(METHOD_BLOCK, "info")
                .withFields(fields)
                .withQuery("game", game)
                .withQuery("language", language);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, List<GameServer>>>>() {
        }).getData();
    }
}
