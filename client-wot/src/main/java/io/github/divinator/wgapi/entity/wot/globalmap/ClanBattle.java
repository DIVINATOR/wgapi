package io.github.divinator.wgapi.entity.wot.globalmap;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.GlobalMapMethod;

/**
 * Класс описывает сущность "Бой из списка боев клана на Глобальной карте" для метод-блока {@link GlobalMapMethod}
 *
 * @author Sergey Divin
 */
public final class ClanBattle {

    @SerializedName("attack_type")
    private String attackType;

    @SerializedName("competitor_id")
    private int competitorId;

    @SerializedName("front_id")
    private String frontId;

    @SerializedName("front_name")
    private String frontName;

    @SerializedName("province_id")
    private String provinceId;

    @SerializedName("province_name")
    private String provinceName;

    @SerializedName("time")
    private int time;

    @SerializedName("type")
    private String type;

    @SerializedName("vehicle_level")
    private int vehicleLevel;

    /**
     * Метод возвращает тип атаки.
     * <p>
     * Типы: наземный, аукцион, турнир
     *
     * @return Тип атаки.
     */
    public String getAttackType() {
        return attackType;
    }

    /**
     * Метод возвращает идентификатор клана противника.
     *
     * @return Идентификатор клана противника.
     */
    public int getCompetitorId() {
        return competitorId;
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
     * Метод возвращает название фронта.
     *
     * @return Название фронта.
     */
    public String getFrontName() {
        return frontName;
    }

    /**
     * Метод возвращает идентификатор провинции.
     *
     * @return Идентификатор провинции.
     */
    public String getProvinceId() {
        return provinceId;
    }

    /**
     * Метод возвращает название провинции.
     *
     * @return Название провинции.
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * Метод возвращает дату и время боя.
     *
     * @return Дата и время боя.
     */
    public int getTime() {
        return time;
    }

    /**
     * Метод возвращает тип боя.
     * <p>
     * Типы: атака или оборона
     *
     * @return Тип боя.
     */
    public String getType() {
        return type;
    }

    /**
     * Метод возвращает Уровень техники.
     *
     * @return Уровень техники.
     */
    public int getVehicleLevel() {
        return vehicleLevel;
    }
}
