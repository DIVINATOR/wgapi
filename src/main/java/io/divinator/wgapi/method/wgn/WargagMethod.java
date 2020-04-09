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
import io.divinator.wgapi.entity.wgn.wargag.Category;
import io.divinator.wgapi.entity.wgn.wargag.Comment;
import io.divinator.wgapi.entity.wgn.wargag.InformationContent;
import io.divinator.wgapi.entity.wgn.wargag.Tag;

import java.util.List;

/**
 * Класс описывет Метод-блок для получения информации об контенте Wargag.
 *
 * @author Sergey Divin
 */
public class WargagMethod extends AbstractMethodBlock {

    private final static String METHOD_BLOCK = "wargag";

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
     * Метод возвращает информацию о контенте.
     *
     * @param accessToken     Ключ доступа к личным данным аккаунта пользователя; можно получить при помощи метода
     *                        авторизации; действителен в течение определённого времени
     * @param accountId       Идентификатор автора публикации
     * @param categoryId      Идентификатор категории контента
     * @param contentId       Идентификатор контента. При указании данного параметра другие переданные параметры игнорируются.
     * @param date            Дата публикации
     * @param fields          Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                        Для исключения поля используется знак «-» перед названием поля. Если параметр не указан,
     *                        возвращаются все поля. Максимальное ограничение: 100.
     * @param orderBy         Сортировка. По умолчанию: "-date". Допустимые значения:
     *                        <p>
     *                        "date" — по дате публикации
     *                        "-date" — по дате публикации в обратном порядке (используется по умолчанию)
     *                        "rating" — по значению рейтинга
     *                        "-rating" — по значению рейтинга в обратном порядке
     * @param pageNo          Номер страницы результатов
     * @param ratingThreshold Пороговое значение рейтинга публикации
     * @param tagId           Идентификатор тега
     * @param type            Тип контента. Допустимые значения:
     *                        <p>
     *                        "quote" — тип контента «Цитата»
     *                        "video" — тип контента «Видео»
     *                        "picture" — тип контента «Картинки»
     * @return Информацию о контенте
     * @throws WgApiClientException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом POST
     */
    public List<InformationContent> getContent(String accessToken, String accountId, String categoryId, String contentId,
                                               String date, List<String> fields, String orderBy, int pageNo,
                                               String ratingThreshold, String tagId, String type) throws WgApiClientException {

        WgApiUrlBuilder urlBuilder = getWgApiUrlBuilder()
                .withMethod(METHOD_BLOCK, "content")
                .withAccessToken(accessToken)
                .withQuery("account_id", accountId)
                .withQuery("category_id", categoryId)
                .withQuery("content_id", contentId)
                .withQuery("date", date)
                .withFields(fields)
                .withQuery("order_by", orderBy)
                .withQuery("page_no", pageNo)
                .withQuery("rating_threshold", ratingThreshold)
                .withQuery("tag_id", tagId)
                .withQuery("type", type);

        return super.post(urlBuilder, new TypeToken<JsonResponse<List<InformationContent>>>() {
        }).getData();
    }

    /**
     * Метод осуществляет текстовый поиск по контенту.
     *
     * <p>Переданные переменные, кроме "q", могут быть NULL</p>
     *
     * @param q               Текст для поиска по контенту. Минимальная длина: 3 символа без учёта регистра.
     *                        <p>Обязательный параметр.</p>
     * @param accessToken     Ключ доступа к личным данным аккаунта пользователя; можно получить при помощи метода
     *                        авторизации; действителен в течение определённого времени
     * @param categoryId      Идентификатор категории контента
     * @param fields          Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                        Для исключения поля используется знак «-» перед названием поля.
     *                        Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
     * @param ratingThreshold Пороговое значение рейтинга публикации
     * @param tagId           Идентификатор тега
     * @param type            Тип контента. Допустимые значения:
     *                        <p>
     *                        "quote" — тип контента «Цитата»
     *                        "video" — тип контента «Видео»
     *                        "picture" — тип контента «Картинки»
     * @return Результат текстового поиска по контенту
     * @throws WgApiClientException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом POST
     */
    public List<InformationContent> findContent(String q, String accessToken, String categoryId, List<String> fields,
                                                String ratingThreshold, String tagId, String type) throws WgApiClientException {
        WgApiUrlBuilder urlBuilder = getWgApiUrlBuilder()
                .withMethod(METHOD_BLOCK, "search")
                .withQuery("q", q)
                .withAccessToken(accessToken)
                .withQuery("category_id", categoryId)
                .withFields(fields)
                .withQuery("rating_threshold", ratingThreshold)
                .withQuery("tag_id", tagId)
                .withQuery("type", type);

        return super.post(urlBuilder, new TypeToken<JsonResponse<List<InformationContent>>>() {
        }).getData();
    }

    /**
     * Метод возвращает комментарии к контенту.
     *
     * @param contentId Идентификатор публикации
     *                  <p>Обязательный параметр.
     * @param fields    Поля ответа. Поля разделяются запятыми.
     *                  Вложенные поля разделяются точками. Для исключения поля используется знак «-» перед названием поля.
     *                  Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
     * @param pageNo    Номер страницы результатов
     * @return Комментарии к контенту
     * @throws WgApiClientException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом GET
     */
    public List<Comment> getComments(String contentId, List<String> fields, int pageNo) throws WgApiClientException {
        WgApiUrlBuilder urlBuilder = getWgApiUrlBuilder()
                .withMethod(METHOD_BLOCK, "comments")
                .withQuery("content_id", contentId)
                .withFields(fields)
                .withQuery("page_no", pageNo);

        return super.get(urlBuilder, new TypeToken<JsonResponse<List<Comment>>>() {
        }).getData();
    }

    /**
     * Метод возвращает информацию о категориях контента.
     *
     * @param type       Тип контента. Допустимые значения:
     *                   <p>
     *                   "video" — тип контента «Видео»
     *                   "picture" — тип контента «Картинки»
     *                   <p>Обязательный параметр.
     * @param categoryId Идентификатор категории контента
     * @param fields     Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                   Для исключения поля используется знак «-» перед названием поля.
     *                   Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
     * @return Информация о категориях контента.
     * @throws WgApiClientException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом GET
     */
    public List<Category> getCategories(String type, String categoryId, List<String> fields) throws WgApiClientException {
        WgApiUrlBuilder urlBuilder = getWgApiUrlBuilder()
                .withMethod(METHOD_BLOCK, "categories")
                .withQuery("type", type)
                .withQuery("category_id", categoryId)
                .withFields(fields);
        return super.get(urlBuilder, new TypeToken<JsonResponse<List<Category>>>() {
        }).getData();
    }

    /**
     * Метод возвращает информацию о тегах к контенту.
     *
     * @param fields Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *               Для исключения поля используется знак «-» перед названием поля.
     *               Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
     * @param tagId  Идентификатор тега
     * @return Информация о тегах к контенту
     * @throws WgApiClientException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом GET
     */
    public List<Tag> getTags(List<String> fields, String tagId) throws WgApiClientException {
        WgApiUrlBuilder urlBuilder = getWgApiUrlBuilder()
                .withMethod(METHOD_BLOCK, "tags")
                .withFields(fields)
                .withQuery("tag_id", tagId);
        return super.get(urlBuilder, new TypeToken<JsonResponse<List<Tag>>>() {
        }).getData();
    }

    /**
     * Метод позволяет оценивать контент при наличии действующего access_token для указанного аккаунта.
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
     * @throws WgApiClientException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом POST
     */
    public List<InformationContent> rate(String accessToken, String contentId, String rating) throws WgApiClientException {
        WgApiUrlBuilder urlBuilder = getWgApiUrlBuilder()
                .withMethod(METHOD_BLOCK, "rate")
                .withAccessToken(accessToken)
                .withQuery("content_id", contentId)
                .withQuery("rating", rating);
        return super.post(urlBuilder, new TypeToken<JsonResponse<List<InformationContent>>>() {
        }).getData();
    }

    /**
     * Метод позволяет добавлять комментарии при наличии действующего access_token для указанного аккаунта.
     * Добавление комментариев доступно только для контента типов picture и video.
     *
     * @param accessToken Ключ доступа к личным данным аккаунта пользователя; можно получить при помощи метода
     *                    авторизации; действителен в течение определённого времени
     *                    <p>Обязательный параметр.
     * @param contentId   Идентификатор публикации
     *                    <p>Обязательный параметр.
     * @param text        Текст комментария. Максимальная длина: 1000 символов. Mаксимальная длина: 1000.
     *                    <p>Обязательный параметр.
     * @return Список комментариев
     * @throws WgApiClientException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом POST
     */
    public List<Comment> addComment(String accessToken, String contentId, String text) throws WgApiClientException {
        WgApiUrlBuilder urlBuilder = getWgApiUrlBuilder()
                .withMethod(METHOD_BLOCK, "newcomment")
                .withAccessToken(accessToken)
                .withQuery("content_id", contentId)
                .withQuery("text", text);
        return super.post(urlBuilder, new TypeToken<JsonResponse<List<Comment>>>() {
        }).getData();
    }

    /**
     * Метод позволяет удалять комментарии при наличии действующего access_token для указанного аккаунта.
     *
     * @param accessToken Ключ доступа к личным данным аккаунта пользователя; можно получить при помощи метода авторизации; действителен в течение определённого времени
     *                    <p>Обязательный параметр.
     * @param commentId   Идентификатор комментария
     *                    <p>Обязательный параметр.
     * @return Список комментариев
     * @throws WgApiClientException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом POST
     */
    public List<Comment> removeComment(String accessToken, String commentId) throws WgApiClientException {
        WgApiUrlBuilder urlBuilder = getWgApiUrlBuilder()
                .withMethod(METHOD_BLOCK, "deletecomment")
                .withAccessToken(accessToken)
                .withQuery("comment_id", commentId);
        return super.post(urlBuilder, new TypeToken<JsonResponse<List<Comment>>>() {
        }).getData();
    }
}
