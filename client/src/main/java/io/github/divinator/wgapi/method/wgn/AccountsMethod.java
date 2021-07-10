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
import io.github.divinator.wgapi.entity.wgn.accounts.Account;
import io.github.divinator.wgapi.entity.wgn.accounts.AccountInformation;

import java.util.List;
import java.util.Map;

/**
 * Класс описывает Метод-блок для получения информации об аккаунтах Wargaming
 *
 * @author Sergey Divin
 */
public class AccountsMethod extends AbstractMethodBlock {

    private final static String METHOD_BLOCK = "account";

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
     * <h2>Метод возвращает частичный список игроков, когда-либо заходивших в какую-либо игру Wargaming.net.</h2>
     * <h3>Список фильтруется по имени или начальным символам имени пользователя и сортируется по алфавиту.</h3>
     *
     * @param search     Обязательный параметр. Не должен быть NULL. Строка поиска по имени игрока. Вид поиска и минимальная длина строки поиска зависят от параметра type.
     *                   При использовании типа поиска <i>"exact"</i> можно перечислить несколько имён для поиска, разделив их запятыми.
     *                   Максимальная длина: 24.
     *                   <p><br/>
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
     *                          <li>"wowp" — World of Warplanes</li>
     *
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
     *                      <li><b>limit</b> - Количество возвращаемых записей (может вернуться меньше записей, но не больше 100).
     *                      Если переданный лимит превышает 100, тогда автоматически выставляется лимит в None (по умолчанию).</li>
     *                      <li><b>type</b> - Тип поиска. По умолчанию: "startswith". Допустимые значения:
     *                          <ul>
     *                              <li><i>"startswith"</i> — Поиск по начальной части имени игрока без учёта регистра.
     *                              Минимальная длина: 3 символа. Максимальная длина: 24 символа. (используется по умолчанию)</li>
     *                              <li><i>"exact"</i> — Поиск по строгому соответствию имени игрока без учёта регистра.
     *                              Можно перечислить несколько имён для поиска (до 100 значений), разделив их запятыми.</li>
     *                          </ul>
     *                      </li>
     *                   </ul>
     * @return Частичный список игроков, когда-либо заходивших в какую-либо игру Wargaming.net.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<List<Account>> getListAccounts(String search, Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "list")
                .withParameter(new Parameter("search", search))
                .withParameters(parameters);
        return super.get(urlBuilder, new TypeToken<JsonResponse<List<Account>>>() {
        });
    }

    /**
     * <h2>Метод возвращает информацию об аккаунте Wargaming.net.</h2>
     *
     * @param accountId   Идентификатор игрока. Максимальное ограничение: 100.
     *                    <p>Обязательный параметр. Не должен быть NULL.
     *                    <p><br/>
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>accessToken</b> - Ключ доступа к личным данным аккаунта пользователя; можно получить
     *                      при помощи метода авторизации; действителен в течение определённого времени</li>
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
     *                      <li><b>limit</b> - Количество возвращаемых записей (может вернуться меньше записей, но не больше 100).
     *                      Если переданный лимит превышает 100, тогда автоматически выставляется лимит в None (по умолчанию).</li>
     *                      <li><b>type</b> - Тип поиска. По умолчанию: "startswith". Допустимые значения:
     *                          <ul>
     *                              <li><i>"startswith"</i> — Поиск по начальной части имени игрока без учёта регистра.
     *                              Минимальная длина: 3 символа. Максимальная длина: 24 символа. (используется по умолчанию)</li>
     *                              <li><i>"exact"</i> — Поиск по строгому соответствию имени игрока без учёта регистра.
     *                              Можно перечислить несколько имён для поиска (до 100 значений), разделив их запятыми.</li>
     *                          </ul>
     *                      </li>
     *                   </ul>
     * @return Информация об аккаунте Wargaming.net
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом POST
     */
    public JsonResponse<Map<String, AccountInformation>> getAccountInfo(Parameter accountId, Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "info")
                .withParameter(accountId)
                .withParameters(parameters);
        return super.post(urlBuilder, new TypeToken<JsonResponse<Map<String, AccountInformation>>>() {
        });
    }
}
