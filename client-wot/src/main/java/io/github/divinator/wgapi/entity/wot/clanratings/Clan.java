package io.github.divinator.wgapi.entity.wot.clanratings;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.ClanRatingsMethod;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Класс описывает сущность "Рейтинги кланов" для метод-блока {@link ClanRatingsMethod}
 *
 * @author Sergey Divin
 */
public final class Clan {

    @SerializedName("clan_id")
    private int clanId;

    @SerializedName("clan_name")
    private String clanName;

    @SerializedName("clan_tag")
    private String clanTag;

    @SerializedName("exclude_reasons")
    private Map<String, String> excludeReasons;

    @SerializedName("battles_count_avg")
    private Rank battlesCountAvg;

    @SerializedName("battles_count_avg_daily")
    private Rank battlesCountAvgDaily;

    @SerializedName("efficiency")
    private Rank efficiency;

    @SerializedName("fb_elo_rating")
    private Rank fbEloRating;

    @SerializedName("fb_elo_rating_10")
    private Rank fbEloRating10;

    @SerializedName("fb_elo_rating_8")
    private Rank fbEloRating8;

    @SerializedName("fb_elo_rating_6")
    private Rank fbEloRating6;

    @SerializedName("global_rating_avg")
    private Rank globalRatingAvg;

    @SerializedName("global_rating_weighted_avg")
    private Rank globalRatingWeightedAvg;

    @SerializedName("gm_elo_rating")
    private Rank gmEloRating;

    @SerializedName("gm_elo_rating_10")
    private Rank gmEloRating10;

    @SerializedName("gm_elo_rating_8")
    private Rank gmEloRating8;

    @SerializedName("gm_elo_rating_6")
    private Rank gmEloRating6;

    @SerializedName("rating_fort")
    private Rank ratingFort;

    @SerializedName("v10l_avg")
    private Rank vehicle10LevelAvg;

    @SerializedName("wins_ratio_avg")
    private Rank winsRatioAvg;

    /**
     * Метод возвращает идентификатор клана.
     *
     * @return Идентификатор клана.
     */
    public int getClanId() {
        return clanId;
    }

    /**
     * Метод возвращает название клана.
     *
     * @return Название клана.
     */
    public String getClanName() {
        return clanName;
    }

    /**
     * Метод возвращает тег клана.
     *
     * @return Тег клана.
     */
    public String getClanTag() {
        return clanTag;
    }

    /**
     * Метод возвращает причины, по которым не были рассчитаны определённые категории рейтингов.
     * <p>
     * Содержит данные в формате ключ-значение, где ключом является название категории, а значением причина.
     * <p>
     * Возможные причины:
     * inactivity - Неактивность на протяжении 28 дней
     * newbies_measure - В клане меньше десяти игроков
     * limits - Условия ранка не выполнены
     * blocked - Клан заблокирован
     * other - Технические причины
     *
     * @return Причины, по которым не были рассчитаны определённые категории рейтингов
     */
    public Map<String, String> getExcludeReasons() {
        return excludeReasons;
    }

    /**
     * Метод возвращает среднее количество боёв.
     *
     * @return Среднее количество боёв.
     */
    public Rank getBattlesCountAvg() {
        return battlesCountAvg;
    }

    /**
     * Метод возвращает среднее количество боёв в день.
     *
     * @return Среднее количество боёв в день.
     */
    public Rank getBattlesCountAvgDaily() {
        return battlesCountAvgDaily;
    }

    /**
     * Метод возвращает показатель клановой эффективности.
     *
     * @return Показатель клановой эффективности.
     */
    public Rank getEfficiency() {
        return efficiency;
    }

    /**
     * Метод возвращает взвешенное значение рейтинга Эло, достигнутое в режиме «Укрепрайон».
     *
     * @return Взвешенное значение рейтинга Эло, достигнутое в режиме «Укрепрайон».
     */
    public Rank getStrongholdEloRating() {
        return fbEloRating;
    }

    /**
     * Метод возвращает значение рейтинга Эло, достигнутое кланом на технике X уровня в режиме «Укрепрайон».
     *
     * @return Значение рейтинга Эло, достигнутое кланом на технике X уровня в режиме «Укрепрайон».
     */
    public Rank getStrongholdEloRating10() {
        return fbEloRating10;
    }

    /**
     * Метод возвращает значение рейтинга Эло, достигнутое на технике VIII уровня в режиме «Укрепрайон»
     *
     * @return Значение рейтинга Эло, достигнутое на технике VIII уровня в режиме «Укрепрайон»
     */
    public Rank getStrongholdEloRating8() {
        return fbEloRating8;
    }

    /**
     * Метод возвращает значение рейтинга Эло, достигнутое на технике VI уровня в режиме «Укрепрайон».
     *
     * @return Значение рейтинга Эло, достигнутое на технике VI уровня в режиме «Укрепрайон».
     */
    public Rank getStrongholdEloRating6() {
        return fbEloRating6;
    }

    /**
     * Метод возвращает среднее значение глобального рейтинга.
     *
     * @return Среднее значение глобального рейтинга.
     */
    public Rank getGlobalRatingAvg() {
        return globalRatingAvg;
    }

    /**
     * Метод возвращает средневзвешенное значение глобального рейтинга.
     *
     * @return Средневзвешенное значение глобального рейтинга.
     */
    public Rank getGlobalRatingWeightedAvg() {
        return globalRatingWeightedAvg;
    }

    /**
     * Метод возвращает Рейтинг Эло на Глобальной карте.
     *
     * @return Рейтинг Эло на Глобальной карте.
     */
    public Rank getGlobalMapEloRating() {
        return gmEloRating;
    }

    /**
     * Метод возвращает рейтинг Эло на Глобальной карте в абсолютном дивизионе.
     *
     * @return Рейтинг Эло на Глобальной карте в абсолютном дивизионе.
     */
    public Rank getGlobalMapEloRating10() {
        return gmEloRating10;
    }

    /**
     * Метод возвращает рейтинг Эло на Глобальной карте в чемпионском дивизионе.
     *
     * @return Рейтинг Эло на Глобальной карте в чемпионском дивизионе.
     */
    public Rank getGlobalMapEloRating8() {
        return gmEloRating8;
    }

    /**
     * Метод возвращает Рейтинг Эло на Глобальной карте в среднем дивизионе
     *
     * @return Рейтинг Эло на Глобальной карте в среднем дивизионе
     */
    public Rank getGlobalMapEloRating6() {
        return gmEloRating6;
    }

    /**
     * Метод возвращает рейтинг в Битвах за Укрепрайон.
     *
     * @return Рейтинг в Битвах за Укрепрайон.
     */
    public Rank getRatingFort() {
        return ratingFort;
    }

    /**
     * Метод возвращает среднее количество техники 10 уровня на игрока клана.
     *
     * @return Среднее количество техники 10 уровня на игрока клана.
     */
    public Rank getVehicle10LevelAvg() {
        return vehicle10LevelAvg;
    }

    /**
     * Метод возвращает Средний процент побед.
     *
     * @return Средний процент побед.
     */
    public Rank getWinsRatioAvg() {
        return winsRatioAvg;
    }

    /**
     * Сущность описывает среднее количество боёв.
     */
    public static class Rank {

        @SerializedName("rank")
        private Object rank;

        @SerializedName("rank_delta")
        private Object rankDelta;

        @SerializedName("value")
        private float value;

        /**
         * Метод возвращает позицию.
         * <p>
         * В случае, если от Wargaming.net Public API получено значение NUll, то метод вернет 0
         *
         * @return Позиция.
         */
        public int getRank() {
            return (rank instanceof BigDecimal) ? ((BigDecimal) rank).intValue() : 0;
        }

        /**
         * Метод возвращает изменение позиции в рейтинге.
         * <p>
         * В случае, если от Wargaming.net Public API получено значение NUll, то метод вернет 0
         *
         * @return Изменение позиции в рейтинге.
         */
        public int getRankDelta() {
            return (rankDelta instanceof BigDecimal) ? ((BigDecimal) rankDelta).intValue() : 0;
        }

        /**
         * Метод возвращает абсолютное значение.
         *
         * @return Абсолютное значение.
         */
        public float getValue() {
            return value;
        }
    }
}
