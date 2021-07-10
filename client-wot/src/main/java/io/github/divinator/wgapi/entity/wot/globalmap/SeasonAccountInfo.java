package io.github.divinator.wgapi.entity.wot.globalmap;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.GlobalMapMethod;

import java.util.List;
import java.util.Map;

/**
 * Класс описывает сущность "Статистику игрока для определённого сезона" для метод-блока {@link GlobalMapMethod}
 *
 * @author Sergey Divin
 */
public final class SeasonAccountInfo {

    @SerializedName("seasons")
    private Map<String, List<Season>> seasons;

    /**
     * Метод возвращает информацию о клане по сезонам и уровням техники.
     *
     * @return Информация о клане по сезонам и уровням техники.
     */
    public Map<String, List<Season>> getSeasons() {
        return seasons;
    }

    /**
     * Сущость описывает информацию о клане в сезоне.
     */
    public static class Season {

        @SerializedName("account_id")
        private int accountId;

        @SerializedName("award_level")
        private String awardLevel;

        @SerializedName("battles")
        private int battles;

        @SerializedName("battles_to_award")
        private int battlesToAward;

        @SerializedName("clan_id")
        private int clanId;

        @SerializedName("clan_rank")
        private int clanRank;

        @SerializedName("season_id")
        private String seasonId;

        @SerializedName("updated_at")
        private int updatedAt;

        @SerializedName("vehicle_level")
        private int vehicleLevel;

        /**
         * Метод возвращает идентификатор аккаунта.
         *
         * @return Идентификатор аккаунта.
         */
        public int getAccountId() {
            return accountId;
        }

        /**
         * Метод возвращает уровень награды.
         *
         * @return Уровень награды.
         */
        public String getAwardLevel() {
            return awardLevel;
        }

        /**
         * Метод возвращает проведено боёв за текущий клан.
         *
         * @return Проведено боёв за текущий клан.
         */
        public int getBattles() {
            return battles;
        }

        /**
         * Метод возвращает число боёв, которые необходимо провести в составе текущего клана, чтобы получить клановую награду за сезон.
         *
         * @return Число боёв, которые необходимо провести в составе текущего клана, чтобы получить клановую награду за сезон.
         */
        public int getBattlesToAward() {
            return battlesToAward;
        }

        /**
         * Метод возвращает идентификатор клана.
         *
         * @return Идентификатор клана.
         */
        public int getClanId() {
            return clanId;
        }

        /**
         * Метод возвращает рейтинг клана.
         *
         * @return Рейтинг клана.
         */
        public int getClanRank() {
            return clanRank;
        }

        /**
         * Метод возвращает идентификатор сезона.
         *
         * @return Идентификатор сезона.
         */
        public String getSeasonId() {
            return seasonId;
        }

        /**
         * Метод возвращает дату обновления данных аккаунта.
         *
         * @return Дата обновления данных аккаунта.
         */
        public int getUpdatedAt() {
            return updatedAt;
        }

        /**
         * Метод возвращает уровень техники.
         *
         * @return Уровень техники.
         */
        public int getVehicleLevel() {
            return vehicleLevel;
        }
    }
}
