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

package io.divinator.wgapi.entity.wgn.wargag;

import com.google.gson.annotations.SerializedName;

/**
 * Класс описывает сущность "Информация о тегах к контенту" для метод-блока {@link io.divinator.wgapi.method.wgn.WargagMethod}
 *
 * @author Sergey Divin
 */
public final class Tag {

    @SerializedName("name")
    private String name;

    @SerializedName("tag_id")
    private int tag_id;

    /**
     * Метод возвращает название тега
     *
     * @return Название тега
     */
    public String getName() {
        return name;
    }

    /**
     * Метод возвращает идентификатор тега
     *
     * @return Идентификатор тега
     */
    public int getTag_id() {
        return tag_id;
    }
}
