package io.github.divinator.wgapi.entity.wot.globalmap;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.GlobalMapMethod;

import java.util.List;
import java.util.Map;

/**
 * Сущность описывает "Информацию о клане по событиям и фронтам" для метод-блока {@link GlobalMapMethod}
 *
 * @author Sergey Divin
 */
public final class EventClanInfo {


    @SerializedName("events")
    private Map<String, List<Event>> events;

    /**
     * Метод возвращает информацию о клане по событиям и фронтам.
     *
     * @return Информация о клане по событиям и фронтам.
     */
    public Map<String, List<Event>> getEvents() {
        return events;
    }

    /**
     * Сущность описывает событие
     */
    public static class Event {

        @SerializedName("battle_fame_points")
        private int battleFamePoints;

        @SerializedName("battles")
        private int battles;

        @SerializedName("event_id")
        private String eventId;

        @SerializedName("fame_points")
        private int famePoints;

        @SerializedName("fame_points_since_turn")
        private int famePointsSinceTurn;

        @SerializedName("front_id")
        private String frontId;

        @SerializedName("rank")
        private int rank;

        @SerializedName("rank_delta")
        private int rankDelta;

        @SerializedName("task_fame_points")
        private int taskFamePoints;

        @SerializedName("url")
        private String url;

        @SerializedName("wins")
        private int wins;

        /**
         * Метод возвращает очки славы за бои.
         *
         * @return Очки славы за бои.
         */
        public int getBattleFamePoints() {
            return battleFamePoints;
        }

        /**
         * Метод возвращает проведено боёв.
         *
         * @return Проведено боёв.
         */
        public int getBattles() {
            return battles;
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
         * Метод возвращает очки славы за выполнение кланового задания.
         *
         * @return Очки славы за выполнение кланового задания.
         */
        public int getTaskFamePoints() {
            return taskFamePoints;
        }

        /**
         * Метод возвращает ссылка на фронт.
         *
         * @return Ссылка на фронт.
         */
        public String getUrl() {
            return url;
        }

        /**
         * Метод возвращает количество побед.
         *
         * @return Количество побед.
         */
        public int getWins() {
            return wins;
        }
    }
}

