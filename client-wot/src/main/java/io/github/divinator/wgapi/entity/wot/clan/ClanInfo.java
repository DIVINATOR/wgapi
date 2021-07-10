package io.github.divinator.wgapi.entity.wot.clan;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.ClanMethod;

import java.util.List;
import java.util.Map;

/**
 * Класс описывает сущность "Информацию о клане" для метод-блока {@link ClanMethod}
 *
 * @author Sergey Divin
 */
public final class ClanInfo {

    @SerializedName("accepts_join_requests")
    private boolean isJoinRequests;

    @SerializedName("clan_id")
    private int clanId;

    @SerializedName("color")
    private String color;

    @SerializedName("created_at")
    private int createdAt;

    @SerializedName("creator_id")
    private int creatorId;

    @SerializedName("creator_name")
    private String creatorName;

    @SerializedName("description")
    private String description;

    @SerializedName("description_html")
    private String descriptionHtml;

    @SerializedName("is_clan_disbanded")
    private boolean isClanDisbanded;

    @SerializedName("leader_id")
    private int leaderId;

    @SerializedName("leader_name")
    private String leaderName;

    @SerializedName("members_count")
    private int membersCount;

    @SerializedName("motto")
    private String motto;

    @SerializedName("name")
    private String name;

    @SerializedName("old_name")
    private String oldName;

    @SerializedName("old_tag")
    private String oldTag;

    @SerializedName("renamed_at")
    private int renamedAt;

    @SerializedName("tag")
    private String tag;

    @SerializedName("updated_at")
    private int updatedAt;

    @SerializedName("emblems")
    private Clan.Emblems emblems;

    @SerializedName("members")
    private Map<String, Member> members;

    @SerializedName("private")
    private Private privat;

    /**
     * Метод показывает может ли клан приглашать игроков.
     *
     * @return Может ли клан приглашать игроков.
     */
    public boolean isJoinRequests() {
        return isJoinRequests;
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
     * Метод возвращает цвет клана в формате HEX #RRGGBB.
     *
     * @return Цвет клана в формате HEX #RRGGBB.
     */
    public String getColor() {
        return color;
    }

    /**
     * Метод возвращает дату создания клана.
     *
     * @return Дата создания клана.
     */
    public int getCreatedAt() {
        return createdAt;
    }

    /**
     * Метод возвращает идентификатор игрока, создавшего клан.
     *
     * @return Идентификатор игрока, создавшего клан.
     */
    public int getCreatorId() {
        return creatorId;
    }

    /**
     * Метод возвращает имя игрока, создавшего клан.
     *
     * @return Имя игрока, создавшего клан.
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * Метод возвращает описание клана.
     *
     * @return Описание клана.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Метод возвращает описание клана в HTML.
     *
     * @return Описание клана в HTML.
     */
    public String getDescriptionHtml() {
        return descriptionHtml;
    }

    /**
     * Метод показывает удален ли клан удалён.
     * <p>
     * Информация об удалённом клане содержит актуальные значения только для следующих полей: clan_id, is_clan_disbanded, updated_at.
     *
     * @return Показывает удален ли клан удалён.
     */
    public boolean isClanDisbanded() {
        return isClanDisbanded;
    }

    /**
     * Метод возвращает идентификатор Командующего клана.
     *
     * @return Идентификатор Командующего клана.
     */
    public int getLeaderId() {
        return leaderId;
    }

    /**
     * Метод возвращает имя Командующего.
     *
     * @return Имя Командующего.
     */
    public String getLeaderName() {
        return leaderName;
    }

    /**
     * Метод возвращает количество игроков клана.
     *
     * @return Количество игроков клана.
     */
    public int getMembersCount() {
        return membersCount;
    }

    /**
     * Метод возвращает девиз клана.
     *
     * @return Девиз клана.
     */
    public String getMotto() {
        return motto;
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
     * Метод возвращает старое название клана.
     *
     * @return Старое название клана.
     */
    public String getOldName() {
        return oldName;
    }

    /**
     * Метод возвращает старый тег клана.
     *
     * @return Старый тег клана.
     */
    public String getOldTag() {
        return oldTag;
    }

    /**
     * Метод возвращает время последнего переименования клана в UTC.
     *
     * @return Время последнего переименования клана в UTC.
     */
    public int getRenamedAt() {
        return renamedAt;
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
     * Метод возвращает время обновления информации о клане.
     *
     * @return Время обновления информации о клане.
     */
    public int getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Метод возвращает информацию об эмблемах клана в играх и на клановом портале.
     *
     * @return Информация об эмблемах клана в играх и на клановом портале.
     */
    public Clan.Emblems getEmblems() {
        return emblems;
    }

    /**
     * Метод возвращает Информация об игроках клана.
     *
     * @return Информация об игроках клана.
     */
    public Map<String, Member> getMembers() {
        return members;
    }

    /**
     * Метод возвращает секретную информацию клана.
     *
     * @return Секретную информацию клана.
     */
    public Private getPrivate() {
        return privat;
    }

    /**
     * Сущность описывает члена клана.
     */
    public static class Member {

        @SerializedName("account_id")
        private int accountId;

        @SerializedName("account_name")
        private String accountName;

        @SerializedName("joined_at")
        private int joinedAt;

        @SerializedName("role")
        private String role;

        @SerializedName("role_i18n")
        private String roleName;

        /**
         * Метод возвращает идентификатор аккаунта игрока.
         *
         * @return Идентификатор аккаунта игрока.
         */
        public int getAccountId() {
            return accountId;
        }

        /**
         * Метод возвращает имя игрока.
         *
         * @return Имя игрока.
         */
        public String getAccountName() {
            return accountName;
        }

        /**
         * Метод возвращает дату вступления в клан.
         *
         * @return Дата вступления в клан.
         */
        public int getJoinedAt() {
            return joinedAt;
        }

        /**
         * Метод возвращает техническое название должности.
         *
         * @return Техническое название должности.
         */
        public String getRole() {
            return role;
        }

        /**
         * Метод возвращает название должности.
         *
         * @return Название должности.
         */
        public String getRoleName() {
            return roleName;
        }
    }

    /**
     * Сущность описывает приватные данные клана.
     */
    public static class Private {

        @SerializedName("online_members")
        private List<Integer> onlineMembers;

        @SerializedName("clan_treasury")
        private ClanTreasury clanTreasury;

        /**
         * Метод возвращает список игроков клана c активной игровой сессией в World of Tanks.
         * <p>
         * Дополнительное поле.
         *
         * @return Список игроков клана c активной игровой сессией в World of Tanks.
         */
        public List<Integer> getOnlineMembers() {
            return onlineMembers;
        }

        /**
         * Метод возвращает казну клана.
         *
         * @return Казна клана.
         */
        public ClanTreasury getClanTreasury() {
            return clanTreasury;
        }

        /**
         * Сущность описывает казну клана.
         */
        public static class ClanTreasury {

            @SerializedName("credits")
            private Object credits;

            @SerializedName("crystal")
            private int crystal;

            @SerializedName("gold")
            private int gold;

            /**
             * Метод возвращает количество кредитов в казне клана.
             *
             * @return Количество кредитов в казне клана.
             */
            public int getCredits() {
                return (credits instanceof Integer) ? (int) credits : 0;
            }

            /**
             * Метод возвращает количество бон в казне клана.
             *
             * @return Количество бон в казне клана.
             */
            public int getCrystal() {
                return crystal;
            }

            /**
             * Метод возвращает количество золота в казне клана.
             *
             * @return Количество золота в казне клана.
             */
            public int getGold() {
                return gold;
            }
        }
    }
}
