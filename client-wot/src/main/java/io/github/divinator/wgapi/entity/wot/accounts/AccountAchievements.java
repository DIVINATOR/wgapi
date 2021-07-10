package io.github.divinator.wgapi.entity.wot.accounts;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.AccountsMethod;

import java.util.Map;

/**
 * Класс описывает сущность "Информация о достижениях игрока" для метод-блока {@link AccountsMethod}
 *
 * @author Sergey Divin
 */
public final class AccountAchievements {

    @SerializedName("achievements")
    private Map<String, Integer> achievements;

    @SerializedName("frags")
    private Map<String, Integer> frags;

    @SerializedName("max_series")
    private Map<String, Integer> maxSeries;

    /**
     * Метод возвращает полученные достижения
     *
     * @return Полученные достижения
     */
    public Map<String, Integer> getAchievements() {
        return achievements;
    }

    /**
     * Метод возвращает прогресс достижений
     *
     * @return Прогресс достижений
     */
    public Map<String, Integer> getFrags() {
        return frags;
    }

    /**
     * Метод возвращает максимальные значения серийных достижений
     *
     * @return Максимальные значения серийных достижений
     */
    public Map<String, Integer> getMaxSeries() {
        return maxSeries;
    }
}
