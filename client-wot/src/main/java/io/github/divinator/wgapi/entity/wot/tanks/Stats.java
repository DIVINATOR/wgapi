package io.github.divinator.wgapi.entity.wot.tanks;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.TanksMethod;

/**
 * Класс описывает сущность "Статистику по каждой единице техники" для метод-блока {@link TanksMethod}
 *
 * @author Sergey Divin
 */
public final class Stats {

    @SerializedName("account_id")
    private int accountId;

    @SerializedName("mark_of_mastery")
    private int markOfMastery;

    @SerializedName("max_frags")
    private int maxFrags;

    @SerializedName("max_xp")
    private int maxXp;

    @SerializedName("tank_id")
    private int tankId;

    @SerializedName("frags")
    private Object frags;

    @SerializedName("in_garage")
    private Object inGarage;

    @SerializedName("all")
    private AllStatisticsWithoutMax all;

    @SerializedName("clan")
    private StatisticsWithMax clan;

    @SerializedName("company")
    private Statistics company;

    @SerializedName("epic")
    private StatisticsWithMax epic;

    @SerializedName("fallout")
    private FalloutStatistics fallout;

    @SerializedName("globalmap")
    private AllStatisticsWithoutMax globalmap;

    @SerializedName("random")
    private StatisticsWithMax random;

    @SerializedName("ranked_battles")
    private StatisticsWithMax rankedBattles;

    @SerializedName("regular_team")
    private StatisticsWithMax regularTeam;

    @SerializedName("stronghold_defense")
    private StrongholdStatistics strongholdDefense;

    @SerializedName("stronghold_skirmish")
    private StrongholdStatistics strongholdSkirmish;

    @SerializedName("team")
    private StatisticsWithMax team;

    /**
     * Метод возвращает идентификатор аккаунта игрока.
     *
     * @return Идентификатор аккаунта игрока.
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Метод возвращает знак классности.
     * <p>
     * 0 — Отсутствует
     * 1 — 3 степень
     * 2 — 2 степень
     * 3 — 1 степень
     * 4 — Мастер
     *
     * @return Знак классности.
     */
    public int getMarkOfMastery() {
        return markOfMastery;
    }

    /**
     * Метод возвращает максимум уничтожено за бой.
     *
     * @return Максимум уничтожено за бой.
     */
    public int getMaxFrags() {
        return maxFrags;
    }

    /**
     * Метод возвращает максимальный опыт за бой.
     *
     * @return Максимальный опыт за бой.
     */
    public int getMaxXp() {
        return maxXp;
    }

    /**
     * Метод возвращает идентификатор техники.
     *
     * @return Идентификатор техники.
     */
    public int getTankId() {
        return tankId;
    }

    /**
     * Метод возвращает количество уничтоженной техники.
     * <p>
     * Данные доступны только при наличии действующего access_token для указанного аккаунта.
     *
     * @return Количество уничтоженной техники.
     */
    public int getFrags() {
        return (frags instanceof Integer) ? (Integer) frags : 0;
    }

    /**
     * Метод возвращает присутствие техники в Ангаре.
     * <p>
     * Данные доступны только при наличии действующего access_token для указанного аккаунта.
     *
     * @return Присутствие техники в Ангаре.
     */
    public boolean inGarage() {
        return (inGarage instanceof Boolean) ? (boolean) inGarage : false;
    }

    /**
     * Метод возвращает всю статистику.
     *
     * @return Вся статистика.
     */
    public AllStatisticsWithoutMax getAll() {
        return all;
    }

    /**
     * Метод возвращает статистику боёв в составе клана.
     *
     * @return Статистика боёв в составе клана.
     */
    public StatisticsWithMax getClan() {
        return clan;
    }

    /**
     * Метод возвращает статистику боёв в составе роты.
     *
     * @return Статистика боёв в составе роты.
     */
    public Statistics getCompany() {
        return company;
    }

    /**
     * Метод возвращает статистику в типе боя «Генеральное сражение».
     * <p>
     * Дополнительное поле.
     *
     * @return Статистика в типе боя «Генеральное сражение».
     */
    public StatisticsWithMax getEpic() {
        return epic;
    }

    /**
     * Метод возвращает статистику в режиме «Бой до последнего».
     * <p>
     * Дополнительное поле.
     *
     * @return Статистика в режиме «Бой до последнего».
     */
    public FalloutStatistics getFallout() {
        return fallout;
    }

    /**
     * Метод возвращает статистику боёв на Глобальной карте.
     *
     * @return Статистика боёв на Глобальной карте.
     */
    public AllStatisticsWithoutMax getGlobalmap() {
        return globalmap;
    }

    /**
     * Метод возвращает статистику случайных боёв.
     * <p>
     * Дополнительное поле.
     *
     * @return Статистика случайных боёв.
     */
    public StatisticsWithMax getRandom() {
        return random;
    }

    /**
     * Метод возвращает статистику в Ранговых боях.
     * <p>
     * Дополнительное поле.
     *
     * @return Статистика в Ранговых боях.
     */
    public StatisticsWithMax getRankedBattles() {
        return rankedBattles;
    }

    /**
     * Метод возвращает статистику командных боёв постоянных команд.
     *
     * @return Статистика командных боёв постоянных команд.
     */
    public StatisticsWithMax getRegularTeam() {
        return regularTeam;
    }

    /**
     * Метод возвращает общую по всем кланам статистику боёв игрока в режиме обороны Укрепрайона.
     *
     * @return Общая по всем кланам статистика боёв игрока в режиме обороны Укрепрайона.
     */
    public StrongholdStatistics getStrongholdDefense() {
        return strongholdDefense;
    }

    /**
     * Метод возвращает общую по всем кланам статистику боёв игрока в режиме вылазок Укрепрайона.
     *
     * @return Общая по всем кланам статистика боёв игрока в режиме вылазок Укрепрайона.
     */
    public StrongholdStatistics getStrongholdSkirmish() {
        return strongholdSkirmish;
    }

    /**
     * Метод возвращает статистику командных боёв.
     *
     * @return Статистика командных боёв.
     */
    public StatisticsWithMax getTeam() {
        return team;
    }

    /**
     * Сущность описывает 19 параметров статистики
     */
    public static class Statistics {

        @SerializedName("battle_avg_xp")
        private int battleAvgXp;

        @SerializedName("battles")
        private int battles;

        @SerializedName("battles_on_stunning_vehicles")
        private int battlesOnStunningVehicles;

        @SerializedName("capture_points")
        private int capturePoints;

        @SerializedName("damage_dealt")
        private int damageDealt;

        @SerializedName("damage_received")
        private int damageReceived;

        @SerializedName("draws")
        private int draws;

        @SerializedName("dropped_capture_points")
        private int droppedCapturePoints;

        @SerializedName("frags")
        private int frags;

        @SerializedName("hits")
        private int hits;

        @SerializedName("hits_percents")
        private int hitsPercents;

        @SerializedName("losses")
        private int losses;

        @SerializedName("shots")
        private int shots;

        @SerializedName("spotted")
        private int spotted;

        @SerializedName("stun_assisted_damage")
        private int stunAssistedDamage;

        @SerializedName("stun_number")
        private int stunNumber;

        @SerializedName("survived_battles")
        private int survivedBattles;

        @SerializedName("wins")
        private int wins;

        @SerializedName("xp")
        private int xp;

        /**
         * Метод возвращает средний опыт за бой.
         *
         * @return Средний опыт за бой.
         */
        public int getBattleAvgXp() {
            return battleAvgXp;
        }

        /**
         * Метод возвращает количество проведенных боёв.
         *
         * @return Количество проведенных боёв.
         */
        public int getBattles() {
            return battles;
        }

        /**
         * Метод возвращает количество боёв на технике, причиняющей оглушение.
         *
         * @return Количество боёв на технике, причиняющей оглушение.
         */
        public int getBattlesOnStunningVehicles() {
            return battlesOnStunningVehicles;
        }

        /**
         * Метод возвращает очки захвата базы.
         *
         * @return Очки захвата базы.
         */
        public int getCapturePoints() {
            return capturePoints;
        }

        /**
         * Метод возвращает количество нанесенных повреждений.
         *
         * @return Количество нанесенных повреждений.
         */
        public int getDamageDealt() {
            return damageDealt;
        }

        /**
         * Метод возвращает количество полученных повреждений.
         *
         * @return Количество полученных повреждений.
         */
        public int getDamageReceived() {
            return damageReceived;
        }

        /**
         * Метод возвращает количество боев сыгранных в ничью.
         *
         * @return Количество боев сыгранных в ничью.
         */
        public int getDraws() {
            return draws;
        }

        /**
         * Метод возвращает очки защиты базы.
         *
         * @return Очки защиты базы.
         */
        public int getDroppedCapturePoints() {
            return droppedCapturePoints;
        }

        /**
         * Метод возвращает количество уничтоженной техники.
         *
         * @return Количество уничтоженной техники.
         */
        public int getFrags() {
            return frags;
        }

        /**
         * Метод возвращает количество попаданий.
         *
         * @return Количество попаданий.
         */
        public int getHits() {
            return hits;
        }

        /**
         * Метод возвращает процент попаданий.
         *
         * @return Процент попаданий.
         */
        public int getHitsPercents() {
            return hitsPercents;
        }

        /**
         * Метод возвращает количество проигранных боев.
         *
         * @return Количество проигранных боев.
         */
        public int getLosses() {
            return losses;
        }

        /**
         * Метод возвращает количество произведенных выстрелов.
         *
         * @return Количество произведенных выстрелов.
         */
        public int getShots() {
            return shots;
        }

        /**
         * Метод возвращает количество обнаруженных противников.
         *
         * @return Количество обнаруженных противников.
         */
        public int getSpotted() {
            return spotted;
        }

        /**
         * Метод возвращает нанесенный урон по оглушённым вами целям.
         *
         * @return Нанесенный урон по оглушённым вами целям.
         */
        public int getStunAssistedDamage() {
            return stunAssistedDamage;
        }

        /**
         * Метод возвращает количество оглушений, причинённых экипажу противника.
         *
         * @return Количество оглушений, причинённых экипажу противника.
         */
        public int getStunNumber() {
            return stunNumber;
        }

        /**
         * Метод возвращает количество боев в которых выжил.
         *
         * @return Количество боев в которых выжил.
         */
        public int getSurvivedBattles() {
            return survivedBattles;
        }

        /**
         * Метод возвращает количество выигранных боев.
         *
         * @return Количество выигранных боев.
         */
        public int getWins() {
            return wins;
        }

        /**
         * Метод возвращает суммарный опыт.
         *
         * @return Суммарный опыт.
         */
        public int getXp() {
            return xp;
        }
    }

    /**
     * Сущность описывает 19 параметров статистики и 3 параметра MAX
     */
    public static class StatisticsWithMax extends Statistics {

        @SerializedName("max_damage")
        private int maxDamage;

        @SerializedName("max_frags")
        private int maxFrags;

        @SerializedName("max_xp")
        private int maxXp;

        /**
         * Метод возвращает максимальный урон за бой.
         *
         * @return Максимальный урон за бой.
         */
        public int getMaxDamage() {
            return maxDamage;
        }

        /**
         * Метод возвращает максимум уничтожено за бой.
         *
         * @return Максимум уничтожено за бой.
         */
        public int getMaxFrags() {
            return maxFrags;
        }

        /**
         * Метод возвращает максимальный опыт за бой.
         *
         * @return Максимальный опыт за бой.
         */
        public int getMaxXp() {
            return maxXp;
        }
    }

    /**
     * Сущность описывает 19 параметров статистики и 8 дополнительных параметра
     */
    public static class AllStatisticsWithoutMax extends Statistics {

        @SerializedName("avg_damage_blocked")
        private float avgDamageBlocked;

        @SerializedName("direct_hits_received")
        private int directHitsReceived;

        @SerializedName("explosion_hits")
        private int explosionHits;

        @SerializedName("explosion_hits_received")
        private int explosionHitsReceived;

        @SerializedName("no_damage_direct_hits_received")
        private int noDamageDirectHitsReceived;

        @SerializedName("piercings")
        private int piercings;

        @SerializedName("piercings_received")
        private int piercingsReceived;

        @SerializedName("tanking_factor")
        private float tankingFactor;

        /**
         * Метод возвращает средний заблокированный бронёй урон за бой.
         * <p>
         * Заблокированный бронёй урон — это урон от снарядов (бронебойных, кумулятивных и подкалиберных),
         * которые попали в танк, но не нанесли урона. Значение считается с версии игры 9.0.
         *
         * @return Средний заблокированный бронёй урон за бой.
         */
        public float getAvgDamageBlocked() {
            return avgDamageBlocked;
        }


        /**
         * Метод возвращает количество полученных прямых попаданий.
         *
         * @return Количество полученных прямых попаданий.
         */
        public int getDirectHitsReceived() {
            return directHitsReceived;
        }

        /**
         * Метод возвращает количество нанесённых осколочно-фугасных попаданий.
         *
         * @return Количество нанесённых осколочно-фугасных попаданий.
         */
        public int getExplosionHits() {
            return explosionHits;
        }

        /**
         * Метод возвращает количество полученных осколочно-фугасных попаданий.
         *
         * @return Количество полученных осколочно-фугасных попаданий.
         */
        public int getExplosionHitsReceived() {
            return explosionHitsReceived;
        }

        /**
         * Метод возвращает Количество полученных прямых попаданий, не нанёсших урон.
         *
         * @return Количество полученных прямых попаданий, не нанёсших урон.
         */
        public int getNoDamageDirectHitsReceived() {
            return noDamageDirectHitsReceived;
        }

        /**
         * Метод возвращает количество пробитий.
         *
         * @return Количество пробитий.
         */
        public int getPiercings() {
            return piercings;
        }

        /**
         * Метод возвращает количество полученных пробитий.
         *
         * @return Количество полученных пробитий.
         */
        public int getPiercingsReceived() {
            return piercingsReceived;
        }

        /**
         * Метод возвращает Отношение заблокированного бронёй урона к полученному игроком урону от бронебойных,
         * кумулятивных, подкалиберных снарядов.
         * <p>
         * Значение считается с версии игры 9.0.
         *
         * @return Отношение заблокированного бронёй урона.
         */
        public float getTankingFactor() {
            return tankingFactor;
        }
    }

    /**
     * Сущность описывает 27 параметров статистики и 3 параметра MAX
     */
    public static class StrongholdStatistics extends AllStatisticsWithoutMax {

        @SerializedName("max_damage")
        private int maxDamage;

        @SerializedName("max_frags")
        private int maxFrags;

        @SerializedName("max_xp")
        private int maxXp;

        /**
         * Метод возвращает максимальный урон за бой.
         *
         * @return Максимальный урон за бой.
         */
        public int getMaxDamage() {
            return maxDamage;
        }

        /**
         * Метод возвращает максимум уничтожено за бой.
         *
         * @return Максимум уничтожено за бой.
         */
        public int getMaxFrags() {
            return maxFrags;
        }

        /**
         * Метод возвращает максимальный опыт за бой.
         *
         * @return Максимальный опыт за бой.
         */
        public int getMaxXp() {
            return maxXp;
        }
    }

    /**
     * Сущность описывает 30 параметров и 14 дополнительных
     */
    public static class FalloutStatistics extends StrongholdStatistics {

        @SerializedName("avatar_damage_dealt")
        private int avatarDamageDealt;

        @SerializedName("avatar_frags")
        private int avatarFrags;

        @SerializedName("avg_damage_assisted")
        private float avgDamageAssisted;

        @SerializedName("avg_damage_assisted_radio")
        private float avgDamageAssistedRadio;

        @SerializedName("avg_damage_assisted_track")
        private float avgDamageAssistedTrack;

        @SerializedName("death_count")
        private int deathCount;

        @SerializedName("max_damage_with_avatar")
        private int maxDamageWithAvatar;

        @SerializedName("max_frags_with_avatar")
        private int maxFragsWithAvatar;

        @SerializedName("max_win_points")
        private int maxWinPoints;

        @SerializedName("resource_absorbed")
        private int resourceAbsorbed;

        @SerializedName("win_points")
        private int winPoints;

        /**
         * Метод возвращает урон, нанесённый при помощи боевых резервов.
         *
         * @return Урон, нанесённый при помощи боевых резервов.
         */
        public int getAvatarDamageDealt() {
            return avatarDamageDealt;
        }

        /**
         * Метод возвращает уничтожено при помощи боевых резервов.
         *
         * @return Уничтожено при помощи боевых резервов.
         */
        public int getAvatarFrags() {
            return avatarFrags;
        }

        /**
         * Метод возвращает средний урон, нанесённый с вашей помощью.
         *
         * @return Средний урон, нанесённый с вашей помощью.
         */
        public float getAvgDamageAssisted() {
            return avgDamageAssisted;
        }

        /**
         * Метод возвращает средний урон по вашим разведданным.
         *
         * @return Средний урон по вашим разведданным.
         */
        public float getAvgDamageAssistedRadio() {
            return avgDamageAssistedRadio;
        }

        /**
         * Метод возвращает средний урон после вашего попадания, сбившего гусеницу.
         *
         * @return Средний урон после вашего попадания, сбившего гусеницу.
         */
        public float getAvgDamageAssistedTrack() {
            return avgDamageAssistedTrack;
        }

        /**
         * Метод возвращает количество смертей в бою.
         *
         * @return Количество смертей в бою.
         */
        public int getDeathCount() {
            return deathCount;
        }

        /**
         * Метод возвращает максимальный урон за бой.
         *
         * @return Максимальный урон за бой.
         */
        @Override
        public int getMaxDamage() {
            return super.maxDamage;
        }

        /**
         * Метод возвращает максимальный урон, нанесённый в одном бою, включая урон от аватара.
         *
         * @return Максимальный урон, нанесённый в одном бою, включая урон от аватара.
         */
        public int getMaxDamageWithAvatar() {
            return maxDamageWithAvatar;
        }

        /**
         * Метод возвращает максимум уничтожено за бой.
         *
         * @return Максимум уничтожено за бой.
         */
        @Override
        public int getMaxFrags() {
            return super.maxFrags;
        }

        /**
         * Метод возвращает максимальное количество уничтоженной техники, включая технику, уничтоженную аватаром.
         *
         * @return Максимальное количество уничтоженной техники, включая технику, уничтоженную аватаром.
         */
        public int getMaxFragsWithAvatar() {
            return maxFragsWithAvatar;
        }

        /**
         * Метод возвращает максимальное количество очков победы, заработанное в режиме «Бой до последнего».
         *
         * @return Максимальное количество очков победы, заработанное в режиме «Бой до последнего».
         */
        public int getMaxWinPoints() {
            return maxWinPoints;
        }

        /**
         * Метод возвращает максимальный опыт за бой.
         *
         * @return Максимальный опыт за бой.
         */
        @Override
        public int getMaxXp() {
            return super.maxXp;
        }

        /**
         * Метод возвращает ресурсы, захваченные на ресурсных точках.
         *
         * @return Ресурсы, захваченные на ресурсных точках.
         */
        public int getResourceAbsorbed() {
            return resourceAbsorbed;
        }

        /**
         * Метод возвращает очки победы.
         *
         * @return Очки победы.
         */
        public int getWinPoints() {
            return winPoints;
        }
    }
}
