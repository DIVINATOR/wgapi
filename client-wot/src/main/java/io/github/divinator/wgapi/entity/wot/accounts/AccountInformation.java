package io.github.divinator.wgapi.entity.wot.accounts;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.AccountsMethod;

import java.util.List;
import java.util.Map;

/**
 * Класс описывает сущность "Информация об акаунте игрока" для метод-блока {@link AccountsMethod}
 *
 * @author Sergey Divin
 */
public final class AccountInformation {

    @SerializedName("account_id")
    private int accountId;

    @SerializedName("clan_id")
    private int clanId;

    @SerializedName("created_at")
    private int createdAt;

    @SerializedName("global_rating")
    private int globalRating;

    @SerializedName("last_battle_time")
    private int lastBattleTime;

    @SerializedName("logout_at")
    private int logoutAt;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("updated_at")
    private int updatedAt;

    @SerializedName("private")
    private Private privat;

    @SerializedName("statistics")
    private Statistics statistics;

    /**
     * Метод возвращает идентификатор аккаунта игрока.
     *
     * @return Идентификатор аккаунта игрока.
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Метод возвращает идентификатор клана игрока.
     *
     * @return Идентификатор клана игрока.
     */
    public int getClanId() {
        return clanId;
    }

    /**
     * Метод возвращает дату создания аккаунта игрока.
     *
     * @return Дата создания аккаунта игрока.
     */
    public int getCreatedAt() {
        return createdAt;
    }

    /**
     * Метод возвращает Личный рейтинг игрока.
     *
     * @return Личный рейтинг игрока.
     */
    public int getGlobalRating() {
        return globalRating;
    }

    /**
     * Метод возвращает время последнего боя.
     *
     * @return Время последнего боя.
     */
    public int getLastBattleTime() {
        return lastBattleTime;
    }

    /**
     * Метод возвращает время окончания последней игровой сессии.
     *
     * @return Время окончания последней игровой сессии.
     */
    public int getLogoutAt() {
        return logoutAt;
    }

    /**
     * Метод возвращает имя игрока.
     *
     * @return Имя игрока.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Метод возвращает дату обновления информации об игроке.
     *
     * @return Дата обновления информации об игроке.
     */
    public int getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Метод возвращает приватные данные игрока.
     *
     * @return Приватные данные игрока.
     */
    public Private getPrivat() {
        return privat;
    }

    /**
     * Метод возвращает статистику игрока.
     *
     * @return Статистика игрока.
     */
    public Statistics getStatistics() {
        return statistics;
    }

    /**
     * Сущность описывает приватную информацию об аккаунте игрока.
     */
    public static class Private {

        @SerializedName("ban_info")
        private String banInfo;

        @SerializedName("ban_time")
        private Object banTime;

        @SerializedName("battle_life_time")
        private int battleLifeTime;

        @SerializedName("bonds")
        private int bonds;

        @SerializedName("credits")
        private int credits;

        @SerializedName("freeXp")
        private int freeXp;

        @SerializedName("garage")
        private List<Integer> garage;

        @SerializedName("gold")
        private int gold;

        @SerializedName("is_bound_to_phone")
        private boolean isBoundToPhone;

        @SerializedName("is_premium")
        private boolean isPremium;

        @SerializedName("personal_missions")
        private Map<String, String> personalMissions;

        @SerializedName("premium_expires_at")
        private int premiumExpiresAt;

        @SerializedName("boosters")
        private Boosters boosters;

        @SerializedName("grouped_contacts")
        private Contacts contacts;

        @SerializedName("rented")
        private Rented rented;

        @SerializedName("restrictions")
        private Restrictions restrictions;

        /**
         * Метод возвращает информацию о блокировке аккаунта
         *
         * @return Информация о блокировке аккаунта
         */
        public String getBanInfo() {
            return banInfo;
        }

        /**
         * Метод возвращает время окончания блокировки аккаунта
         *
         * @return Время окончания блокировки аккаунта
         */
        public int getBanTime() {
            return (int) banTime;
        }

        /**
         * Метод возвращает общее время в бою до уничтожения в секундах
         *
         * @return Общее время в бою до уничтожения в секундах
         */
        public int getBattleLifeTime() {
            return battleLifeTime;
        }

        /**
         * Метод возвращает количество Бон
         *
         * @return количество Бон
         */
        public int getBonds() {
            return bonds;
        }

        /**
         * Метод возвращает количество кредитов
         *
         * @return Количество кредитов
         */
        public int getCredits() {
            return credits;
        }

        /**
         * Метод возвращает количество свободного опыта
         *
         * @return Количество свободного опыта
         */
        public int getFreeXp() {
            return freeXp;
        }

        /**
         * Метод возвращает список техники в ангаре
         *
         * @return Список техники в ангаре
         */
        public List<Integer> getGarage() {
            return garage;
        }

        /**
         * Метод возвращает количество золота
         *
         * @return Количество золота
         */
        public int getGold() {
            return gold;
        }

        /**
         * Метод показывает, привязан ли аккаунт к номеру мобильного телефона
         *
         * @return Привязан ли аккаунт к номеру мобильного телефона
         */
        public boolean isBoundToPhone() {
            return isBoundToPhone;
        }

        /**
         * Метод показывает, является ли аккаунт премиум аккаунтом
         *
         * @return Показывает, является ли аккаунт премиум аккаунтом
         */
        public boolean isPremium() {
            return isPremium;
        }

        /**
         * Метод возвращает прогресс по личным боевым задачам.
         * <p>Ключ - идентификатор задачи, значение - статус.
         * <p>
         * Возможные статусы:
         * <p>
         * NONE - миссия недоступна
         * UNLOCKED - миссия доступна
         * NEED_GET_MAIN_REWARD - не получено основное вознаграждение
         * MAIN_REWARD_GOTTEN - основное вознаграждение получено
         * NEED_GET_ADD_REWARD - не получено второстепенное вознаграждение
         * NEED_GET_ALL_REWARDS - не получено ни одно вознаграждение
         * ALL_REWARDS_GOTTEN - все вознаграждения получены .
         *
         * @return Прогресс по личным боевым задачам
         */
        public Map<String, String> getPersonalMissions() {
            return personalMissions;
        }

        /**
         * Метод возвращает срок действия премиум аккаунта
         *
         * @return Срок действия премиум аккаунта
         */
        public int getPremiumExpiresAt() {
            return premiumExpiresAt;
        }

        /**
         * Метод возвращает личные резервы.
         *
         * @return Личные резервы.
         */
        public Boosters getBoosters() {
            return boosters;
        }

        /**
         * Метод возвращает группы контактов.
         *
         * @return Группы контактов.
         */
        public Contacts getContacts() {
            return contacts;
        }

        /**
         * Метод возвращает сущность "Аренда техники".
         *
         * @return Аренда техники.
         */
        public Rented getRented() {
            return rented;
        }

        /**
         * Метод возвращает сущность "Ограничения аккаунта"
         *
         * @return "Ограничения аккаунта"
         */
        public Restrictions getRestrictions() {
            return restrictions;
        }

        /**
         * Сущность описывает личные резервы аккаунта игрока
         */
        public static class Boosters {

            @SerializedName("count")
            private int count;

            @SerializedName("expiration_time")
            private int expirationTime;

            @SerializedName("state")
            private String state;

            /**
             * Метод возвращает количество личных резервов
             *
             * @return Количество личных резервов
             */
            public int getCount() {
                return count;
            }

            /**
             * Метод возвращает время окончания действия личных резервов
             *
             * @return Время окончания действия личных резервов
             */
            public int getExpirationTime() {
                return expirationTime;
            }

            /**
             * Метод возвращает статус личных резервов.
             * <p>Допустимые значения:
             * ACTIVE - Активны
             * INACTIVE - Неактивны
             * USED - Использованы
             *
             * @return Статус личных резервов.
             */
            public String getState() {
                return state;
            }
        }

        /**
         * Сущность описывает группы контактов аккаунта игрока
         */
        public static class Contacts {

            @SerializedName("blocked")
            private List<Integer> blocked;

            @SerializedName("groups")
            private Map<String, String> groups;

            @SerializedName("ignored")
            private List<Integer> ignored;

            @SerializedName("muted")
            private List<Integer> muted;

            @SerializedName("ungrouped")
            private List<Integer> ungrouped;

            /**
             * Метод возвращает контакты внесённые в чёрный список.
             * <p>Обратите внимание, что заблокированный контакт (account_id) всё ещё находится в группах контактов или
             * списке контактов, который не распределён по группам.
             *
             * @return Контакты внесённые в чёрный список.
             */
            public List<Integer> getBlocked() {
                return blocked;
            }

            /**
             * Метод возвращает группы контактов
             *
             * @return Группы контактов
             */
            public Map<String, String> getGroups() {
                return groups;
            }

            /**
             * Метод возвращает контакты внесённые в игнорируемые.
             *
             * @return Контакты внесённые в игнорируемые
             */
            public List<Integer> getIgnored() {
                return ignored;
            }

            /**
             * Метод возвращает контакты у отключён звук
             *
             * @return Контакты у отключён звук
             */
            public List<Integer> getMuted() {
                return muted;
            }

            /**
             * Метод возвращает не сгруппированные контакты
             *
             * @return Не сгруппированные контакты
             */
            public List<Integer> getUngrouped() {
                return ungrouped;
            }
        }

        /**
         * Сущность описывает арендованную технику.
         */
        public static class Rented {

            @SerializedName("compensation_credits")
            private int compensationCredits;

            @SerializedName("compensation_gold")
            private int compensationGold;

            @SerializedName("expiration_time")
            private int expirationTime;

            @SerializedName("tank_id")
            private int tankId;

            /**
             * Метод возвращает компенсация аренды в кредитах
             *
             * @return Компенсация аренды в кредитах
             */
            public int getCompensationCredits() {
                return compensationCredits;
            }

            /**
             * Метод возвращает компенсация аренды в золоте
             *
             * @return Компенсация аренды в золоте
             */
            public int getCompensationGold() {
                return compensationGold;
            }

            /**
             * Метод возвращает время окончания аренды
             *
             * @return Время окончания аренды
             */
            public int getExpirationTime() {
                return expirationTime;
            }

            /**
             * Метод возвращает идентификатор техники в аренде
             *
             * @return Идентификатор техники в аренде
             */
            public int getTankId() {
                return tankId;
            }
        }

        /**
         * Сущность описывает Ограничения аккаунта
         */
        public static class Restrictions {

            @SerializedName("chat_ban_time")
            private Object chatBanTime;

            /**
             * Метод возвращает время окончания блокировки в чате
             *
             * @return Время окончания блокировки в чате
             */
            public int getChatBanTime() {
                return (int) chatBanTime;
            }
        }
    }

    /**
     * Сущность описывает статистику игрока.
     */
    public static class Statistics {

        @SerializedName("frags")
        private Map<String, Integer> frags;

        @SerializedName("trees_cut")
        private int treesCut;

        @SerializedName("all")
        private FullStatistics all;

        @SerializedName("clan")
        private ShortStatistics clan;

        @SerializedName("company")
        private ShortStatistics company;

        @SerializedName("epic")
        private FullStatistics epic;

        @SerializedName("fallout")
        private FalloutStatistics fallout;

        @SerializedName("globalmap_absolute")
        private ShortStatistics globalmapAbsolute;

        @SerializedName("globalmap_champion")
        private ShortStatistics globalmapChampion;

        @SerializedName("globalmap_middle")
        private ShortStatistics globalmapMiddle;

        @SerializedName("historical")
        private FullStatistics historical;

        @SerializedName("random")
        private ShortStatistics random;

        @SerializedName("ranked_battles")
        private FullStatistics rankedBattles;

        @SerializedName("ranked_battles_current")
        private FullStatistics rankedBattlesCurrent;

        @SerializedName("ranked_battles_previous")
        private FullStatistics rankedBattlesPrevious;

        @SerializedName("stronghold_defense")
        private FullStatistics strongholdDefense;

        @SerializedName("stronghold_skirmish")
        private FullStatistics strongholdSkirmish;

        @SerializedName("team")
        private FullStatistics team;

        /**
         * Метод возвращает количество и модели уничтоженной игроком техники.
         * <p>Приватные данные игрока.
         *
         * @return Количество и модели уничтоженной игроком техники.
         */
        public Map<String, Integer> getFrags() {
            return frags;
        }

        /**
         * Метод возвращает количество поваленных деревьев
         *
         * @return Количество поваленных деревьев
         */
        public int getTreesCut() {
            return treesCut;
        }

        /**
         * Метод возвращает общую статистику для Случайных и клановых боёв без учёта Глобальной карты 2.0.
         *
         * @return Общая статистика для Случайных и клановых боёв без учёта Глобальной карты 2.0.
         */
        public FullStatistics getAllStatistics() {
            return all;
        }

        /**
         * Метод возвращает статистику боёв в составе клана.
         *
         * @return Статистика боёв в составе клана.
         */
        public ShortStatistics getClanStatistics() {
            return clan;
        }

        /**
         * Метод возвращает статистику боёв в составе роты.
         *
         * @return Статистика боёв в составе роты.
         */
        public ShortStatistics getCompanyStatistics() {
            return company;
        }

        /**
         * Метод возвращает статистику в типе боя «Генеральное сражение».
         * <p>Необходимо указать дополнительное поле в запросе.
         *
         * @return Статистика в типе боя «Генеральное сражение».
         */
        public FullStatistics getEpicStatistics() {
            return epic;
        }

        /**
         * Метод возвращает статистику в режиме «Бой до последнего».
         * <p>Необходимо указать дополнительное поле в запросе.
         *
         * @return Статистика в режиме «Бой до последнего».
         */
        public FalloutStatistics getFalloutStatistics() {
            return fallout;
        }

        /**
         * Метод возвращает статистику боёв на Глобальной карте в Абсолютном дивизионе.
         * <p>Необходимо указать дополнительное поле в запросе.
         *
         * @return Статистика боёв на Глобальной карте в Абсолютном дивизионе.
         */
        public ShortStatistics getGlobalmapAbsoluteStatistics() {
            return globalmapAbsolute;
        }

        /**
         * Метод возвращает статистику боёв на Глобальной карте в Чемпионском дивизионе.
         * <p>Необходимо указать дополнительное поле в запросе.
         *
         * @return Статистика боёв на Глобальной карте в Чемпионском дивизионе.
         */
        public ShortStatistics getGlobalmapChampionStatistics() {
            return globalmapChampion;
        }

        /**
         * Метод возвращает статистику боёв на Глобальной карте в Среднем  дивизионе.
         * <p>Необходимо указать дополнительное поле в запросе.
         *
         * @return Статистика боёв на Глобальной карте в Среднем  дивизионе.
         */
        public ShortStatistics getGlobalmapMiddleStatistics() {
            return globalmapMiddle;
        }

        /**
         * Метод возвращает статистику исторических боёв.
         *
         * @return Статистика исторических боёв.
         */
        public FullStatistics getHistoricalStatistics() {
            return historical;
        }

        /**
         * Метод возвращает статистику случайных боёв.
         * <p>Необходимо указать дополнительное поле в запросе.
         *
         * @return Статистика случайных боёв.
         */
        public ShortStatistics getRandomStatistics() {
            return random;
        }

        /**
         * Метод возвращает статистику по Ранговым боям.
         * <p>Необходимо указать дополнительное поле в запросе.
         *
         * @return Статистика по Ранговым боям.
         */
        public FullStatistics getRankedBattlesStatistics() {
            return rankedBattles;
        }

        /**
         * Метод возвращает текущую статистику по Ранговым боям.
         * <p>Необходимо указать дополнительное поле в запросе.
         *
         * @return Текущая статистика по Ранговым боям.
         */
        public FullStatistics getRankedBattlesCurrentStatistics() {
            return rankedBattlesCurrent;
        }

        /**
         * Метод возвращает предыдущую статистику по Ранговым боям.
         * <p>Необходимо указать дополнительное поле в запросе.
         *
         * @return Текущая статистика по Ранговым боям.
         */
        public FullStatistics getRankedBattlesPreviousStatistics() {
            return rankedBattlesPrevious;
        }

        /**
         * Метод возвращает общую по всем кланам статистику боёв игрока в режиме обороны Укрепрайона.
         *
         * @return Общая по всем кланам статистика боёв игрока в режиме обороны Укрепрайона.
         */
        public FullStatistics getStrongholdDefenseStatistics() {
            return strongholdDefense;
        }

        /**
         * Метод возвращает общую по всем кланам статистику боёв игрока в режиме вылазок Укрепрайона.
         *
         * @return Общая по всем кланам статистика боёв игрока в режиме вылазок Укрепрайона.
         */
        public FullStatistics getStrongholdSkirmishStatistics() {
            return strongholdSkirmish;
        }

        /**
         * Метод возвращает статистику командных боёв
         *
         * @return Статистика командных боёв
         */
        public FullStatistics getTeamStatistics() {
            return team;
        }

        /**
         * Сущность описывает параметры статистики
         */
        public static class ShortStatistics {

            @SerializedName("avg_damage_assisted")
            private float avgDamageAssisted;

            @SerializedName("avg_damage_assisted_radio")
            private float avgDamageAssistedRadio;

            @SerializedName("avg_damage_assisted_track")
            private float avgDamageAssistedTrack;

            @SerializedName("avg_damage_blocked")
            private float avgDamageBlocked;

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

            @SerializedName("direct_hits_received")
            private int directHitsReceived;

            @SerializedName("draws")
            private int draws;

            @SerializedName("dropped_capture_points")
            private int droppedCapturePoints;

            @SerializedName("explosion_hits")
            private int explosionHits;

            @SerializedName("explosion_hits_received")
            private int explosionHitsReceived;

            @SerializedName("frags")
            private int frags;

            @SerializedName("hits")
            private int hits;

            @SerializedName("hits_percents")
            private int hitsPercents;

            @SerializedName("losses")
            private int losses;

            @SerializedName("no_damage_direct_hits_received")
            private int noDamageDirectHitsReceived;

            @SerializedName("piercings")
            private int piercings;

            @SerializedName("piercings_received")
            private int piercingsReceived;

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

            @SerializedName("tanking_factor")
            private float tankingFactor;

            @SerializedName("wins")
            private int wins;

            @SerializedName("xp")
            private int xp;

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
             * Метод возвращает средний заблокированный бронёй урон за бой.
             * <p>Заблокированный бронёй урон — это урон от снарядов (бронебойных, кумулятивных и подкалиберных),
             * которые попали в танк, но не нанесли урона.
             *
             * @return Средний заблокированный бронёй урон за бой.
             */
            public float getAvgDamageBlocked() {
                return avgDamageBlocked;
            }

            /**
             * Метод возвращает средний опыт за бой.
             *
             * @return Средний опыт за бой.
             */
            public int getBattleAvgXp() {
                return battleAvgXp;
            }

            /**
             * Метод возвращает количество проведеных боёв.
             *
             * @return Проведено боёв.
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
             * Метод возвращает количество очков захвата базы.
             *
             * @return Очки захвата базы.
             */
            public int getCapturePoints() {
                return capturePoints;
            }

            /**
             * Метод возвращает нанесено повреждений.
             *
             * @return Нанесено повреждений.
             */
            public int getDamageDealt() {
                return damageDealt;
            }

            /**
             * Метод возвращает получено урона.
             *
             * @return Получено урона.
             */
            public int getDamageReceived() {
                return damageReceived;
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
             * Метод возвращает количество боев сыгранных в "ничью".
             *
             * @return Количество боев сыгранных в "ничью".
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
             * Метод возвращает количество уничтоженой техники.
             *
             * @return Количество уничтоженой техники.
             */
            public int getFrags() {
                return frags;
            }

            /**
             * Метод возвращает количество попаданий.
             *
             * @return количество попаданий.
             */
            public int getHits() {
                return hits;
            }

            /**
             * Метод возвращает процент попаданий
             *
             * @return Процент попаданий
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
             * Метод возвращает количество полученных прямых попаданий, не нанёсших урон.
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
             * Метод возвращает количество произведеных выстрелов.
             *
             * @return Количество произведеных выстрелов.
             */
            public int getShots() {
                return shots;
            }

            /**
             * Метод возвращает количество обнаруженых противников.
             *
             * @return Количество обнаруженых противников.
             */
            public int getSpotted() {
                return spotted;
            }

            /**
             * Метод возвращает урон по оглушённым вами целям.
             *
             * @return Урон по оглушённым вами целям.
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
             * Метод возвращает выжил в боях.
             *
             * @return Выжил в боях.
             */
            public int getSurvivedBattles() {
                return survivedBattles;
            }

            /**
             * Метод возвращает отношение заблокированного бронёй урона к полученному игроком урону от бронебойных,
             * кумулятивных, подкалиберных снарядов.
             *
             * @return Отношение заблокированного урона.
             */
            public float getTankingFactor() {
                return tankingFactor;
            }

            /**
             * Метод возвращает количество победных боев.
             *
             * @return Количество победных боев.
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
         * Сущность расширяет параметры статистики
         */
        public static class FullStatistics extends ShortStatistics {

            @SerializedName("max_damage")
            private Object maxDamage;

            @SerializedName("max_damage_tank_id")
            private Object maxDamageTankId;

            @SerializedName("max_frags")
            private Object maxFrags;

            @SerializedName("max_frags_tank_id")
            private Object maxFragsTankId;

            @SerializedName("max_xp")
            private Object maxXp;

            @SerializedName("max_xp_tank_id")
            private Object maxXpTankId;

            /**
             * Метод возвращает средний урон, нанесённый с вашей помощью.
             * <p>
             * Значение считается с версии игры 8.8.
             *
             * @return Средний урон, нанесённый с вашей помощью.
             */
            @Override
            public float getAvgDamageAssisted() {
                return super.getAvgDamageAssisted();
            }

            /**
             * Метод возвращает средний урон по вашим разведданным.
             * <p>
             * Значение считается с версии игры 8.8.
             *
             * @return Средний урон по вашим разведданным.
             */
            @Override
            public float getAvgDamageAssistedRadio() {
                return super.getAvgDamageAssistedRadio();
            }

            /**
             * Метод возвращает средний урон после вашего попадания, сбившего гусеницу.
             * <p>
             * Значение считается с версии игры 8.8.
             *
             * @return Средний урон после вашего попадания, сбившего гусеницу.
             */
            @Override
            public float getAvgDamageAssistedTrack() {
                return super.getAvgDamageAssistedTrack();
            }

            /**
             * Метод возвращает средний заблокированный бронёй урон за бой.
             * <p>Заблокированный бронёй урон — это урон от снарядов (бронебойных, кумулятивных и подкалиберных),
             * которые попали в танк, но не нанесли урона.
             * <p>
             * Значение считается с версии игры 9.0.
             *
             * @return Средний заблокированный бронёй урон за бой.
             */
            @Override
            public float getAvgDamageBlocked() {
                return super.getAvgDamageBlocked();
            }

            /**
             * Метод возвращает отношение заблокированного бронёй урона к полученному игроком урону от бронебойных,
             * кумулятивных, подкалиберных снарядов.
             * <p>
             * Значение считается с версии игры 9.0.
             *
             * @return Отношение заблокированного урона.
             */
            @Override
            public float getTankingFactor() {
                return super.getTankingFactor();
            }

            /**
             * Метод возвращает максимальный урон за бой.
             *
             * @return Максимальный урон за бой.
             */
            public int getMaxDamage() {
                return (int) maxDamage;
            }

            /**
             * Метод возвращает технику, на которой был нанесён максимальный урон за бой.
             *
             * @return Техника, на которой был нанесён максимальный урон за бой.
             */
            public int getMaxDamageTankId() {
                return (int) maxDamageTankId;
            }

            /**
             * Метод возвращает максимум уничтожено за бой.
             *
             * @return Максимум уничтожено за бой.
             */
            public int getMaxFrags() {
                return (int) maxFrags;
            }

            /**
             * Метод возвращает технику, на которой уничтожено максимальное количество противников за бой.
             *
             * @return Техника, на которой уничтожено максимальное количество противников за бой.
             */
            public int getMaxFragsTankId() {
                return (int) maxFragsTankId;
            }

            /**
             * Метод возвращает максимальный опыт за бой
             *
             * @return Максимальный опыт за бой
             */
            public int getMaxXp() {
                return (int) maxXp;
            }

            /**
             * Метод возвращает технику, на которой получен максимальный опыт за бой.
             *
             * @return Техника, на которой получен максимальный опыт за бой.
             */
            public int getMaxXpTankId() {
                return (int) maxXpTankId;
            }
        }

        /**
         * Сущность описывает статистику боёв в типе Статистика в режиме «Бой до последнего».
         * <p>Дополнительное поле.
         */
        public static class FalloutStatistics extends FullStatistics {

            @SerializedName("avatar_damage_dealt")
            private int avatarDamageDealt;

            @SerializedName("avatar_frags")
            private int avatarFrags;

            @SerializedName("death_count")
            private int deathCount;

            @SerializedName("flag_capture")
            private int flagCapture;

            @SerializedName("flag_capture_solo")
            private int flagCaptureSolo;

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
             * Метод возвращает количество уничтоженой техники при помощи боевых резервов
             *
             * @return Количество уничтоженой техники при помощи боевых резервов
             */
            public int getAvatarFrags() {
                return avatarFrags;
            }

            /**
             * Метод возвращает количество раз когда погиб.
             *
             * @return Количество раз когда погиб.
             */
            public int getDeathCount() {
                return deathCount;
            }

            /**
             * Метод возвращает количество захваченных флагов в составе взвода.
             *
             * @return Количество захваченных флагов в составе взвода.
             */
            public int getFlagCapture() {
                return flagCapture;
            }

            /**
             * Метод возвращает количество захваченных флагов в соло.
             *
             * @return Количество захваченных флагов в соло.
             */
            public int getFlagCaptureSolo() {
                return flagCaptureSolo;
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
             * Метод возвращает максимальное количество уничтоженной техники, включая технику, уничтоженную аватаром.
             *
             * @return Максимальное количество уничтоженной техники, включая технику, уничтоженную аватаром.
             */
            public int getMaxFragsWithAvatar() {
                return maxFragsWithAvatar;
            }

            /**
             * Метод возвращает максимальное количество Очков победы, заработанное в режиме «Бой до последнего».
             *
             * @return Максимальное количество Очков победы, заработанное в режиме «Бой до последнего».
             */
            public int getMaxWinPoints() {
                return maxWinPoints;
            }

            /**
             * Метод возвращает количество ресурсов, захваченных на ресурсных точках.
             *
             * @return Количество ресурсов, захваченные на ресурсных точках.
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
}
