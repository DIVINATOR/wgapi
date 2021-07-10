package io.github.divinator.wgapi.entity.wot.globalmap;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.GlobalMapMethod;

import java.util.List;
import java.util.Map;


/**
 * Сущность описывает "Статистику игрока для определённого события" для метод-блока {@link GlobalMapMethod}
 *
 * @author Sergey Divin
 */
public final class EventAccountInfo {

    @SerializedName("events")
    private Map<String, List<Event>> events;

    /**
     * Метод возвращает информацию об аккаунте по событию и фронту
     *
     * @return Информация об аккаунте по событию и фронту
     */
    public Map<String, List<Event>> getEvents() {
        return events;
    }

    /**
     * Сущность описывает событие
     */
    public static class Event {

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

        @SerializedName("event_id")
        private String eventId;

        @SerializedName("fame_points")
        private int famePoints;

        @SerializedName("fame_points_since_turn")
        private int famePointsSinceTurn;

        @SerializedName("fame_points_to_improve_award")
        private int famePointsToImproveAward;

        @SerializedName("front_id")
        private String frontId;

        @SerializedName("rank")
        private int rank;

        @SerializedName("rank_delta")
        private int rankDelta;

        @SerializedName("updated_at")
        private int updatedAt;

        @SerializedName("url")
        private String url;

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
         * Метод возвращает идентификатор события.
         *
         * @return Идентификатор события.
         */
        public String getEventId() {
            return eventId;
        }

        /**
         * Метод возвращает суммарное количество очков славы.
         *
         * @return Суммарное количество очков славы.
         */
        public int getFamePoints() {
            return famePoints;
        }

        /**
         * Метод возвращает изменение Очков славы с момента последнего расчёта хода.
         *
         * @return Изменение Очков славы с момента последнего расчёта хода.
         */
        public int getFamePointsSinceTurn() {
            return famePointsSinceTurn;
        }

        /**
         * Метод возвращает количество Очков славы, необходимое для улучшения личной награды.
         *
         * @return Количество Очков славы, необходимое для улучшения личной награды.
         */
        public int getFamePointsToImproveAward() {
            return famePointsToImproveAward;
        }

        /**
         * Метод возвращает идентификатор фронта.
         *
         * @return Идентификатор фронта.
         */
        public String getFrontId() {
            return frontId;
        }

        /**
         * Метод возвращает текущий рейтинг.
         *
         * @return Текущий рейтинг.
         */
        public int getRank() {
            return rank;
        }

        /**
         * Метод возвращает изменения в рейтинге во время предыдущего хода.
         *
         * @return Изменения в рейтинге во время предыдущего хода.
         */
        public int getRankDelta() {
            return rankDelta;
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
         * Метод возвращает ссылку на фронт.
         *
         * @return Ссылка на фронт.
         */
        public String getUrl() {
            return url;
        }
    }
}
