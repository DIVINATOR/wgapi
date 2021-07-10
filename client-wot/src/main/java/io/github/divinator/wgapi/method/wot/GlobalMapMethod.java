package io.github.divinator.wgapi.method.wot;

import com.google.gson.reflect.TypeToken;
import io.github.divinator.wgapi.client.AbstractMethodBlock;
import io.github.divinator.wgapi.client.*;
import io.github.divinator.wgapi.entity.JsonResponse;
import io.github.divinator.wgapi.entity.wot.globalmap.*;

import java.util.List;
import java.util.Map;

/**
 * Класс описывет Метод-блок для получения информации о Глобальной карте WorldOfTanks.
 *
 * @author Sergey Divin
 */
public class GlobalMapMethod extends AbstractMethodBlock {

    private final static String METHOD_BLOCK = "globalmap";

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
     * Метод возвращает информацию о Фронтах Глобальной карты.
     *
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
     *                      </li>
     *                      <li><b>"front_id"</b> - Список идентификаторов фронтов, указывающий, какие фронты необходимо
     *                      возвращать. Максимальное ограничение: 100.</li>
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
     *                      <li><b>"limit"</b> - Количество возвращаемых записей (может вернуться меньше записей,
     *                      но не больше 100). Если переданный лимит превышает 100, тогда автоматически
     *                      выставляется лимит в 100 (по умолчанию).</li>
     *                   </ul>
     * @return Информацию о Фронтах Глобальной карты.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<List<Front>> getFronts(Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "fronts")
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<List<Front>>>() {
        });
    }

    /**
     * Метод возвращает информацию о провинциях Глобальной карты.
     *
     * @param frontId    Идентификатор фронта. Чтобы получить его, используйте метод {@link GlobalMapMethod getFront()}
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"arena_id"</b> - Идентификатор игровой карты.</li>
     *                      <li><b>"daily_revenue_gte"</b> - Поиск провинций с дневным доходом больше или равным значению.</li>
     *                      <li><b>"daily_revenue_lte"</b> - Поиск провинций с дневным доходом меньше или равным значению.</li>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
     *                      </li>
     *                      <li><b>"landing_type"</b> - Поиск провинций с типом высадки. Допустимые значения:
     *                          <ul>
     *                              <li><i>"null"</i> - Аукционы отключены.</li>
     *                              <li><i>"auction"</i> - Аукцион.</li>
     *                              <li><i>"tournament"</i> - Высадочный турнир.</li>
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
     *                      <li><b>"limit"</b> - Количество возвращаемых записей (может вернуться меньше записей,
     *                      но не больше 100). Если переданный лимит превышает 100, тогда автоматически
     *                      выставляется лимит в 100 (по умолчанию).</li>
     *                      <li><b>"order_by"</b> - Сортировка. Допустимые значения:
     *                          <ul>
     *                              <li><i>"province_id"</i> - По названию провинции.</li>
     *                              <li><i>"-province_id"</i> - По названии провинции в обратном порядке.</li>
     *                              <li><i>"daily_revenue"</i> - По доходности провинции.</li>
     *                              <li><i>"-daily_revenue"</i> - По доходности провинции в обратном порядке.</li>
     *                              <li><i>"prime_hour"</i> - По Прайм-тайму.</li>
     *                              <li><i>"-prime_hour"</i> - По Прайм-тайму в обратном порядке.</li>
     *                          </ul>
     *                      </li>
     *                      <li><b>"page_no"</b> - Номер страницы. По умолчанию: 1. Минимальное значение: 1.</li>
     *                      <li><b>"prime_hour"</b> - Поиск провинций со значением часа начала Прайм-тайма.
     *                      Доступные значения: от 0 до 23. Максимальное значение: 23.</li>
     *                      <li><b>"province_id"</b> - Фильтр по списку идентификаторов провинций. Максимальное ограничение: 100.</li>
     *                   </ul>
     * @return Информация о провинциях Глобальной карты.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<List<Province>> getProvinces(String frontId, Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "provinces")
                .withParameter(new Parameter("front_id", frontId))
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<List<Province>>>() {
        });
    }

    /**
     * Метод возвращает данные клана на Глобальной Карте.
     *
     * @param clanId     Идентификатор клана. Чтобы получить его, используйте метод Кланы. Максимальное ограничение: 10.
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"access_token"</b> - Ключ доступа к личным данным аккаунта пользователя; можно получить при помощи метода
     *                      авторизации; действителен в течение определённого времени.</li>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
     *                      </li>
     *                   </ul>
     * @return Данные клана на Глобальной Карте
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом POST
     */
    public JsonResponse<Map<String, ClanInfo>> getClanInfo(String clanId, Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "claninfo")
                .withParameter(new Parameter("clan_id", clanId))
                .withParameters(parameters);

        return super.post(urlBuilder, new TypeToken<JsonResponse<Map<String, ClanInfo>>>() {
        });
    }

    /**
     * Метод возвращает списки провинций кланов.
     *
     * @param clanId     Список идентификаторов кланов. Чтобы получить идентификатор клана, используйте метод Кланы.
     *                   Максимальное ограничение: 10.
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"access_token"</b> - Ключ доступа к личным данным аккаунта пользователя; можно получить при помощи метода
     *                      авторизации; действителен в течение определённого времени.</li>
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
     * @return Списки провинций кланов
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом POST
     */
    public JsonResponse<Map<String, List<ClanProvince>>> getClanProvinces(String clanId, Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "clanprovinces")
                .withParameter(new Parameter("clan_id", clanId))
                .withParameters(parameters);

        return super.post(urlBuilder, new TypeToken<JsonResponse<Map<String, List<ClanProvince>>>>() {
        });
    }

    /**
     * Метод возвращает список боёв клана на Глобальной карте.
     *
     * @param clanId     Идентификатор клана. Чтобы получить его, используйте метод Кланы.
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
     *                      Если переданный лимит превышает 100, тогда автоматически выставляется лимит в 100 (по умолчанию).</li>
     *                      <li><b>"page_no"</b> - Номер страницы. По умолчанию: 1. Минимальное значение: 1.</li>
     *                   </ul>
     * @return Список боёв клана на Глобальной карте
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<List<ClanBattle>> getClanBattles(String clanId, Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "clanbattles")
                .withParameter(new Parameter("clan_id", clanId))
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<List<ClanBattle>>>() {
        });
    }

    /**
     * Метод возвращает информацию о сезонах на Глобальной карте.
     *
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
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
     *                      <li><b>"limit"</b> - Количество возвращаемых записей (может вернуться меньше записей, но не больше 100).
     *                      Если переданный лимит превышает 100, тогда автоматически выставляется лимит в 100 (по умолчанию).</li>
     *                      <li><b>"page_no"</b> - Номер страницы. По умолчанию: 1. Минимальное значение: 1.</li>
     *                      <li><b>"season_id"</b> - Идентификатор сезона.</li>
     *                      <li><b>"status"</b> - Возвращает сезоны, отфильтрованные по статусу. Допустимые значения:
     *                          <ul>
     *                              <li><i>"PLANNED"</i> - Предстоящий сезон.</li>
     *                              <li><i>"ACTIVE"</i> - Текущий сезон.</li>
     *                              <li><i>"FINISHED"</i> - Сезон завершён.</li>
     *                          </ul>
     *                      </li>
     *                   </ul>
     * @return Информация о сезонах на Глобальной карте.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<List<Season>> getSeasons(Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "seasons")
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<List<Season>>>() {
        });
    }

    /**
     * Метод возвращает статистику клана для определённого сезона.
     *
     * @param clanId       Идентификатор клана. Чтобы получить его, используйте метод Кланы. Минимальное значение: 1.
     * @param seasonId     Идентификатор сезона. Чтобы получить его, используйте метод Сезоны.
     * @param vehicleLevel Перечень уровней техники. Максимальное ограничение: 100. Допустимые значения:
     *                     <p>
     *                     "6" — Техника 6 уровня
     *                     "8" — Техника 8 уровня
     *                     "10" — Техника 10 уровня
     * @param parameters   Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                     <ul>
     *                        <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                        Для исключения поля используется знак «-» перед названием поля.
     *                        Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.</li>
     *                     </ul>
     * @return Статистика клана для определённого сезона.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<Map<String, SeasonClanInfo>> getSeasonClanInfo(String clanId, String seasonId, String vehicleLevel,
                                                                       Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "seasonclaninfo")
                .withParameter(new Parameter("clan_id", clanId))
                .withParameter(new Parameter("season_id", seasonId))
                .withParameter(new Parameter("vehicle_level", vehicleLevel))
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, SeasonClanInfo>>>() {
        });
    }

    /**
     * Метод возвращает статистику игрока для определённого сезона.
     *
     * @param accountId    Идентификатор аккаунта. Минимальное значение: 1.
     * @param seasonId     Идентификатор сезона. Чтобы получить его, используйте метод Сезоны.
     * @param vehicleLevel Перечень уровней техники. Максимальное ограничение: 100. Допустимые значения:
     *                     <p>
     *                     "6" — Техника 6 уровня
     *                     "8" — Техника 8 уровня
     *                     "10" — Техника 10 уровня
     * @param parameters   Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                     <ul>
     *                        <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                        Для исключения поля используется знак «-» перед названием поля.
     *                        Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.</li>
     *                     </ul>
     * @return Статистика игрока для определённого сезона.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<Map<String, SeasonAccountInfo>> getSeasonAccountInfo(String accountId, String seasonId, String vehicleLevel,
                                                                             Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "seasonaccountinfo")
                .withParameter(new Parameter("account_id", accountId))
                .withParameter(new Parameter("season_id", seasonId))
                .withParameter(new Parameter("vehicle_level", vehicleLevel))
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, SeasonAccountInfo>>>() {
        });
    }

    /**
     * Метод возвращает клановый рейтинг сезона.
     *
     * @param seasonId     Идентификатор сезона. Чтобы получить его, используйте метод Сезоны.
     * @param vehicleLevel Уровень техники. Допустимые значения:
     *                     <p>
     *                     "6" — Техника 6 уровня
     *                     "8" — Техника 8 уровня
     *                     "10" — Техника 10 уровня
     * @param parameters   Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                     <ul>
     *                        <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                        Для исключения поля используется знак «-» перед названием поля.
     *                        Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.</li>
     *                        <li><b>"limit"</b> - Количество возвращаемых записей (может вернуться меньше записей, но не больше 100).
     *                        Если переданный лимит превышает 100, тогда автоматически выставляется лимит в 100 (по умолчанию).</li>
     *                        <li><b>"page_no"</b> - Номер страницы. По умолчанию: 1. Минимальное значение: 1.</li>
     *                     </ul>
     * @return Клановый рейтинг сезона.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<List<SeasonClanRating>> getSeasonClanRating(String seasonId, String vehicleLevel, Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "seasonrating")
                .withParameter(new Parameter("season_id", seasonId))
                .withParameter(new Parameter("vehicle_level", vehicleLevel))
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<List<SeasonClanRating>>>() {
        });
    }

    /**
     * Метод возвращает список соседних позиций в клановом рейтинге сезона.
     *
     * @param clanId       Идентификатор клана. Чтобы получить его, используйте метод Кланы. Минимальное значение: 1.
     * @param seasonId     Идентификатор сезона. Чтобы получить его, используйте метод Сезоны.
     * @param vehicleLevel Уровень техники. Допустимые значения:
     *                     <p>
     *                     "6" — Техника 6 уровня
     *                     "8" — Техника 8 уровня
     *                     "10" — Техника 10 уровня
     * @param parameters   Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                     <ul>
     *                        <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                        Для исключения поля используется знак «-» перед названием поля.
     *                        Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.</li>
     *                        <li><b>"limit"</b> - Количество возвращаемых записей (может вернуться меньше записей, но не больше 100).
     *                        Если переданный лимит превышает 100, тогда автоматически выставляется лимит в 100 (по умолчанию).</li>
     *                     </ul>
     * @return Список соседних позиций в клановом рейтинге сезона.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<List<SeasonClanRating>> getSeasonClanRatingNeighbors(String clanId, String seasonId, String vehicleLevel,
                                                                             Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "seasonratingneighbors")
                .withParameter(new Parameter("clan_id", clanId))
                .withParameter(new Parameter("season_id", seasonId))
                .withParameter(new Parameter("vehicle_level", vehicleLevel))
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<List<SeasonClanRating>>>() {
        });
    }

    /**
     * Метод возвращает список событий на Глобальной карте.
     *
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"event_id"</b> - Идентификатор события.</li>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
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
     *                      <li><b>"limit"</b> - Количество возвращаемых записей (может вернуться меньше записей, но не больше 100).
     *                      Если переданный лимит превышает 100, тогда автоматически выставляется лимит в 100 (по умолчанию).</li>
     *                      <li><b>"page_no"</b> - Номер страницы. По умолчанию: 1. Минимальное значение: 1.</li>
     *                      <li><b>"status"</b> - Возвращает сезоны, отфильтрованные по статусу. Допустимые значения:
     *                          <ul>
     *                              <li><i>"PLANNED"</i> - Предстоящий сезон.</li>
     *                              <li><i>"ACTIVE"</i> - Текущий сезон.</li>
     *                              <li><i>"FINISHED"</i> - Сезон завершён.</li>
     *                          </ul>
     *                      </li>
     *                   </ul>
     * @return Список событий на Глобальной карте.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<List<Event>> getEvents(Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "events")
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<List<Event>>>() {
        });
    }

    /**
     * Метод возвращает статистику клана для определённого события.
     *
     * @param clanId     Идентификатор клана. Чтобы получить его, используйте метод Кланы. Минимальное значение: 1.
     * @param eventId    Идентификатор события. Чтобы получить его, используйте метод События.
     * @param frontId    Идентификатор фронта. Чтобы получить его, используйте метод Фронты. Максимальное ограничение: 10.
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.</li>
     *                   </ul>
     * @return Статистика клана для определённого события.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<Map<String, EventClanInfo>> getEventClanInfo(String clanId, String eventId, String frontId,
                                                                     Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "eventclaninfo")
                .withParameter(new Parameter("clan_id", clanId))
                .withParameter(new Parameter("event_id", eventId))
                .withParameter(new Parameter("front_id", frontId))
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, EventClanInfo>>>() {
        });
    }

    /**
     * Метод возвращает клановый рейтинг события.
     *
     * @param eventId    Идентификатор события. Чтобы получить его, используйте метод События.
     * @param frontId    Идентификатор фронта. Чтобы получить его, используйте метод Фронты.
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.</li>
     *                      <li><b>"limit"</b> - Количество возвращаемых записей (может вернуться меньше записей, но не больше 100).
     *                      Если переданный лимит превышает 100, тогда автоматически выставляется лимит в 100 (по умолчанию).</li>
     *                      <li><b>"page_no"</b> - Номер страницы. По умолчанию: 1. Минимальное значение: 1.</li>
     *                   </ul>
     * @return Клановый рейтинг события
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<List<EventClanRating>> getEventClanRating(String eventId, String frontId, Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "eventrating")
                .withParameter(new Parameter("event_id", eventId))
                .withParameters(new Parameter("front_id", frontId))
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<List<EventClanRating>>>() {
        });
    }

    /**
     * Метод возвращает список соседних позиций в клановом рейтинге события.
     *
     * @param clanId     Идентификатор клана. Чтобы получить его, используйте метод Кланы. Минимальное значение: 1.
     * @param eventId    Идентификатор события. Чтобы получить его, используйте метод События.
     * @param frontId    Идентификатор фронта. Чтобы получить его, используйте метод Фронты.
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.</li>
     *                      <li><b>"limit"</b> - Количество возвращаемых записей (может вернуться меньше записей, но не больше 100).
     *                      Если переданный лимит превышает 100, тогда автоматически выставляется лимит в 100 (по умолчанию).</li>
     *                   </ul>
     * @return Список соседних позиций в клановом рейтинге события.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<List<EventClanRating>> getEventClanRatingNeighbors(String clanId, String eventId, String frontId,
                                                                           Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "eventratingneighbors")
                .withParameter(new Parameter("clan_id", clanId))
                .withParameter(new Parameter("event_id", eventId))
                .withParameter(new Parameter("front_id", frontId))
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<List<EventClanRating>>>() {
        });
    }


    /**
     * Метод возвращает статистику игрока для определённого события.
     *
     * @param accountId  Идентификатор аккаунта. Минимальное значение: 1.
     * @param eventId    Идентификатор события. Чтобы получить его, используйте метод События.
     * @param frontId    Идентификатор фронта. Чтобы получить его, используйте метод Фронты. Максимальное ограничение: 10.
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"clan_id"</b> - Идентификатор клана. Чтобы получить его, используйте метод Кланы. Минимальное значение: 1.</li>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.</li>
     *                   </ul>
     * @return Статистика игрока для определённого события.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<Map<String, EventAccountInfo>> getEventAccountInfo(String accountId, String eventId, String frontId,
                                                                           Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "eventaccountinfo")
                .withParameter(new Parameter("account_id", accountId))
                .withParameter(new Parameter("event_id", eventId))
                .withParameter(new Parameter("front_id", frontId))
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, EventAccountInfo>>>() {
        });
    }

    /**
     * Метод возвращает рейтинг игрока в событии.
     *
     * @param eventId  Идентификатор события. Чтобы получить его, используйте метод События.
     * @param frontId  Идентификатор фронта. Чтобы получить его, используйте метод Фронты.
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.</li>
     *                      <li><b>"in_rating"</b> - Получить данные только для аккаунтов с рейтингом. По умолчанию: 0.
     *                      Допустимые значения:
     *                          <ul>
     *                              <li><i>"1"</i> - Только с рейтингом.</li>
     *                              <li><i>"0"</i> - Все (используется по умолчанию).</li>
     *                          </ul>
     *                      </li>
     *                      <li><b>"limit"</b> - Количество возвращаемых записей (может вернуться меньше записей, но не больше 100).
     *                      Если переданный лимит превышает 100, тогда автоматически выставляется лимит в 100 (по умолчанию).</li>
     *                      <li><b>"page_no"</b> - Номер страницы. По умолчанию: 1. Минимальное значение: 1.</li>
     *                   </ul>
     * @return Рейтинг игрока в событии.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<List<EventAccountRatings>> getEventAccountRatings(String eventId, String frontId, Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "eventaccountratings")
                .withParameter(new Parameter("event_id", eventId))
                .withParameter(new Parameter("front_id", frontId))
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<List<EventAccountRatings>>>() {
        });
    }

    /**
     * Метод возвращает соседние позиции в рейтинге игроков события.
     *
     * @param accountId       Идентификатор аккаунта. Минимальное значение: 1.
     * @param eventId         Идентификатор события. Чтобы получить его, используйте метод События.
     * @param frontId         Идентификатор фронта. Чтобы получить его, используйте метод Фронты.
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.</li>
     *                      <li><b>"limit"</b> - Количество возвращаемых записей (может вернуться меньше записей, но не больше 100).
     *                      Если переданный лимит превышает 100, тогда автоматически выставляется лимит в 100 (по умолчанию).</li>
     *                      <li><b>"neighbours_count"</b> - Сколько соседних позиций отобразить рядом с аккаунтом. По умолчанию: 3.
     *                      Допустимые значения:
     *                          <ul>
     *                              <li><i>"1"</i> - Минимальное значение.</li>
     *                              <li><i>"99"</i> - Максимальное значение.</li>
     *                          </ul>
     *                      </li>
     *                      <li><b>"page_no"</b> - Номер страницы. По умолчанию: 1. Минимальное значение: 1.</li>
     *                   </ul>
     * @return Соседние позиции в рейтинге игроков события.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<List<EventAccountRatings>> getEventAccountRatingNeighbors(String accountId, String eventId, String frontId,
                                                                                  Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "eventaccountratingneighbors")
                .withParameter(new Parameter("account_id", accountId))
                .withParameter(new Parameter("event_id", eventId))
                .withParameter(new Parameter("front_id", frontId))
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<List<EventAccountRatings>>>() {
        });
    }

    /**
     * Метод возвращает общую информацию о Глобальной карте.
     *
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.</li>
     *                   </ul>
     * @return Общая информация о Глобальной карте.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<GlobalMapInfo> getGlobalMapInfo(Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "info")
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<GlobalMapInfo>>() {
        });
    }
}
