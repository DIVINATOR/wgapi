package io.github.divinator.wgapi.entity.wot.clan;

import com.google.gson.annotations.SerializedName;
import io.github.divinator.wgapi.method.wot.ClanMethod;

import java.util.Map;

/**
 * Класс описывает сущность "Клан" для метод-блока {@link ClanMethod}
 *
 * @author Sergey Divin
 */
public final class Clan {

    @SerializedName("clan_id")
    private int clanId;

    @SerializedName("color")
    private String color;

    @SerializedName("created_at")
    private int createdAt;

    @SerializedName("members_count")
    private int membersCount;

    @SerializedName("name")
    private String name;

    @SerializedName("tag")
    private String tag;

    @SerializedName("emblems")
    private Emblems emblems;

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
     * Метод возвращает количество игроков клана.
     *
     * @return Количество игроков клана.
     */
    public int getMembersCount() {
        return membersCount;
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
     * Метод возвращает тег клана.
     *
     * @return Тег клана.
     */
    public String getTag() {
        return tag;
    }

    /**
     * Метод возвращает информацию об эмблемах клана в играх и на клановом портале.
     *
     * @return Информация об эмблемах клана в играх и на клановом портале.
     */
    public Emblems getEmblems() {
        return emblems;
    }

    /**
     * Сущность описывает информацию об эмблемах клана в играх и на клановом портале
     */
    public static class Emblems {

        @SerializedName("x24")
        private Map<String, String> x24;

        @SerializedName("x32")
        private Map<String, String> x32;

        @SerializedName("x64")
        private Map<String, String> x64;

        @SerializedName("x195")
        private Map<String, String> x195;

        @SerializedName("x256")
        private Map<String, String> x256;

        /**
         * Метод возвращает перечень ссылок на эмблемы 24x24 px.
         *
         * @return Перечень ссылок на эмблемы 24x24 px.
         */
        public Map<String, String> getX24() {
            return x24;
        }

        /**
         * Метод возвращает перечень ссылок на эмблемы 32x32 px.
         *
         * @return Перечень ссылок на эмблемы 32x32 px.
         */
        public Map<String, String> getX32() {
            return x32;
        }

        /**
         * Метод возвращает перечень ссылок на эмблемы 64x64 px.
         *
         * @return Перечень ссылок на эмблемы 64x64 px.
         */
        public Map<String, String> getX64() {
            return x64;
        }

        /**
         * Метод возвращает Перечень ссылок на эмблемы 195x195 px.
         *
         * @return Перечень ссылок на эмблемы 195x195 px.
         */
        public Map<String, String> getX195() {
            return x195;
        }

        /**
         * Метод возвращает Перечень ссылок на эмблемы 256x256 px.
         *
         * @return Перечень ссылок на эмблемы 256x256 px.
         */
        public Map<String, String> getX256() {
            return x256;
        }
    }
}
