package io.github.divinator.wgapi.entity.wot.encyclopedia;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.EncyclopediaMethod;

/**
 * Класс описывает сущность "Умение экипажа" для метод-блока {@link EncyclopediaMethod}
 *
 * @author Sergey Divin
 */
public final class CrewSkill {

    @SerializedName("description")
    private String description;

    @SerializedName("name")
    private String name;

    @SerializedName("is_perk")
    private boolean isPerk;

    @SerializedName("skill")
    private String skill;

    @SerializedName("image_url")
    private Images image_url;

    /**
     * Метод возвращает описание умения.
     * @return Описание умения.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Метод возвращает название умения.
     * @return Название умения.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод показывает, является ли навыком.
     * @return Показывает, является ли навыком.
     */
    public boolean isPerk() {
        return isPerk;
    }

    /**
     * Метод возвращает идентификатор умения.
     * @return Идентификатор умения.
     */
    public String getSkill() {
        return skill;
    }

    /**
     * Метод возвращает URL к значку умения
     * @return URL к значку умения
     */
    public Images getImage_url() {
        return image_url;
    }

    /**
     * Сущность описывает URL к значку умения
     */
    public static class Images {

        @SerializedName("big_icon")
        private String iconBig;

        @SerializedName("small_icon")
        private String iconSmall;

        /**
         * Метод возвращает URL к большому изображению.
         * @return URL к большому изображению.
         */
        public String getIconBig() {
            return iconBig;
        }

        /**
         * Метод возвращает URL к малому изображению.
         * @return URL к малому изображению.
         */
        public String getIconSmall() {
            return iconSmall;
        }
    }
}
