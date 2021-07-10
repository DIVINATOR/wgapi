package io.github.divinator.wgapi.entity.wot.globalmap;


import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.GlobalMapMethod;

import java.util.List;

/**
 * Класс описывает сущьность "Фронт Глобальной карты" для метод-блока {@link GlobalMapMethod}
 *
 * @author Sergey Divin
 */
public final class Front {

    @SerializedName("avg_clans_rating")
    private int avgClansRating;

    @SerializedName("avg_min_bet")
    private int avgMinBet;

    @SerializedName("avg_won_bet")
    private int avgWonBet;

    @SerializedName("battle_time_limit")
    private int battleTimeLimit;

    @SerializedName("division_cost")
    private int divisionCost;

    @SerializedName("fog_of_war")
    private boolean isFogOfWar;

    @SerializedName("front_id")
    private String frontId;

    @SerializedName("front_name")
    private String frontName;

    @SerializedName("is_active")
    private boolean isActive;

    @SerializedName("is_event")
    private boolean isEvent;

    @SerializedName("max_tanks_per_division")
    private int maxTanksPerDivision;

    @SerializedName("max_vehicle_level")
    private int maxVehicleLevel;

    @SerializedName("min_tanks_per_division")
    private int minTanksPerDivision;

    @SerializedName("min_vehicle_level")
    private int minVehicleLevel;

    @SerializedName("provinces_count")
    private int provincesCount;

    @SerializedName("vehicle_freeze")
    private boolean isVehicleFreeze;

    @SerializedName("available_extensions")
    private List<AvailableExtension> availableExtensions;

    /**
     * Метод возвращает средний уровень кланов.
     *
     * @return Средний уровень кланов.
     */
    public int getAvgClansRating() {
        return avgClansRating;
    }

    /**
     * Метод возвращает средняя минимальная ставка.
     *
     * @return Средняя минимальная ставка.
     */
    public int getAvgMinBet() {
        return avgMinBet;
    }

    /**
     * Метод возвращает средняя выигрышная ставка.
     *
     * @return Средняя выигрышная ставка.
     */
    public int getAvgWonBet() {
        return avgWonBet;
    }

    /**
     * Метод возвращает максимальное время боя в минутах.
     *
     * @return Максимальное время боя в минутах.
     */
    public int getBattleTimeLimit() {
        return battleTimeLimit;
    }

    /**
     * Метод возвращает стоимость покупки дивизии.
     *
     * @return Стоимость покупки дивизии.
     */
    public int getDivisionCost() {
        return divisionCost;
    }

    /**
     * Метод показывает, присутствует ли Туман войны.
     *
     * @return Показывает, присутствует ли Туман войны.
     */
    public boolean isFogOfWar() {
        return isFogOfWar;
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
     * Метод возвращает Название фронта.
     *
     * @return Название фронта.
     */
    public String getFrontName() {
        return frontName;
    }

    /**
     * Метод возвращает	Показывает, активна ли карта.
     *
     * @return Показывает, активна ли карта.
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Метод возвращает Показывает тип карты: обычная карта или карта события.
     *
     * @return Показывает тип карты: обычная карта или карта события.
     */
    public boolean isEvent() {
        return isEvent;
    }

    /**
     * Метод возвращает максимальное количество техники в дивизионе.
     *
     * @return Максимальное количество техники в дивизионе.
     */
    public int getMaxTanksPerDivision() {
        return maxTanksPerDivision;
    }

    /**
     * Метод возвращает максимальный уровень техники.
     *
     * @return Максимальный уровень техники.
     */
    public int getMaxVehicleLevel() {
        return maxVehicleLevel;
    }

    /**
     * Метод возвращает минимальное количество техники в дивизионе.
     *
     * @return Минимальное количество техники в дивизионе.
     */
    public int getMinTanksPerDivision() {
        return minTanksPerDivision;
    }

    /**
     * Метод возвращает минимальный уровень техники.
     *
     * @return Минимальный уровень техники.
     */
    public int getMinVehicleLevel() {
        return minVehicleLevel;
    }

    /**
     * Метод возвращает количество провинций.
     *
     * @return Количество провинций.
     */
    public int getProvincesCount() {
        return provincesCount;
    }

    /**
     * Метод возвращает показывает, присутствует ли блокировка техники.
     *
     * @return Показывает, присутствует ли блокировка техники.
     */
    public boolean isVehicleFreeze() {
        return isVehicleFreeze;
    }

    /**
     * Метод возвращает список доступных модулей.
     *
     * @return Доступные модули.
     */
    public List<AvailableExtension> getAvailableExtensions() {
        return availableExtensions;
    }

    /**
     * Сущность описывает доступный модуль.
     */
    public static class AvailableExtension {

        @SerializedName("cost")
        private int cost;

        @SerializedName("description_strategic")
        private String descriptionStrategic;

        @SerializedName("description_tactical")
        private String descriptionTactical;

        @SerializedName("extension_id")
        private String extensionId;

        @SerializedName("name")
        private String name;

        @SerializedName("wage")
        private int wage;

        /**
         * Метод возвращает стоимость покупки модулей.
         *
         * @return Стоимость покупки модулей.
         */
        public int getCost() {
            return cost;
        }

        /**
         * Метод возвращает локализованое описание стратегического эффекта.
         *
         * @return Локализованое описание стратегического эффекта.
         */
        public String getDescriptionStrategic() {
            return descriptionStrategic;
        }

        /**
         * Метод возвращает локализованое описание тактического эффекта.
         *
         * @return Локализованое описание тактического эффекта.
         */
        public String getDescriptionTactical() {
            return descriptionTactical;
        }

        /**
         * Метод возвращает идентификатор расходника.
         *
         * @return Идентификатор расходника.
         */
        public String getExtensionId() {
            return extensionId;
        }

        /**
         * Метод возвращает локализованое название cнаряжения.
         *
         * @return Локализованое название cнаряжения.
         */
        public String getName() {
            return name;
        }

        /**
         * Метод возвращает стоимость содержания модулей.
         *
         * @return Стоимость содержания модулей.
         */
        public int getWage() {
            return wage;
        }
    }
}
