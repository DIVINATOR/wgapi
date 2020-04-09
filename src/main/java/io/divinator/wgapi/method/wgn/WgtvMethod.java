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
import io.divinator.wgapi.entity.wgn.wgtv.Tags;
import io.divinator.wgapi.entity.wgn.wgtv.Vehicle;
import io.divinator.wgapi.entity.wgn.wgtv.Video;

import java.util.List;

/**
 * Класс описывет Метод-блок для получения информации об WGTV Wargaming.
 *
 * @author Sergey Divin
 */
public class WgtvMethod extends AbstractMethodBlock {

    private final static String METHOD_BLOCK = "wgtv";

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
     * Метод возвращает списки игровых проектов, категорий и программ.
     *
     * @param fields   Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                 Для исключения поля используется знак «-» перед названием поля.
     *                 Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
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
     * @return Списки игровых проектов, категорий и программ
     * @throws WgApiClientException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом GET
     */
    public Tags getTags(List<String> fields, String language) throws WgApiClientException {
        WgApiUrlBuilder urlBuilder = getWgApiUrlBuilder()
                .withMethod(METHOD_BLOCK, "tags")
                .withFields(fields)
                .withQuery("language", language);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Tags>>() {
        }).getData();
    }

    /**
     * Метод возвращает список видео, отфильтрованный по указанным параметрам.
     *
     * @param dateFrom   Не старше указанной даты
     * @param categoryId Идентификатор категории контента. Максимальное ограничение: 100.
     * @param fields     Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                   Для исключения поля используется знак «-» перед названием поля.
     *                   Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
     * @param important  Отметка «Важное».
     * @param language   Язык локализации. По умолчанию: "ru". Допустимые значения:
     *                   <p>
     *                   "en" — English
     *                   "ru" — Русский (используется по умолчанию)
     *                   "pl" — Polski
     *                   "de" — Deutsch
     *                   "fr" — Français
     *                   "es" — Español
     *                   "zh-cn" — 简体中文
     *                   "zh-tw" — 繁體中文
     *                   "tr" — Türkçe
     *                   "cs" — Čeština
     *                   "th" — ไทย
     *                   "vi" — Tiếng Việt
     *                   "ko" — 한국어
     * @param limit      Количество возвращаемых записей (может вернуться меньше записей, но не больше 1000).
     *                   Если переданный лимит превышает 1000, тогда автоматически выставляется лимит в 100 (по умолчанию).
     * @param pageNo     Номер страницы результатов. По умолчанию: 1. Минимальное значение: 1.
     * @param programId  Идентификатор программы. Максимальное ограничение: 100.
     * @param projectId  Идентификатор игрового проекта. Максимальное ограничение: 100.
     * @param q          Текст для поиска по названию
     * @param vehicleId  Идентификатор техники. Максимальное ограничение: 100.
     * @param videoId    Идентификатор видео на Youtube. Максимальное ограничение: 100.
     * @return Список видео, отфильтрованный по указанным параметрам.
     * @throws WgApiClientException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом GET
     */
    public List<Video> getVideos(String categoryId, String dateFrom, List<String> fields, String important,
                                 String language, int limit, int pageNo, String programId, String projectId,
                                 String q, String vehicleId, String videoId) throws WgApiClientException {
        WgApiUrlBuilder urlBuilder = getWgApiUrlBuilder()
                .withMethod(METHOD_BLOCK, "videos")
                .withQuery("category_id", categoryId)
                .withQuery("date_from", dateFrom)
                .withFields(fields)
                .withQuery("important", important)
                .withQuery("language", language)
                .withQuery("limit", limit)
                .withQuery("page_no", pageNo)
                .withQuery("program_id", programId)
                .withQuery("project_id", projectId)
                .withQuery("q", q)
                .withQuery("vehicle_id", vehicleId)
                .withQuery("video_id", videoId);

        return super.get(urlBuilder, new TypeToken<JsonResponse<List<Video>>>() {
        }).getData();
    }

    /**
     * Метод возвращает отфильтрованный по играм список техники, о которой есть видео.
     *
     * @param categoryId Идентификатор категории контента. Максимальное ограничение: 100.
     * @param programId  Идентификатор программы. Максимальное ограничение: 100.
     * @param projectId  Идентификатор игрового проекта. Максимальное ограничение: 100.
     * @return Отфильтрованный по играм список техники, о которой есть видео.
     * @throws WgApiClientException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом GET
     */
    public Vehicle getVehiclesVideo(String categoryId, String programId, String projectId) throws WgApiClientException {
        WgApiUrlBuilder urlBuilder = getWgApiUrlBuilder()
                .withMethod(METHOD_BLOCK, "vehicles")
                .withQuery("category_id", categoryId)
                .withQuery("program_id", programId)
                .withQuery("project_id", projectId);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Vehicle>>() {
        }).getData();
    }
}
