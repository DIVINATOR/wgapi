package io.github.divinator.wgapi.entity.wot.encyclopedia;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.EncyclopediaMethod;

import java.util.List;
import java.util.Map;

/**
 * Класс описывает сущность "Информация о достижениях в энциклопедии" для метод-блока {@link EncyclopediaMethod}
 *
 * @author Sergey Divin
 */
public final class Achievement {

    @SerializedName("condition")
    private String condition;

    @SerializedName("description")
    private String description;

    @SerializedName("hero_info")
    private String heroInfo;

    @SerializedName("image")
    private String image;

    @SerializedName("image_big")
    private String imageBig;

    @SerializedName("name")
    private String name;

    @SerializedName("name_i18n")
    private String nameI18n;

    @SerializedName("order")
    private int order;

    @SerializedName("outdated")
    private boolean outdated;

    @SerializedName("section")
    private String section;

    @SerializedName("section_order")
    private int sectionOrder;

    @SerializedName("type")
    private String type;

    @SerializedName("options")
    private List<Options> options;

    /**
     * Метод возвращает условие для получения.
     *
     * @return Условие для получения.
     */
    public String getCondition() {
        return condition;
    }

    /**
     * Метод возвращает описание достижения.
     *
     * @return Описание достижения.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Метод возвращает историческую справку.
     *
     * @return Историческая справка.
     */
    public String getHeroInfo() {
        return heroInfo;
    }

    /**
     * Метод возвращает ссылку на изображение.
     *
     * @return Ссылка на изображение.
     */
    public String getImage() {
        return image;
    }

    /**
     * Метод возвращает ссылку на изображение 180x180px
     *
     * @return Ссылка на изображение 180x180px
     */
    public String getImageBig() {
        return imageBig;
    }

    /**
     * Метод возвращает название достижения.
     *
     * @return Название достижения.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод возвращает локализованное поле name.
     *
     * @return Локализованное поле name.
     */
    public String getNameI18n() {
        return nameI18n;
    }

    /**
     * Метод возвращает порядок отображения достижений в разделе.
     * <p>
     * Достижения с меньшим значением поля «Порядок» отображены выше достижений с большим значением.
     *
     * @return Порядок отображения достижений в разделе.
     */
    public int getOrder() {
        return order;
    }

    /**
     * Метод показывает, если достижение устарело и больше не может быть получено.
     *
     * @return Показывает, если достижение устарело и больше не может быть получено.
     */
    public boolean isOutdated() {
        return outdated;
    }

    /**
     * Метод возвращает раздел достижения.
     *
     * @return Раздел достижения.
     */
    public String getSection() {
        return section;
    }

    /**
     * Метод возвращает порядок отображения разделов достижений.
     * <p>
     *     Разделы с меньшим значением поля «Порядок отображения раздела» отображены выше разделов с большим значением.
     *
     * @return Порядок отображения разделов достижений.
     */
    public int getSectionOrder() {
        return sectionOrder;
    }

    /**
     * Метод возвращает тип достижения.
     *
     * @return Тип достижения.
     */
    public String getType() {
        return type;
    }

    /**
     * Метод возвращает опции достижения
     *
     * @return Опции достижения.
     */
    public List<Options> getOptions() {
        return options;
    }

    /**
     * Сущность описывает опции достижения.
     */
    public static class Options {

        @SerializedName("description")
        private String description;

        @SerializedName("image")
        private String image;

        @SerializedName("image_big")
        private String imageBig;

        @SerializedName("name_i18n")
        private String nameI18n;

        @SerializedName("nation_images")
        private NationImages nationImages;

        /**
         * Метод возвращает описание достижения.
         *
         * @return Описание достижения.
         */
        public String getDescription() {
            return description;
        }

        /**
         * Метод возвращает ссылку на изображение.
         *
         * @return Ссылка на изображение.
         */
        public String getImage() {
            return image;
        }

        /**
         * Метод возвращает ссылку на изображение 180x180px.
         *
         * @return Ссылка на изображение 180x180px.
         */
        public String getImageBig() {
            return imageBig;
        }

        /**
         * Метод возвращает локализованное поле "name".
         *
         * @return Локализованное поле "name".
         */
        public String getNameI18n() {
            return nameI18n;
        }

        /**
         * Метод возвращает информацию об эмблемах наций.
         *
         * @return Информация об эмблемах наций.
         */
        public NationImages getNationImages() {
            return nationImages;
        }

        /**
         * Сущность описывает информацию об эмблемах наций.
         */
        public static class NationImages {

            @SerializedName("x180")
            private Map<String, String> x180;

            @SerializedName("x71")
            private Map<String, String> x71;

            @SerializedName("x85")
            private Map<String, String> x85;

            /**
             * Метод возвращает перечень ссылок на эмблемы 180x180 px.
             *
             * @return Перечень ссылок на эмблемы 180x180 px.
             */
            public Map<String, String> getX180() {
                return x180;
            }

            /**
             * Метод возвращает перечень ссылок на эмблемы 67x71 px.
             *
             * @return Перечень ссылок на эмблемы 67x71 px.
             */
            public Map<String, String> getX71() {
                return x71;
            }

            /**
             * Метод возвращает Перечень ссылок на эмблемы 95x85 px.
             *
             * @return Перечень ссылок на эмблемы 95x85 px.
             */
            public Map<String, String> getX85() {
                return x85;
            }
        }
    }
}
