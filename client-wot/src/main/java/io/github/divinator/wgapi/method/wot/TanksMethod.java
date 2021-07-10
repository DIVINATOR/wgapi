package io.github.divinator.wgapi.method.wot;

import com.google.gson.reflect.TypeToken;
import io.divinator.wgapi.client.AbstractMethodBlock;
import io.divinator.wgapi.client.*;
import io.divinator.wgapi.client.Cluster;
import io.divinator.wgapi.client.WgApiUriBuilder;
import io.divinator.wgapi.entity.JsonResponse;
import io.divinator.wgapi.entity.wot.tanks.Achievement;
import io.divinator.wgapi.entity.wot.tanks.Stats;

import java.util.List;
import java.util.Map;

/**
 * @author Sergey Divin
 */
public class TanksMethod extends AbstractMethodBlock {

    private final static String METHOD_BLOCK = "tanks";

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
     * Метод возвращает общую, ротную и клановую статистику по каждой единице техники каждого пользователя.
     *
     * @param accountId  Идентификатор аккаунта игрока
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"access_token"</b> - Ключ доступа к личным данным аккаунта пользователя; можно получить при помощи метода
     *                      авторизации; действителен в течение определённого времени.</li>
     *                      <li><b>"extra"</b> - Список дополнительных полей, которые будут включены в ответ. Допустимые значения:
     *                          <ul>
     *                              <li><i>"epic"</i></li>
     *                              <li><i>"fallout"</i></li>
     *                              <li><i>"random"</i></li>
     *                              <li><i>"ranked"</i></li>
     *                              <li><i>"ranked_battles"</i></li>
     *                          </ul>
     *                      </li>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
     *                      </li>
     *                      <li><b>"in_garage"</b> - Фильтр по наличию техники в Ангаре. Если параметр не указан,
     *                      возвращается вся техника. Параметр обрабатывается только при наличии действующего
     *                      access_token для указанного account_id. Допустимые значения:
     *                          <ul>
     *                              <li><i>"1"</i> - Возвращать технику из Ангара.</li>
     *                              <li><i>"0"</i> - Возвращать технику, которой уже нет в Ангаре.</li>
     *                          </ul>
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
     * @return Общую, ротную и клановую статистику по каждой единице техники каждого пользователя.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом POST
     */
    public JsonResponse<Map<String, List<Stats>>> getStats(String accountId, Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "stats")
                .withParameter(new Parameter("account_id", accountId))
                .withParameters(parameters);

        return super.post(urlBuilder, new TypeToken<JsonResponse<Map<String, List<Stats>>>>() {
        });
    }

    /**
     * Метод возвращает список достижений по всей технике игрока.
     * <p>
     * Значения поля achievements зависят от свойств достижений:
     * степень от 1 до 4 для знака классности и этапных достижений (type: "class")
     * максимальное значение серийных достижений (type: "series")
     * количество заработанных наград из секций: Герой битвы, Эпические достижения, Групповые достижения,
     * Особые достижения и т.п. (type: "repeatable, single, custom").
     * </p>
     *
     * @param accountId   Идентификатор аккаунта игрока.
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"access_token"</b> - Ключ доступа к личным данным аккаунта пользователя; можно получить при помощи метода
     *                      авторизации; действителен в течение определённого времени.</li>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
     *                      </li>
     *                      <li><b>"in_garage"</b> - Фильтр по наличию техники в Ангаре. Если параметр не указан,
     *                      возвращается вся техника. Параметр обрабатывается только при наличии действующего
     *                      access_token для указанного account_id. Допустимые значения:
     *                          <ul>
     *                              <li><i>"1"</i> - Возвращать технику из Ангара.</li>
     *                              <li><i>"0"</i> - Возвращать технику, которой уже нет в Ангаре.</li>
     *                          </ul>
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
     * @return Список достижений по всей технике игрока
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом POST
     */
    public JsonResponse<Map<String, List<Achievement>>> getAchievements(String accountId, Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "achievements")
                .withParameter(new Parameter("account_id", accountId))
                .withParameters(parameters);

        return super.post(urlBuilder, new TypeToken<JsonResponse<Map<String, List<Achievement>>>>() {
        });
    }
}
