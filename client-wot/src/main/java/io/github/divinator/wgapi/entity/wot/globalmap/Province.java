package io.github.divinator.wgapi.entity.wot.globalmap;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.GlobalMapMethod;

import java.util.List;

/**
 * Класс описывает сущность "Информация о провинции на Глобальной карте" для метод-блока {@link GlobalMapMethod}
 *
 * @author Sergey Divin
 */
public final class Province {

    @SerializedName("arena_id")
    private String arenaId;

    @SerializedName("arena_name")
    private String arenaName;

    @SerializedName("attackers")
    private List<Integer> attackers;

    @SerializedName("battles_start_at")
    private String battlesStartAt;

    @SerializedName("competitors")
    private List<Integer> competitors;

    @SerializedName("current_min_bet")
    private int currentMinBet;

    @SerializedName("daily_revenue")
    private int dailyRevenue;

    @SerializedName("front_id")
    private String frontId;

    @SerializedName("front_name")
    private String frontName;

    @SerializedName("is_borders_disabled")
    private boolean isBordersDisabled;

    @SerializedName("landing_type")
    private String landingType;

    @SerializedName("last_won_bet")
    private int lastWonBet;

    @SerializedName("max_bets")
    private int maxBets;

    @SerializedName("neighbours")
    private List<String> neighbours;

    @SerializedName("owner_clan_id")
    private int ownerClanId;

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

    @SerializedName("round_number")
    private int roundNumber;

    @SerializedName("server")
    private String server;

    @SerializedName("status")
    private String status;

    @SerializedName("uri")
    private String uri;

    @SerializedName("world_redivision")
    private boolean isWorldRedivision;

    @SerializedName("active_battles")
    private List<ActiveBattles> activeBattles;

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
     * Метод возвращает список идентификаторов атакующих кланов.
     *
     * @return Список идентификаторов атакующих кланов.
     */
    public List<Integer> getAttackers() {
        return attackers;
    }

    /**
     * Метод возвращает время начала сражений в UTC.
     *
     * @return Время начала сражений в UTC.
     */
    public String getBattlesStartAt() {
        return battlesStartAt;
    }

    /**
     * Метод возвращает список идентификаторов кланов участвующих в турнире.
     *
     * @return Список идентификаторов кланов участвующих в турнире.
     */
    public List<Integer> getCompetitors() {
        return competitors;
    }

    /**
     * Метод возвращает текущая минимальная ставка.
     *
     * @return Текущая минимальная ставка.
     */
    public int getCurrentMinBet() {
        return currentMinBet;
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
     * Метод показывает, что границы провинции закрыты.
     *
     * @return Показывает, что границы провинции закрыты.
     */
    public boolean isBordersDisabled() {
        return isBordersDisabled;
    }

    /**
     * Метод возвращает Тип высадки
     * <p>Тип: аукцион, турнир или значение "null"
     *
     * @return Тип высадки.
     */
    public String getLandingType() {
        return landingType;
    }

    /**
     * Метод возвращает последняя выигрышная ставка.
     *
     * @return Последняя выигрышная ставка.
     */
    public int getLastWonBet() {
        return lastWonBet;
    }

    /**
     * Метод возвращает максимальное количество ставок.
     *
     * @return Максимальное количество ставок.
     */
    public int getMaxBets() {
        return maxBets;
    }

    /**
     * Метод возвращает список идентификаторов соседних провинций.
     *
     * @return Список идентификаторов соседних провинций.
     */
    public List<String> getNeighbours() {
        return neighbours;
    }

    /**
     * Метод возвращает идентификатор клана владельца.
     *
     * @return Идентификатор клана владельца.
     */
    public int getOwnerClanId() {
        return ownerClanId;
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
     * Метод возвращает Уровень доходности от 0 до 11.
     * <p>Значение 0 означает, что доходность не повышалась.
     *
     * @return Уровень доходности от 0 до 11.
     */
    public int getRevenueLevel() {
        return revenueLevel;
    }

    /**
     * Метод возвращает текущий раунд.
     *
     * @return Текущий раунд.
     */
    public int getRoundNumber() {
        return roundNumber;
    }

    /**
     * Метод возвращает идентификатор сервера.
     *
     * @return Идентификатор сервера.
     */
    public String getServer() {
        return server;
    }

    /**
     * Метод возвращает Статус турнира.
     * <p>Тип: STARTED, FINISHED или null
     *
     * @return Статус турнира.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Метод возвращает относительную ссылку на провинцию.
     *
     * @return Относительная ссылка на провинцию.
     */
    public String getUri() {
        return uri;
    }

    /**
     * Метод показывает, включен ли Передел мира.
     *
     * @return Показывает, включен ли Передел мира.
     */
    public boolean isWorldRedivision() {
        return isWorldRedivision;
    }

    /**
     * Метод возвращает список текущих битв.
     *
     * @return Список текущих битв.
     */
    public List<ActiveBattles> getActiveBattles() {
        return activeBattles;
    }

    /**
     * Сушность описывает Текущиу битву
     */
    public static class ActiveBattles {

        @SerializedName("round")
        private int round;

        @SerializedName("start_at")
        private String startAt;

        @SerializedName("clan_a")
        private Clan clanA;

        @SerializedName("clan_b")
        private Clan clanB;

        /**
         * Метод возвращает текущий раунд.
         *
         * @return Текущий раунд.
         */
        public int getRound() {
            return round;
        }

        /**
         * Метод возвращает время начала битвы в UTC.
         *
         * @return Время начала битвы в UTC.
         */
        public String getStartAt() {
            return startAt;
        }

        /**
         * Метод возвращает идентификатор первого клана-участника
         *
         * @return Идентификатор первого клана-участника
         */
        public Clan getClanA() {
            return clanA;
        }

        /**
         * Метод возвращает идентификатор второго клана-участника
         *
         * @return Идентификатор второго клана-участника
         */
        public Clan getClanB() {
            return clanB;
        }

        /**
         * Сущность описывает клан-участник.
         */
        public static class Clan {
            @SerializedName("battle_reward")
            private int battleReward;

            @SerializedName("clan_id")
            private int clanId;

            @SerializedName("loose_elo_delta")
            private int looseEloDelta;

            @SerializedName("win_elo_delta")
            private int winEloDelta;

            /**
             * Метод возвращает награду.
             *
             * @return Награда.
             */
            public int getBattleReward() {
                return battleReward;
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
             * Метод возвращает изменение в рейтинге Эло в результате поражения.
             *
             * @return Изменения в рейтинге Эло в результате поражения.
             */
            public int getLooseEloDelta() {
                return looseEloDelta;
            }

            /**
             * Метод возвращает изменения в рейтинге Эло в результате победы.
             *
             * @return Изменения в рейтинге Эло в результате победы.
             */
            public int getWinEloDelta() {
                return winEloDelta;
            }
        }
    }
}
