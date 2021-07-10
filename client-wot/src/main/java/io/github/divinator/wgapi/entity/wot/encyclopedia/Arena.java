package io.github.divinator.wgapi.entity.wot.encyclopedia;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.EncyclopediaMethod;

/**
 * Класс описывает сущность "Информация об игровой карте" для метод-блока {@link EncyclopediaMethod}
 *
 * @author Sergey Divin
 */
public final class Arena {

    @SerializedName("arena_id")
    private String arenaId;

    @SerializedName("camouflage_type")
    private String camouflageType;

    @SerializedName("description")
    private String description;

    @SerializedName("name_i18n")
    private String nameI18n;

    /**
     * Метод возвращает идентификатор карты.
     * @return Идентификатор карты.
     */
    public String getArenaId() {
        return arenaId;
    }

    /**
     * Метод возвращает тип карты.
     * @return Тип карты.
     */
    public String getCamouflageType() {
        return camouflageType;
    }

    /**
     * Метод возвращает краткое описание карты.
     * @return Краткое описание карты.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Метод возвращает Локализованное название карты
     * @return
     *
     * Локализованное название карты
     */
    public String getNameI18n() {
        return nameI18n;
    }
}
