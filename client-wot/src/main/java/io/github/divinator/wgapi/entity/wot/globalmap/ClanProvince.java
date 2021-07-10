package io.github.divinator.wgapi.entity.wot.globalmap;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.GlobalMapMethod;

/**
 * Класс описывает сущность "Провинция клана на Глобальной Карте" для метод-блока {@link GlobalMapMethod}
 *
 * @author Sergey Divin
 */
public final class ClanProvince {

    @SerializedName("arena_id")
    private String arenaId;

    @SerializedName("arena_name")
    private String arenaName;

    @SerializedName("clan_id")
    private int clanId;

    @SerializedName("daily_revenue")
    private int dailyRevenue;

    @SerializedName("front_id")
    private String frontId;

    @SerializedName("front_name")
    private String frontName;

    @SerializedName("landing_type")
    private String landingType;

    @SerializedName("max_vehicle_level")
    private int maxVehicleLevel;

    @SerializedName("pillage_end_at")
    private String pillageEndAt;

    @SerializedName("prime_time")
    private String primeTime;

    @SerializedName("province_id")
    private String provinceId;

    @SerializedName("province_name")
    private String provinceName;

    @SerializedName("revenue_level")
    private int revenueLevel;

    @SerializedName("turns_owned")
    private int turnsOwned;

    @SerializedName("private")
    private Private privat;

    /**
     * Метод возвращает идентификатор игровой карты.
     *
     * @return Идентификатор игровой карты.
     */
    public String getArenaId() {
        return arenaId;
    }

    /**
     * Метод возвращает локализованное название карты.
     *
     * @return Локализованное название карты.
     */
    public String getArenaName() {
        return arenaName;
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
     * Метод возвращает доходность за день.
     *
     * @return Доходность за день.
     */
    public int getDailyRevenue() {
        return dailyRevenue;
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
     * Метод возвращает показывает, является ли провинция высадочной.
     *
     * @return Показывает, является ли провинция высадочной.
     */
    public String getLandingType() {
        return landingType;
    }

    /**
     * Метод возвращает максимальный уровень техники на Фронте.
     *
     * @return Максимальный уровень техники на Фронте.
     */
    public int getMaxVehicleLevel() {
        return maxVehicleLevel;
    }

    /**
     * Метод возвращает дату, когда провинция восстановит свою доходность после разграбления.
     *
     * @return Дата, когда провинция восстановит свою доходность после разграбления.
     */
    public String getPillageEndAt() {
        return pillageEndAt;
    }

    /**
     * Метод возвращает прайм-тайм в UTC.
     *
     * @return Прайм-тайм в UTC.
     */
    public String getPrimeTime() {
        return primeTime;
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
     * Метод возвращает уровень доходности от 0 до 11.
     * <p>
     * Значение 0 означает, что доходность не повышалась.
     *
     * @return Уровень доходности от 0 до 11.
     */
    public int getRevenueLevel() {
        return revenueLevel;
    }

    /**
     * Метод возвращает длительность владения провинцией (в ходах).
     *
     * @return Длительность владения провинцией (в ходах).
     */
    public int getTurnsOwned() {
        return turnsOwned;
    }

    /**
     * Метод возвращает секретную информацию о провинции.
     *
     * @return Секретная информация о провинции.
     */
    public Private getPrivate() {
        return privat;
    }

    /**
     * Сущность рписывает секретную информацию о провинции
     */
    public static class Private {

        @SerializedName("hq_connected")
        private boolean isHqConnected;

        @SerializedName("is_revenue_limit_exceeded")
        private boolean isRevenueLimitExceeded;

        /**
         * Метод показывает наличие связи со штабом клана.
         *
         * @return Показывает наличие связи со штабом клана.
         */
        public boolean isHqConnected() {
            return isHqConnected;
        }

        /**
         * Метод показывает достигнута ли максимальная доходность провинции.
         * <p>
         * False — максимальный доход не получен, доходность провинции блокируется,
         * но может быть заблокирована по правилам события.
         * <p>
         * True — получен максимальный доход, доходность провинции заблокирована.
         *
         * @return Показывает достигнута ли максимальная доходность провинции
         */
        public boolean isRevenueLimitExceeded() {
            return isRevenueLimitExceeded;
        }
    }
}
