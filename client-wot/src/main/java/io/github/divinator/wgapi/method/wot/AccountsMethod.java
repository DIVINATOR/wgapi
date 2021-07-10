package io.github.divinator.wgapi.method.wot;

import com.google.gson.reflect.TypeToken;
import io.github.divinator.wgapi.client.*;
import io.github.divinator.wgapi.entity.JsonResponse;
import io.github.divinator.wgapi.entity.wot.accounts.Account;
import io.github.divinator.wgapi.entity.wot.accounts.AccountAchievements;
import io.github.divinator.wgapi.entity.wot.accounts.AccountInformation;
import io.github.divinator.wgapi.entity.wot.accounts.AccountTank;

import java.util.List;
import java.util.Map;

/**
 * Класс описывает Метод-блок для получения информации об аккаунтах WorldOfTanks.
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
        return super.getWgApiUriBuilder().withCluster(Cluster.WORLD_OF_TANKS);
    }

    /**
     * Метод возвращает часть списка игроков, отфильтрованную по первым символам имени и отсортированную по алфавиту.
     *
     * @param search     Строка поиска по имени игрока. Вид поиска и минимальная длина строки поиска зависят от параметра type.
     *                   При использовании типа поиска exact можно перечислить несколько имён для поиска, разделив их запятыми.
     *                   Максимальная длина: 24.
     *
     *                   <p>Обязательный параметр. Не должен быть NULL.
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
     *                      </li>
     *                      <li><b>"language"</b> - Язык локализации. По умолчанию: "ru". Допустимые значения:
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
     *                      <li><b>"limit"</b> - Количество возвращаемых записей (может вернуться меньше записей, но не больше 100).
     *                      Если переданный лимит превышает 100, тогда автоматически выставляется лимит в None (по умолчанию).</li>
     *                      <li><b>"type"</b> - Тип поиска. По умолчанию: "startswith". Допустимые значения:
     *                          <ul>
     *                              <li><i>"startswith"</i> — Поиск по начальной части имени игрока без учёта регистра.
     *                              Минимальная длина: 3 символа. Максимальная длина: 24 символа. (используется по умолчанию)</li>
     *                              <li><i>"exact"</i> — Поиск по строгому соответствию имени игрока без учёта регистра.
     *                              Можно перечислить несколько имён для поиска (до 100 значений), разделив их запятыми.</li>
     *                          </ul>
     *                      </li>
     *                   </ul>
     * @return Список игроков
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */


    public JsonResponse<List<Account>> getAccounts(String search, Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "list")
                .withParameter(new Parameter("search", search))
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<List<Account>>>() {
        });
    }

    /**
     * Метод возвращает информацию об игроке.
     *
     * @param accountId  Идентификатор аккаунта игрока. Максимальное ограничение: 100.
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"access_token"</b> - Ключ доступа к личным данным аккаунта пользователя; можно
     *                      получить при помощи метода авторизации; действителен в течение определённого времени.</li>
     *                      <li><b>"extra"</b> - Список дополнительных полей, которые будут включены в ответ. Допустимые значения:
     *                          <ul>
     *                              <li><i>"private.boosters"</i></li>
     *                              <li><i>"private.garage"</i></li>
     *                              <li><i>"private.grouped_contacts"</i></li>
     *                              <li><i>"private.personal_missions"</i></li>
     *                              <li><i>"private.rented"</i></li>
     *                              <li><i>"statistics.epic"</i></li>
     *                              <li><i>"statistics.fallout"</i></li>
     *                              <li><i>"statistics.globalmap_absolute"</i></li>
     *                              <li><i>"statistics.globalmap_champion"</i></li>
     *                              <li><i>"statistics.globalmap_middle"</i></li>
     *                              <li><i>"statistics.random"</i></li>
     *                              <li><i>"statistics.ranked_battles"</i></li>
     *                              <li><i>"statistics.ranked_battles_current"</i></li>
     *                              <li><i>"statistics.ranked_battles_previous"</i></li>
     *                          </ul>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
     *                      </li>
     *                      <li><b>"language"</b> - Язык локализации. По умолчанию: "ru". Допустимые значения:
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
     * @return Информация об игроке
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом POST
     */
    public JsonResponse<Map<String, AccountInformation>> getAccountsInformation(String accountId, Parameter... parameters
    ) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "info")
                .withParameter(new Parameter("account_id", accountId))
                .withParameters(parameters);

        return super.post(urlBuilder, new TypeToken<JsonResponse<Map<String, AccountInformation>>>() {
        });
    }

    /**
     * Метод возвращает информацию о технике игрока.
     *
     * @param accountId  Идентификатор аккаунта игрока. Максимальное ограничение: 100.
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"access_token"</b> - Ключ доступа к личным данным аккаунта пользователя; можно
     *                      получить при помощи метода авторизации; действителен в течение определённого времени.</li>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
     *                      </li>
     *                      <li><b>"language"</b> - Язык локализации. По умолчанию: "ru". Допустимые значения:
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
     *                      <li><b>"tank_id"</b> - Идентификатор техники игрока. Максимальное ограничение: 100.</li>
     *                   </ul>
     * @return Информация о технике игрока.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом POST
     */
    public JsonResponse<Map<String, List<AccountTank>>> getAccountsTanks(String accountId, Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "tanks")
                .withParameter(new Parameter("account_id", accountId))
                .withParameters(parameters);

        return super.post(urlBuilder, new TypeToken<JsonResponse<Map<String, List<AccountTank>>>>() {
        });
    }

    /**
     * Метод возвращает информацию о достижениях игроков.
     * <p>
     * Значения поля achievements зависят от свойств достижений:
     * <p>
     * от 1 до 4 для Знаков классности и Этапных достижений (type: "class");
     * максимальное значение серийных достижений (type: "series");
     * количество заработанных достижений из секций Герой битвы, Эпические достижения, Групповые достижения,
     * Особые достижения и т.п. (type: "repeatable, single, custom").
     *
     * @param accountId  Идентификатор аккаунта игрока. Максимальное ограничение: 100.
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
     *                      </li>
     *                      <li><b>"language"</b> - Язык локализации. По умолчанию: "ru". Допустимые значения:
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
     * @return Информация о достижениях игроков.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<Map<String, AccountAchievements>> getAccountsAchievements(String accountId, Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "achievements")
                .withParameter(new Parameter("account_id", accountId))
                .withQuery("account_id", accountId)
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, AccountAchievements>>>() {
        });
    }
}
