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

package io.github.divinator.wgapi.method.wot;

import com.google.gson.reflect.TypeToken;
import io.github.divinator.wgapi.client.*;
import io.github.divinator.wgapi.entity.JsonResponse;
import io.github.divinator.wgapi.entity.wot.auth.Prolongate;

import java.util.Map;

/**
 * Класс описывает Метод-блок для аутентификации игрока при помощи Идентификатора Wargaming.net (OpenID)
 *
 * @author Sergey Divin
 */
public class AuthenticationMethod extends AbstractMethodBlock {

    private final static String METHOD_BLOCK = "auth";

    /**
     * Метод возвращает объект строителя URL для Wargaming.net Public API используемого AbstractHttpClient
     *
     * @return Объект строителя URL для Wargaming.net Public API используемого AbstractHttpClient
     */
    @Override
    protected WgApiUriBuilder getWgApiUriBuilder() {
        return super.getWgApiUriBuilder().withCluster(Cluster.WORLD_OF_TANKS);
    }

    /**
     * <h2>Метод осуществляет аутентификацию игрока при помощи Идентификатора Wargaming.net (OpenID)</h2>
     * <h3>Метод используется в играх World of Tanks, World of Tanks Blitz, World of Warships, World of Warplanes и на сайте WarGag.ru.
     * Игрок должен ввести email и пароль, использованные при создании аккаунта, или войти при помощи аккаунта
     * социальной сети. Аутентификация не поддерживается для пользователя Game Center под iOS, если аккаунт не
     * привязан к одной из социальных сетей или в профиле не указан email и пароль. Информация о статусе аутентификации
     * будет отправлена на URL, указанный в параметре redirect_uri.</h3>
     *
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"display"</b> - Внешний вид формы мобильных приложений. Допустимые значения:
     *                          <ul>
     *                              <li><i>"page"</i> — Страница.</li>
     *                              <li><i>"popup"</i> — Всплывающее окно.</li>
     *                          </ul>
     *                      </li>
     *                      <li><b>"expires_at"</b> - Срок действия access_token в формате UNIX.
     *                      Также можно указать дельту в секундах. Срок действия и дельта не должны превышать две
     *                      недели, начиная с настоящего времени.</li>
     *                      <li><b>"nofollow" - При передаче параметра nofollow=1 переадресация не происходит.
     *                      URL возвращается в ответе. По умолчанию: 0. Минимальное значение: 0.
     *                      Максимальное значение: 1.</b></li>
     *                      <li><b>"redirect_uri"</b> - URL на который будет переброшен пользователь после того как
     *                      он пройдет аутентификацию. По умолчанию: api.worldoftanks.ru/wot//blank/</li>
     *                   </ul>
     * @return Возвращает URL, на который необходимо перенаправить пользователя для аутентификации.
     * Возвращается, только если передан параметр nofollow=1.
     */
    public JsonResponse<Map<String, String>> login(Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "login")
                .withParameters(parameters);

        return super.post(urlBuilder, new TypeToken<JsonResponse<Map<String, String>>>() {
        });
    }

    /**
     * Метод осуществляет аутентификацию игрока при помощи Идентификатора Wargaming.net (OpenID), который используется
     * в играх World of Tanks, World of Tanks Blitz, World of Warships, World of Warplanes и на сайте WarGag.ru.
     * Игрок должен ввести email и пароль, использованные при создании аккаунта, или войти при помощи аккаунта
     * социальной сети. Аутентификация не поддерживается для пользователя Game Center под iOS, если аккаунт не
     * привязан к одной из социальных сетей или в профиле не указан email и пароль. Информация о статусе аутентификации
     * будет отправлена на URL, указанный в параметре redirect_uri.
     *
     * <p>
     * Параметры redirect_uri при успешной аутентификации:
     * <p>
     * status: ok — аутентификация пройдена;
     * access_token — ключ доступа, передаётся во все методы, требующие аутентификации;
     * expires_at — срок действия access_token;
     * account_id — Идентификатор пользователя;
     * nickname — имя пользователя.
     * <p>
     * Параметры redirect_uri при ошибке аутентификации:
     * <p>
     * status: error — произошла ошибка аутентификации;
     * code — код ошибки;
     * message — информация об ошибке.
     *
     * @param display     Внешний вид формы мобильных приложений. Допустимые значения:
     *                    <p>
     *                    "page" — Страница
     *                    "popup" — Всплывающее окно
     * @param expiresAt   Срок действия access_token в формате UNIX. Также можно указать дельту в секундах.
     *                    <p>
     *                    Срок действия и дельта не должны превышать две недели, начиная с настоящего времени.
     * @param nofollow    При передаче параметра nofollow=true переадресация не происходит. URL возвращается в ответе.
     *                    По умолчанию: false.
     * @param redirectUri URL на который будет переброшен пользователь после того как он пройдет аутентификацию.
     *                    По умолчанию: api.worldoftanks.ru/wot//blank/
     * @return Возвращает URL, на который необходимо перенаправить пользователя для аутентификации.
     * Возвращается, только если передан параметр nofollow=1.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом POST
     */
    public JsonResponse<Map<String, String>> login(String display, String expiresAt, boolean nofollow, String redirectUri) throws WgApiException {
        return login(
                new Parameter("display", display),
                new Parameter("expiresAt", expiresAt),
                new Parameter("nofollow", nofollow),
                new Parameter("redirectUri", redirectUri)
        );
    }

    /**
     * Метод генерирует новый access_token на основе действующего.
     *
     * @param accessToken Старый ключ доступа к личным данным аккаунта пользователя;
     *                    можно получить при помощи метода авторизации; действителен в течение определённого времени
     *                    <p>Обязательный параметр.
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"expires_at"</b> - Срок действия access_token в формате UNIX.
     *                      Также можно указать дельту в секундах. Срок действия и дельта не должны превышать две
     *                      недели, начиная с настоящего времени.</li>
     *                   </ul>
     * @return Сущность "Новый access_token" {@link Prolongate}
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом POST
     */
    public JsonResponse<Prolongate> prolongate(String accessToken, Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "prolongate")
                .withAccessToken(accessToken)
                .withParameters(parameters);

        return super.post(urlBuilder, new TypeToken<JsonResponse<Prolongate>>() {
        });
    }

    /**
     * Метод генерирует новый access_token на основе действующего.
     * <p>
     * Используется для тех случаев, когда пользователь всё ещё пользуется приложением, а срок действия access_token уже подходит к концу.
     *
     * @param accessToken Старый ключ доступа к личным данным аккаунта пользователя;
     *                    можно получить при помощи метода авторизации; действителен в течение определённого времени
     *                    <p>Обязательный параметр.
     * @param expires_at  Срок действия access_token в формате UNIX. Также можно указать дельту в секундах.
     *                    Срок действия и дельта не должны превышать две недели, начиная с настоящего времени.
     * @return Сущность "Новый access_token" {@link Prolongate}
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом POST
     */
    public JsonResponse<Prolongate> prolongate(String accessToken, String expires_at) throws WgApiException {
        return prolongate(accessToken, new Parameter("expires_at", expires_at));
    }

    /**
     * Метод удаляет access_token пользователя.
     * <p>
     * После вызова данного метода access_token перестаёт действовать.
     *
     * @param accessToken Ключ доступа к личным данным аккаунта пользователя; можно получить при помощи метода авторизации;
     *                    действителен в течение определённого времени
     *                    <p>Обязательный параметр.
     * @return JsonResponse {@link JsonResponse}
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом POST
     */
    public JsonResponse exit(String accessToken) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "logout")
                .withAccessToken(accessToken);

        return super.post(urlBuilder, new TypeToken<JsonResponse>() {
        });
    }


}
