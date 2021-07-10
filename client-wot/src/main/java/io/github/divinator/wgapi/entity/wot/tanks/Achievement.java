package io.github.divinator.wgapi.entity.wot.tanks;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.TanksMethod;

import java.util.Map;

/**
 * Класс описывает сущность "Список достижений по технике игрока" для метод-блока {@link TanksMethod}
 *
 * @author Sergey Divin
 */
public final class Achievement {

    @SerializedName("account_id")
    private int accountId;

    @SerializedName("achievements")
    private Map<String, Integer> achievements;

    @SerializedName("max_series")
    private Map<String, Integer> maxSeries;

    @SerializedName("series")
    private Map<String, Integer> series;

    @SerializedName("tank_id")
    private int tankId;

    /**
     * Метод возвращает идентификатор аккаунта игрока.
     *
     * @return Идентификатор аккаунта игрока.
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Метод возвращает полученные достижения.
     *
     * @return Полученные достижения.
     */
    public Map<String, Integer> getAchievements() {
        return achievements;
    }

    /**
     * Метод возвращает максимальные значения серийных достижений.
     *
     * @return Максимальные значения серийных достижений.
     */
    public Map<String, Integer> getMaxSeries() {
        return maxSeries;
    }

    /**
     * Метод возвращает текущие значения серийных достижений.
     *
     * @return Текущие значения серийных достижений.
     */
    public Map<String, Integer> getSeries() {
        return series;
    }

    /**
     * Метод возвращает идентификатор техники.
     *
     * @return Идентификатор техники.
     */
    public int getTankId() {
        return tankId;
    }
}
