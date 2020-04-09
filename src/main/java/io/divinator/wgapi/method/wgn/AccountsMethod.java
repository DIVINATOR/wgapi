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
import io.divinator.wgapi.entity.wgn.accounts.Account;
import io.divinator.wgapi.entity.wgn.accounts.AccountInformation;

import java.util.List;
import java.util.Map;

/**
 * Класс описывет Метод-блок для получения информации об аккаунтах Wargaming
 *
 * @author Sergey Divin
 */
public class AccountsMethod extends AbstractMethodBlock {

    private final static String METHOD_BLOCK = "account";

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
     * Метод возвращает частичный список игроков, когда-либо заходивших в какую-либо игру Wargaming.
     * Список фильтруется по имени или начальным символам имени пользователя и сортируется по алфавиту.
     *
     * <p>Переданные переменные, кроме "search", могут быть NULL</p>
     *
     * @param search   Строка поиска по имени игрока. Вид поиска и минимальная длина строки поиска зависят от параметра type.
     *                 При использовании типа поиска exact можно перечислить несколько имён для поиска, разделив их запятыми.
     *                 Mаксимальная длина: 24.
     *                 <p>Обязательный параметр. Не должен быть NULL.
     * @param fields   Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                 Для исключения поля используется знак «-» перед названием поля.
     *                 Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
     * @param game     Название игры, для которой производится поиск игрока. Если параметр не указан, поиск выполняется среди известных игр.
     *                 Максимальное ограничение: 10. Допустимые значения:
     *                 "wotb" — World of Tanks Blitz
     *                 "wot" — World of Tanks
     *                 "wows" — World of Warships
     *                 "wowp" — World of Warplanes
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
     * @param limit    Количество возвращаемых записей (может вернуться меньше записей, но не больше 100).
     *                 Если переданный лимит превышает 100, тогда автоматически выставляется лимит в None (по умолчанию).
     * @param type     Тип поиска. По умолчанию: "startswith". Допустимые значения:
     *                 <p>
     *                 "startswith" — Поиск по начальной части имени игрока без учёта регистра.
     *                 Минимальная длина: 3 символа. Максимальная длина: 24 символа. (используется по умолчанию)
     *                 "exact" — Поиск по строгому соответствию имени игрока без учёта регистра.
     *                 Можно перечислить несколько имён для поиска (до 100 значений), разделив их запятыми.
     * @return Частичный список игроков, когда-либо заходивших в какую-либо игру Wargaming.
     * @throws WgApiClientException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом GET
     */
    public List<Account> getListAccounts(String search, List<String> fields, String game, String language, int limit, String type) throws WgApiClientException {

        WgApiUrlBuilder urlBuilder = getWgApiUrlBuilder()
                .withMethod(METHOD_BLOCK, "list")
                .withFields(fields)
                .withQuery("search", search)
                .withQuery("game", game)
                .withQuery("language", language)
                .withQuery("limit", limit)
                .withQuery("type", type);

        return super.get(urlBuilder, new TypeToken<JsonResponse<List<Account>>>() {
        }).getData();
    }

    /**
     * Метод возвращает информацию об аккаунте Wargaming.
     *
     * <p>Переданные переменные, кроме "accountId", могут быть NULL</p>
     *
     * @param accountId   Идентификатор игрока. Максимальное ограничение: 100.
     *                    <p>Обязательный параметр. Не должен быть NULL.
     * @param accessToken Ключ доступа к личным данным аккаунта пользователя; можно получить при помощи метода авторизации;
     *                    действителен в течение определённого времени
     * @param fields      Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                    Для исключения поля используется знак «-» перед названием поля.
     *                    Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
     * @param language    Язык локализации. По умолчанию: "ru". Допустимые значения:
     *                    <p>
     *                    "en" — English
     *                    "ru" — Русский (используется по умолчанию)
     *                    "pl" — Polski
     *                    "de" — Deutsch
     *                    "fr" — Français
     *                    "es" — Español
     *                    "zh-cn" — 简体中文
     *                    "zh-tw" — 繁體中文
     *                    "tr" — Türkçe
     *                    "cs" — Čeština
     *                    "th" — ไทย
     *                    "vi" — Tiếng Việt
     *                    "ko" — 한국어
     * @return Информацию об аккаунте Wargaming
     * @throws WgApiClientException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом POST
     */
    public Map<String, AccountInformation> getAccountInfo(String accountId, String accessToken, List<String> fields, String language) throws WgApiClientException {

        WgApiUrlBuilder urlBuilder = getWgApiUrlBuilder()
                .withMethod(METHOD_BLOCK, "info")
                .withQuery("account_id", accountId)
                .withQuery("access_token", accessToken)
                .withFields(fields)
                .withQuery("language", language);
        return super.post(urlBuilder, new TypeToken<JsonResponse<Map<String, AccountInformation>>>() {
        }).getData();
    }
}
