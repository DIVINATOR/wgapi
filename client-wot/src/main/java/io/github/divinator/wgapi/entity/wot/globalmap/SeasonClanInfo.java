package io.github.divinator.wgapi.entity.wot.globalmap;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.GlobalMapMethod;

import java.util.List;
import java.util.Map;

/**
 * Класс описывает сущность "Статистику клана для определённого сезона" для метод-блока {@link GlobalMapMethod}
 *
 * @author Sergey Divin
 */
public final class SeasonClanInfo {

    @SerializedName("seasons")
    private Map<String, List<Season>> seasons;

    /**
     * Метод возвращает информацию о клане по сезонам и уровням техники.
     * @return Информация о клане по сезонам и уровням техники.
     */
    public Map<String, List<Season>> getSeasons() {
        return seasons;
    }

    /**
     * Сущость описывает информацию о клане в сезоне.
     */
    public static class Season {

        @SerializedName("battles")
        private int battles;

        @SerializedName("elo")
        private int elo;

        @SerializedName("rank")
        private int rank;

        @SerializedName("rank_delta")
        private int rankDelta;

        @SerializedName("vehicle_level")
        private int vehicleLevel;

        @SerializedName("victory_points")
        private int victoryPoints;

        @SerializedName("victory_points_since_turn")
        private int victoryPointsSinceTurn;

        @SerializedName("wins")
        private int wins;

        /**
         * Метод возвращает количество проведенных боёв в сезоне.
         *
         * @return Количество проведенных боёв в сезоне.
         */
        public int getBattles() {
            return battles;
        }

        /**
         * Метод возвращает рейтинг Эло.
         *
         * @return Рейтинг Эло.
         */
        public int getElo() {
            return elo;
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
         * Метод возвращает изменение в рейтинге во время предыдущего хода.
         *
         * @return Изменение в рейтинге во время предыдущего хода.
         */
        public int getRankDelta() {
            return rankDelta;
        }

        /**
         * Метод возвращает уровень техники.
         *
         * @return Уровень техники.
         */
        public int getVehicleLevel() {
            return vehicleLevel;
        }

        /**
         * Метод возвращает очки победы.
         *
         * @return Очки победы.
         */
        public int getVictoryPoints() {
            return victoryPoints;
        }

        /**
         * Метод возвращает изменение очков победы с момента последнего расчёта хода.
         *
         * @return Изменение очков победы с момента последнего расчёта хода.
         */
        public int getVictoryPointsSinceTurn() {
            return victoryPointsSinceTurn;
        }

        /**
         * Метод возвращает количество Побед.
         *
         * @return количество Побед.
         */
        public int getWins() {
            return wins;
        }
    }
}
