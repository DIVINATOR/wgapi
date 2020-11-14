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
import io.divinator.wgapi.client.*;
import io.divinator.wgapi.entity.JsonResponse;
import io.divinator.wgapi.entity.wgn.wgtv.Tags;
import io.divinator.wgapi.entity.wgn.wgtv.Vehicle;
import io.divinator.wgapi.entity.wgn.wgtv.Video;

import java.util.List;

/**
 * Класс описывает Метод-блок для получения информации об WGTV Wargaming.
 *
 * @author Sergey Divin
 */
public class WgtvMethod extends AbstractMethodBlock {

    private final static String METHOD_BLOCK = "wgtv";

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
     * <h2>Метод возвращает списки игровых проектов, категорий и программ.</h2>
     *
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.</li>
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
     * @return Списки игровых проектов, категорий и программ
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом GET
     */
    public JsonResponse<Tags> getTags(Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "tags")
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Tags>>() {
        });
    }

    /**
     * <h2>Метод возвращает список видео, отфильтрованный по указанным параметрам.</h2>
     *
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"category_id"</b> - Идентификатор категории контента. Максимальное ограничение: 100.</li>
     *                      <li><b>"date_from" - Не старше указанной даты.</b></li>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.</li>
     *                      <li><b>"important" - Отметка «Важное». Минимальное значение: 0. Максимальное значение: 1.</b></li>
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
     *                      <li><b>"limit"</b> - Количество возвращаемых записей (может вернуться меньше записей,
     *                      но не больше 1000). Если переданный лимит превышает 1000, тогда автоматически выставляется
     *                      лимит в 100 (по умолчанию).</li>
     *                      <li><b>"page_no"</b> - Номер страницы результатов. По умолчанию: 1. Минимальное значение: 1.</li>
     *                      <li><b>"program_id"</b> - Идентификатор программы. Максимальное ограничение: 100.</li>
     *                      <li><b>"project_id"</b> - Идентификатор игрового проекта. Максимальное ограничение: 100.</li>
     *                      <li><b>"q"</b> - Текст для поиска по названию.</li>
     *                      <li><b>"vehicle_id"</b> - Идентификатор техники. Максимальное ограничение: 100.</li>
     *                      <li><b>"video_id"</b> - Идентификатор видео на Youtube. Максимальное ограничение: 100.</li>
     *                   </ul>
     * @return Список видео, отфильтрованный по указанным параметрам.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом GET
     */
    public JsonResponse<List<Video>> getVideos(Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "videos")
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<List<Video>>>() {
        });
    }

    /**
     * <h2>Метод возвращает отфильтрованный по играм список техники, о которой есть видео.</h2>
     *
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"category_id"</b> - Идентификатор категории контента. Максимальное ограничение: 100.</li>
     *                      <li><b>"program_id"</b> - Идентификатор программы. Максимальное ограничение: 100.</li>
     *                      <li><b>"project_id"</b> - Идентификатор игрового проекта. Максимальное ограничение: 100.</li>
     *                   </ul>
     * @return Отфильтрованный по играм список техники, о которой есть видео.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом GET
     */
    public JsonResponse<Vehicle> getVehiclesVideo(Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "vehicles")
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Vehicle>>() {
        });
    }
}
