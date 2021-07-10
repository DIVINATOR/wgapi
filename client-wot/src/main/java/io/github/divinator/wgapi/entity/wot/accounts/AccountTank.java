package io.github.divinator.wgapi.entity.wot.accounts;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.AccountsMethod;

/**
 * Класс описывает сущность "Информация о технике игрока" для метод-блока {@link AccountsMethod}
 *
 * @author Sergey Divin
 */
public final class AccountTank {

    @SerializedName("mark_of_mastery")
    private int markOfMastery;

    @SerializedName("tank_id")
    private int tankId;

    @SerializedName("statistics")
    private Statistics statistics;

    /**
     * Метод возвращает знак классности.
     * <p>
     * 0 — Отсутствует
     * 1 — 3 степень
     * 2 — 2 степень
     * 3 — 1 степень
     * 4 — Мастер
     *
     * @return Знак классности.
     */
    public int getMarkOfMastery() {
        return markOfMastery;
    }

    /**
     * Метод возвращает идентификатор техники.
     *
     * @return Идентификатор техники.
     */
    public int getTankId() {
        return tankId;
    }

    /**
     * Метод возвращает статистику на танке.
     *
     * @return Статистика машины.
     */
    public Statistics getStatistics() {
        return statistics;
    }

    /**
     * Сущность описывает статистику машины.
     */
    public static class Statistics {

        @SerializedName("battles")
        private int battles;

        @SerializedName("wins")
        private int wins;

        /**
         * Метод возвращает количество проведенных боёв.
         *
         * @return Количество проведенных боёв.
         */
        public int getBattles() {
            return battles;
        }

        /**
         * Метод возвращает количество победных боев на танке.
         *
         * @return Количество победных боев на танке.
         */
        public int getWins() {
            return wins;
        }
    }
}
