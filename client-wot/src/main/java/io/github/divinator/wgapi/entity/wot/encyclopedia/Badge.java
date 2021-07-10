package io.github.divinator.wgapi.entity.wot.encyclopedia;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.EncyclopediaMethod;

/**
 * Класс описывает сущность "Доступная нашивка" для метод-блока {@link EncyclopediaMethod}
 *
 * @author Sergey Divin
 */
public final class Badge {

    @SerializedName("badge_id")
    private int badgeId;

    @SerializedName("description")
    private String description;

    @SerializedName("name")
    private String name;

    @SerializedName("images")
    private Images images;

    /**
     * Метод возвращает идентификатор нашивки.
     * @return Идентификатор нашивки.
     */
    public int getBadgeId() {
        return badgeId;
    }

    /**
     * Метод возвращает описание нашивки.
     * @return Описание нашивки.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Метод возвращает название нашивки.
     * @return Название нашивки.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод возвращает ссылки на изображения.
     * @return Ссылки на изображения.
     */
    public Images getImages() {
        return images;
    }

    /**
     * Сущность описывает ссылки на изображения.
     */
    public static class Images {

        @SerializedName("big_icon")
        private String iconBig;

        @SerializedName("medium_icon")
        private String iconMedium;

        @SerializedName("small_icon")
        private String iconSmall;

        /**
         * Метод возвращает URL изображения нашивки размером 80x80 px.
         * @return URL изображения нашивки размером 80x80 px.
         */
        public String getIconBig() {
            return iconBig;
        }

        /**
         * Метод возвращает URL изображения нашивки размером 48x48 px.
         * @return URL изображения нашивки размером 48x48 px.
         */
        public String getIconMedium() {
            return iconMedium;
        }

        /**
         * Метод возвращает URL изображения нашивки размером 24x24 px.
         * @return URL изображения нашивки размером 24x24 px.
         */
        public String getIconSmall() {
            return iconSmall;
        }
    }
}
