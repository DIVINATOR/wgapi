package io.github.divinator.wgapi.entity.wot.encyclopedia;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.EncyclopediaMethod;

import java.util.List;

/**
 * Класс описывает сущность "Специальность экипажа" для метод-блока {@link EncyclopediaMethod}
 *
 * @author Sergey Divin
 */
public final class CrewRole {

    @SerializedName("name")
    private String name;

    @SerializedName("role")
    private String role;

    @SerializedName("skills")
    private List<String> skills;

    /**
     * Метод возвращает название специальности экипажа.
     *
     * @return Название специальности экипажа.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод возвращает идентификатор специальности экипажа.
     *
     * @return Идентификатор специальности экипажа.
     */
    public String getRole() {
        return role;
    }

    /**
     * Метод возвращает список специальностей членов экипажа.
     *
     * @return Список специальностей членов экипажа.
     */
    public List<String> getSkills() {
        return skills;
    }
}
