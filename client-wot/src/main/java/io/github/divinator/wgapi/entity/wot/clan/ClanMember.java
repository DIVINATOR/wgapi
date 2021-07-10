package io.github.divinator.wgapi.entity.wot.clan;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.ClanMethod;

/**
 * Класс описывает сущность "Информация об игроке клана" для метод-блока {@link ClanMethod}
 *
 * @author Sergey Divin
 */
public final class ClanMember {

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

    @SerializedName("clan")
    private Clan clan;

    /**
     * Метод возвращает идентификатор аккаунта игрока.
     *
     * @return Идентификатор аккаунта игрока.
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Метод возвращает Имя игрока.
     *
     * @return Имя игрока.
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Метод возвращает дата вступления в клан.
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

    /**
     * Метод возвращает краткую информацию о клане.
     *
     * @return Краткая информация о клане.
     */
    public Clan getClan() {
        return clan;
    }
}
