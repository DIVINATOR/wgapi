package io.github.divinator.wgapi.entity.wot.stronghold;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.StrongholdMethod;

import java.util.List;

/**
 * Класс описывает сущность "Информацию и боевую статистику кланов в режиме «Укрепрайон»" для метод-блока {@link StrongholdMethod}
 * <p>Обратите внимание, что информация о количестве проведённых боёв, а также количестве побед и поражений клана обновляется один раз в сутки.
 *
 * @author Sergey Divin
 */
public final class StrongholdInformation {

    @SerializedName("clan_id")
    private int clanId;

    @SerializedName("clan_name")
    private String clanName;

    @SerializedName("clan_tag")
    private String clanTag;

    @SerializedName("command_center_arena_id")
    private String commandCenterArenaId;

    @SerializedName("stronghold_buildings_level")
    private int strongholdBuildingsLevel;

    @SerializedName("stronghold_level")
    private int strongholdLevel;

    @SerializedName("battles_for_strongholds_statistics")
    private StrongholdsStatisticsAll strongholdsStatisticsAll;

    @SerializedName("battles_series_for_strongholds_statistics")
    private StrongholdsStatistics strongholdsStatisticsOffensive;

    @SerializedName("skirmish_statistics")
    private StrongholdsStatisticsSkirmish strongholdsStatisticsSkirmish;

    @SerializedName("building_slots")
    private List<BuildingSlot> buildingSlots;

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
     * Метод возвращает идентификатор карты, привязанный стройплощадке командного центра.
     *
     * @return Идентификатор карты, привязанный стройплощадке командного центра.
     */
    public String getCommandCenterArenaId() {
        return commandCenterArenaId;
    }

    /**
     * Метод возвращает суммарный уровень строений Укрепрайона
     *
     * @return Суммарный уровень строений Укрепрайона.
     */
    public int getStrongholdBuildingsLevel() {
        return strongholdBuildingsLevel;
    }

    /**
     * Метод возвращает уровень Укрепрайона.
     *
     * @return Уровень Укрепрайона.
     */
    public int getStrongholdLevel() {
        return strongholdLevel;
    }

    /**
     * Метод возвращает статистику сражений клана в режиме «Укрепрайон».
     *
     * @return Статистика сражений клана в режиме «Укрепрайон».
     */
    public StrongholdsStatisticsAll getStrongholdsStatisticsAll() {
        return strongholdsStatisticsAll;
    }

    /**
     * Метод возвращает статистику по наступлениям в режиме «Укрепрайон».
     *
     * @return Статистика по наступлениям в режиме «Укрепрайон».
     */
    public StrongholdsStatistics getStrongholdsStatisticsOffensive() {
        return strongholdsStatisticsOffensive;
    }

    /**
     * Метод возвращает статистику вылазок клана в режиме «Укрепрайон»
     *
     * @return Статистика вылазок клана в режиме «Укрепрайон»
     */
    public StrongholdsStatisticsSkirmish getStrongholdsStatisticsSkirmish() {
        return strongholdsStatisticsSkirmish;
    }

    /**
     * Метод возвращает информацию о стройплощадках Укрепрайона.
     *
     * @return Информация о стройплощадках Укрепрайона.
     */
    public List<BuildingSlot> getBuildingSlots() {
        return buildingSlots;
    }

    /**
     * Сущность описывает статистику наступлений клана в режиме «Укрепрайон».
     */
    public static class StrongholdsStatistics {

        @SerializedName("lose_10")
        private int loseBattleOn10Level;

        @SerializedName("total_10")
        private int totalBattleOn10Level;

        @SerializedName("total_10_in_28d")
        private int totalBattleOn10LevelIn28d;

        @SerializedName("win_10")
        private int winBattleOn10Level;

        @SerializedName("win_10_in_28d")
        private int winBattleOn10LevelIn28d;

        /**
         * Метод возвращает количество поражений на технике X уровня.
         *
         * @return Количество поражений на технике X уровня.
         */
        public int getLoseBattleOn10Level() {
            return loseBattleOn10Level;
        }

        /**
         * Метод возвращает общее количество боёв на технике X уровня.
         *
         * @return Общее количество боёв на технике X уровня.
         */
        public int getTotalBattleOn10Level() {
            return totalBattleOn10Level;
        }

        /**
         * Метод возвращает общее количество боёв на технике X уровня за 28 дней.
         *
         * @return Общее количество боёв на технике X уровня за 28 дней.
         */
        public int getTotalBattleOn10LevelIn28d() {
            return totalBattleOn10LevelIn28d;
        }

        /**
         * Метод возвращает количество побед на технике X уровня.
         *
         * @return Количество побед на технике X уровня.
         */
        public int getWinBattleOn10Level() {
            return winBattleOn10Level;
        }

        /**
         * Метод возвращает количество побед на технике X уровня за 28 дней.
         *
         * @return Количество побед на технике X уровня за 28 дней.
         */
        public int getWinBattleOn10LevelIn28d() {
            return winBattleOn10LevelIn28d;
        }
    }

    /**
     * Сущность описывает статистику всех сражений клана в режиме «Укрепрайон».
     */
    public static class StrongholdsStatisticsAll extends StrongholdsStatistics {

        @SerializedName("last_time_10")
        private int lastTime10Level;

        /**
         * Метод возвращает время окончания последнего боя, проведённого на технике X уровня.
         *
         * @return Время окончания последнего боя, проведённого на технике X уровня.
         */
        public int getLastTime10Level() {
            return lastTime10Level;
        }
    }

    /**
     * Сущность описывает статистику вылазок клана в режиме «Укрепрайон».
     */
    public static class StrongholdsStatisticsSkirmish extends StrongholdsStatisticsAll {

        @SerializedName("last_time_8")
        private int lastTime8Level;

        @SerializedName("lose_8")
        private int loseBattleOn8Level;

        @SerializedName("total_8")
        private int totalBattleOn8Level;

        @SerializedName("total_8_in_28d")
        private int totalBattleOn8LevelIn28d;

        @SerializedName("win_8")
        private int winBattleOn8Level;

        @SerializedName("win_8_in_28d")
        private int winBattleOn8LevelIn28d;

        @SerializedName("last_time_6")
        private int lastTime6Level;

        @SerializedName("lose_6")
        private int loseBattleOn6Level;

        @SerializedName("total_6")
        private int totalBattleOn6Level;

        @SerializedName("total_6_in_28d")
        private int totalBattleOn6LevelIn28d;

        @SerializedName("win_6")
        private int winBattleOn6Level;

        @SerializedName("win_6_in_28d")
        private int winBattleOn6LevelIn28d;

        /**
         * Метод возвращает время окончания последнего боя, проведённого на технике VIII уровня.
         *
         * @return Время окончания последнего боя, проведённого на технике VIII уровня.
         */
        public int getLastTime8Level() {
            return lastTime8Level;
        }

        /**
         * Метод возвращает количество поражений на технике VIII уровня.
         *
         * @return Количество поражений на технике VIII уровня.
         */
        public int getLoseBattleOn8Level() {
            return loseBattleOn8Level;
        }

        /**
         * Метод возвращает общее количество боёв на технике VIII уровня.
         *
         * @return Общее количество боёв на технике VIII уровня.
         */
        public int getTotalBattleOn8Level() {
            return totalBattleOn8Level;
        }

        /**
         * Метод возвращает общее количество боёв на технике VIII уровня за 28 дней.
         *
         * @return Общее количество боёв на технике VIII уровня за 28 дней.
         */
        public int getTotalBattleOn8LevelIn28d() {
            return totalBattleOn8LevelIn28d;
        }

        /**
         * Метод возвращает количество побед на технике VIII уровня.
         *
         * @return Количество побед на технике VIII уровня.
         */
        public int getWinBattleOn8Level() {
            return winBattleOn8Level;
        }

        /**
         * Метод возвращает количество побед на технике VIII уровня за 28 дней.
         *
         * @return Количество побед на технике VIII уровня за 28 дней.
         */
        public int getWinBattleOn8LevelIn28d() {
            return winBattleOn8LevelIn28d;
        }

        /**
         * Метод возвращает время окончания последнего боя, проведённого на технике VI уровня.
         *
         * @return Время окончания последнего боя, проведённого на технике VI уровня.
         */
        public int getLastTime6Level() {
            return lastTime6Level;
        }

        /**
         * Метод возвращает количество поражений на технике VI уровня.
         *
         * @return Количество поражений на технике VI уровня.
         */
        public int getLoseBattleOn6Level() {
            return loseBattleOn6Level;
        }

        /**
         * Метод возвращает общее количество боёв на технике VI уровня.
         *
         * @return Общее количество боёв на технике VI уровня.
         */
        public int getTotalBattleOn6Level() {
            return totalBattleOn6Level;
        }

        /**
         * Метод возвращает общее количество боёв на технике VI уровня за 28 дней.
         *
         * @return Общее количество боёв на технике VI уровня за 28 дней.
         */
        public int getTotalBattleOn6LevelIn28d() {
            return totalBattleOn6LevelIn28d;
        }

        /**
         * Метод возвращает количество побед на технике VI уровня.
         *
         * @return Количество побед на технике VI уровня.
         */
        public int getWinBattleOn6Level() {
            return winBattleOn6Level;
        }

        /**
         * Метод возвращает количество побед на технике VI уровня за 28 дней.
         *
         * @return Количество побед на технике VI уровня за 28 дней.
         */
        public int getWinBattleOn6LevelIn28d() {
            return winBattleOn6LevelIn28d;
        }
    }

    /**
     * Сущность описывает слот стройплощадки Укрепрайона.
     */
    public static class BuildingSlot {

        @SerializedName("arena_id")
        private String arenaId;

        @SerializedName("building_level")
        private int buildingLevel;

        @SerializedName("building_title")
        private String buildingTitle;

        @SerializedName("direction")
        private String direction;

        @SerializedName("position")
        private String position;

        @SerializedName("reserve_title")
        private String reserveTitle;

        /**
         * Метод возвращает идентификатор карты, привязанный к текущей стройплощадке.
         *
         * @return Идентификатор карты, привязанный к текущей стройплощадке.
         */
        public String getArenaId() {
            return arenaId;
        }

        /**
         * Метод возвращает уровень строения, расположенного на текущей стройплощадке.
         *
         * @return Уровень строения, расположенного на текущей стройплощадке.
         */
        public int getBuildingLevel() {
            return buildingLevel;
        }

        /**
         * Метод возвращает название строения, расположенного на текущей стройплощадке.
         *
         * @return Название строения, расположенного на текущей стройплощадке.
         */
        public String getBuildingTitle() {
            return buildingTitle;
        }

        /**
         * Метод возвращает название плацдарма.
         *
         * @return Название плацдарма.
         */
        public String getDirection() {
            return direction;
        }

        /**
         * Метод возвращает позицию стройплощадки.
         *
         * @return Позиция стройплощадки.
         */
        public String getPosition() {
            return position;
        }

        /**
         * Метод возвращает название Резерва, заработанного в строении, расположенном на текущей стройплощадке.
         *
         * @return Название Резерва, заработанного в строении, расположенном на текущей стройплощадке.
         */
        public String getReserveTitle() {
            return reserveTitle;
        }
    }
}
