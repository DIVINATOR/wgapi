/*
 * Copyright [2020] [Sergey Divin]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.divinator.wgapi.entity.wgn.wgtv;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Класс описывает сущность "Видео" для метод-блока {@link io.divinator.wgapi.method.wgn.WgtvMethod}
 *
 * @author Sergey Divin
 */
public final class Video {

    @SerializedName("category_id")
    private List<Integer> categoryId;

    @SerializedName("description")
    private String description;

    @SerializedName("duration")
    private int duration;

    @SerializedName("ext_title")
    private String extTitle;

    @SerializedName("important")
    private boolean important;

    @SerializedName("program_id")
    private int programId;

    @SerializedName("project_id")
    private List<Integer> projectid;

    @SerializedName("published_at")
    private int publishedAt;

    @SerializedName("title")
    private String title;

    @SerializedName("vehicles")
    private Map<String, String> vehicles;

    @SerializedName("video_id")
    private String videoid;

    @SerializedName("video_url")
    private String videoUrl;

    @SerializedName("thumbnails")
    private Map<String, Thumbnail> thumbnails;

    /**
     * Метод возвращает список идентификаторов категорий
     *
     * @return Список идентификаторов категорий
     */
    public List<Integer> getCategoryId() {
        return categoryId;
    }

    /**
     * Метод возвращает Локализованное описание видео
     *
     * @return Локализованное описание видео
     */
    public String getDescription() {
        return description;
    }

    /**
     * Метод возвращает длительность видео в секундах.
     * <p>Поле может возвращать 0.
     *
     * @return Длительность видео в секундах
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Метод возвращает название видео на Youtube
     *
     * @return Название видео на Youtube
     */
    public String getExtTitle() {
        return extTitle;
    }

    /**
     * Метод возвращает отметку «Важное»
     *
     * @return Отметка «Важное» В случае true - да, в случае false - нет
     */
    public boolean isImportant() {
        return important;
    }

    /**
     * Метод возвращает идентификатор программы
     *
     * @return Идентификатор программы
     */
    public int getProgramId() {
        return programId;
    }

    /**
     * Метод возвращает список идентификаторов проектов
     *
     * @return Список идентификаторов проектов
     */
    public List<Integer> getProjectid() {
        return projectid;
    }

    /**
     * Метод возвращает дату и время публикации видео
     *
     * @return Дата и время публикации видео
     */
    public int getPublishedAt() {
        return publishedAt;
    }

    /**
     * Метод возвращает локализованное название видео
     *
     * @return Локализованное название видео
     */
    public String getTitle() {
        return title;
    }

    /**
     * Метод возвращает список идентификаторов техники, которой посвящено видео
     *
     * @return Список идентификаторов техники, которой посвящено видео
     */
    public Map<String, String> getVehicles() {
        return vehicles;
    }

    /**
     * Метод возвращает идентификатор видео на Youtube
     *
     * @return Идентификатор видео на Youtube
     */
    public String getVideoid() {
        return videoid;
    }

    /**
     * Метод возвращает ссылку на Youtube
     *
     * @return Ссылка на Youtube
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * Метод возвращает список изображений для видео
     *
     * @return Список изображений для видео
     */
    public Map<String, Thumbnail> getThumbnails() {
        return thumbnails;
    }

    /**
     * Класс описывает сущьность "изображение видео" для {@link Video}
     */
    public static class Thumbnail {

        @SerializedName("url")
        private String url;

        @SerializedName("width")
        private int width;

        @SerializedName("height")
        private int height;

        /**
         * Метод возвращает ссылку на изображение
         *
         * @return Ссылка на изображение
         */
        public String getUrl() {
            return url;
        }

        /**
         * Метод возвращает ширину изображения
         *
         * @return Ширину изображения
         */
        public int getWidth() {
            return width;
        }

        /**
         * Метод возвращает высоту изображения
         *
         * @return Высоту изображения
         */
        public int getHeight() {
            return height;
        }
    }
}
