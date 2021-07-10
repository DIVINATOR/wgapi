package io.github.divinator.wgapi.method.wot;

import com.google.gson.reflect.TypeToken;
import io.github.divinator.wgapi.client.*;
import io.github.divinator.wgapi.entity.JsonResponse;
import io.github.divinator.wgapi.entity.wot.encyclopedia.*;
import io.github.divinator.wgapi.entity.wot.encyclopedia.Module;

import java.util.List;
import java.util.Map;

/**
 * Класс описывет Метод-блок для получения информации Танкопедии WorldOfTanks.
 *
 * @author Sergey Divin
 */
public class EncyclopediaMethod extends AbstractMethodBlock {

    private final static String METHOD_BLOCK = "encyclopedia";

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
     * Метод возвращает список доступной техники.
     *
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
     *                      <li><b>"nation"</b> - Нация. Максимальное ограничение: 100.</li>
     *                      <li><b>"page_no"</b> - Номер страницы результатов.</li>
     *                      <li><b>"tank_id"</b> - Идентификатор техники. Максимальное ограничение: 100.</li>
     *                      <li><b>"tier"</b> - Уровень. Максимальное ограничение: 100.</li>
     *                      <li><b>"type"</b> - Тип техники. Максимальное ограничение: 100. Допустимые значения:
     *                          <ul>
     *                              <li><i>"heavyTank"</i> - Тяжёлый танк.</li>
     *                              <li><i>"AT-SPG"</i> - ПТ-САУ.</li>
     *                              <li><i>"mediumTank"</i> - Средний танк.</li>
     *                              <li><i>"lightTank"</i> - Легкий танк.</li>
     *                              <li><i>"SPG"</i> - САУ.</li>
     *                          </ul>
     *                      </li>
     *                   </ul>
     * @return Список доступной техники.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<Map<String, Vehicle>> getVehicles(Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "vehicles")
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, Vehicle>>>() {
        });
    }

    /**
     * Метод возвращает характеристики конфигурации техники на основе указанных идентификаторов модулей.
     *
     * @param tankId     Идентификатор техники
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"engine_id"</b> - Идентификатор двигателя. Если модуль не указан, используется модуль базовой комплектации.</li>
     *                      <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                      Для исключения поля используется знак «-» перед названием поля.
     *                      Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
     *                      </li>
     *                      <li><b>"gun_id"</b> - Идентификатор орудия. Если модуль не указан, используется
     *                      модуль базовой комплектации.</li>
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
     *                      <li><b>"profile_id"</b> - Идентификатор комплектации. Если указан, параметры идентификаторов
     *                      отдельных модулей не учитываются.</li>
     *                      <li><b>"radio_id"</b> - Идентификатор радиостанции. Если модуль не указан, используется модуль базовой комплектации.</li>
     *                      <li><b>"suspension_id"</b> - Идентификатор ходовой. Если модуль не указан, используется модуль базовой комплектации.</li>
     *                      <li><b>"turret_id"</b> - Идентификатор башни. Если модуль не указан, используется модуль базовой комплектации.</li>
     *                   </ul>
     * @return Характеристики конфигурации техники
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<Map<String, VehicleProfileSpec>> getVehicleProfile(String tankId, Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "vehicleprofile")
                .withParameter(new Parameter("tank_id", tankId))
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, VehicleProfileSpec>>>() {
        });
    }

    /**
     * Метод возвращает характеристики комплектации техники.
     *
     * @param tankId     Идентификатор техники
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
     *                      <li><b>"order_by"</b> - Сортировка. Допустимые значения:
     *                          <ul>
     *                              <li><i>"price_credit"</i> - По стоимости в кредитах.</li>
     *                              <li><i>"-price_credit"</i> - По стоимости в кредитах, в обратном порядке.</li>
     *                          </ul>
     *                      </li>
     *                   </ul>
     * @return Характеристики комплектации техники.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<Map<String, List<VehicleProfile>>> getVehicleProfiles(String tankId, Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "vehicleprofiles")
                .withParameter(new Parameter("tank_id", tankId))
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, List<VehicleProfile>>>>() {
        });
    }

    /**
     * Метод возвращает информацию о достижениях.
     *
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
     * @return Информация о достижениях.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<Map<String, Achievement>> getAchievements(Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "achievements")
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, Achievement>>>() {
        });
    }

    /**
     * Метод возвращает информацию о Танкопедии.
     *
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
     * @return Информация о Танкопедии.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<EncyclopediaInfo> getInfo(Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "info")
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<EncyclopediaInfo>>() {
        });
    }

    /**
     * Метод возвращает информацию об игровых картах.
     *
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
     * @return Информация об игровых картах.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<Map<String, Arena>> getArenas(Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "arenas")
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, Arena>>>() {
        });
    }

    /**
     * Метод возвращает список доступного оборудования и снаряжения.
     *
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
     *                      <li><b>"page_no"</b> - Номер страницы результатов.</li>
     *                      <li><b>"provision_id"</b> - Идентификатор оборудования или снаряжения. Максимальное ограничение: 100.</li>
     *                      <li><b>"type"</b> - Тип техники. Максимальное ограничение: 100. Допустимые значения:
     *                          <ul>
     *                              <li><i>"equipment"</i> - Снаряжение.</li>
     *                              <li><i>"optionalDevice"</i> - Оборудование.</li>
     *                          </ul>
     *                      </li>
     *                   </ul>
     * @return Список доступного оборудования и снаряжения.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<Map<String, Provision>> getProvisions(Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "provisions")
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, Provision>>>() {
        });
    }

    /**
     * Метод возвращает информацию о Личных боевых задачах на основе указанных идентификаторов кампании, операции, ветки боевых задач и тегов.
     *
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                      <li><b>"campaign_id"</b> - Идентификатор кампании. Максимальное ограничение: 100.</li>
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
     *                      <li><b>"operation_id"</b> - Идентификатор операции. Максимальное ограничение: 100.</li>
     *                      <li><b>"set_id"</b> - Идентификатор ветки задач. Максимальное ограничение: 100.</li>
     *                      <li><b>"tag"</b> - Тег задачи. Максимальное ограничение: 100.</li>
     *                   </ul>
     * @return Информацию о Личных боевых задачах
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<Map<String, PersonalMission>> getPersonalMissions(Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "personalmissions")
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, PersonalMission>>>() {
        });
    }

    /**
     * Метод возвращает информацию о личных резервах.
     *
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
     * @return Информация о личных резервах.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<Map<String, Booster>> getBoosters(Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "boosters")
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, Booster>>>() {
        });
    }

    /**
     * Метод возвращает перечень доступных модулей, которые можно установить на технику, таких как двигатели,
     * башни и т.д.
     * <p>
     * Необходимо указать как минимум один входной параметр фильтра (идентификатор модуля, тип модуля).
     * </p>
     *
     * @param parameters Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                   <ul>
     *                       <li><b>"extra"</b> - Список дополнительных полей, которые будут включены в ответ. Допустимые значения:
     *                          <ul>
     *                              <li><i>"default_profile"</i></li>
     *                          </ul>
     *                      </li>
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
     *                      <li><b>"module_id"</b> - Идентификатор модуля. Максимальное ограничение: 100.</li>
     *                      <li><b>"nation"</b> - Нация. Максимальное ограничение: 100.</li>
     *                      <li><b>"page_no"</b> - Номер страницы результатов.</li>
     *                       <li><b>"type"</b> - Тип модуля. Максимальное ограничение: 100. Допустимые значения:
     *                          <ul>
     *                              <li><i>"vehicleRadio"</i> - Радиостанции.</li>
     *                              <li><i>"vehicleEngine"</i> - Двигатели.</li>
     *                              <li><i>"vehicleGun"</i> - Орудия.</li>
     *                              <li><i>"vehicleChassis"</i> - Ходовые.</li>
     *                              <li><i>"vehicleTurret" - Башни.</i></li>
     *                          </ul>
     *                      </li>
     *                   </ul>
     * @return Перечень доступных модулей.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<Map<String, Module>> getModules(Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "modules")
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, Module>>>() {
        });
    }

    /**
     * Метод возвращает список доступных нашивок.
     *
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
     * @return Список доступных нашивок.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<Map<String, Badge>> getBadges(Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "badges")
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, Badge>>>() {
        });
    }

    /**
     * Метод возвращает полное описание всех специальностей экипажа.
     *
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
     *                      <li><b>"role"</b> - Идентификатор специальности экипажа. Максимальное ограничение: 100.</li>
     *                   </ul>
     * @return Описание специальностей экипажа
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<Map<String, CrewRole>> getCrewRoles(Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "crewroles")
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, CrewRole>>>() {
        });
    }

    /**
     * Метод возвращает полное описание всех умений экипажа.
     *
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
     *                      <li><b>"role"</b> - Идентификатор специальности экипажа. Максимальное ограничение: 100.</li>
     *                      <li><b>"skill"</b> - Идентификатор умения. Максимальное ограничение: 100.</li>
     *                   </ul>
     * @return Описание умений экипажа.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<Map<String, CrewSkill>> getCrewSkills(Parameter... parameters) throws WgApiException {

        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "crewskills")
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, CrewSkill>>>() {
        });
    }
}
