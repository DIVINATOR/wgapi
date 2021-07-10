package io.github.divinator.wgapi.entity.wot.clan;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.ClanMethod;

import java.util.Map;

/**
 * Класс описывает сущность "Информация о клановых сущностях" для метод-блока {@link ClanMethod}
 *
 * @author Sergey Divin
 */
public final class ClanRoles {

    @SerializedName("clans_roles")
    private Map<String, String> clansRoles;

    /**
     * Метод возвращает возможные должности игроков в клане
     * @return Возможные должности игроков в клане
     */
    public Map<String, String> getClansRoles() {
        return clansRoles;
    }
}
