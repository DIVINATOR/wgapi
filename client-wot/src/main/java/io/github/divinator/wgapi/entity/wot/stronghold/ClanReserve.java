package io.github.divinator.wgapi.entity.wot.stronghold;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.StrongholdMethod;

import java.util.List;

/**
 * Класс описывает сущность "Доступный резерв и его текущий статус в «Укрепрайоне»" для метод-блока {@link StrongholdMethod}
 *
 * @author Sergey Divin
 */
public final class ClanReserve {

    @SerializedName("bonus_type")
    private String bonusType;

    @SerializedName("disposable")
    private boolean isDisposable;

    @SerializedName("icon")
    private String icon;

    @SerializedName("name")
    private String name;

    @SerializedName("type")
    private String type;

    @SerializedName("in_stock")
    private List<Stock> stock;

    /**
     * Метод возвращает тип эффекта резерва.
     *
     * @return Тип эффекта резерва.
     */
    public String getBonusType() {
        return bonusType;
    }

    /**
     * Метод возвращает показывает, является ли резерв резервом для сражений.
     *
     * @return Показывает, является ли резерв резервом для сражений.
     */
    public boolean isDisposable() {
        return isDisposable;
    }

    /**
     * Метод возвращает URL к значку.
     *
     * @return URL к значку.
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Метод возвращает название резерва.
     *
     * @return Название резерва.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод возвращает тип резерва.
     *
     * @return Тип резерва.
     */
    public String getType() {
        return type;
    }

    /**
     * Метод возвращает список доступных клановых резервов и их статус.
     *
     * @return Список доступных клановых резервов и их статус.
     */
    public List<Stock> getStock() {
        return stock;
    }

    /**
     * Сущность описывает доступные клановые резервы и их статус.
     */
    public static class Stock {

        @SerializedName("action_time")
        private Object actionTime;

        @SerializedName("activated_at")
        private Object activatedAt;

        @SerializedName("active_till")
        private Object activeTill;

        @SerializedName("amount")
        private int amount;

        @SerializedName("level")
        private int level;

        @SerializedName("status")
        private String status;

        @SerializedName("x_level_only")
        private boolean xLevelOnly;

        @SerializedName("bonus_values")
        private List<Bonus> bonusValues;

        /**
         * Метод возвращает время действия клановых резервов каждого уровня.
         *
         * @return Время действия клановых резервов каждого уровня.
         */
        public int getActionTime() {
            return (int) actionTime;
        }

        /**
         * Метод возвращает время активации клановых резервов каждого уровня.
         *
         * @return Время активации клановых резервов каждого уровня.
         */
        public int getActivatedAt() {
            return (int) activatedAt;
        }

        /**
         * Метод возвращает время окончания действия клановых резервов каждого уровня.
         *
         * @return Время окончания действия клановых резервов каждого уровня.
         */
        public int getActiveTill() {
            return (int) activeTill;
        }

        /**
         * Метод возвращает количество клановых резервов каждого уровня.
         *
         * @return Количество клановых резервов каждого уровня.
         */
        public int getAmount() {
            return amount;
        }

        /**
         * Метод возвращает уровень доступных клановых резервов.
         *
         * @return Уровень доступных клановых резервов.
         */
        public int getLevel() {
            return level;
        }

        /**
         * Метод возвращает статус клановых резервов каждого уровня.
         *
         * @return Статус клановых резервов каждого уровня.
         */
        public String getStatus() {
            return status;
        }

        /**
         * Метод показывает, подходит ли резерв только для техники X уровня.
         *
         * @return Показывает, подходит ли резерв только для техники X уровня.
         */
        public boolean isxLevelOnly() {
            return xLevelOnly;
        }

        /**
         * Метод возвращает эффекты резерва.
         *
         * @return Эффекты резерва.
         */
        public List<Bonus> getBonusValues() {
            return bonusValues;
        }

        /**
         * Сущность описывает эффект резерва.
         */
        public static class Bonus {

            @SerializedName("battle_type")
            private String battle_type;

            @SerializedName("value")
            private float value;

            /**
             * Метод возвращает тип боя для бонуса.
             *
             * @return Тип боя
             */
            public String getBattle_type() {
                return battle_type;
            }

            /**
             * Метод возвращает значение эффекта резерва для каждого типа боя.
             *
             * @return Значение эффекта резерва для каждого типа боя.
             */
            public float getValue() {
                return value;
            }
        }
    }
}
