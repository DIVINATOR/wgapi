package io.github.divinator.wgapi.entity.wot.clan;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.ClanMethod;

/**
 * Класс описывает сущность "Информация о клановой истории игрока" для метод-блока {@link ClanMethod}
 *
 * @author Sergey Divin
 */
public final class ClanMemberHistory {

    @SerializedName("account_id")
    private int accountId;

    @SerializedName("clan_id")
    private int clanId;

    @SerializedName("joined_at")
    private int joinedAt;

    @SerializedName("left_at")
    private int leftAt;

    @SerializedName("role")
    private String role;

    /**
     * Метод возвращает идентификатор аккаунта игрока.
     *
     * @return Идентификатор аккаунта игрока.
     */
    public int getAccountId() {
        return accountId;
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
     * Метод возвращает дату вступления в клан.
     *
     * @return Дата вступления в клан.
     */
    public int getJoinedAt() {
        return joinedAt;
    }

    /**
     * Метод возвращает дату выхода из клана.
     *
     * @return Дата выхода из клана.
     */
    public int getLeftAt() {
        return leftAt;
    }

    /**
     * Метод возвращает последнюю должность в клане.
     *
     * @return Последняя должность в клане.
     */
    public String getRole() {
        return role;
    }
}
