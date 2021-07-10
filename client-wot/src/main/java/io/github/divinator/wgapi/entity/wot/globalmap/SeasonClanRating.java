package io.github.divinator.wgapi.entity.wot.globalmap;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.GlobalMapMethod;

/**
 * Класс описывает сущность "Клановый рейтинг сезона" для метод-блока {@link GlobalMapMethod}
 *
 * @author Sergey Divin
 */
public final class SeasonClanRating {

    @SerializedName("award_level")
    private String awardLevel;

    @SerializedName("clan_id")
    private int clanId;

    @SerializedName("color")
    private String color;

    @SerializedName("name")
    private String name;

    @SerializedName("rank")
    private int rank;

    @SerializedName("rank_delta")
    private int rankDelta;

    @SerializedName("tag")
    private String tag;

    @SerializedName("updated_at")
    private int updatedAt;

    @SerializedName("victory_points")
    private int victoryPoints;

    @SerializedName("victory_points_to_next_award")
    private int victoryPointsToNextAward;

    /**
     * Метод возвращает уровень награды.
     *
     * @return Уровень награды.
     */
    public String getAwardLevel() {
        return awardLevel;
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
     * Метод возвращает цвет клана.
     *
     * @return Цвет клана.
     */
    public String getColor() {
        return color;
    }

    /**
     * Метод возвращает название клана.
     *
     * @return Название клана.
     */
    public String getName() {
        return name;
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
     * Метод возвращает тег клана.
     *
     * @return Тег клана.
     */
    public String getTag() {
        return tag;
    }

    /**
     * Метод возвращает дата подсчёта рейтинга.
     *
     * @return Дата подсчёта рейтинга.
     */
    public int getUpdatedAt() {
        return updatedAt;
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
     * Метод возвращает очки победы для получения следующей награды.
     *
     * @return Очки победы для получения следующей награды.
     */
    public int getVictoryPointsToNextAward() {
        return victoryPointsToNextAward;
    }
}
