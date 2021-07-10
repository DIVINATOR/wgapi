package io.github.divinator.wgapi.entity.wot.globalmap;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.GlobalMapMethod;

/**
 * Класс описывает сущность "Данные клана на Глобальной Карте" для метод-блока {@link GlobalMapMethod}
 *
 * @author Sergey Divin
 */
public final class ClanInfo {

    @SerializedName("clan_id")
    private int clanId;

    @SerializedName("name")
    private String name;

    @SerializedName("tag")
    private String tag;

    @SerializedName("private")
    private Private privat;

    @SerializedName("ratings")
    private Ratings ratings;

    @SerializedName("statistics")
    private Statistics statistics;

    /**
     * Метод возвращает идентификатор клана.
     * @return Идентификатор клана.
     */
    public int getClanId() {
        return clanId;
    }

    /**
     * Метод возвращает название клана.
     * @return Название клана.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод возвращает тег клана.
     * @return Тег клана.
     */
    public String getTag() {
        return tag;
    }

    /**
     * Метод возвращает секретную информацию клана на Глобальной карте.
     * @return Секретная информация клана на Глобальной карте.
     */
    public Private getPrivat() {
        return privat;
    }

    /**
     * Метод возвращает рейтинг клана на Глобальной карте.
     * @return Рейтинг клана на Глобальной карте.
     */
    public Ratings getRatings() {
        return ratings;
    }

    /**
     * Метод возвращает статистику клана на Глобальной карте.
     * @return Статистика клана на Глобальной карте.
     */
    public Statistics getStatistics() {
        return statistics;
    }

    /**
     * Сущность описывает приватные данные клана.
     */
    public static class Private {

        @SerializedName("daily_wage")
        private int dailyWage;

        @SerializedName("influence")
        private int influence;

        /**
         * Метод возвращает дневной расход очков влияния.
         *
         * @return Дневной расход очков влияния.
         */
        public int getDailyWage() {
            return dailyWage;
        }

        /**
         * Метод возвращает Количество очков влияния.
         *
         * @return Количество очков влияния.
         */
        public int getInfluence() {
            return influence;
        }
    }

    /**
     * Сущность описывает Рейтинг клана на Глобальной карте.
     */
    public static class Ratings {

        @SerializedName("elo_10")
        private int elo10;

        @SerializedName("elo_8")
        private int elo8;

        @SerializedName("elo_6")
        private int elo6;

        @SerializedName("updated_at")
        private int updatedAt;

        /**
         * Метод возвращает рейтинг Эло клана в абсолютном дивизионе.
         *
         * @return Рейтинг Эло клана в абсолютном дивизионе.
         */
        public int getElo10() {
            return elo10;
        }

        /**
         * Метод возвращает рейтинг Эло клана в чемпионском дивизионе.
         *
         * @return Рейтинг Эло клана в чемпионском дивизионе.
         */
        public int getElo8() {
            return elo8;
        }

        /**
         * Метод возвращает рейтинг Эло клана в среднем дивизионе.
         *
         * @return Рейтинг Эло клана в среднем дивизионе.
         */
        public int getElo6() {
            return elo6;
        }

        /**
         * Метод возвращает Время обновления рейтингов.
         *
         * @return Время обновления рейтингов.
         */
        public int getUpdatedAt() {
            return updatedAt;
        }
    }

    /**
     * Сущность описывает статистику клана на Глобальной карте.
     */
    public static class Statistics {

        @SerializedName("battles")
        private int battles;

        @SerializedName("battles_10_level")
        private int battleOn10Level;

        @SerializedName("battles_8_level")
        private int battleOn8Level;

        @SerializedName("battles_6_level")
        private int battleOn6Level;

        @SerializedName("captures")
        private int captures;

        @SerializedName("losses")
        private int losses;

        @SerializedName("provinces_count")
        private int provincesCount;

        @SerializedName("wins")
        private int wins;

        @SerializedName("wins_10_level")
        private int winsBattleOn10Level;

        @SerializedName("wins_8_level")
        private int winsBattleOn8Level;

        @SerializedName("wins_6_level")
        private int winsBattleOn6Level;

        /**
         * Метод возвращает количество боёв.
         *
         * @return Количество боёв.
         */
        public int getBattles() {
            return battles;
        }

        /**
         * Метод возвращает количество боёв в Абсолютном дивизионе.
         *
         * @return Количество боёв в Абсолютном дивизионе.
         */
        public int getBattleOn10Level() {
            return battleOn10Level;
        }

        /**
         * Метод возвращает количество боёв Чемпионском дивизионе.
         *
         * @return Количество боёв Чемпионском дивизионе.
         */
        public int getBattleOn8Level() {
            return battleOn8Level;
        }

        /**
         * Метод возвращает количество боёв Среднем дивизионе.
         *
         * @return Количество боёв Среднем дивизионе.
         */
        public int getBattleOn6Level() {
            return battleOn6Level;
        }

        /**
         * Метод возвращает общее количество провинций, захваченных кланом.
         *
         * @return Общее количество провинций, захваченных кланом.
         */
        public int getCaptures() {
            return captures;
        }

        /**
         * Метод возвращает количество поражений.
         *
         * @return Количество поражений.
         */
        public int getLosses() {
            return losses;
        }

        /**
         * Метод возвращает текущее количество захваченных провинций.
         *
         * @return Текущее количество захваченных провинций.
         */
        public int getProvincesCount() {
            return provincesCount;
        }

        /**
         * Метод возвращает количество побед клана.
         *
         * @return Количество побед клана.
         */
        public int getWins() {
            return wins;
        }

        /**
         * Метод возвращает количество побед в Абсолютном дивизионе.
         *
         * @return Количество побед в Абсолютном дивизионе.
         */
        public int getWinsBattleOn10Level() {
            return winsBattleOn10Level;
        }

        /**
         * Метод возвращает количество побед в Чемпионском дивизионе.
         *
         * @return Количество побед в Чемпионском дивизионе.
         */
        public int getWinsBattleOn8Level() {
            return winsBattleOn8Level;
        }

        /**
         * Метод возвращает количество побед в Среднем дивизионе.
         *
         * @return Количество побед в Среднем дивизионе.
         */
        public int getWinsBattleOn6Level() {
            return winsBattleOn6Level;
        }
    }
}
