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

package io.divinator.wgapi.method.wot;

import com.google.gson.reflect.TypeToken;
import io.divinator.wgapi.client.*;
import io.divinator.wgapi.entity.JsonResponse;
import io.divinator.wgapi.entity.wot.auth.Prolongate;

import java.util.Map;

/**
 * Класс описывет Метод-блок для аутентификации игрока при помощи Идентификатора Wargaming.net (OpenID)
 *
 * @author Sergey Divin
 */
public class AuthenticationMethod extends AbstractMethodBlock {

    private final static String METHOD_BLOCK = "auth";

    /**
     * Метод возвращает обьект строителя URL для Wargaming.net Public API используемого AbstractHttpClient
     *
     * @return Обьект строителя URL для Wargaming.net Public API используемого AbstractHttpClient
     */
    @Override
    protected WgApiUrlBuilder getWgApiUrlBuilder() {
        return super.getWgApiUrlBuilder().withCluster(Cluster.WORLD_OF_TANKS);
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
     * @param nofollow    При передаче параметра nofollow=1 переадресация не происходит. URL возвращается в ответе.
     *                    По умолчанию: 0. Минимальное значение: 0. Максимальное значение: 1.
     * @param redirectUri URL на который будет переброшен пользователь после того как он пройдет аутентификацию.
     *                    По умолчанию: api.worldoftanks.ru/wot//blank/
     * @return Возвращает URL, на который необходимо перенаправить пользователя для аутентификации.
     * Возвращается, только если передан параметр nofollow=1.
     * @throws WgApiClientException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом POST
     */
    public Map<String, String> login(String display, String expiresAt, boolean nofollow, String redirectUri) throws WgApiClientException {

        WgApiUrlBuilder urlBuilder = getWgApiUrlBuilder()
                .withMethod(METHOD_BLOCK, "login")
                .withQuery("display", display)
                .withQuery("expires_at", expiresAt)
                .withQuery("nofollow", Boolean.compare(nofollow, false))
                .withQuery("redirect_uri", redirectUri);

        return super.post(urlBuilder, new TypeToken<JsonResponse<Map<String, String>>>() {
        }).getData();
    }

    /**
     * Метод осуществляет аутентификацию игрока при помощи Идентификатора Wargaming.net (OpenID), который используется
     * в играх World of Tanks, World of Tanks Blitz, World of Warships, World of Warplanes и на сайте WarGag.ru.
     * Игрок должен ввести email и пароль, использованные при создании аккаунта, или войти при помощи аккаунта
     * социальной сети. Аутентификация не поддерживается для пользователя Game Center под iOS, если аккаунт не
     * привязан к одной из социальных сетей или в профиле не указан email и пароль. Информация о статусе аутентификации
     * будет отправлена на URL, указанный в параметре redirect_uri.
     *
     * @param params Массив параметров запроса (пример - "key=value"):
     *               <p>
     *               <b>"display"</b> - Внешний вид формы мобильных приложений. Допустимые значения:
     *               "page" — Страница
     *               "popup" — Всплывающее окно
     *               <p>
     *               <b>"expires_at"</b> - Срок действия access_token в формате UNIX.
     *               Также можно указать дельту в секундах. Срок действия и дельта не должны превышать две недели,
     *               начиная с настоящего времени.
     *               <p>
     *               <b>nofollow</b> - При передаче параметра nofollow=1 переадресация не происходит.
     *               URL возвращается в ответе. По умолчанию: 0. Минимальное значение: 0. Максимальное значение: 1.
     *               <p>
     *               <b>redirect_uri</b> - URL на который будет переброшен пользователь после того как он
     *               пройдет аутентификацию. По умолчанию: api.worldoftanks.ru/wot//blank/
     * @return Возвращает URL, на который необходимо перенаправить пользователя для аутентификации.
     * Возвращается, только если передан параметр nofollow=1.
     */
    public Map<String, String> login(String... params) throws WgApiClientException {
        Map<String, Object> paramsMap = RequestUtils.parseRequestParams(params);

        return login(
                (String) paramsMap.get("display"),
                (String) paramsMap.get("expires_at"),
                (Boolean) paramsMap.get("nofollow").equals("1"),
                (String) paramsMap.get("redirect_uri")
        );
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
     * @throws WgApiClientException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом POST
     */
    public Prolongate prolongate(String accessToken, String expires_at) throws WgApiClientException {
        WgApiUrlBuilder urlBuilder = getWgApiUrlBuilder()
                .withMethod(METHOD_BLOCK, "prolongate")
                .withAccessToken(accessToken)
                .withQuery("expires_at", expires_at);

        return super.post(urlBuilder, new TypeToken<JsonResponse<Prolongate>>() {
        }).getData();
    }

    /**
     * Метод генерирует новый access_token на основе действующего.
     *
     * @param accessToken Старый ключ доступа к личным данным аккаунта пользователя;
     *                    можно получить при помощи метода авторизации; действителен в течение определённого времени
     *                    <p>Обязательный параметр.
     * @param params      Массив параметров запроса (пример - "key=value"):
     *                    <p>
     *                    <b>"expires_at"</b> - Срок действия access_token в формате UNIX.
     *                    Также можно указать дельту в секундах.
     *                    Срок действия и дельта не должны превышать две недели, начиная с настоящего времени.
     * @return Сущность "Новый access_token" {@link Prolongate}
     * @throws WgApiClientException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом POST
     */
    public Prolongate prolongate(String accessToken, String... params) throws WgApiClientException {
        return prolongate(accessToken, (String) RequestUtils.parseRequestParams(params).get("expires_at"));
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
     * @throws WgApiClientException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                              HTTP-запроса методом POST
     */
    public JsonResponse exit(String accessToken) throws WgApiClientException {
        WgApiUrlBuilder urlBuilder = getWgApiUrlBuilder()
                .withMethod(METHOD_BLOCK, "logout")
                .withAccessToken(accessToken);

        return super.post(urlBuilder, new TypeToken<JsonResponse>() {
        });
    }


}
