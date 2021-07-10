package io.github.divinator.wgapi.entity.wot.globalmap;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.GlobalMapMethod;

/**
 * Сущность описывает "Клановый рейтинг в событии" для метод-блока {@link GlobalMapMethod}
 *
 * @author Sergey Divin
 */
public final class EventClanRating {

    @SerializedName("award_level")
    private String awardLevel;

    @SerializedName("battle_fame_points")
    private int battleFamePoints;

    @SerializedName("clan_id")
    private int clanId;

    @SerializedName("color")
    private String color;

    @SerializedName("fame_points_to_improve_award")
    private int famePointsToImproveAward;

    @SerializedName("name")
    private String name;

    @SerializedName("rank")
    private int rank;

    @SerializedName("rank_delta")
    private int rankDelta;

    @SerializedName("tag")
    private String tag;

    @SerializedName("task_fame_points")
    private Object taskFamePoints;

    @SerializedName("total_fame_points")
    private int totalFamePoints;

    @SerializedName("updated_at")
    private int updatedAt;

    /**
     * Метод возвращает уровень награды.
     * @return Уровень награды.
     */
    public String getAwardLevel() {
        return awardLevel;
    }

    /**
     * Метод возвращает очки славы за бои.
     * @return Очки славы за бои.
     */
    public int getBattleFamePoints() {
        return battleFamePoints;
    }

    /**
     * Метод возвращает идентификатор клана.
     * @return Идентификатор клана.
     */
    public int getClanId() {
        return clanId;
    }

    /**
     * Метод возвращает цвет клана.
     * @return Цвет клана.
     */
    public String getColor() {
        return color;
    }

    /**
     * Метод возвращает количество Очков славы, необходимое для улучшения личной награды.
     * @return Количество Очков славы, необходимое для улучшения личной награды.
     */
    public int getFamePointsToImproveAward() {
        return famePointsToImproveAward;
    }

    /**
     * Метод возвращает название клана.
     * @return Название клана.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод возвращает текущий рейтинг.
     * @return Текущий рейтинг.
     */
    public int getRank() {
        return rank;
    }

    /**
     * Метод возвращает изменения в рейтинге во время предыдущего хода.
     * @return Изменения в рейтинге во время предыдущего хода.
     */
    public int getRankDelta() {
        return rankDelta;
    }

    /**
     * Метод возвращает тег клана.
     * @return Тег клана.
     */
    public String getTag() {
        return tag;
    }

    /**
     * Метод возвращает очки славы за выполнение кланового задания.
     * @return Очки славы за выполнение кланового задания.
     */
    public int getTaskFamePoints() {
        return (int) taskFamePoints;
    }

    /**
     * Метод возвращает суммарное количество очков славы.
     * @return Суммарное количество очков славы.
     */
    public int getTotalFamePoints() {
        return totalFamePoints;
    }

    /**
     * Метод возвращает дату подсчёта рейтинга.
     * @return Дата подсчёта рейтинга.
     */
    public int getUpdatedAt() {
        return updatedAt;
    }
}
