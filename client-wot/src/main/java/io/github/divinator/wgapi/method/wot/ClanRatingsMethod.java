package io.github.divinator.wgapi.method.wot;

import com.google.gson.reflect.TypeToken;
import io.divinator.wgapi.client.AbstractMethodBlock;
import io.divinator.wgapi.client.Cluster;
import io.divinator.wgapi.client.*;
import io.divinator.wgapi.entity.JsonResponse;
import io.divinator.wgapi.entity.wot.clanratings.Clan;
import io.divinator.wgapi.entity.wot.clanratings.DatesRatings;
import io.divinator.wgapi.entity.wot.clanratings.TypesRatings;

import java.util.List;
import java.util.Map;

/**
 * Класс описывет Метод-блок для получения информации об рейтингах кланов в WorldOfTanks.
 *
 * @author Sergey Divin
 */
public class ClanRatingsMethod extends AbstractMethodBlock {

    private final static String METHOD_BLOCK = "clanratings";

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
     * Метод возвращает информацию о типах и категориях рейтингов.
     *
     * @return Информация о типах и категориях рейтингов.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<Map<String, TypesRatings>> getTypesRatings() throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "types");

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, TypesRatings>>>() {
        });
    }

    /**
     * Метод возвращает даты, за которые есть рейтинговые данные.
     *
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"limit"</b> - Количество возвращаемых записей (может вернуться меньше записей, но не больше 365).
     *                      Если переданный лимит превышает 365, тогда автоматически выставляется лимит в 7 (по умолчанию).
     *                      </li>
     *                   </ul>
     * @return Даты, за которые есть рейтинговые данные
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<Map<String, DatesRatings>> getDatesRatings(Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "dates")
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, DatesRatings>>>() {
        });
    }

    /**
     * Метод возвращает рейтинги кланов по заданным идентификаторам.
     *
     * @param clanId     Идентификаторы кланов. Максимальное ограничение: 100.
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"date"</b> - Дата расчёта рейтингов.
     *                      Дата в формате UNIX timestamp или ISO 8601. Например, 1376542800 или 2013-08-15T00:00:00</li>
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
     * @return Рейтинги кланов.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<Map<String, Clan>> getClans(String clanId, Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "clans")
                .withParameter(new Parameter("clan_id", clanId))
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, Clan>>>() {
        });
    }

    /**
     * Метод возвращает список соседних позиций в заданном рейтинге кланов.
     *
     * @param clanId     Идентификатор клана
     * @param rankField  Категория рейтинга
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"date"</b> - Дата расчёта рейтингов.
     *                      Дата в формате UNIX timestamp или ISO 8601. Например, 1376542800 или 2013-08-15T00:00:00</li>
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
     *                      <li><b>"limit"</b> - Количество возвращаемых записей (может вернуться меньше записей, но не больше 50).
     *                      Если переданный лимит превышает 50, тогда автоматически выставляется лимит в 5 (по умолчанию).</li>
     *                   </ul>
     * @return Список соседних позиций в заданном рейтинге кланов.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<List<Clan>> getClanNeighbors(String clanId, String rankField, Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "neighbors")
                .withParameter(new Parameter("clan_id", clanId))
                .withParameter(new Parameter("rank_field", rankField))
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<List<Clan>>>() {
        });
    }

    /**
     * Метод возвращает список лучших кланов по заданным параметрам.
     * <p>
     * Переданные переменные, кроме "rankField", могут быть NULL.
     *
     * @param rankField  Категория рейтинга
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"date"</b> - Дата расчёта рейтингов.
     *                      Дата в формате UNIX timestamp или ISO 8601. Например, 1376542800 или 2013-08-15T00:00:00</li>
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
     *                      <li><b>"limit"</b> - Количество возвращаемых записей (может вернуться меньше записей, но не больше 50).
     *                      Если переданный лимит превышает 50, тогда автоматически выставляется лимит в 5 (по умолчанию).</li>
     *                      <li><b>"page_no"</b> - Номер страницы. По умолчанию: 1. Минимальное значение: 1.</li>
     *                   </ul>
     * @return Список лучших кланов по заданным параметрам.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<List<Clan>> getTopClans(String rankField, Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "top")
                .withParameter(new Parameter("rank_field", rankField))
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<List<Clan>>>() {
        });
    }
}
