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
import io.divinator.wgapi.entity.wgn.wargag.Category;
import io.divinator.wgapi.entity.wgn.wargag.Comment;
import io.divinator.wgapi.entity.wgn.wargag.InformationContent;
import io.divinator.wgapi.entity.wgn.wargag.Tag;

import java.util.List;

/**
 * Класс описывает Метод-блок для получения информации об контенте Wargag.
 *
 * @author Sergey Divin
 */
public class WargagMethod extends AbstractMethodBlock {

    private final static String METHOD_BLOCK = "wargag";

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
     * <h2>Метод возвращает информацию о контенте.</h2>
     *
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"access_token"</b> - Ключ доступа к личным данным аккаунта пользователя;
     *                      можно получить при помощи метода авторизации; действителен в течение определённого времени</li>
     *                      <li><b>"account_id"</b> - Идентификатор автора публикации</li>
     *                      <li><b>"category_id"</b> - Идентификатор категории контента</li>
     *                      <li><b>"content_id"</b> - Идентификатор контента. При указании данного параметра другие
     *                      переданные параметры игнорируются.</li>
     *                      <li><b>"date"</b> - Дата публикации</li>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.</li>
     *                      <li><b>"order_by"</b> - Сортировка. По умолчанию: "-date". Допустимые значения:
     *                      <ul>
     *                          <li>"date" — по дате публикации</li>
     *                          <li>"-date" — по дате публикации в обратном порядке (используется по умолчанию)</li>
     *                          <li>"rating" — по значению рейтинга</li>
     *                          <li>"-rating" — по значению рейтинга в обратном порядке</li>
     *                      </ul>
     *                      </li>
     *                      <li><b>page_no</b> - Номер страницы результатов</li>
     *                      <li><b>rating_threshold</b> - Пороговое значение рейтинга публикации</li>
     *                      <li><b>tag_id</b> - Идентификатор тега</li>
     *                      <li><b>type</b> - Тип контента. Допустимые значения:
     *                          <ul>
     *                              <li><i>"quote"</i> — тип контента «Цитата»</li>
     *                              <li><i>"video"</i> — тип контента «Видео»</li>
     *                              <li><i>"picture"</i> — тип контента «Картинки»</li>
     *                          </ul>
     *                      </li>
     *                   </ul>
     * @return Информацию о контенте
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом POST
     */
    public JsonResponse<List<InformationContent>> getContent(Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "content")
                .withParameters(parameters);

        return super.post(urlBuilder, new TypeToken<JsonResponse<List<InformationContent>>>() {
        });
    }

    /**
     * <h2>Метод осуществляет текстовый поиск по контенту.</h2>
     *
     * @param q          Текст для поиска по контенту. Минимальная длина: 3 символа без учёта регистра.
     *                   <p>Обязательный параметр.</p>
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"access_token"</b> - Ключ доступа к личным данным аккаунта пользователя;
     *                      можно получить при помощи метода авторизации; действителен в течение определённого времени</li>
     *                      <li><b>"category_id"</b> - Идентификатор категории контента.</li>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.</li>
     *                      <li><b>"rating_threshold"</b> - Пороговое значение рейтинга публикации.</li>
     *                      <li><b>"tag_id"</b> - Идентификатор тега.</li>
     *                      <li><b>"type"</b> - Тип контента. Допустимые значения:
     *                          <ul>
     *                              <li><i>"quote"</i> — тип контента «Цитата»</li>
     *                              <li><i>"video"</i> — тип контента «Видео»</li>
     *                              <li><i>"picture"</i> — тип контента «Картинки»</li>
     *                          </ul>
     *                      </li>
     *                   </ul>
     * @return Результат текстового поиска по контенту
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом POST
     */
    public JsonResponse<List<InformationContent>> findContent(String q, Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "search")
                .withQuery("q", q)
                .withParameters(parameters);

        return super.post(urlBuilder, new TypeToken<JsonResponse<List<InformationContent>>>() {
        });
    }

    /**
     * <h2>Метод возвращает комментарии к контенту.</h2>
     *
     * @param contentId  Идентификатор публикации
     *                   <p>Обязательный параметр.
     *                   <p><br/>
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.</li>
     *                      <li><b>"page_no"</b> - Номер страницы результатов</li>
     *                   </ul>
     * @return Комментарии к контенту
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<List<Comment>> getComments(Parameter contentId, Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "comments")
                .withParameter(contentId)
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<List<Comment>>>() {
        });
    }

    /**
     * <h2>Метод возвращает информацию о категориях контента.</h2>
     *
     * @param type       Тип контента. Допустимые значения:
     *                   <p>
     *                   "video" — тип контента «Видео»
     *                   "picture" — тип контента «Картинки»
     *                   <p>Обязательный параметр.
     *                   <p><br/>
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"category_id"</b> - Идентификатор категории контента.</li>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.</li>
     *                   </ul>
     * @return Информация о категориях контента.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<List<Category>> getCategories(String type, Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "categories")
                .withQuery("type", type)
                .withParameters(parameters);
        return super.get(urlBuilder, new TypeToken<JsonResponse<List<Category>>>() {
        });
    }

    /**
     * <h2>Метод возвращает информацию о тегах к контенту.</h2>
     *
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.</li>
     *                      <li><b>"tag_id"</b> - Идентификатор тега.</li>
     *                   </ul>
     * @return Информация о тегах к контенту
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */

    public JsonResponse<List<Tag>> getTags(Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "tags")
                .withParameters(parameters);
        return super.get(urlBuilder, new TypeToken<JsonResponse<List<Tag>>>() {
        });
    }

    /**
     * <h2>Метод позволяет оценивать контент при наличии действующего access_token для указанного аккаунта.</h2>
     *
     * @param accessToken Ключ доступа к личным данным аккаунта пользователя; можно получить при помощи метода
     *                    авторизации; действителен в течение определённого времени.
     *                    <p>Обязательный параметр.
     * @param contentId   Идентификатор публикации.
     *                    <p>Обязательный параметр.
     * @param rating      Оценка. Допустимые значения:
     *                    <p>
     *                    "up" — Увеличить рейтинг контента
     *                    "down" — Уменьшить рейтинг контента
     *                    <p>Обязательный параметр.
     * @return Оцененный контент
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом POST
     */
    public JsonResponse<List<InformationContent>> rate(String accessToken, String contentId, String rating) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "rate")
                .withAccessToken(accessToken)
                .withQuery("content_id", contentId)
                .withQuery("rating", rating);
        return super.post(urlBuilder, new TypeToken<JsonResponse<List<InformationContent>>>() {
        });
    }

    /**
     * <h2>Метод позволяет добавлять комментарии при наличии действующего access_token для указанного аккаунта.</h2>
     * <h3>Добавление комментариев доступно только для контента типов picture и video.</h3>
     *
     * @param accessToken Ключ доступа к личным данным аккаунта пользователя; можно получить при помощи метода
     *                    авторизации; действителен в течение определённого времени
     *                    <p>Обязательный параметр.
     * @param contentId   Идентификатор публикации
     *                    <p>Обязательный параметр.
     * @param text        Текст комментария. Максимальная длина: 1000 символов. Mаксимальная длина: 1000.
     *                    <p>Обязательный параметр.
     * @return Список комментариев
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом POST
     */
    public JsonResponse<List<Comment>> addComment(String accessToken, String contentId, String text) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "newcomment")
                .withAccessToken(accessToken)
                .withQuery("content_id", contentId)
                .withQuery("text", text);
        return super.post(urlBuilder, new TypeToken<JsonResponse<List<Comment>>>() {
        });
    }

    /**
     * <h2>Метод позволяет удалять комментарии при наличии действующего access_token для указанного аккаунта.</h2>
     *
     * @param accessToken Ключ доступа к личным данным аккаунта пользователя; можно получить при помощи метода авторизации; действителен в течение определённого времени
     *                    <p>Обязательный параметр.
     * @param commentId   Идентификатор комментария
     *                    <p>Обязательный параметр.
     * @return Список комментариев
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом POST
     */
    public JsonResponse<List<Comment>> removeComment(String accessToken, Parameter commentId) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "deletecomment")
                .withAccessToken(accessToken)
                .withParameter(commentId);
        return super.post(urlBuilder, new TypeToken<JsonResponse<List<Comment>>>() {
        });
    }
}
