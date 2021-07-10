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

package io.github.divinator.wgapi.method.wgn;

import com.google.gson.reflect.TypeToken;
import io.github.divinator.wgapi.client.*;
import io.github.divinator.wgapi.entity.JsonResponse;
import io.github.divinator.wgapi.entity.wgn.servers.GameServer;

import java.util.List;
import java.util.Map;

/**
 * Класс описывает Метод-блок для получения информации об игровых серверах Wargaming.
 *
 * @author Sergey Divin
 */
public class ServersMethod extends AbstractMethodBlock {

    private final static String METHOD_BLOCK = "servers";

    /**
     * Метод возвращает объект строителя URL для Wargaming.net Public API используемого AbstractHttpClient
     *
     * @return Объект строителя URL для Wargaming.net Public API используемого AbstractHttpClient
     */
    @Override
    protected WgApiUriBuilder getWgApiUriBuilder() {
        return super.getWgApiUriBuilder().withCluster(Cluster.WARGAMING);
    }

    /**
     * <h2>Метод возвращает количество пользователей онлайн на игровых серверах Wargaming.</h2>
     *
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.</li>
     *                      <li><b>"game"</b> - Название игры, для которой производится поиск игрока.
     *                      Если параметр не указан, поиск выполняется среди известных игр.
     *                      Максимальное ограничение: 10. Допустимые значения:
     *                      <ul>
     *                          <li>"wotb" — World of Tanks Blitz</li>
     *                          <li>"wot" — World of Tanks</li>
     *                          <li>"wows" — World of Warships</li>
     *                      </ul>
     *                      </li>
     *                      <li><b>language</b> - Язык локализации. По умолчанию: "ru". Допустимые значения:
     *                          <ul>
     *                              <li><i>"en"</i> — English</li>
     *                              <li><i>"ru"</i> — Русский (используется по умолчанию)</li>
     *                              <li><i>"pl"</i> — Polski</li>
     *                              <li><i>"de"</i> — Deutsch</li>
     *                              <li><i>"fr"</i> — Français</li>
     *                              <li><i>"es"</i> — Español</li>
     *                              <li><i>"zh-cn"</i> — 简体中文</li>
     *                              <li><i>"zh-tw"</i> — 繁體中文</li>
     *                              <li><i>"tr"</i> — Türkçe</li>
     *                              <li><i>"cs"</i> — Čeština</li>
     *                              <li><i>"th"</i> — ไทย</li>
     *                              <li><i>"vi"</i> — Tiếng Việt</li>
     *                              <li><i>"ko"</i> — 한국어</li>
     *                          </ul>
     *                      </li>
     *                   </ul>
     * @return Количество пользователей онлайн на игровых серверах Wargaming
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом GET
     */

    public JsonResponse<Map<String, List<GameServer>>> getGameServers(Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "info")
                .withParameters(parameters);
        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, List<GameServer>>>>() {
        });
    }
}
