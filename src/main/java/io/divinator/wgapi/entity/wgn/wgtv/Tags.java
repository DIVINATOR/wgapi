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

import com.google.api.client.util.Key;

import java.util.List;

/**
 * Класс описывает сущьность "Игровых проектов, категорий и программ" для метод-блока {@link io.divinator.wgapi.method.wgn.WgtvMethod}
 *
 * @author Sergey Divin
 */
public final class Tags {

    @Key("categories")
    private List<Categories> categories;

    @Key("programs")
    private List<Programs> programs;

    @Key("projects")
    private List<Projects> projects;

    /**
     * Метод возвращает Список категорий
     * @return Список категорий
     */
    public List<Categories> getCategories() {
        return categories;
    }

    /**
     * Метод возвращает Список программ
     * @return Список программ
     */
    public List<Programs> getPrograms() {
        return programs;
    }

    /**
     * Метод возвращает Список проектов
     * @return Список проектов
     */
    public List<Projects> getProjects() {
        return projects;
    }

    /**
     *
     */
    public static class Projects extends TagsEntity {
        @Key("project_id")
        private int projectId;

        /**
         * Метод возвращает идентификатор игрового проекта
         *
         * @return Идентификатор игрового проекта
         */
        public int getProjectId() {
            return projectId;
        }
    }

    /**
     *
     */
    public static class Programs extends TagsEntity {
        @Key("program_id")
        private int programId;

        /**
         * Метод возвращает идентификатор программы
         *
         * @return Идентификатор программы
         */
        public int getProgramId() {
            return programId;
        }
    }

    /**
     *
     */
    public static class Categories extends TagsEntity {
        @Key("category_id")
        private int categoryId;

        /**
         * Метод возвращает идентификатор категории контента
         *
         * @return Идентификатор категории контента
         */
        public int getCategoryId() {
            return categoryId;
        }
    }

    /**
     *
     */
    public abstract static class TagsEntity {
        @Key("name")
        private String name;

        @Key("order")
        private int order;

        /**
         * Метод возвращает название игрового проекта
         *
         * @return Название игрового проекта
         */
        public String getName() {
            return name;
        }

        /**
         * Метод возвращает прядок сортировки
         *
         * @return Порядок сортировки
         */
        public int getOrder() {
            return order;
        }
    }
}
