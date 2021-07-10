package io.github.divinator.wgapi.method.wot;

import com.google.gson.reflect.TypeToken;
import io.divinator.wgapi.client.AbstractMethodBlock;
import io.divinator.wgapi.client.*;
import io.divinator.wgapi.entity.JsonResponse;
import io.divinator.wgapi.entity.wot.stronghold.ActivateClanReserve;
import io.divinator.wgapi.entity.wot.stronghold.ClanReserve;
import io.divinator.wgapi.entity.wot.stronghold.StrongholdInformation;

import java.util.List;
import java.util.Map;

/**
 * Класс описывет Метод-блок для получения информации об укрепрайонах WorldOfTanks.
 *
 * @author Sergey Divin
 */
public class StrongholdMethod extends AbstractMethodBlock {

    private final static String METHOD_BLOCK = "stronghold";

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
     * Метод возвращает общую информацию и боевую статистику кланов в режиме «Укрепрайон».
     * <p>
     * Обратите внимание, что информация о количестве проведённых боёв, а также количестве побед и
     * поражений клана обновляется один раз в сутки.
     *
     * @param clanId     Идентификатор клана. Чтобы получить его, используйте метод Кланы. Максимальное ограничение: 10.
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
     * @return Информацию и боевую статистику кланов в режиме «Укрепрайон»
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом GET
     */
    public JsonResponse<Map<String, StrongholdInformation>> getStrongholdsInformation(String clanId, Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "claninfo")
                .withParameter(new Parameter("clan_id", clanId))
                .withParameters(parameters);

        return super.get(urlBuilder, new TypeToken<JsonResponse<Map<String, StrongholdInformation>>>() {
        });
    }

    /**
     * Метод возвращает информацию о доступных резервах и их текущем статусе.
     * <p>Переданные переменные, кроме "accessToken", могут быть NULL</p>
     *
     * @param accessToken Ключ доступа к личным данным аккаунта пользователя; можно получить при помощи метода
     *                    авторизации; действителен в течение определённого времени
     * @param parameters  Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                    <ul>
     *                       <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                       Для исключения поля используется знак «-» перед названием поля.
     *                       Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
     *                       </li>
     *                       <li><b>"language"</b> - Язык локализации. По умолчанию: "ru". Допустимые значения:
     *                           <ul>
     *                               <li><i>"en"</i> — English</li>
     *                               <li><i>"ru"</i> — Русский (используется по умолчанию)</li>
     *                               <li><i>"pl"</i> — Polski</li>
     *                               <li><i>"de"</i> — Deutsch</li>
     *                               <li><i>"fr"</i> — Français</li>
     *                               <li><i>"es"</i> — Español</li>
     *                               <li><i>"zh-cn"</i> — 简体中文</li>
     *                               <li><i>"zh-tw"</i> — 繁體中文</li>
     *                               <li><i>"tr"</i> — Türkçe</li>
     *                               <li><i>"cs"</i> — Čeština</li>
     *                               <li><i>"th"</i> — ไทย</li>
     *                               <li><i>"vi"</i> — Tiếng Việt</li>
     *                               <li><i>"ko"</i> — 한국어</li>
     *                           </ul>
     *                       </li>
     *                    </ul>
     * @return Информация о доступных резервах и их текущем статусе.
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом POST
     */
    public JsonResponse<List<ClanReserve>> getClanReserves(String accessToken, Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "clanreserves")
                .withAccessToken(accessToken)
                .withParameters(parameters);

        return super.post(urlBuilder, new TypeToken<JsonResponse<List<ClanReserve>>>() {
        });
    }

    /**
     * Метод активирует доступный клановый резерв.
     * <p>Активировать резерв может только игрок клана, у которого есть необходимые права.
     * <p>Переданные переменные, кроме "accessToken", "reserveType", "reserveLevel", могут быть NULL</p>
     *
     * @param accessToken  Ключ доступа к личным данным аккаунта пользователя; можно получить при помощи
     *                     метода авторизации; действителен в течение определённого времени
     * @param reserveType  Тип кланового резерва для активации
     * @param reserveLevel Уровень кланового резерва для активации
     * @param parameters   Массив необязательных параметров запроса (пример - <code>new Parameter("key", "value")</code>), где ключи параметров:
     *                     <ul>
     *                        <li><b>"fields"</b> - Поля ответа. Поля разделяются запятыми. Вложенные поля разделяются точками.
     *                        Для исключения поля используется знак «-» перед названием поля.
     *                        Если параметр не указан, возвращаются все поля. Максимальное ограничение: 100.
     *                        </li>
     *                        <li><b>"language"</b> - Язык локализации. По умолчанию: "ru". Допустимые значения:
     *                            <ul>
     *                                <li><i>"en"</i> — English</li>
     *                                <li><i>"ru"</i> — Русский (используется по умолчанию)</li>
     *                                <li><i>"pl"</i> — Polski</li>
     *                                <li><i>"de"</i> — Deutsch</li>
     *                                <li><i>"fr"</i> — Français</li>
     *                                <li><i>"es"</i> — Español</li>
     *                                <li><i>"zh-cn"</i> — 简体中文</li>
     *                                <li><i>"zh-tw"</i> — 繁體中文</li>
     *                                <li><i>"tr"</i> — Türkçe</li>
     *                                <li><i>"cs"</i> — Čeština</li>
     *                                <li><i>"th"</i> — ไทย</li>
     *                                <li><i>"vi"</i> — Tiếng Việt</li>
     *                                <li><i>"ko"</i> — 한국어</li>
     *                            </ul>
     *                        </li>
     *                     </ul>
     * @return Активация доступного кланового резерва в «Укрепрайоне».
     * @throws WgApiException В случае если парсинг данных не удался, либо если возникла ошибка отправки
     *                        HTTP-запроса методом POST
     */
    public JsonResponse<ActivateClanReserve> activateClanReserve(String accessToken, String reserveLevel, String reserveType,
                                                                 Parameter... parameters) throws WgApiException {
        WgApiUriBuilder urlBuilder = getWgApiUriBuilder()
                .withMethod(METHOD_BLOCK, "activateclanreserve")
                .withAccessToken(accessToken)
                .withParameter(new Parameter("reserve_level", reserveLevel))
                .withParameter(new Parameter("reserve_type", reserveType))
                .withParameters(parameters);

        return super.post(urlBuilder, new TypeToken<JsonResponse<ActivateClanReserve>>() {
        });
    }
}
